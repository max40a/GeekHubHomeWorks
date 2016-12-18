package task3.storage;

import task3.objects.Employee;
import task3.objects.Salary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseStorage {

    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    public void createEmployeeTable() throws StorageException {
        String nameTable = "EMPLOYEE";
        String sql = "CREATE TABLE " + nameTable + " (" +
                " id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                " name VARCHAR(20));";

        try (Statement statement = connection.createStatement()) {
            dropTable(nameTable);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    public void createSalaryTable() throws StorageException {
        String nameTable = "SALARY";
        String sql = "CREATE TABLE " + nameTable + "(" +
                " ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                " DATE DATE NOT NULL," +
                " VALUE DOUBLE NOT NULL," +
                " EMP_ID INTEGER NOT NULL," +
                " CONSTRAINT SALARY_EMPLOYEE_ID_FK FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE (ID));";

        try (Statement statement = connection.createStatement()) {
            dropTable(nameTable);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    private void dropTable(String nameTable) throws SQLException {
        String sql = "DROP TABLE " + nameTable + " ;";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    public void insertEmployee(Employee employee) throws StorageException {
        String sql = "INSERT INTO EMPLOYEE VALUES (default, ?);";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getName());

            ps.executeUpdate();

            ResultSet generatedKey = ps.getGeneratedKeys();
            generatedKey.next();
            employee.setId(generatedKey.getInt(1));
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    public void insertSalary(Salary salary) throws StorageException {
        String sql = "INSERT INTO SALARY VALUES(default, ?, ?, ?);";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(salary.getDate()));
            ps.setDouble(2, salary.getValue());
            ps.setInt(3, salary.getWhomThisSalary());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    public void showTotalSumSalaryForEachEmployee() throws StorageException {
        String sql = "SELECT" +
                "  EMPLOYEE.ID," +
                "  EMPLOYEE.NAME," +
                "  sum(SALARY.VALUE)" +
                " FROM EMPLOYEE INNER JOIN SALARY" +
                "    ON EMPLOYEE.id = SALARY.EMP_ID" +
                " GROUP BY EMPLOYEE.NAME, EMPLOYEE.ID;";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            printResult(fillShowedList(rs));
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    private List<String> fillShowedList(ResultSet rs) throws SQLException {
        List<String> showList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double sumSalary = rs.getDouble(3);
            String result = String.format("%d %s, total sum salary = %.2f$", id, name, sumSalary);
            showList.add(result);
        }
        return showList;
    }

    private void printResult(List<String> list) {
        list.forEach(System.out::println);
    }
}
