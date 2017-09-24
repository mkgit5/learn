package com.java.iq.programs.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Method 1:
 * Traverse the whole linked list and count the no. of nodes. 
 * Now traverse the list again till count/2 and return the node at count/2.
 *
 * Method 2:
 * Traverse linked list using two pointers. 
 * Move one pointer by one and other pointer by two. 
 * When the fast pointer reaches end, slow pointer will reach middle of the linked list.
 * 
 */
public class FindMiddleLinkedList {

	public static void main(String[] args) {
		List<Integer> test = new LinkedList<Integer>();

		for (int i = 0; i < 9; i++) {
			test.add(i);
		}
		System.out.println(9 / 2);
		System.out.println(test);
		System.out.println("Middle element is - " + findMiddleElement(test));

	}

	private static int findMiddleElement(List<Integer> test) {
		int i = 0;
		int middle = test.size() / 2;
		for (Iterator itr = test.iterator(); itr.hasNext();) {
			Integer num = (Integer) itr.next();
			if (i == middle) {
				return num;
			}
			i++;
		}
		return -1;
	}
}
