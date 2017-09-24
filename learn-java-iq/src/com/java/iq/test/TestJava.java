package com.java.iq.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestJava {

	public static void main(String[] args) {

		List<Integer> test = new LinkedList<Integer>();
		// test.rem

		// 121
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the text : ");
		String line = scanner.nextLine();

		char[] charArray = line.toCharArray();

		StringBuilder sb = new StringBuilder();// Hello --> Helo

		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					charArray[j] = 0;
				}
			}
			if (charArray[i] != 0) {
				sb.append(charArray[i]);
			}
		}

		System.out.println(sb.toString());

		scanner.close();
	}
}
