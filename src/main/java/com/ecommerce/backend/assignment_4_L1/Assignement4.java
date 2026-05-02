package com.ecommerce.backend.assignment_4_L1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //3.Find the maximum and minimum number in a list using streams (return both in one object or record).
        //4.Count the frequency of each character in a given string using streams.
        //5.Given a list of integers, calculate sum, average, count, min, and max in one stream pass (use summarizingInt).
    }
}
