package com.java.iq.datastructure;

public class DoubleLinkedList {

	private Node head;

	public boolean add(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			n.prev = null;
			n.next = null;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
			n.prev = temp;
			n.next = null;
		}

		return true;
	}

	public void display() {
		Node temp = head;
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
		Node prev;
		int data;
		Node next;

		public Node(int data) {
			this.prev = null;
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList linkedList = new DoubleLinkedList();
		linkedList.add(1);
		System.out.print("1.");
		linkedList.display();
		linkedList.add(2);
		System.out.print("2.");
		linkedList.display();
		linkedList.add(3);
		System.out.print("3.");
		linkedList.display();
	}
}
