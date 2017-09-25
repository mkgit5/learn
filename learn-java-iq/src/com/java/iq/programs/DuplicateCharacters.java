package com.java.iq.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 Find the duplicate characters and print them.

 Ways:
 HashMap<Character, Integer> or LinkedHashMap

 Input:
 Hello

 Output:
 H 1
 e 1
 l 2
 o 1

 */
public class DuplicateCharacters {

	public static void main(String[] args) {
		System.out.println("Enter value to find duplicate characters: ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		usingHash(str);
	}

	private static void usingHash(String str) {
		char[] characters = str.toCharArray();
		Map<Character, Integer> counter = new HashMap<Character, Integer>(characters.length);

		for (char c : characters) {
			if (counter.containsKey(c)) {
				counter.put(c, counter.get(c) + 1);
			} else {
				counter.put(c, 1);
			}
		}

		for (char c : counter.keySet()) {
			System.out.println(c + " " + counter.get(c));
		}
	}

}
