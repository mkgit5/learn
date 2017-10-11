package com.java.iq.dynamic.programming;

/*

101110 is a binary number
10110101 is a binary number

128956 is not a binary number
42578 is not a binary number
 
 */
public class BinaryNumber {
	static void isBinaryOrNot(int number) {
		int num = number;
		boolean isBinary = true;
		while (num != 0) {
			int temp = num % 10; // Gives last digit of the number
			if (temp > 1) {
				isBinary = false;
				break;
			} else {
				num = num / 10; // Removes last digit from the number
			}
		}

		if (isBinary) {
			System.out.println(number + " is a binary number");
		} else {
			System.out.println(number + " is not a binary number");
		}
	}

	public static void main(String[] args) {
		isBinaryOrNot(128956);
		isBinaryOrNot((101110));
		isBinaryOrNot((42578));
		isBinaryOrNot((10110101));
	}
}
