package com.java8.features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8.features.lambdas.Person;
import com.java8.features.lambdas.PersonRepository;

public class StreamsVsCollectionExample {

	public static void main(String[] args) {
		List<String> names=new ArrayList<>();
		names.add("John");
		names.add("Adan");
		names.add("nancy");
		
		for(String name:names) {
			System.out.println("Iteration 1"+name);
		}
		for(String name:names) {
			System.out.println("Iteration 2"+name);
		}
		
		Stream<String> stream=names.stream();
		stream.forEach(p->System.out.println("<<<< :"+p));
		//stream.forEach(p->System.out.println("<<<< :"+p));
		
		List<String> personNames=PersonRepository
				.getAllPersons()
				.stream()
				.peek(per->System.out.println(per))
				.map(Person::getName)
				.peek(System.out::println)
				.collect(Collectors.toList());
	}

}
 