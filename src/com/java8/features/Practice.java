package com.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {
		
		 //Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
		 System.out.println("find out all the even numbers that exist in the list using Stream functions");
		 List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,10);
		 list.stream().filter(i->i%2==0).forEach(System.out::println);

		
		 //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		 System.out.println("find out all the numbers starting with 1 using Stream functions");
		 list.stream().map(s->s+"")//convert integer to string
		 .filter(s->s.startsWith("1")).forEach(System.out::println);

		
		 //3. How to find duplicate elements in a given integers list in java using Stream functions?
		 System.out.println("find duplicate elements in a given integers list in java using Stream functions");
		 Set<Integer> set=new HashSet<>();
		 list.stream().filter(n-> !set.add(n)).forEach(System.out::println);

		
		 //4. Given the list of integers, find the first element of the list using Stream functions?
		 System.out.println("find the first element of the list using Stream functions");
		 list.stream().findFirst().ifPresent(System.out::println);

		
		 //5. Given a list of integers, find the total number of elements present in the list using Stream functions?
		 System.out.println("find the total number of elements present in the list using Stream functions");
		 Long count=list.stream().count();
		 System.out.println("Count : "+count);

		
		 //6. Given a list of integers, find the maximum value element present in it using Stream functions?
		 System.out.println("find the maximum value element present in it using Stream functions");
		 int max=list.stream().max(Integer::compare).get();
		 System.out.println("Max : "+max);

		
		 //7. Given a String, find the first non-repeated character in it using Stream function
		 System.out.println("find the first non-repeated character in it using Stream function");
		 String input = "Java articles are Awesome";
		 Character result= input.chars() //Streams of String
		 .mapToObj(c->Character.toLowerCase(Character.valueOf((char) c))) //first convert to Character object and then to lowercase
		 .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
		 .entrySet().stream().filter(entry->entry.getValue()==1L)
		 .map(entry->entry.getKey())
		 .findFirst()
		 .get();
		 
		 System.out.println(result);

		
		 //8. Given a String, find the first repeated character in it using Stream functions?
		 System.out.println("find the first repeated character in it using Stream functions");
		 Character resultRepeated= input.chars()
		 .mapToObj(s-> Character.toLowerCase(Character.valueOf((char) s)))
		 .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
		 .entrySet()
		 .stream()
		 .filter(entry-> entry.getValue()>1L)
		 .map(entry->entry.getKey())
		 .findFirst()
		 .get();
		 System.out.println(resultRepeated);

		
		 //9. Given a list of integers, sort all the values present in it using Stream functions?
		 System.out.println("sort all the values present in it using Stream functions");
		 list.stream().sorted().forEach(System.out::println);

		
		 //10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
		 System.out.println("sort all the values present in it in descending order using Stream functions");
		 list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		
		 //11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
		 System.out.println("Return true if any value appears at least twice in the array, and return false if every element is distinct");
		 int[] nums= {1,2,3,1};
		 List<Integer> numList= Arrays.stream(nums).boxed().collect(Collectors.toList());
		 Set<Integer> set1=new HashSet<>(numList);
		 if(set1.size()==list.size()) {
			 System.out.println("False");
		 }else {
			 System.out.println("True");
		 }

		
		 //12. How will you get the current date and time using Java 8 Date and Time API?
		 System.out.println("get the current date and time using Java 8 Date and Time API");
		 //Using LocalDate API to get the date
		 System.out.println("Current Local Date: "+java.time.LocalDate.now());
		 //using LocalTime API to get the time
		 System.out.println("Current Local Time: "+java.time.LocalTime.now());
		 //using LocalDateTime API to get the date and time
		 System.out.println("Current Local Date and Time: "+java.time.LocalDateTime.now());

		
		 //13. Write a Java 8 program to concatenate two Streams?
		 System.out.println("Java 8 program to concatenate two Streams");
		 List<String> list1= Arrays.asList("Java", "8");
		 List<String> list2 = Arrays.asList("explained", "through", "programs");
		 //Concatenate the list1 and list2 by converting them into stream
		 Stream<String> concatStream= Stream.concat(list1.stream(), list2.stream());
		 //print the concatenated string
		 concatStream.forEach(str -> System.out.println(str+" "));

		
		 //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
		 System.out.println("Java 8 program to perform cube on list elements and filter numbers greater than 50");
		 list.stream().map(i-> i*i*i).filter(i->i>50).forEach(System.out::println);

		
		 //15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
		 System.out.println("Java 8 program to sort an array and then convert the sorted array into Stream");
		 int arr[] = { 99, 55, 203, 99, 4, 91 };
		 //sort using parallel sort
		 Arrays.parallelSort(arr);
		 //Convert it into stream and then print using forEach
		 Arrays.stream(arr).forEach(n->System.out.println(n+" "));

		
		 //16. How to use map to convert object into Uppercase in Java 8?
		 List<String> namelist= Arrays.asList("Kalidass","Gayu","Mohith","Hema","Sai","Vandana","Kalidass");
		 namelist.stream().map(String::toUpperCase).forEach(System.out::println);

		
		 //17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
		 System.out.println("convert a List of objects into a Map by considering duplicated keys and store them in sorted order");
		 List<Notes> noteLst = new ArrayList<>();
		 noteLst.add(new Notes(1, "note1", 11));
		 noteLst.add(new Notes(2, "note2", 22));
		 noteLst.add(new Notes(3, "note3", 33));
		 noteLst.add(new Notes(4, "note4", 44));
		 noteLst.add(new Notes(5, "note5", 55));

		 noteLst.add(new Notes(6, "note4", 66));		 

		
		 Map<String, Integer> notesRecords= noteLst.stream().sorted(Comparator.comparingLong(Notes::getTagId).reversed()) //sorting is based on TagId 55, 44, 33, 22, 11
		 .collect(Collectors.toMap(Notes::getName, Notes::getTagId, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
		 System.out.println(notesRecords);

		
		 //18. How to count each element/word from the String ArrayList in Java8?
		 System.out.println("count each element/word from the String ArrayList in Java8");
		 Map<String, Long> namesCount= namelist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 System.out.println(namesCount);

		
		 //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
		 System.out.println("find only duplicate elements with its count from the String ArrayList in Java8");
		 Map<String, Long> duplicateNamesCount= namelist.stream().filter(x-> Collections.frequency(namelist, x)>1)
		 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 System.out.println(duplicateNamesCount);

		
		 //20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
		 System.out.println("check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object");
		 Optional.ofNullable(noteLst)
		 .orElseGet(Collections::emptyList) //creates empty immutable list: [] in case notelst is null
		 .stream().filter(Objects::nonNull) //loop through each object and consider non null objects
		 .map(Notes::getName) //method reference, consider only tag name
		 .forEach(System.out::println);

		
		 //21. Write a Program to find the Maximum element in an array?
		 System.out.println("find the Maximum element in an array");
		 System.out.println(Arrays.stream(arr).max().getAsInt());

		
		 //22. Write a program to print the count of each character in a String?
		 System.out.println("print the count of each character in a String");
		 Map<String, Long> countOfChar= Arrays.stream(input.split(""))
		 .map(String::toLowerCase).collect(Collectors.groupingBy(str->str, LinkedHashMap::new, Collectors.counting()));
		 System.out.println(countOfChar);
		 
		 
		 
	}

}
