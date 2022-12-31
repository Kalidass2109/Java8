package com.java8.features.default_methods;

import java.util.List;
import java.util.stream.Collectors;

import com.java8.features.repo.Person;

public interface PersonDetails {
	Double calculateTotalSalary(List<Person> personList);

	//We can override default method
	default int totalKids(List<Person> personList) {
		return personList.stream().map(Person::getKids).reduce(0, (x,y)->x+y);
	}
	
	//We cannot override static method
	static List<String> personNames(List<Person> personList){
		return personList.stream().map(Person::getName).collect(Collectors.toList());
	}
}
