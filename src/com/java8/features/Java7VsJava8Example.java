package com.java8.features;

import java.util.stream.IntStream;

public class Java7VsJava8Example {

	public static void main(String[] args) {
		// Before Java 8
		int total = 0;
		for (int i = 0; i <= 50; i++) {
			total += i;
		}
		System.out.println("Total is :" + total);

		// After
		int total1 = IntStream.range(0, 51).map(Integer::new).sum();
		System.out.println("Total in Java8 :" + total1);
	}

}
