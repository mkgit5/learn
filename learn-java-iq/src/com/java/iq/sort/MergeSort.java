package com.java.iq.sort;

/*
 Merge sort is a divide and conquer algorithm.

 Steps:

 1. Divide the unsorted array into n partitions, each partition contains 1 element. 
 Here the one element is considered as sorted.

 2. Repeatedly merge partitioned units to produce new sublists until there is only 1 sublist remaining. 
 This will be the sorted list at the end.

 */
public class MergeSort {

	private int[] array;
	private int[] mergedArray;
	private int length;

	public static void main(String a[]) {
		int[] arr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		// int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10 };
		// int[] arr = new int[] { 4, 3, 2, 1 };

		MergeSort sort = new MergeSort();
		sort.sort(arr);
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.mergedArray = new int[length];
		mergeSort(0, length - 1);
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			// Sorts the left side of the array
			mergeSort(low, mid);
			// Sorts the right side of the array
			mergeSort(mid + 1, high);
			// Now merge both sides
			mergePartitions(low, mid, high);
		}
	}

	private void mergePartitions(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			mergedArray[i] = array[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (mergedArray[i] <= mergedArray[j]) {
				array[k] = mergedArray[i];
				i++;
			} else {
				array[k] = mergedArray[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			array[k] = mergedArray[i];
			k++;
			i++;
		}

	}
}
