package org.example.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOpretion {

    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee("Kamal", LocalDate.of(1988, 9, 8), "IT", 500.25),
                new Employee("Uthpalavi", LocalDate.of(1988, 11, 4), "IT", 9500.25),
                new Employee("Chathuara", LocalDate.of(1990, 12, 8), "IT", 100.25),
                new Employee("Madhawa", LocalDate.of(1978, 4, 18), "IT", 88500.0),
                new Employee("Dilshan", LocalDate.of(1988, 1, 4), "IT", 500.25)

        );

        System.out.println(StreamOpretion.streamOp(empList));
        // Filter employees older than 30 years

    }

    private static String streamOp(List<Employee> empList) {
        List<Employee> empTmp = empList.stream().filter(emp -> emp.getBirthday().isBefore(LocalDate.now().minusYears(40))).collect(Collectors.toList());
        empTmp.stream().forEach(System.out::println);
        return empTmp.stream().toString();
    }
}
