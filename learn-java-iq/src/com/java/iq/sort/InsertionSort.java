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
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	@SuppressWarnings("unused")
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
