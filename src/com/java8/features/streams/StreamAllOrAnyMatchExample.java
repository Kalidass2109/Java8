package com.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.java8.features.lambdas.Person;
import com.java8.features.lambdas.PersonRepository;

public class StreamAllOrAnyMatchExample {

	static Predicate<String> p1=num->num.length()>7;
	static Predicate<Person> p2=per->per.getHeight()>=140;
	static Predicate<Person> p3=per->per.getGender().equals("Male");
	
	public static void main(String[] args) {
		List<String> fruits=Arrays.asList("Apple","Orange","Graphs","Banana","Pineapple");
		System.out.println("Length Check All Match :"+fruits.stream().allMatch(p1));
		System.out.println("Length Check Any Match :"+fruits.stream().anyMatch(p1));
		
		List<Person> personList=PersonRepository.getAllPersons();
		System.out.println("Person All Match :"+personList.stream()
		.allMatch(p2));
		
		System.out.println("Person Any Match :"+personList.stream()
		.anyMatch(p2.and(p3)));
	}

}
