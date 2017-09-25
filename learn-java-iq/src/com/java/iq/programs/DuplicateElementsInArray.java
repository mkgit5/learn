package com.java.iq.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 Find the duplicate elements in an array and print them.

 Ways:
 HashMap<Character, Integer> or LinkedHashMap

 Input:
 12344

 Output:
 1 1
 2 1
 3 1
 4 2 

 */
public class DuplicateElementsInArray {

	public static void main(String[] args) {
		int[] intArray = new int[] { 1, 2, 3, 4, 4 };
		findDuplicatesByIteration(intArray);
	}

	private static void findDuplicatesByIteration(int[] intArray) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>(intArray.length);
		for (int i = 0; i < intArray.length; i++) {
			if (count.containsKey(intArray[i])) {
				count.put(intArray[i], count.get(intArray[i]) + 1);
			} else {
				count.put(intArray[i], 1);
			}
		}

		for (Entry<Integer, Integer> entry : count.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
