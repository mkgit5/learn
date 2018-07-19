package com.java.iq.datastructure;

public class StackUsingCustomLinkedList {
	private Node top;

	public void push(int data) {
		Node n = new Node(data);
		if (top == null) {
			top = n;
		} else {
			Node temp = top;
			while (temp.next != null) {
				temp = temp.next;
			}
			n.next = temp;
			top = n;
		}
	}

	public int pop() {
		if (top != null) {
			int data = top.data;
			top = null;
			top = top.next;
			return data;
		}
		return -1;
	}

	public void display() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print(",");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;

		}
	}

	public static void main(String[] args) {
		StackUsingCustomLinkedList stackUsingCustomLinkedList = new StackUsingCustomLinkedList();
		stackUsingCustomLinkedList.push(1);
		stackUsingCustomLinkedList.push(2);
		stackUsingCustomLinkedList.push(3);
		stackUsingCustomLinkedList.display();
		System.out.println(stackUsingCustomLinkedList.pop());
		stackUsingCustomLinkedList.display();
	}
}
