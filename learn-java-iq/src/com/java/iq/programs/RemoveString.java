package com.java.iq.programs;

/*
 Write an efficient function that deletes characters from an ASCII string. 
 Use the prototype string removeChars(string str, string remove); 
 where any character existing in remove must be deleted from str. 
 For example, given str of "Battle of the Vowels: Hawaii vs. Grozny" and a remove of "aeiou",
 the function should transform str to “Bttl f th Vwls: Hw vs. Grzny”. 
 Justify any design decisions you make, and discuss the ef ciency of your solution.
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
		int src, dst = 0;
		// flags automatically initialized to false, size of 128 assumes ASCII
		boolean[] flags = new boolean[128];
		// Set flags for characters to be removed
		for (src = 0; src < r.length; ++src) {
			flags[r[src]] = true;
		}
		// Now loop through all the characters, // copying only if they aren’t flagged
		for (src = 0; src < s.length; ++src) {
			if (!flags[s[src]]) {
				s[dst++] = s[src];
			}
		}
		return new String(s, 0, dst);
	}

}
