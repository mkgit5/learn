package com.java.iq.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Solutions
 * 
 * 1. Initialize byte array in a never ending loop, 1MB each (1 x 1024 x 1024 = 1048576) 
 * 		byte[] b = new byte[1024 x 1024];
 * 
 * 2. Initialize int array with Integer.MAX_VALUE 
 * 		int[] i = new int[Integer.MAX_VALUE];
 * 
 */
public class JavaOutOfMemory {

	public static void main(String[] args) {
//		addingBytes();
		initializeInt();
	}

	private static void addingBytes() {
		List<byte[]> list = new ArrayList<>();
		int index = 1;
		while (true) {
			// 1MB each loop, 1 x 1024 x 1024 = 1048576
			byte[] b = new byte[1048576];
			list.add(b);
			Runtime rt = Runtime.getRuntime();
			// Print available free memory
			System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
		}
	}

	private static void initializeInt() {
		System.out.println("Integer MAX value : " + Integer.MAX_VALUE);
		int[] i = new int[Integer.MAX_VALUE];
		System.out.println("i=" + i);
	}

}
