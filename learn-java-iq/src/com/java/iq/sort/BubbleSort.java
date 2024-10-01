package com.java.iq.sort;

/*
 Starting on the left, compare adjacent items and keep “bubbling” the larger one to the right (until it’s in its final place). 
 Bubble sort the remaining N -1 items.
 Though “simple” I found bubble sort nontrivial. 

 In general, sorts where you iterate backwards (decreasing some index) were counter-intuitive for me.
 With bubble-sort, either you bubble items “forward” (left-to-right) and move the endpoint backwards (decreasing), 
 or bubble items “backward” (right-to-left) and increase the left endpoint. Either way, some index is decreasing.
 You also need to keep track of the next-to-last endpoint, so you don’t swap with a non-existent item.

 Performance:
 Best  : O(n)
 Worst : O(n^2)

 Sequence of sorting:
 ----------------------------
 Unsorted array: 4,3,2,1
	Bubble sort...
	3,2,1,4,
	2,1,3,4,
	1,2,3,4,
	1,2,3,4,
 Sorted array: 1,2,3,4

 */
public class BubbleSort {

	public static void main(String[] args) {
		// int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10 };
		int[] arr = new int[] { 4, 3, 2, 1 };

		BubbleSort bs = new BubbleSort();

		System.out.print("Unsorted array: ");
		bs.printData(arr);

		System.out.println("Bubble sort...");
		bs.bubbleSort(arr);

		System.out.print("Sorted array: ");
		bs.printData(arr);
	}


	public void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {	// n, n-1, n-2, n-3, ...., 3,2,1 ==> n2
			for (int j = 0; j < i; j++) {			// 1,2,3, .... n
				if (arr[j] > arr[j + 1]) {			// 1+2+3+...+n = (n*(n-1))/2 = O(n^2)
					swapValues(arr, j, j + 1);
				}
			}
			printData(arr);
		}
	}

	private void swapValues(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	private void printData(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + ",");
		}
		System.out.println();
	}
}
