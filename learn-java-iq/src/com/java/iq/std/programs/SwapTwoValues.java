package com.java.iq.std.programs;

public class SwapTwoValues {

	public static void main(String[] args) {
		swapValues();
		swapInSingleLine();
	}

	private static void swapValues() {
		int a = 10;
		int b = 20;

		System.out.println("Values before swap...");
		System.out.println("a=" + a);
		System.out.println("b=" + b);

		// a + b = 10 + 20 = 30 = a
		// a - b = 30 - 20 = 10 = b
		// a - b = 30 - 10 = 20 = a

		a = a + b; // a = 30
		b = a - b; // b = 10
		a = a - b; // a = 20

		System.out.println("Values after swap...");
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}

	// Java program to swap two variables in single line
	public static void swapInSingleLine() {
		int x = 5, y = 10;
		System.out.println("Before swapping values of x and y are " + x + " " + y);
		x = x ^ y ^ (y = x);
		System.out.println("After swapping values of x and y are " + x + " " + y);
	}

}
