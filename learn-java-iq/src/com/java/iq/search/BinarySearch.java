package com.java.iq.search;

/*
 * A binary search or half-interval search algorithm finds the position of a specified value (the input "key") 
 * within a sorted array. 
 * In each step, the algorithm compares the input key value with the key value of the middle element of the array. 
 * If the keys match, then a matching element has been found so its index, or position, is returned. 
 * Otherwise, if the sought key is less than the middle element's key, then the algorithm repeats its action on 
 * the sub-array to the left of the middle element or, if the input key is greater, on the sub-array to the right.
 * If the remaining array to be searched is reduced to zero, then the key cannot be found in the array and a special 
 * "Not found" indication is returned.
 * Every iteration eliminates half of the remaining possibilities. This makes binary searches very efficient - even 
 * for large collections.
 * 
 * Binary search requires a sorted collection. 
 * Also, binary searching can only be applied to a collection that allows random access (indexing).
 * 
 * Performance:
 * Best : O(1)
 * Worst: O(log n) = n, n/2, n/4
 * 
 * What is O(log n)?
 * Basically means time goes up linearly while the n goes up exponentially. 
 * So if it takes 1 second to compute 10 elements, 
 * it takes 2 seconds to compute 100 elements, 
 * 3 seconds to compute 1000 elements, and so on. ​
 * It is O(log n) when we do divide and conquer type of algorithms e.g binary search.
 * 
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int searchKey = 10;
		final BinarySearch bs = new BinarySearch();
		System.out.println("Search by divide and conquer method.");
		int index = bs.binarySearch(arr, searchKey);
		System.out.println("Key " + searchKey + " found at index " + index);
		System.out.println("Search by recursive method.");
		index = bs.recursiveBinarySearch(arr, 0, arr.length, searchKey);
		System.out.println("Key " + searchKey + " found at index " + index);
	}

	public int binarySearch(int[] arr, int searchKey) {
		int start = 0;
		int end = arr.length;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == searchKey) {
				return mid;
			} else if (arr[mid] > searchKey) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int recursiveBinarySearch(int arr[], int start, int end, int key) {
		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return recursiveBinarySearch(arr, start, mid - 1, key);
		} else {
			return recursiveBinarySearch(arr, mid + 1, end, key);
		}
	}

}
