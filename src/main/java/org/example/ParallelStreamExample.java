package org.example;


import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Alice", 50000),
                new Employee(2, "Bob", 60000),
                new Employee(3, "Charlie", 70000),
                new Employee(4, "David", 60000),
                new Employee(5, "Eve", 70000),
                new Employee(6, "Frank", 80000)
        );

        // Using parallelStream to calculate average salary in parallel
        double averageSalary = empList.parallelStream()
                .mapToDouble(Employee::getSalary)    // Map Employee to salary
                .average()                           // Calculate average
                .orElse(0.0);                        // Handle case when list is empty

        System.out.println("The average salary is: " + averageSalary);
    }
}