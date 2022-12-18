package com.java8.features.parallel_streams;

import java.util.List;
import java.util.stream.Collectors;

import com.java8.features.lambdas.Person;
import com.java8.features.lambdas.PersonRepository;

public class ParallelStreamUseCase {

	static List<String> getHobbiesBySeq(){
		long start=System.currentTimeMillis();
		List<String> hobbies= PersonRepository.getAllPersons()
		.stream()
		.map(Person::getHobbies)
		.flatMap(List::stream)
		.collect(Collectors.toList());
		long end=System.currentTimeMillis();
		System.out.println("Sequential Duration :"+(end-start));
		return hobbies;
	}
	
	static List<String> getHobbiesByParallel(){
		long start=System.currentTimeMillis();
		List<String> hobbies= PersonRepository.getAllPersons()
		.parallelStream()
		.map(Person::getHobbies)
		.flatMap(List::stream)
		.collect(Collectors.toList());
		long end=System.currentTimeMillis();
		System.out.println("Parallel Duration :"+(end-start));
		return hobbies;
	}
	public static void main(String[] args) {
		System.out.println(getHobbiesBySeq());
		System.out.println(getHobbiesByParallel());

	}

}
