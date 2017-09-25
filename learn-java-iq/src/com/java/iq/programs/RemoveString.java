package com.java.iq.programs;

/*
 Write an efficient function that deletes characters from an ASCII string. 
 Use the prototype string removeChars(string str, string remove); 
 where any character existing in remove must be deleted from str. 
 For example, given str of "Battle of the Vowels: Hawaii vs. Grozny" and a remove of "aeiou",
 the function should transform str to “Bttl f th Vwls: Hw vs. Grzny”. 
 Justify any design decisions you make, and discuss the efficiency of your solution.
 */
public class RemoveString {

	public static void main(String[] args) {
		String str = "Battle of the Vowels: Hawaii vs. Grozny";
		String remove = "aeiou";
		System.out.println(removeChars(str, remove));
	}

	public static String removeChars(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();

		// Flags automatically initialized to false, size of 128 assumes ASCII
		boolean[] flags = new boolean[128];

		// Set flags for characters to be removed
		for (int i = 0; i < r.length; ++i) {
			flags[r[i]] = true;
		}

		// Now loop through all the characters, copying only if they aren’t flagged
		int j = 0;
		for (int i = 0; i < s.length; ++i) {
			if (!flags[s[i]]) {
				s[j++] = s[i];
			}
		}
		return new String(s, 0, j);
	}

}
