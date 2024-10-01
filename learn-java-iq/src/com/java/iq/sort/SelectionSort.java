package com.java.iq.sort;

/*
 Scan all items and find the position of the smallest. 
 Swap it into position as the first item. 
 Repeat the selection sort on the remaining N-1 items. 
 This is most intuitive and easiest to implement — you always iterate forward (i from 0 to N-1), 
 and swap with the smallest element (always i).

 Performance:
 Best  : O(n^2)
 Worst : O(n^2)


 Sequence of sorting:
 ----------------------------
 4 3 2 1  	Find position of smallest item and swap with the 0th position. Here swap 4 and 1
 1 3 2 4 	Find position of next smallest item and swap with the 1st position. Here swap 3 and 2
 1 2 3 4	Find position of next smallest item and swap with the 2nd position. No swapping as 

 */
public class SelectionSort {

	public static void main(String[] args) {
		// int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10 };
		int[] arr = new int[] { 4, 3, 2, 1 };
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
		for (int i = 0; i < a.length - 1; i++) { 		// Time complexity = 0, 1, 2...n-1 [O(n-1)]
			int k = i;									// 1
			for (int j = i + 1; j < a.length; j++) {	// 1,2,3 ... n ( n, n-1, n-2 ...)  [O(n)]
				if (a[k] > a[j]) { 						// 1+2+3+...+n ((n * (n-1))) / 2 = O(n^2))
					k = j;								
				}
			}
			swapValues(a, i, k); 						// Time complexity = 3
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
