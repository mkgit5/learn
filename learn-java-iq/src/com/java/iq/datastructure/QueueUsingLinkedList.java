package com.java.iq.datastructure;

public class QueueUsingLinkedList {

	private Node front;
	private Node rear;

	public void add(int data) {
		Node n = new Node(data);
		if (front == null) {
			front = n;
			rear = n;
			n.next = null;
		} else {
			rear.next = n;
			rear = n;
		}
	}

	public int poll() {
		if (front != null) {
			int data = front.data;
			front = front.next;
			return data;
		}
		return -1;
	}

	public void display() {
		Node temp = front;
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
		QueueUsingLinkedList usingLinkedList = new QueueUsingLinkedList();
		usingLinkedList.add(1);
		usingLinkedList.add(2);
		usingLinkedList.add(3);
		usingLinkedList.display();
		System.out.println(usingLinkedList.poll());
		usingLinkedList.display();
	}

}
