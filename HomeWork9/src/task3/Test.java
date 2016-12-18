package task3;

import task3.objects.Employee;
import task3.objects.Salary;
import task3.storage.DatabaseStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    private static final String DB_NAME = "jdbc:h2:~/test";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1";

    public static void main(String[] args) throws Exception {
        Connection connection = createConnection(LOGIN, PASSWORD, DB_NAME);
        DatabaseStorage storage = new DatabaseStorage(connection);

        storage.createEmployeeTable();
        storage.createSalaryTable();

        Employee victor = new Employee("Victor");
        Employee inna = new Employee("Inna");
        Employee andrey = new Employee("Andrey");
        Employee ivan = new Employee("Ivan");
        Employee ivan1 = new Employee("Ivan");

        storage.insertEmployee(victor);
        storage.insertEmployee(inna);
        storage.insertEmployee(andrey);
        storage.insertEmployee(ivan);
        storage.insertEmployee(ivan1);

        List<Salary> salaryList = new ArrayList<>();
        Collections.addAll(salaryList,
                new Salary(victor, LocalDate.now(), 10.99),
                new Salary(victor, LocalDate.now(), 11.55),
                new Salary(victor, LocalDate.now(), 16.23),
                new Salary(victor, LocalDate.now(), 15.23),
                new Salary(inna, LocalDate.now(), 20.00),
                new Salary(inna, LocalDate.now(), 30.00),
                new Salary(inna, LocalDate.now(), 40.00),
                new Salary(andrey, LocalDate.now(), 10.55),
                new Salary(andrey, LocalDate.now(), 11.55),
                new Salary(andrey, LocalDate.now(), 12.55),
                new Salary(ivan, LocalDate.now(), 100.00),
                new Salary(ivan, LocalDate.now(), 100.00),
                new Salary(ivan, LocalDate.now(), 100.00),
                new Salary(ivan, LocalDate.now(), 150.00),
                new Salary(ivan, LocalDate.now(), 250.00),
                new Salary(ivan1, LocalDate.now(), 50.00),
                new Salary(ivan1, LocalDate.now(), 50.00)
        );

        for (Salary salary: salaryList) {
            storage.insertSalary(salary);
        }

        storage.showTotalSumSalaryForEachEmployee();

        connection.close();
    }

    private static Connection createConnection(String login, String password, String dbName) throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(dbName, login, password);
    }
}
