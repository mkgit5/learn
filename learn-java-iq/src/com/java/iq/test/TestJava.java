package com.java.iq.test;

import java.util.Stack;

public class TestJava {

	public static void main(String[] args) throws InterruptedException {
		// System.out.println(10 % 20);
		// System.out.println("abc".substring(0, 0));
		//
		// int[] i = new int[10];
		// Arrays.fill(i, -1);
		// System.out.println(Arrays.toString(i));

		// LinkedList<Integer> list = new LinkedList<>();
		//
		// list.add(1);
		// System.out.println(list.get(0));
		// list.remove(new Integer(1));
		// System.out.println(list.isEmpty());

		// balancedParanthesis();

		// System.out.println(Math.ceil(1.4));
		// System.out.println(Math.ceil(1.5));
		// System.out.println(Math.ceil(1.9));
		// System.out.println(Math.floor(1.4));
		// System.out.println(Math.floor(1.5));
		// System.out.println(Math.floor(1.9));
		// int i = 17 % 3;
		// System.out.println(i);
		// System.out.println(Math.log(4));

		// Get available processors of the underlying machine.
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

	public static void balancedParanthesis() {
		String str = "}]";
		char[] c = str.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == '[' || c[i] == '{' || c[i] == '(') {
				stack.push(c[i]);
			} else {
				if (!stack.isEmpty() && stack.pop() == matchingCloseParanthesis(c[i])) {
					continue;
				} else {
					System.out.println("Unbalanced paranthesis!");
					return;
				}
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("Unbalanced paranthesis!");
		} else {
			System.out.println("Balanced paranthesis!");
		}
	}

	private static char matchingCloseParanthesis(char c) {
		if (c == ']') {
			return '[';
		} else if (c == '}') {
			return '{';
		} else {
			return '(';
		}
	}

}
