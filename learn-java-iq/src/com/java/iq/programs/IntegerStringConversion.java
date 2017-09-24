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
		int i = 0, number = 0;
		boolean isNegative = false;
		int len = str.length();
		if (str.charAt(0) == '-') {
			isNegative = true;
			i = 1;
		}
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
