package com.java.iq.datastructure;

public class MyLinkedList {

	private MyNode first;
	private MyNode last;
	private int size;

	public boolean add(String item) {
		linkLast(item);
		return true;
	}

	public boolean remove(String item) {
		if (item != null) {
			MyNode temp = first;
			unlink(item, temp);
			// for (MyNode x = first; x != null; x = x.next) {
			// unlink(item, x);
			// return true;
			// }
		}
		return false;
	}

	public void display() {
		MyNode temp = first;
		final StringBuilder builder = new StringBuilder("[");
		while (temp != null) {
			builder.append(temp.item);
			temp = temp.next;
			if (temp != null) {
				builder.append(", ");
			}
		}
		builder.append("]");
		System.out.println(builder.toString());
	}

	private void unlink(String item, MyNode currNode) {
		while (currNode != null) {
			MyNode prevNode = currNode.prev;
			MyNode nextNode = currNode.next;

			if (currNode.item.equals(item)) {
				if (prevNode == null) {
					first = nextNode;
				} else {
					prevNode.next = nextNode;
				}
				if (nextNode == null) {
					last = prevNode;
				} else {
					nextNode.prev = prevNode;
				}

				currNode = null;
				size--;
				return;
			}
			currNode = currNode.next;
		}

	}

	private void linkLast(final String item) {
		final MyNode n = new MyNode(last, item, null);
		if (first == null) {
			first = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
		size++;
	}

	class MyNode {

		private MyNode prev;
		private String item;
		private MyNode next;

		public MyNode() {

		}

		public MyNode(MyNode prev, String item, MyNode next) {
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		final MyLinkedList linkedList = new MyLinkedList();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		linkedList.add("d");
		System.out.println("My Linked List: ");
		linkedList.display();

		System.out.println("Removing item: a");
		linkedList.remove("a");

		System.out.println("My Linked List: ");
		linkedList.display();
	}

}
