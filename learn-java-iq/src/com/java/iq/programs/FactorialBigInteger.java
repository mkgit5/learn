package com.java.iq.programs;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialBigInteger {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.printf("Factorial of %d is %s %n", n, factorial(n));
	}

	/*
	 * Java method to calculate factorial of a large number
	 * @return BigInteger factorial of given number
	 */
	public static BigInteger factorial(int number) {
		BigInteger fact = BigInteger.ONE;

		for (int i = number; i > 0; i--) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		return fact;
	}

}
