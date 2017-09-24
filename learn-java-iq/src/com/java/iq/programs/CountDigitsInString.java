package com.java.iq.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Print number of occurrences of digits (0 - 9) in a string.

 Input:
 1234561

 Output:
 0 0
 1 2
 2 1
 3 1
 4 1
 5 1
 6 1
 7 0
 8 0
 9 0

 */
public class CountDigitsInString {

	public static void main(String[] args) throws IOException {
		int[] count = new int[10];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		for (int i = 0; i < line.length(); i++) {
			int j = Integer.parseInt(String.valueOf(line.charAt(i)));
			count[j] = ++count[j];
		}
		for (int i = 0; i < count.length; i++) {
			System.out.println(i + "  " + count[i]);
		}

	}
}
