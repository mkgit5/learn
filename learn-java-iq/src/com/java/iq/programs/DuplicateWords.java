package com.java.iq.programs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 Find duplicate words in a string

 Ways:
 Using Set<String> (2 set variables: set and duplicates)
 
 Input:
 This sentence contains two words, one and two

 */
public class DuplicateWords {

	public static void main(String[] args) {
		String str = "This sentence contains two words, one and two";
		Set<String> duplicates = duplicateWords(str);
		System.out.println("input : " + str);
		System.out.println("output : " + duplicates);
	}

	/**
	 * Method to find duplicate words in a Sentence or String
	 * @param str String
	 * @return set of duplicate words
	 */
	public static Set<String> duplicateWords(String str) {
		if (str == null || str.isEmpty()) {
			return Collections.emptySet();
		}

		String[] words = str.split("\\s+");

		Set<String> duplicates = new HashSet<String>();
		Set<String> set = new HashSet<>();
		for (String word : words) {
			if (!set.add(word)) {
				duplicates.add(word);
			}
		}
		return duplicates;
	}

}
