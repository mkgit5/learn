package com.java.iq.datastructure;

public class CircularLinkedList {

	private Node head;

	public boolean add(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			head.next = n;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = n;
			n.next = head;
		}
		return true;
	}

	public void display() {
		if (head != null) {
			Node temp = head;
			while (temp.next != head) {
				System.out.print(temp.data);
				if (temp.next != head) {
					System.out.print(",");
				}
				temp = temp.next;
			}
			System.out.println(temp.data);
		}
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
		CircularLinkedList linkedList = new CircularLinkedList();
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
