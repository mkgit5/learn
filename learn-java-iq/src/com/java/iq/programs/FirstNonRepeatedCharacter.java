package com.java.iq.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 Find first non-repeated character in a string

 Ways:
 1. HashMap<Character, Integer>
 2. LinkedHashMap<Character, Integer>
 3. Set (unique char) and List (repeated char) in a single loop
 4. int[] (counter) and char[]

 */
public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		System.out.println("Enter value to find first non-repeated character: ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();

		// str = "Hello";
		// str = "dadade";
		System.out.println("First non-repeated char is " + firstNonRepeatedChar1(str));
		System.out.println("First non-repeated char is " + firstNonRepeatedChar2(str));
		System.out.println("First non-repeated char is " + firstNonRepeatedChar3(str));
		System.out.println("First non-repeated char is " + firstNonRepeatedChar4(str));
	}

	/*
	 * Using HashMap to find first non-repeated character from String in Java.
	 * Algorithm :
	 * Step 1 : Scan String and store count of each character in HashMap
	 * Step 2 : traverse String and get count for each character from Map.
	 * Since we are going through String from first to last character, when count for any character is 1, we break,
	 * it's the first non repeated character.
	 * Here order is achieved by going through String again.
	 */
	private static char firstNonRepeatedChar1(String word) {
		final Map<Character, Integer> scoreboard = new HashMap<>();
		// Build table [char -> count]
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.containsKey(c)) {
				scoreboard.put(c, scoreboard.get(c) + 1);
			} else {
				scoreboard.put(c, 1);
			}
		}
		// Since HashMap doesn't maintain order, going through string again
		char firstNonRepeatedChar = '0';
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.get(c) == 1) {
				firstNonRepeatedChar = c;
			}
		}
		return firstNonRepeatedChar;
	}

	/*
	 * Finds first non repeated character in a String in just one pass.
	 * It uses two storage to cut down one iteration, standard space vs time trade-off.
	 * Since we store repeated and non-repeated character separately, at the end of iteration, first
	 * element from List is our first non repeated character from String.
	 */
	private static char firstNonRepeatedChar2(String word) {
		final Set<Character> repeating = new HashSet<>();
		final List<Character> nonRepeating = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (repeating.contains(letter)) {
				continue;
			}
			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		char firstNonRepeatedChar = '0';
		if (nonRepeating != null && nonRepeating.size() > 0) {
			firstNonRepeatedChar = nonRepeating.get(0);
		}

		return firstNonRepeatedChar;
	}

	/*
	 * Using LinkedHashMap to find first non repeated character of String
	 * Algorithm :
	 * Step 1: get character array and loop through it to build a hash table with char and their count.
	 * Step 2: loop through LinkedHashMap to find an entry with value 1,
	 * that's your first non-repeated character, as LinkedHashMap maintains insertion order.
	 */
	private static char firstNonRepeatedChar3(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		char firstNonRepeatedChar = '0';
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				firstNonRepeatedChar = entry.getKey();
				break;
			}
		}
		return firstNonRepeatedChar;
	}

	private static char firstNonRepeatedChar4(String str) {
		char[] charArray = str.toCharArray();
		int[] counter = new int[charArray.length];
		for (int i = 0; i < charArray.length - 1; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					counter[i] = 1;
					counter[j] = 1;
				}
			}
		}

		char firstNonRepeatedChar = '0';
		for (int i = 0; i < charArray.length; i++) {
			if (counter[i] == 0) {
				firstNonRepeatedChar = charArray[i];
				break;
			}
		}
		return firstNonRepeatedChar;
	}

}
