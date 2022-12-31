package com.java8.features.repo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepository {
	
	public static List<Person> getAllPersons(){
		Person p1=new Person("John",165,2000,"Male",2,Arrays.asList("Cricket","Swimming","Tenies","football"));
		Person p2=new Person("Kali",168,5000,"Male",2,Arrays.asList("coding","readig","music","chess"));
		Person p3=new Person("dass",158,5700,"Male",2,Arrays.asList("vallyball","Swimming","football"));
		Person p4=new Person("Priya",166,6000,"Female",2,Arrays.asList("reading","writing","listening"));
		Person p5=new Person("Amrutha",115,7000,"Female",2,Arrays.asList("Cricket","Swimming","Tenies","football"));
		Person p6=new Person("Peter",165,2000,"Male",2,Arrays.asList("Swimming","Tenies","football"));

		return Arrays.asList(p1,p2,p3,p4,p5,p6);
	}
	
	public static Person getPerson() {
		return new Person("Priya",166,6000,"Female",2,Arrays.asList("reading","writing","listening"));
	}
	
	public static Optional<Person> getPersonOptional() {
		Person per=getPerson();
		per.setAdress(Optional.of(new Address("7 nth block", "Ashburn","Virginia","USA",20047)));
		return Optional.of(per);
	}

}
