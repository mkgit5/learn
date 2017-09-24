package com.java.iq.programs;

import java.util.Scanner;

/*
 Fibonacci series is a mathematical series, where each number is sum of previous two numbers

 Two ways:
 1. Iterative method
 2. Recursion method

 Example: 1, 1, 2, 3, 5, 8, 13, 21
 */
public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to find the fibonacci series: ");
		int n = scanner.nextInt();
		System.out.print("Fibonacci numbers (by iteration) are: ");
		for (int i = 1; i <= n; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		System.out.println();
		System.out.print("Fibonacci numbers (by recursion) are: ");
		for (int i = 1; i <= n; i++) {
			System.out.print(recursiveFibonacci(i) + " ");
		}

		scanner.close();
	}

	private static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			int fibo1 = 1;
			int fibo2 = 1;
			int fibonacci = 1;
			for (int i = 3; i <= n; i++) {
				fibonacci = fibo1 + fibo2;
				fibo1 = fibo2;
				fibo2 = fibonacci;
			}
			return fibonacci;
		}
	}

	private static int recursiveFibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);

	}
}
