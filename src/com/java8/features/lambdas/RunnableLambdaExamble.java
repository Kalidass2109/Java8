package com.java8.features.lambdas;

public class RunnableLambdaExamble {

	public static void main(String[] args) {
		//Before
		Runnable t1=new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1");
			}
		};
		new Thread(t1).run();
		
		//After
		Runnable t2=()->{System.out.println("Thread 2");};
		new Thread(t2).start();
		
		Runnable t3=()->{System.out.println("Thread 3");
		System.out.println("Thread 3.1");
		};
		new Thread(t3).start();
		
		//Before
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 4");
			}
		}).start();
		
		//After
		new Thread(()->{
			System.out.println("Thread 5");
			System.out.println("Thread 5.1");
		}).start();

	}

}
