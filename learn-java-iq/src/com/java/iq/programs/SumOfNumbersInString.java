package com.java.iq.programs;

/*
 *
 * Given the following inputs, we expect the corresponding output:
 * "1a2b3c" => 6        (1+2+3)
 * "123ab!45c" => 168   (123+45)
 * "abcdef" => 0        (no Integers in String)
 * "0123.4" => 127      (0123+4)
 * "dFD$#23+++12@#T1234+;/.,10"  => 1279  (23+12+1234+10)
 * "12a-10b" => 2		(12-10)
 */
public class SumOfNumbersInString {

	public static void main(String[] args) {
		// System.out.println(sumOfNumbers("1a2b3c"));
		// System.out.println(sumOfNumbers("123ab!45c"));
		// System.out.println(sumOfNumbers("abcdef"));
		System.out.println(sumOfNumbers("0123.4"));
		System.out.println(sumOfNumbers("dFD$#23+++12@#T1234+;/.,10"));
		System.out.println(sumOfNumbers("12a-10b"));
	}

	public static int sumOfNumbers(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder().append(0);
		boolean isSubtract = false;
		for (int i = 0; i < str.length(); i++) {
			if (isNumber(str.charAt(i))) {
				sb.append(str.charAt(i));

				// If the string ends with a number, then add last number to the count variable
				if (i + 1 == str.length()) {
					if (isSubtract) {
						count -= Integer.parseInt(sb.toString());
					} else {
						count += Integer.parseInt(sb.toString());
					}
				}
			} else {
				if (!isSubtract) {
					isSubtract = isSubtraction(str.charAt(i));
				}
				if (isSubtract) {
					count -= Integer.parseInt(sb.toString());
				} else {
					count += Integer.parseInt(sb.toString());
				}
				if (i < str.length()) {
					sb = new StringBuilder().append(0);
				}
			}
		}
		return count;
	}

	private static boolean isSubtraction(char c) {
		return c == '-' ? true : false;
	}

	private static boolean isNumber(char c) {
		try {
			Integer.parseInt(c + "");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
