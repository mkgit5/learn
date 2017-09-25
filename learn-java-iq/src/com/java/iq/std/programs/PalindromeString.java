package com.java.iq.std.programs;

import java.util.Scanner;

/*
 Find if a string is a palindrome.

 Ways:
 1. Reverse the string and then compare with original string
 2. Split and then use binary search to find palindrome nature. 

 Input:
 dad

 Output:
 String is a palindrome.

 */
public class PalindromeString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		// str = "dad";
		// str = "program";
		System.out.println("Is \"" + str + "\" a palindrome? " + palindrome(str));
		System.out.println("Is \"" + str + "\" a palindrome? " + palindromeByReversingString(str));
		scanner.close();
	}

	/**
	 * This method uses binary search technique.
	 * @param str String
	 * @return boolean
	 */
	private static boolean palindrome(String str) {
		boolean palindromeFlag = true;
		int pivotIndex = str.length() / 2;
		int j = str.length() - 1;
		for (int i = 0; i <= pivotIndex; i++) {
			if (str.charAt(i) != str.charAt(j)) {
				palindromeFlag = false;
				break;
			}
			j--;
		}
		return palindromeFlag;
	}

	/**
	 * This method reverses the string and compares with original string.
	 * @param str String
	 * @return boolean
	 */
	private static boolean palindromeByReversingString(String str) {
		final StringBuilder sb = new StringBuilder(str).reverse();
		sb.reverse();
		return str.equals(sb.toString());
	}
}
