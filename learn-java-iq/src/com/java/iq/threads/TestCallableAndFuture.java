package com.java.iq.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1. Runnable interface is an interface that contains a single method.
 * 	  Runnable interface is usually used in conjunction with the Thread class.
 * 		public void run();
 * 
 * 2. Callable is similar to Runnable but it returns a result and may throw an exception 
 * 		public Object call() throws Exception;
 * 
 * 3. Future interface is used to retrieve the result of a Callable interface.
 * 
 * 4. FutureTask is a concrete implementation of the Future, Runnable and RunnableFuture
 * 
 * 5. Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
 * 
 * 6. How to invoke Callable? 
 * 		1. Pass Callable instance to a FutureTask constructor
 * 			new FutureTask<Long>(new MyCallable());
 * 		2. Pass new FutureTask object to a Thread constructor 
 * 			Thread t = new Thread(futureTasks); 
 * 		3. Invoke thread's start method 
 * 			t.start();
 *
 */
public class TestCallableAndFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		simpleCallable();
		multipleCallables();
	}

	private static void simpleCallable() throws InterruptedException, ExecutionException {
		final FutureTask<Long> futureTask = new FutureTask<>(new MyCallable());
		final Thread t = new Thread(futureTask);
		t.start();
		System.out.println("Simple Callable Test - " + futureTask.get());
	}

	private static void multipleCallables() throws InterruptedException, ExecutionException {
		FutureTask<Long>[] futureTasks = new FutureTask[5];
		for (int i = 0; i < 5; i++) {
			futureTasks[i] = new FutureTask<Long>(new MyCallable());
			Thread t = new Thread(futureTasks[i]);
			t.start();
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Multiple Callable Test " + i + " : " + futureTasks[i].get());
		}
	}

}

class MyCallable implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		final Random random = new Random();
		final Long number = random.nextLong();
		System.out.println("Multiple Callable : " + number);
		Thread.sleep(1000);
		return number;
	}

}