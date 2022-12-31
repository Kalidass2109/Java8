package com.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class StreamFlatMapExample {
	
	static List<String> hobbies(List<Person> personList){
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}
	
	static List<String> distinctHobbies(List<Person> personList){
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}
	
	static long countOfHobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.count();
	}

	public static void main(String[] args) {
		List<Integer> oddNumber=Arrays.asList(1,3,5,7);
		List<Integer> evenNumber=Arrays.asList(2,5,6,8);
		
		List<List<Integer>> listoflist=Arrays.asList(oddNumber,evenNumber);
		System.out.println("Before Flatten :"+listoflist);
		
		List<Integer> flattenList=listoflist.stream()
				.flatMap(list->list.stream())
				.collect(Collectors.toList());
		System.out.println("After Flatten :"+flattenList);
		
		List<Person> listOfPersons=PersonRepository.getAllPersons();
		System.out.println("Hobbies Result with duplicates :"+hobbies(listOfPersons));
		System.out.println("Hobbies Result without duplicates :"+distinctHobbies(listOfPersons));
		System.out.println("Hobbies count :"+countOfHobbies(listOfPersons));
	}

}
