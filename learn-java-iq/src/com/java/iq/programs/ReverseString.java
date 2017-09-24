package com.java.iq.programs;

/*
 Reverse a string.

 Ways:
 1. Iterate backwards and store it in StringBuilder
 2. Use binary search logic and swap values in char array
 3. Recursive method [recurse(str.substring(1)) + str.charAt(0)]
 4. In place - Use StringBuilder.setCharAt(index, 'value')

 */
public class ReverseString {

	public static void main(String[] args) {
		// String str = "Hello world";
		// String str = "Do or do not, there is no try.";
		String str = "HOW";
		System.out.println("String before reversing - " + str);
		System.out.println("String after reversal - " + reverseString1(str));
		System.out.println("String after reversal - " + reverseString2(str));
		System.out.println("String after reversal (recursively) - " + recursivelyReverse(str));
		System.out.println("String after reversal (in place) - " + reverseStringInPlace(str));

	}

	private static String reverseString1(String str) {
		char[] charArray = str.toCharArray();
		char[] temp = new char[charArray.length];
		int i = 0;
		for (int j = charArray.length - 1; j >= 0; j--) {
			temp[i] = charArray[j];
			i++;
		}
		return new String(temp);
	}

	private static String reverseString2(String str) {
		char[] charArray = str.toCharArray();
		char temp;
		int pivotIndex = charArray.length / 2;
		int i = 0;
		for (int j = charArray.length - 1; j >= 0; j--) {
			if (j < pivotIndex) {
				break;
			} else {
				temp = charArray[j];
				charArray[j] = charArray[i];
				charArray[i] = temp;
			}
			i++;
		}
		return new String(charArray);
	}

	private static String recursivelyReverse(String str) {
		if (str.length() < 2) {
			return str;
		}

		return recursivelyReverse(str.substring(1)) + str.charAt(0);
	}

	private static String reverseStringInPlace(String str) {
		int j = str.length() - 1;
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < str.length() / 2; i++) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			j--;
		}
		return sb.toString();
	}
}
