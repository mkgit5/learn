package com.java.iq.datastructure;

public class StackUsingArray {
	int[] stack = new int[10];
	int top = -1;

	public void push(int data) {
		top++;
		stack[top] = data;
	}

	public int pop() {
		if (top != -1) {
			return stack[top--];
		}
		return -1;
	}

	public void display() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i]);
			if (i < top) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		final StackUsingArray stack = new StackUsingArray();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.print("Stack values: ");
		stack.display();
		System.out.println("Stack pop: " + stack.pop());
		System.out.print("Stack values: ");
		stack.display();
	}
}
