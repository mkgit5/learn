package com.java.iq.datastructure;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class TestJava {

	public static void main(String[] args) {
		// List<Integer> list = new LinkedList<>();
		// System.out.println(list.get(0));
		//
		// Stack<Integer> stack = new Stack<>();
		// stack.push(1);
		// System.out.println(stack.pop());

		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());

		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

	}
}
