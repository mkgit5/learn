package com.java.iq.sort;

/*
 Start with a sorted list of 1 element on the left, and N-1 unsorted items on the right. 
 Take the first unsorted item (element #2) and insert it into the sorted list, moving elements as necessary. 
 We now have a sorted list of size 2, and N-2 unsorted elements. 
 Repeat for all elements. 

 Cons:
 Like bubble sort, I found this counter-intuitive because you step “backwards”.
 This is little like bubble sort for moving items, except when you encounter an item smaller than you, you stop. 
 If the data is reverse-sorted, each item must travel to the head of the list, and this becomes bubble-sort. 
 There are various ways to move the item leftwards — you can do a swap on each iteration, 
 or copy each item over its neighbor.

 Performance:
 Best  : O(n)
 Worst : O(n^2)
 
 Sequence of sorting:
 ----------------------------
 Sorted list 	Unsorted list
 4 				3 2 1
 3 4			2 1
 2 3 4			1
 1 2 3 4

 */
public class InsertionSort {

	public static void main(String[] args) {
		// int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// int[] arr = new int[] { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10 };
		int[] arr = new int[] { 4, 3, 2, 1 };

		InsertionSort sort = new InsertionSort();

		System.out.print("Unsorted array: ");
		sort.printData(arr);

		System.out.println("Insertion sort...");
		sort.insertionSort(arr);

		System.out.print("Sorted array: ");
		sort.printData(arr);

	}

	public void insertionSort(int[] a) {
		int temp;
		for (int i = 1; i < a.length; i++) {	// 1, 2, 3, ... n
			for (int j = i; j > 0; j--) {		// n, n-1,n-2...1
				if (a[j] < a[j - 1]) {
					swapValues(a, j, j - 1);	// 1 + 2 + 3 + ... + n-1 = (n*(n-1))/2 = O(n^2)
				}
			}
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
