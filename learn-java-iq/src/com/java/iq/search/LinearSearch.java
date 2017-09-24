package com.java.iq.search;

/*
 * Linear search or sequential search is a method for finding a particular value in a list, 
 * that consists of checking every one of its elements, one at a time and in sequence, until the desired one is found. 
 * Linear search is the simplest search algorithm. 
 * 
 * For a list with n items, the best case is when the value is equal to the first element of the list, 
 * in which case only one comparison is needed. 
 * 
 * The worst case is when the value is not in the list (or occurs only once at the end of the list), 
 * in which case n comparisons are needed. 
 * 
 * The worst case performance scenario for a linear search is that it has to loop through the entire collection, 
 * either because the item is the last one, or because the item is not found. 
 * In other words, if you have N items in your collection, the worst case scenario to find an item is N
 * iterations. 
 * 
 * In Big O Notation it is O(n). The speed of search grows linearly with the number of items within your collection.
 * 
 * Performance:
 * Best : O(1)
 * Worst: O(n)
 * 
 */
public class LinearSearch {

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int searchKey = 10;
		linearSearch(arr, searchKey);
	}

	public static int linearSearch(int[] arr, int key) {
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] == key) {
				System.out.println("Key " + key + " found at index " + (index + 1));
				return arr[index];
			}
		}
		return -1;
	}

}
