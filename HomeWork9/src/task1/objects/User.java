package task1.objects;

import java.time.LocalDate;

public class User extends Entity {

    private String name;
    private Integer age;
    private Boolean admin;
    private Double balance;

    @Ignore
    private LocalDate creationDate;

    public User() {
        this.creationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "name=" + name +
                " age=" + age +
                " admin=" + admin +
                " balance=" + balance +
                " creationDate=" + creationDate;
    }
}
