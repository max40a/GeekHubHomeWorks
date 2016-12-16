package task1.storage;

import task1.objects.Entity;
import task1.objects.Ignore;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Implementation of {@link Storage} that uses database as a storage for objects.
 * It uses simple object type names to define target table to save the object.
 * It uses reflection to access objects fields and retrieve data to map to database tables.
 * As an identifier it uses field id of {@link Entity} class.
 * Could be created only with {@link Connection} specified.
 */
public class DatabaseStorage implements Storage {

    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + " WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
        try (Statement statement = connection.createStatement()) {
            return extractResult(clazz, statement.executeQuery(sql));
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        String sql = "DELETE FROM " + entity.getClass().getSimpleName().toLowerCase() + " WHERE id = " + entity.getId();
        try (Statement s = connection.createStatement()) {
            return s.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException {
        if (entity.isNew()) {
            insertExecute(entity);
        } else {
            updateExecute(entity);
        }
    }

    private <T extends Entity> void insertExecute(T entity) throws StorageException {
        try {
            Collection values = prepareEntity(entity).values();

            String sql = prepareSqlInsertQuery(entity);
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int i = 1;
                for (Object value : values) {
                    ps.setObject(i, value);
                    ++i;
                }

                ps.executeUpdate();

                ResultSet generatedKeys = ps.getGeneratedKeys();
                generatedKeys.next();
                entity.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private <T extends Entity> String prepareSqlInsertQuery(T entity) throws IllegalAccessException {
        Collection values = prepareEntity(entity).values();

        StringBuilder prepareInsertQueryString = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            prepareInsertQueryString.append("?, ");
        }
        prepareInsertQueryString.delete(prepareInsertQueryString.length() - 2, prepareInsertQueryString.length());

        return String.format("INSERT INTO %s VALUES (default, %s)",
                entity.getClass().getSimpleName().toLowerCase(),
                prepareInsertQueryString.toString());
    }

    private <T extends Entity> void updateExecute(T entity) throws StorageException {
        try {
            Collection values = prepareEntity(entity).values();

            String sql = prepareSqlUpdateQuery(entity);
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                int i = 1;
                for (Object value : values) {
                    ps.setObject(i, value);
                    ++i;
                }

                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private <T extends Entity> String prepareSqlUpdateQuery(T entity) throws IllegalAccessException {
        Set keys = prepareEntity(entity).keySet();

        StringBuilder prepareUpdateQueryString = new StringBuilder();
        for (Object key : keys) {
            prepareUpdateQueryString.append(key);
            prepareUpdateQueryString.append(" = ?, ");
        }
        prepareUpdateQueryString.delete(prepareUpdateQueryString.length() - 2, prepareUpdateQueryString.length());

        return String.format("UPDATE %s SET %s WHERE id = %d",
                entity.getClass().getSimpleName().toLowerCase(),
                prepareUpdateQueryString.toString(),
                entity.getId()
        );
    }

    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws IllegalAccessException {
        Map<String, Object> preparedResult = new LinkedHashMap<>();

        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field f : fields) {
            if (!f.isAnnotationPresent(Ignore.class)) {
                preparedResult.put(f.getName(), f.get(entity));
            }
        }

        return preparedResult;
    }

    @SuppressWarnings("unchecked")
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        List<T> result = new ArrayList<>();

        while (resultSet.next()) {
            Object object = clazz.newInstance();

            Class<? super T> superclass = clazz.getSuperclass();
            Field[] fieldsSuperClass = superclass.getDeclaredFields();
            AccessibleObject.setAccessible(fieldsSuperClass, true);
            fieldsSuperClass[0].set(object, resultSet.getObject(1));

            Field[] fieldsClazz = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fieldsClazz, true);

            int i = 2;
            for (Field f : fieldsClazz) {
                if (!f.isAnnotationPresent(Ignore.class)) {
                    f.set(object, resultSet.getObject(i++));
                }
            }

            result.add((T) object);
        }

        return result;
    }
}