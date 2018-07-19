package com.java.iq.datastructure;

public class QueueUsingArray {

	private int[] queue = new int[10];
	private int front = 0;
	private int rear = 0;

	public boolean add(int data) {
		queue[rear++] = data;
		return false;
	}

	public int poll() {
		int data = queue[front];
		queue[front++] = 0;
		System.arraycopy(queue, front, queue, 0, rear - front);
		queue[--rear] = 0;
		front--;
		return data;
	}

	public void display() {
		for (int i = front; i < rear; i++) {
			System.out.print(queue[i]);
			if (i < rear - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueUsingArray usingArray = new QueueUsingArray();
		usingArray.add(1);
		usingArray.add(2);
		usingArray.add(3);
		usingArray.display();
		System.out.println(usingArray.poll());
		usingArray.display();
		System.out.println(usingArray.poll());
		usingArray.display();
		System.out.println(usingArray.poll());
		usingArray.display();

	}

}
