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
			for (MyNode x = first; x != null; x = x.getNext()) {
				unlink(item, x);
				return true;
			}
		}
		return false;
	}

	private void unlink(String item, MyNode x) {
		if (x.getItem().equals(item)) {
			MyNode prev = x.getPrev();
			MyNode next = x.getNext();

			if (prev == null) {
				first.setNext(next);
			} else {
				prev.setNext(next);
				x.setPrev(null);
			}

			if (next == null) {
				last = prev;
			} else {
				next.setPrev(next);
				x.setNext(null);
			}
			x.setItem(null);
			size--;
		}
	}

	private void linkLast(String item) {
		MyNode lastTemp = last;
		MyNode newNode = new MyNode(last, item, null);
		last = newNode;
		if (lastTemp == null) {
			first = newNode;
		} else {
			last.setNext(newNode);
		}
		size++;
	}

	public MyNode getFirst() {
		return first;
	}

	public MyNode getLast() {
		return last;
	}

	public int getSize() {
		return size;
	}

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

	public MyNode getPrev() {
		return prev;
	}

	public String getItem() {
		return item;
	}

	public MyNode getNext() {
		return next;
	}

	public void setPrev(MyNode prev) {
		this.prev = prev;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setNext(MyNode next) {
		this.next = next;
	}

}
