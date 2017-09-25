package com.java.iq.programs;

public class IntegerStringConversion {

	public static void main(String[] args) {
		int i = 4;
		String str = convertIntegerToString1(i);
		System.out.println(str);

		System.out.println(stringToint(str));
	}

	private static String convertIntegerToString1(int i) {
		return "" + i;
	}

	public static int stringToint(String str) {
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
			number += (str.charAt(i) - '0');
			i++;
		}
		if (isNegative)
			number = -number;
		return number;
	}

}
