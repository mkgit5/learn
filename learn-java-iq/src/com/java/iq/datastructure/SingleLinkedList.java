package com.java.iq.datastructure;

public class SingleLinkedList {
	private Node head;
	private int size;

	public boolean add(Integer data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
			size++;
		}
		return true;
	}

	public boolean remove(Integer data) {
		if (head == null) {
			return false;
		} else {
			Node curr = head;
			Node prev = curr;
			while (curr.next != null) {
				if (curr.data == data) {
					if (curr == head) {
						head = head.next;
						size++;
						return true;
					} else if (curr.next == null) {
						prev.next = null;
						size++;
						return true;
					} else {
						prev.next = curr.next;
						size++;
						return true;
					}
				}
				prev = curr;
				curr = curr.next;
			}
			return false;
		}
	}

	public Integer get(int index) {
		int result = -1;
		if (index <= size) {
			Node temp = head;
			int i = 0;
			while (i < index) {
				i++;
				temp = temp.next;
			}
			result = temp.data;
		} else {
			throw new IndexOutOfBoundsException("Index is out of range");
		}

		return result;
	}

	public void display() {
		if (head == null) {
			return;
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data);
				if (temp.next != null) {
					System.out.print(",");
				}
				temp = temp.next;
			}
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
		System.out.println("String");
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		System.out.println(linkedList.get(2));
		linkedList.display();
	}

	public static int main(Integer[] args) {
		System.out.println("Integer");
		return 0;
	}
}
