package com.java.iq.programs.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArrayList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			list.add(i);
		}
		System.out.println("List before reversing: " + list);
		reverseArrayList1(list);
		System.out.println("List after reversing: " + list);
		reverseArrayList2(list);
		System.out.println("List after reversing: " + list);
		Collections.reverse(list);
		System.out.println("Reversed using Collections.reverse(): " + list);
		System.out.println("Reversed recursively: " + reverseArrayListRecursively(list));
	}

	private static void reverseArrayList1(List<Integer> list) {
		int pivotIndex = list.size() / 2;
		int j = list.size() - 1;
		for (int i = 0; i < list.size(); i++) {
			if (i >= pivotIndex) {
				break;
			} else {
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
				j--;
			}
		}
	}

	private static void reverseArrayList2(List<Integer> list) {
		int j = list.size() - 1;
		for (int i = 0; i < list.size() / 2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
			j--;
		}
	}

	private static List<Integer> reverseArrayListRecursively(List<Integer> list) {
		if (list.size() < 2) {
			return list;
		}
		List<Integer> reversed = new ArrayList<Integer>();
		reversed.add(list.get(list.size() - 1));
		reversed.addAll(reverseArrayListRecursively(list.subList(0, list.size() - 1)));
		return reversed;
	}
}
