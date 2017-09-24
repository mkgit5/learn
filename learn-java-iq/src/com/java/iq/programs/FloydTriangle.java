package com.java.iq.programs;

import java.util.Scanner;

/*
 Floyd's triangle is a right angle triangle.
 It consists of natural numbers starting from 1 in the first row. 
 It then goes on with two numbers in second row, 3 numbers in 3rd row and so on.

 Example:
 1
 2 3
 4 5 6 
 7 8 9 10
 11 12 13 14

 */
public class FloydTriangle {

	public static void main(String[] args) {
		System.out.println("Please enter the number of rows of Floyd's triangle you want to print");

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		int number = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(number++ + " ");
			}
			System.out.println();
		}
	}
}
