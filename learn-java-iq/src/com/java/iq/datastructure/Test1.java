package com.java.iq.datastructure;

public class Test1 {

	public static void main(String[] args) {

		final String inputStr = "Count and Print";
		final String[] strArray = inputStr.split(" ");
		int present = 0;
		int absent = 0;

		for (int i = 0; i < strArray.length; i++) {
			if (inputStr.contains("nt")) {
				present++;
			} else {
				absent++;
			}
		}

		System.out.println("Number of words containing ‘nt’: " + present);
		System.out.println("Number of words not containing ‘nt’: " + absent);

	}

}