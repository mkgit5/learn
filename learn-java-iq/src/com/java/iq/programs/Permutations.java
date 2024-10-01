package com.java.iq.programs;

import java.util.Scanner;

/*
 1. Permutations with Repetition:
 	P(n,r) = n^r
 	Where n is the number of things to choose from, and we choose r of them
 	(Repetition allowed, order matters) 

 	Ex: P(10,2) = 10^2 = 100

 2. Permutations without Repetition:
 	P(n,r) = nPr = n!/(n-r)!
 	Where n is the number of things to choose from, and we choose r of them
 	(No repetition, order matters)

 	Ex: P(10,2) = 10!/(10-2)! = 10!/8! = 10 * 9 = 90

 Note: Factorial function (symbol: !) just means to multiply a series of descending natural numbers. 
 Examples: 4! = 4 × 3 × 2 × 1 = 24

	EG: abc ==> abc, acb, bac, bca, cab, cba ==> 3!

 */
public class Permutations {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Enter characters to find the permuations: ");
		String word = scanner.nextLine();
		permutations(word);
	}

	private static void permutations(String word) {
		permutations("", word);
	}

	private static void permutations(String perm, String word) {
		if (word.isEmpty()) {
			System.out.println("PERM: " + perm + word);
		}
		for (int i = 0; i < word.length(); i++) {
			System.out.println("Index: " + i + "\tPerm: " + perm + "   Word: " + word
					+ "\tpermutations(" + perm + word.charAt(i) + "," + word.substring(0, i)
					+ word.substring(i + 1, word.length()) + ")");

			permutations(perm + word.charAt(i),
					word.substring(0, i) + word.substring(i + 1, word.length()));

			System.out.println("Nothing");
		}

	}
}
