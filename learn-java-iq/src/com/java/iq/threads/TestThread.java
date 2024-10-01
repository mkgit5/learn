package com.java.iq.threads;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {

		// Option 1
		final MyRunnable myRunnable = new MyRunnable();
		myRunnable.run();

		// Option 2
		Thread t = new Thread(new MyRunnable());
		t.start();

		// Option 3
		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();

		myThread1.start();
		myThread1.sleep(1000l);
		myThread2.start();

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from MyRunnable!");
	}

}

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			System.out.println("Hello from MyThread! - " + i);
		}
	}

}
