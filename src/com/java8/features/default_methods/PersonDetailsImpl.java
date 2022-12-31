package com.java8.features.default_methods;

import java.util.Arrays;
import java.util.List;

import com.java8.features.repo.Person;

public class PersonDetailsImpl implements PersonDetails {

	@Override
	public Double calculateTotalSalary(List<Person> personList) {
		return personList.stream().map(Person::getSalary).reduce(0d, (x,y)->x+y);
	}
	
	public int totalKids(List<Person> person) {
		return (10+10);
	}
	
	static List<String> personNames(List<Person> personList){
		return Arrays.asList("One","Two");
	}

}
