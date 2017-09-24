package com.java.iq.sort;

import java.util.Arrays;

/*
 * Bucket sort (bin sort) is a stable sorting algorithm 
 * It is based on partitioning the input array into several parts – so called buckets. 
 */
public class BucketSort {

	public static void main(String[] args) {
		int maxVal = 11;
		int[] a = { 5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4, 11 };

		System.out.println("Before: " + Arrays.toString(a));
		bucketSort(a, maxVal);
		System.out.println("After:  " + Arrays.toString(a));
	}

	public static void bucketSort(int[] a, int maxVal) {
		int[] bucket = new int[maxVal + 1];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}

		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
		}

		int outPos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				a[outPos++] = i;
			}
		}
	}

}
