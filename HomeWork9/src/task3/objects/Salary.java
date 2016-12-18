package task3.objects;

import java.time.LocalDate;

public class Salary extends Entity{

    private LocalDate date;
    private Double value;
    private Integer whomThisSalary;

    public Salary(Employee employee, LocalDate date, Double value) {
        this.whomThisSalary = employee.getId();
        this.date = date;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }


    public Double getValue() {
        return value;
    }

    public Integer getWhomThisSalary() {
        return whomThisSalary;
    }
}
