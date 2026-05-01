package com.ecommerce.backend.assignment_4_L1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignement4 {
    public static void main(String[] args) {
        //1. Even Numbers Given a list of integers:Return only even numbers
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> list = arr1.stream()
                .filter(i -> i % 2 == 0)
                .toList();
        System.out.println(list);
        //2.Names uppercases
        List<String> names = new ArrayList<>(Arrays.asList("vix","max","dix"));
        names.add("yogi");
        names.add("min");
        names.add("sam");
        names.add("pit");

        List<String> list1 = names.stream().map(s -> s.toUpperCase()).toList();
        System.out.println(list1);
        //3. Sum of Numbers
        System.out.println(arr1.stream().mapToInt(Integer::intValue).sum());
        //4. Remove Duplicates
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(4,1,2,5,3,4,2,4,5,7,8,5,7,1));
        System.out.println(arr3.stream().distinct().toList());
    }
}
