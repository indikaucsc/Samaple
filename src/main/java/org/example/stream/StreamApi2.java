package org.example.stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApi2 {

    public static void main(String[] args){


        List<Employee> empList = Arrays.asList(
               new Employee("Kamal", LocalDate.of(1988,8,30),"IT",100),
               new Employee("Nimal", LocalDate.of(1977,1,9),"IT",100),
               new Employee("Sunil", LocalDate.of(1990,2,9),"CS",2568.3),
               new Employee("Piyal", LocalDate.of(2020,6,9),"IT",2568.3)
        );

      //  System.out.println( );

      //  empList.stream().forEach(System.out ::println);

      //  findAge(empList);


        // Group employees by department
        groupByExample(empList);
    }


    private static void getMaxSalary(List<Employee> empList){

    Optional<Employee> maxEmp =  empList.stream().sorted((e1,e2)-> Double.compare(e2.getSalary(), e1.getSalary()))
            .distinct()
            .skip(1)
            .findFirst();
        System.out.println(maxEmp);
    }

    private static void findAge(List<Employee> empList){

        List<Employee> empNew =empList.stream().filter(emp-> emp.getBirthday().isBefore(LocalDate.now().minusYears(40))).collect(Collectors.toList());

        // Create a map of employee names and their ages
        Map<String, Integer> nameAgeMap = empNew.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> Period.between(emp.getBirthday(), LocalDate.now()).getYears()
                ));

        // Print the map
        nameAgeMap.forEach((name, age) -> System.out.println("Name: " + name + ", Age: " + age));


       // empNew.forEach(System.out::println);
    }



    private static void groupByExample(List<Employee> empList){

        Map<String, List<Employee>> groupByEmp = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupByEmp.forEach((d,value)-> System.out.println(" group "+ d + value));

    }
}
