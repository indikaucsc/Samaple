package org.example.stream;

import java.time.LocalDate;

//@Getter
//@Setter
//@AllArgsConstructor
public class Employee {

    private String name;
    private LocalDate birthday;
    private String department;
    private double salary;

    public Employee(String name, LocalDate birthday, String department, double salary) {
        this.name = name;
        this.birthday = birthday;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

// Filter employees older than 30 years
// Group employees by department

// Find the highest paid employee

// Calculate the average salary of IT department