package com.java.iq.dynamic.programming;

import java.util.Scanner;
import java.util.Stack;

/*

A stack helps with the problem. 
While traversing the input, put all of the open parenthesis into the stack, pops an open parenthesis when a matching close parenthesis shows up.
Otherwise if they fail to match, return invalid as the result.

*/
public class BalancedParanthesis {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string of paranthesis: ");
		String input = scanner.nextLine();
		System.out.println(isValid(input) ? "Balanced!" : "Unbalanced!");

		scanner.close();
	}

	private static boolean isValid(String input) {
		final Stack<Character> stack = new Stack<Character>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (stack.isEmpty() || stack.pop() != getMatchingParanthesis(c)) {
				return false;
			}
		}
		return stack.isEmpty() ? true : false;
	}

	private static Character getMatchingParanthesis(char c) {
		if (c == ')')
			return '(';
		if (c == ']')
			return '[';
		return '{';
	}

}
