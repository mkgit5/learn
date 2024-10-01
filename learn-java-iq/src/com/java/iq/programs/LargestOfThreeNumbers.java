package com.java.iq.programs;

import java.util.Scanner;

/*
 Find largest of three numbers.

 Ways:
 1. if-else logic
 2. Ternary condition

 Input:
 1 2 3

 Output:
 3

 */
public class LargestOfThreeNumbers {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number one: ");
		int one = scanner.nextInt();

		System.out.print("Enter number two: ");
		int two = scanner.nextInt();

		System.out.print("Enter number three: ");
		int three = scanner.nextInt();

		scanner.close();

		System.out.println("Largest of three number: " + findLargestOfThree(one, two, three));
		System.out.println("Largest of three number by ternary condition: " + findLargestOfThreeByTernaryCondition(one, two, three));
	}

	private static int findLargestOfThree(int one, int two, int three) {
		if (one > two && one > three) {
			return one;
		} else if (two > one && two > three) {
			return two;
		} else if (three > one && three > two) {
			return three;
		}
		return Integer.MIN_VALUE;
	}

	private static int findLargestOfThreeByTernaryCondition(int one, int two, int three) {
		return (one > two) ? (one > three ? one : three) : (two > three ? two : three);
	}

}
