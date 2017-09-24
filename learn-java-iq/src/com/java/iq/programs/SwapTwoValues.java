package com.java.iq.programs;

public class SwapTwoValues {

	public static void main(String[] args) {
		swapValues();
	}

	private static void swapValues() {
		int a = 10;
		int b = 20;

		System.out.println("Values before swap...");
		System.out.println("a=" + a);
		System.out.println("b=" + b);

		a = a + b; // a = 30
		b = a - b; // b = 10
		a = a - b; // a = 20

		System.out.println("Values after swap...");
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}

}
