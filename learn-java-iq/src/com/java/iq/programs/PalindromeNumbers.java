package com.java.iq.programs;

import java.util.Scanner;

/*
 Find if a number is a palindrome.

 Ways:
 1. Reverse the number and then compare with original number
 2. Convert to string, split and then use binary search to find palindrome nature. 

 Input:
 121

 Output:
 Number is a palindrome.

 */
public class PalindromeNumbers {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		// int[] numbers = {1, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11};

		// for(int number: numbers){
		System.out.println("Does number : " + number + " is a palindrome? " + isPalindrome(number));
		scanner.close();
		// }
	}

	private static boolean isPalindrome(int number) {
		if (number == reverse(number)) {
			return true;
		}
		return false;
	}

	private static int reverse(int number) {
		int reverse = 0;
		while (number != 0) {
			reverse = reverse * 10 + number % 10;
			// 1. number = 33, reverse = 0 + 3 = 3
			// 2. number = 3, reverse = 30 + 3 = 33
			number = number / 10;
			// 1. number = 33/10 = 3
			// 2. number = 3/10 = 0
		}

		return reverse;
	}

}
