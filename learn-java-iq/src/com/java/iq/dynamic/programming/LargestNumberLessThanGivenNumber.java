package com.java.iq.dynamic.programming;

/*
 * Java Program To Find Largest Number Less Than Given Number And Without A Given Digit
 * Converting digit to char
 * Decrement the number & check whether it contains digit
 */
public class LargestNumberLessThanGivenNumber {
	static int getLessThanN(int number, int digit) {
		// Converting digit to char
		char c = Integer.toString(digit).charAt(0);

		// Decrementing number & checking whether it contains digit
		for (int i = number; i > 0; --i) {
			if (Integer.toString(i).indexOf(c) == -1) {
				// If 'i' doesn't contain 'c'
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(getLessThanN(123, 2));
		System.out.println(getLessThanN(4582, 5));
		System.out.println(getLessThanN(98512, 5));
		System.out.println(getLessThanN(548624, 8));
	}

}
