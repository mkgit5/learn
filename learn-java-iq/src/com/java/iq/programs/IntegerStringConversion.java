package com.java.iq.programs;

public class IntegerStringConversion {

	public static void main(String[] args) {
		int i = -123;

		String str = intToString(i);
		System.out.println("Int to String: " + str);

		System.out.println("String to int: " + stringToInt(str));
	}

	private static String intToString(int i) {
		// return String.valueOf(i);
		return "" + i;
	}

	/*
	 * String str = "123";
	 */
	public static int stringToInt(String str) {
		// int i = Integer.parseInt(str);

		boolean isNegative = false;
		int len = str.length();
		int i = 0;
		if (str.charAt(0) == '-') {
			isNegative = true;
			i = 1;
		}
		int number = 0;
		while (i < len) {
			number *= 10;
			number += str.charAt(i) - '0';
			i++;
		}
		if (isNegative)
			number = -number;
		return number;
	}

}
