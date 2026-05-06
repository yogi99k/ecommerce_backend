package com.ecommerce.backend.assignment_4_L1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Assignement4 {
    public static void main(String[] args) {
        //1. Even Numbers Given a list of integers:Return only even numbers
//        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
//        List<Integer> list = arr1.stream()
//                .filter(i -> i % 2 == 0)
//                .toList();
//        System.out.println(list);
//        //2.Names uppercases
//        List<String> names = new ArrayList<>(Arrays.asList("vix","max","dix","marvel","peter","antony","jackson"));
//        names.add("yogi");
//        names.add("min");
//        names.add("sam");
//        names.add("pit");
//
//        List<String> list1 = names.stream().map(s -> s.toUpperCase()).toList();
//        System.out.println(list1);
//        //3. Sum of Numbers
//        System.out.println(arr1.stream().mapToInt(Integer::intValue).sum());
//        //4. Remove Duplicates
//        List<Integer> arr3 = new ArrayList<>(Arrays.asList(4,1,2,5,3,4,2,4,5,7,8,5,7,1));
//        System.out.println(arr3.stream().distinct().toList());
//        //Count Strings with Length > 5
//        List<String> list2 = names.stream()
//                .filter(i -> i.length() > 4)
//                .toList();
//        System.out.println(list2);

        //1.Given a list of integers, filter even numbers and return their squares as a new list.
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> nums2 = new ArrayList<>();
        System.out.println(nums.size());
//        for(int i=0;i<nums.size();i++){
//            int num = nums.get(i);
//            if(num%2==0){
//                nums2.add(num*num);
//            }
//        }
//        System.out.println(nums2);
        List<Integer> list = nums.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .toList();
        System.out.println(list);
        //2.Given a list of strings, convert all to uppercase and remove duplicates.
        List<String> names = new ArrayList<>(Arrays.asList("vix","max","dix","marvel","peter","antony","jackson","ram","gopi","vix","peter"));
        List<String> list1 = names.stream()
                .distinct()
                .map(s -> s.toUpperCase())
                .toList();
        System.out.println(list1);
        //3.Find the maximum and minimum number in a list using streams (return both in one object or record).
        IntSummaryStatistics intSummaryStatistics = nums.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("MAX : "+intSummaryStatistics.getMax()+", Min : "+intSummaryStatistics.getMin());

        record MinMax(int max, int min){}
        MinMax minMax = new MinMax(
                nums.stream().max(Integer::compareTo).get(),
                nums.stream().min(Integer::compareTo).get()
        );
        System.out.println(minMax);
        //4.Count the frequency of each character in a given string using streams.
        String str = "hello world java streams";
        Map<Character, Long> collect = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        System.out.println(collect);
        //5.Given a list of integers, calculate sum, average, count, min, and max in one stream pass (use summarizingInt).
        IntSummaryStatistics stats = nums.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Sum     : " + stats.getSum());
        System.out.println("Average : " + stats.getAverage());
        System.out.println("Count   : " + stats.getCount());
        System.out.println("Min     : " + stats.getMin());
        System.out.println("Max     : " + stats.getMax());

        //Level 2: Mapping & FlatMapping
        //6. Given a list of List<Integer> (nested lists), flatten it into a single list and sort it.
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(5, 2, 9),
                Arrays.asList(1, 7, 3),
                Arrays.asList(8, 4, 6),
                Arrays.asList(-4,0,99)
        );
        List<Integer> list2 = numbers.stream()
                .flatMap(List::stream)
                .sorted()
                .toList();
        System.out.println(list2);
        //7. Given a list of Person objects (with name and list of hobbies), return all unique hobbies across all persons.
        record Person(String name, List<String> hobbies){}
        List<Person> people = List.of(
                new Person("Alice", List.of("Reading", "Swimming", "Hiking")),
                new Person("Bob",   List.of("Gaming", "Reading", "Cooking")),
                new Person("Charlie", List.of("Swimming", "Photography", "Hiking")),
                new Person("Diana", List.of("Reading", "Painting")));
        List<String> list3 = people.stream()
                .flatMap(person -> person.hobbies().stream())
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .toList();
        System.out.println(list3);
        //8. Convert a list of Employee (id, name, salary) into a Map<Integer, String> (id → name).
        record Employee(int id, String name, Double salary){}
        List<Employee> employeeList = List.of(
                new Employee(101,"yogi",55.5),
                new Employee(102,"max",65.5),
                new Employee(103,"kris",75.5),
                new Employee(104,"nik",85.5),
                new Employee(105,"mar",95.5),
                new Employee(106,"nar",95.5),
                new Employee(109,"mik",85.5)
        );
        Map<Integer, Employee> collect1 = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::id,
                        //Employee::name
                        e->e
                ));
        System.out.println(collect1);
        //9. Given a list of strings, group them by their length (Map<Integer, List<String>>).
        Map<Integer, List<String>> collect2 = names.stream()
                .collect(Collectors.groupingBy(
                        String::length
                ));
        System.out.println(collect2);

        Employee highest = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .orElseThrow();
        System.out.println(highest);
        //10. Sort a list of Employee by salary descending, then by name ascending if salary is same.
        List<Employee> list4 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed()
                        .thenComparing(Employee::name))
                .toList();
        System.out.println(list4);

        //Level 3: Grouping & Advanced Collectors
        //11. Group employees by department and count number of employees in each department.
        record Employees(int id, String name, double salary, String department ){}
        List<Employees> employeesList = List.of(
                new Employees(101,"yogi",55.5,"IT"),
                new Employees(102,"max",65.5, "HR"),
                new Employees(103,"kris",75.5,"IT"),
                new Employees(104,"nik",85.5,"Security"),
                new Employees(105,"mar",95.5,"IT"),
                new Employees(106,"nar",95.5,"HR"),
                new Employees(109,"mik",85.5,"Security")
        );
        Map<String, Long> collect3 = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::department,
                        Collectors.counting()
                ));
        System.out.println(collect3);
        //12. Group employees by department and find the highest salary in each department.
        Map<String, Optional<Employees>> collect4 = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::department,
                        Collectors.maxBy(Comparator.comparing(Employees::salary))
                ));
        System.out.println(collect4);
        //13. Group employees by department and calculate average salary per department.
        Map<String, Double> collect5 = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::department,
                        Collectors.averagingDouble(Employees::salary)
                ));
        System.out.println(collect5);
        //14. Partition a list of integers into even and odd numbers (Map<Boolean, List<Integer>>).
        List<Integer> numsList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Map<Boolean, List<Integer>> collect6 = numsList.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Even Nums : "+collect6.get(true));
        System.out.println("Odd Nums : "+collect6.get(false));
    }

}
