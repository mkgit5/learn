package com.java.iq.sort;

/*
 Starting on the left, compare adjacent items and keep “bubbling” the larger one to the right (it’s in its final place). 
 Bubble sort the remaining N -1 items.
 Though “simple” I found bubble sort nontrivial. 

 In general, sorts where you iterate backwards (decreasing some index) were counter-intuitive for me.
 With bubble-sort, either you bubble items “forward” (left-to-right) and move the endpoint backwards (decreasing), 
 or bubble items “backward” (right-to-left) and increase the left endpoint. Either way, some index is decreasing.
 You also need to keep track of the next-to-last endpoint, so you don’t swap with a non-existent item.

 Performance:
 Best  : O(n)
 Worst : O(n^2)

 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10 };
		BubbleSort bs = new BubbleSort();

		System.out.print("Unsorted array: ");
		bs.printData(arr);

		System.out.println("Bubble sort...");
		bs.bubbleSortAsc(arr);

		System.out.print("Sorted array: ");
		bs.printData(arr);
	}

	public void bubbleSortAsc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public void bubbleSortDesc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] > arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public void bubbleSort(int[] arr) {
		// n, n-1, n-2, n-3, ...., 3,2,1 ==> n2
		for (int i = arr.length - 1; i >= 0; i--) {
			// 1,2,3, .... n
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swapValues(arr, j, j + 1);
				}
			}
			printData(arr);
		}
	}

	private void swapValues(int[] arr, int startIndex, int tempIndex) {
		int startValue = arr[startIndex];
		arr[startIndex] = arr[tempIndex];
		arr[tempIndex] = startValue;
	}

	private void printData(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + ",");
		}
		System.out.println();
	}
}
