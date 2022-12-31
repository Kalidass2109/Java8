package com.java8.features.optional;

import java.util.Optional;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;


public class OptionalExample {

	static String myName(String name) {
		return name;
	}
	
	static String personName(Person per) {
		if(per!=null)
			return per.getName();
		else
			return "No Data Found";
	}
	
	static Optional<String> PersonNameWithOptional(Optional<Person> per){
		if(per.isPresent())
			return per.map(Person::getName);
		else
			return Optional.empty();
	}
	public static void main(String[] args) {
		System.out.println("Result :"+myName("Dass"));
		Optional<String> name=Optional.ofNullable(myName("Dass"));
		String name1=Optional.ofNullable(myName("Dass")).get();
		System.out.println(name.isPresent()?name.get():"No Data Found");
		System.out.println("Person Name :"+personName(new Person()));
		Optional<String> personName=PersonNameWithOptional(PersonRepository.getPersonOptional());
		System.out.println("The optional Person name is :"+personName.get());
	}

}
