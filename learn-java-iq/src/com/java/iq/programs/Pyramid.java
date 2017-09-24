package com.java.iq.programs;

/*
 *     *			5 space + star
 *    * *			4 space + star + space + star
 *   * * *			3 space + star + space + star + space + star
 *  * * * *			2 space + star + space + star + space + star + space + star
 * * * * * *		1 space + star + space + star + space + star + space + star + space + star
 * 
 *     0			5 space + 0
 *    0 1			4 space + 0 + space + 1
 *   0 1 2			3 space + 0 + space + 1 + space + 2
 *  0 1 2 3			2 space + 0 + space + 1 + space + 2 + space + 3
 * 0 1 2 3 4		1 space + 0 + space + 1 + space + 2 + space + 3 + space + 4
 */
public class Pyramid {

	public static void main(String[] args) {
		System.out.println("Pyramid pattern of star in Java : ");
		drawPyramidOfStars();

		System.out.println("Pyramid of numbers in Java : ");
		drawPyramidOfNumbers();
	}

	private static void drawPyramidOfStars() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void drawPyramidOfNumbers() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
