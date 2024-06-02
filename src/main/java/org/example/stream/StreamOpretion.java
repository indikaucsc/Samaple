package org.example.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamOpretion {

    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee("Kamal", LocalDate.of(1988, 9, 8), "IT", 88500.0),
                new Employee("Uthpalavi", LocalDate.of(1988, 11, 4), "IT", 9500.25),
                new Employee("Chathuara", LocalDate.of(1990, 12, 8), "CS", 100.25),
                new Employee("Madhawa", LocalDate.of(1978, 4, 18), "IT", 88500.0),
                new Employee("Dilshan", LocalDate.of(1988, 1, 4), "CS", 500.25)

        );

        //System.out.println(StreamOpretion.streamOp(empList));
        // Filter employees older than 30 years

        // Group employees by department
//            StreamOpretion.getDepartment(empList);

        // Find the highest paid employee
        StreamOpretion.getMaxSalary(empList);
    }

    private static String streamOp(List<Employee> empList) {
        List<Employee> empTmp = empList.stream().filter(emp -> emp.getBirthday().isBefore(LocalDate.now().minusYears(40))).collect(Collectors.toList());
        empTmp.stream().forEach(System.out::println);
        return empTmp.stream().toString();
    }

    private static void getDepartment(List<Employee> empList) {
        Map<String, List<Employee>> empTmp = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empTmp.toString());
    }

    private static void getMaxSalary(List<Employee> empList) {
        Optional<Employee> maxSalaryEmp = empList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        // maxSalaryEmp.isPresent(e->System.out.println(e.toString()));

       Optional<Employee> test = empList.stream().sorted((e1,e2)-> Double.compare(e2.getSalary(), e1.getSalary()))
               .distinct()
               .skip(1).findFirst();

//        OptionalDouble maxAmount = empList.stream().mapToDouble(Employee::getSalary).max();
        test.ifPresent(a ->System.out.println(" maxAmount : "+ a));
//        test.stream().forEach(System.out::println);
    }
}
