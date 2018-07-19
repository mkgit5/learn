package com.java.iq.programs;

/*
  1s complement of 10000000 is 01111111
  2s complement of 10000000 is 10000000
 */
public class TwosCompliment {

	public static void main(String[] args) {
		TwosCompliment twosCompliment = new TwosCompliment();
		twosCompliment.twosCompliment("10000000");
	}

	public String onesCompliment(String bin) {
		String ones = "";
		for (int i = 0; i < bin.length(); i++) {
			ones += flip(bin.charAt(i));
		}
		return ones;
	}

	public String twosCompliment(String bin) {
		String twos = "";
		String ones = onesCompliment(bin);
		StringBuilder builder = new StringBuilder(ones);
		boolean b = false;
		for (int i = ones.length() - 1; i >= 0; i--) {
			if (ones.charAt(i) == '1') {
				builder.setCharAt(i, '0');
			} else {
				builder.setCharAt(i, '1');
				b = true;
				break;
			}
		}

		twos = builder.toString();

		System.out.println("Value - " + bin);
		System.out.println("Ones Compliment - " + ones);
		System.out.println("Twos Compliment - " + twos);

		return twos;
	}

	// Returns '0' for '1' and '1' for '0'
	public char flip(char c) {
		return (c == '0') ? '1' : '0';
	}

}
