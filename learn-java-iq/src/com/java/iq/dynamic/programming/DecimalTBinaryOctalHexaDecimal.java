package com.java.iq.dynamic.programming;

/*
Decimal : 50 
Binary 	: 110010

Decimal : 1000
Octal 	: 1750

Decimal : 2000
Hexa	: 7D0

 */
public class DecimalTBinaryOctalHexaDecimal {

	public static void decimalToBinary(int num) {
		System.out.println("Decimal Number : " + num);
		int inputNumber = num;

		// Initializing binary to empty string
		String binary = "";

		// Defining rem to store remainder
		int rem = 0;

		// See the below explanation to know how this loop works
		while (inputNumber > 0) {
			rem = inputNumber % 2;
			binary = rem + binary;
			inputNumber = inputNumber / 2;
		}

		System.out.println("Binary Equivalent of " + num + " is " + binary);
	}

	public static void decimalToOctal(int num) {
		System.out.println("Decimal Number : " + num);
		int inputNumber = num;
		// Initializing binary to empty string
		String octal = "";
		// Defining rem to store remainder
		int rem = 0;
		// See the below explanation to know how this loop works
		while (inputNumber > 0) {
			rem = inputNumber % 8;
			octal = rem + octal;
			inputNumber = inputNumber / 8;
		}

		System.out.println("Octal Equivalent of " + num + " is " + octal);
	}

	public static void decimalToHexadecimal(int num) {
		System.out.println("Decimal Number : " + num);
		int inputNumber = num;

		// Initializing binary to empty string
		String hexa = "";

		// Digits in HexaDecimal Number System
		char hexaDecimals[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// Defining rem to store remainder
		int rem = 0;
		// See the below explanation to know how this loop works
		while (inputNumber > 0) {
			rem = inputNumber % 16;
			hexa = hexaDecimals[rem] + hexa;
			inputNumber = inputNumber / 16;
		}

		System.out.println("HexaDecimal Equivalent of " + num + " is " + hexa);
	}

	public static void main(String[] args) {
		decimalToBinary(50);
		decimalToOctal(1000);
		decimalToHexadecimal(2000);
	}

}
