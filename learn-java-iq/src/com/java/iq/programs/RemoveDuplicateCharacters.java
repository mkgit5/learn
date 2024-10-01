package com.java.iq.programs;

import java.util.Scanner;

/*
 * Input: Hello
 * Output: Helo		
 */
public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		final Scanner scanner = new Scanner(System.in);
		final String str = scanner.nextLine();
		scanner.close();

		System.out.println(removeDuplicates(str));
		System.out.println(removeDuplicates2(str));
	}

	public static String removeDuplicates(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length - 1; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					charArray[j] = 0;
				}
			}

		}
		return toUniqueString(charArray);
	}

	public static String removeDuplicates2(String str) {
		boolean[] ascii = new boolean[256];
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (!ascii[charArray[i]]) {
				ascii[charArray[i]] = true;
			} else {
				charArray[i] = 0;
			}
		}
		return toUniqueString(charArray);
	}

	/*
	 * Utility method to convert Character array to String, omitting NUL character, ASCII value 0.
	 */
	public static String toUniqueString(char[] letters) {
		StringBuilder sb = new StringBuilder(letters.length);
		for (char c : letters) {
			if (c != 0) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
