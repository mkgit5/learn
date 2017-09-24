package com.java.iq.programs;

/*
 Two ways to find Factorial(n) 
 1. Iterative method
 2. Recursion method

 Eg: 
 3! = 3 * 2 * 1 = 6
 4! = 4 * 3 * 2 * 1 = 24

 */
public class Factorial {

	public static void main(String[] args) {
		Factorial f = new Factorial();
		int number = 3;
		System.out.println("Factorial of " + number + " is " + f.factorial(number));
		System.out.println("Factorial of " + number + " is " + f.recursiveFactorial(number));
	}

	public int factorial(int n) {
		int fact = 1;
		if (n != 0) {
			for (int index = 1; index <= n; index++) {
				fact *= index;
			}
		}
		return fact;
	}

	public int recursiveFactorial(int n) {
		if (n == 1) {
			return 1;
		}

		return n * recursiveFactorial(n - 1);
	}

}
