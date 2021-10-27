/*
Author: Jumanazar Saidov
Date: 2021-10-27

 */

package variables.Day2_OOP;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(long id, String firstName, String lastName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }
}
