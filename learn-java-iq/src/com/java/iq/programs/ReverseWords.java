package com.java.iq.programs;

/*
 Reverse words

 Input: 
 Do or do not, there is no try.

 Output:
 try. no is there not, do or Do 

 Reverse words in place

 Input: 
 Do or do not, there is no try.

 Output:
 oD ro  od  ,ton  ereht  si  on  yrt .

 */
public class ReverseWords {

	public static void main(String[] args) {
		String str = "Do or do not, there is no try.";
		System.out.println(str);
		System.out.println("Reversed words - " + swapWords(str));

		System.out.println("Reversed words (in place) - " + reverseWords(str));
	}

	private static String swapWords(String str) {
		String[] splitStr = str.split(" ");
		StringBuilder swappedStr = new StringBuilder();
		for (int index = splitStr.length - 1; index >= 0; index--) {
			swappedStr.append(splitStr[index]).append(' ');
		}
		return swappedStr.toString();
	}

	private static String reverseWords(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				int j = i - 1;
				while (j >= 0 && str.charAt(j) != ' ') {
					sb.append(str.charAt(j));
					j--;
				}
				sb.append(str.charAt(i));
			}
			if (i == str.length() - 1) {
				int j = i - 1;
				while (str.charAt(j) != ' ') {
					sb.append(str.charAt(j));
					j--;
				}
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
