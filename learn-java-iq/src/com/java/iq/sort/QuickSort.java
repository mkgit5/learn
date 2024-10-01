package com.java.iq.sort;

/*
 Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and conquer algorithm. 
 Quicksort first divides a large list into two smaller sub-lists: the low elements and the high elements. 
 Quicksort can then recursively sort the sub-lists.

 Steps to implement Quick sort:

 1. Choose an element, called pivot, from the list. Generally pivot can be the middle index element.

 2. Reorder the list so that all elements with values less than the pivot come before the pivot, 
 while all elements with values greater than the pivot come after it (equal values can go either way). 
 After this partitioning, the pivot is in its final position. This is called the partition operation.

 3. Recursively apply the above steps to the sub-list of elements with smaller values and separate the sub-list
 of elements with greater values.

 Performance:
 Best	: O(n log n)
 Avg	: O(n log n)
 Worst	: O(n^2)

 */
public class QuickSort {

	public static void main(String[] args) {
		// int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7 };
		int[] arr = new int[] { 4, 3, 2, 1 };
		int length = arr.length;

		QuickSort sort = new QuickSort();
		System.out.print("Unsorted array: ");
		sort.printData(arr);

		System.out.println("Quick sort...");
		sort.recursiveQuickSort(arr, 0, length - 1);

		System.out.print("Sorted array: ");
		sort.printData(arr);

	}

	/**
	 * Recursive quick sort logic.
	 * @param array input array
	 * @param low start index of the array
	 * @param high end index of the array
	 */
	public void recursiveQuickSort(int[] array, int low, int high) { // 12
		int idx = partition(array, low, high);

		// Recursively call quick sort with left part of the partitioned array
		if (low < idx - 1) {
			recursiveQuickSort(array, low, idx - 1); // 6 // 3 // 1
		}

		// Recursively call quick sort with right part of the partitioned array
		if (high > idx) { // 6 // 3 // 1
			recursiveQuickSort(array, idx, high);
		}
	}

	/**
	 * Divides array from pivot, left side contains elements less than pivot, while
	 * right side contains elements greater than pivot.
	 * 
	 * @param array array to be partitioned
	 * @param left  lower bound of the array
	 * @param right upper bound of the array
	 * @return the partition index
	 */
	private int partition(int[] array, int left, int right) {
		// Taking first element as pivot
		int pivot = array[left];

		while (left <= right) {
			// Searching number which is greater than pivot, bottom up
			while (array[left] < pivot) {
				left++;
			}

			// Searching number which is less than pivot, top down
			while (array[right] > pivot) {
				right--;
			}

			// Swap the values
			if (left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;

				// Increment left index and decrement right index
				left++;
				right--;
			}
		}
		return left;
	}

	public void quickSort(int[] a, int low, int high) {
		int i = low;
		int j = high;

		int pivot = a[(low + high) / 2];

		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which is greater then the pivot value,
			 * and also we will identify a number from right side which is less then the pivot value.
			 * Once the search is done, then we exchange both numbers.
			 */
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swapValues(a, i, j);
				// Move index to next position on both sides
				i++;
				j--;
			}
		}

		// Call quickSort() method recursively
		if (low < j) {
			quickSort(a, low, j);
		}
		if (i < high) {
			quickSort(a, i, high);
		}
	}

	private void swapValues(int[] arr, int startIndex, int smallerValueIndex) {
		int smallerValue = arr[smallerValueIndex];
		arr[smallerValueIndex] = arr[startIndex];
		arr[startIndex] = smallerValue;
	}

	private void printData(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + ",");
		}
		System.out.println();
	}

}
