package com.java8.features.optional;

import java.util.Optional;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;


public class OptionalIfElseExample {

	static void orElse() {
		Optional<Person> person=PersonRepository.getPersonOptional();
		String name=person.isPresent()?person.get().getName():"Data Not Found";
		String name1=person.map(Person::getName).orElse("Data Not Found");
		System.out.println("OrElse Person name :"+name1);
	}
	
	static void orElseGet() {
		Optional<Person> person=PersonRepository.getPersonOptional();
		String name=person.map(Person::getName).orElseGet(()->{
			//logic
			//to send a notification mail
			//Initiate any script
			return "Data Not Found";
		});
		System.out.println("OrElseGet Person Name :"+name);
	}
	
	static void orElseThrow() {
		Optional<Person> person=PersonRepository.getPersonOptional();
		String name1=person.map(Person::getName).orElseThrow(()->new RuntimeException("Name Not Found"));
		System.out.println("OrElseThrow Person name :"+name1);
	}
	
	public static void main(String[] args) {
		orElse();
		orElseGet();
		orElseThrow();
	}

}
