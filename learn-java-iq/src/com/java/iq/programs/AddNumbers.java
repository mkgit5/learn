package com.java.iq.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Find the sum of 2 numbers.

 Condition:
 First line indicates number of test cases
 Second line has two numbers separated by space.

 Input: 
 1
 1 2

 Output:
 3

 */
public class AddNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
			String line2 = br.readLine();
			String[] split = line2.split(" ");

			int sum = 0;
			for (String n : split) {
				sum += Integer.parseInt(n);
			}
			System.out.println(sum);
		}
		br.close();

	}

}
