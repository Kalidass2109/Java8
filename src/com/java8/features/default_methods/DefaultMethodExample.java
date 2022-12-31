package com.java8.features.default_methods;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class DefaultMethodExample {

	public static void main(String[] args) {
		List<String> nameList=PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		/**Before Java8**/
		System.out.println("Before sort");
		nameList.forEach(name->System.out.print(name+" "));
		Collections.sort(nameList);
		System.out.println("\nAfter sort");
		nameList.forEach(name->System.out.print(name+" "));
		
		/**In Java8**/
		nameList.sort(Comparator.naturalOrder());
		System.out.println("\nNatural Order");
		nameList.forEach(name->System.out.print(name+" "));
		
		nameList.sort(Comparator.reverseOrder());
		System.out.println("\nReverse Order");
		nameList.forEach(name->System.out.print(name+" "));
	}
}
