package com.java.iq.sort;

/*
 Scan all items and find the smallest. 
 Swap it into position as the first item. 
 Repeat the selection sort on the remaining N-1 items. 
 This is most intuitive and easiest to implement — you always iterate forward (i from 0 to N-1), 
 and swap with the smallest element (always i).

 Performance:
 Best  : O(n^2)
 Worst : O(n^2)

 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10 };

		SelectionSort sort = new SelectionSort();
		System.out.print("Unsorted array: ");
		sort.printData(arr);

		sort.selectionSort(arr);

		System.out.println("Selection sort...");
		sort.selectionSort(arr);

		System.out.print("Sorted array: ");
		sort.printData(arr);

	}

	public void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			swapValues(a, i, k);
		}
	}

	private void swapValues(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	private void printData(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}
}
