package com.java.iq.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StackUsingLinkedList {

	private List<Integer> stack = new LinkedList<>();

	public void push(int data) {
		stack.add(data);
	}

	public int pop() {
		int data = -1;
		for (ListIterator<Integer> iterator = stack.listIterator(stack.size()); iterator.hasPrevious();) {
			data = iterator.previous();
			iterator.remove();
			break;
		}
		return data;
	}

	public void display() {
		for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next().intValue());
			if (iterator.hasNext()) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
		stackUsingLinkedList.push(1);
		stackUsingLinkedList.push(2);
		stackUsingLinkedList.push(3);
		stackUsingLinkedList.display();
		System.out.println(stackUsingLinkedList.pop());
		stackUsingLinkedList.display();
		System.out.println(stackUsingLinkedList.pop());
		stackUsingLinkedList.display();
		System.out.println(stackUsingLinkedList.pop());
		stackUsingLinkedList.display();
	}

}
