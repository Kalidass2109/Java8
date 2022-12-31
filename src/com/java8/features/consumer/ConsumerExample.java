package com.java8.features.consumer;

import java.util.List;
import java.util.function.Consumer;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

public class ConsumerExample {
	
	static Consumer<Person> c1=(p)->System.out.println(p);
	
	static Consumer<Person> c2=(p)->System.out.println(p.getName().toUpperCase());
	
	static Consumer<Person> c3=(p)->System.out.println(p.getHobbies());
	
	static List<Person> personList=PersonRepository.getAllPersons();
	
	static void printNameAndHobbies() {
		personList.forEach(c2.andThen(c3));
	}
	
	static void printWithCondition() {
		personList.forEach(p->{
			if(p.getGender().equals("Male") && p.getHeight()>=140) {
				c2.andThen(c3).accept(p);
			}
		});
	}

	public static void main(String[] args) {
//		Consumer<String> con1=(s)->{System.out.println(s.toUpperCase());};
//		//con1.accept("java8");
//		Consumer<String> con2=(s)->System.out.println(s.toLowerCase());
//		con1.andThen(con2).accept("java8");
		
//		c1.accept(PersonRepository.getPerson());
//		c2.accept(PersonRepository.getPerson());
//		c3.accept(PersonRepository.getPerson());
		//c1.andThen(c2).andThen(c3).accept(PersonRepository.getPerson());
		//printNameAndHobbies();
		printWithCondition();
	}

}
