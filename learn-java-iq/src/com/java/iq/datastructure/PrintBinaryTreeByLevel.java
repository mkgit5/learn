package com.java.iq.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*				
 * Print binary tree nodes level by level.
 * 
 * 													(1)
 * 
 *							(2)												(3)
 * 
 * 				(4)						(5)						(6)						(7)
 * 
 * 		(8)				(9)		(10)				(11)		(12)				(13)		(14)			(15)
 * 
 * 
 * Output:
 * 1
 * 2 3
 * 4 5 6 7 8
 * 		
 */
public class PrintBinaryTreeByLevel {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		new PrintBinaryTreeByLevel().binaryTree(root);
	}

	public void binaryTree(Node root) {
		Queue<Node> queue = new PriorityQueue<Node>(10, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.data == o2.data) {
					return 0;
				} else if (o1.data < o2.data) {
					return -1;
				}
				return 1;
			}
		});

		queue.add(root);
		int nodeCount = 1;

		while (true) {
			int queueCount = 0;
			while (nodeCount > 0) {
				Node n = queue.peek();
				System.out.print(n.data + " ");
				queue.remove(n);
				nodeCount--;

				if (n.left != null) {
					queue.add(n.left);
					queueCount++;
				}
				if (n.right != null) {
					queue.add(n.right);
					queueCount++;
				}
			}
			System.out.println();
			nodeCount = queueCount;
			if (nodeCount == 0) {
				break;
			}
		}

	}

}

class Node implements Comparable<Node> {
	Node left;
	int data;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public int compareTo(Node o) {
		if (this.data == o.data) {
			return 0;
		} else if (this.data < this.data) {
			return -1;
		}
		return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

}
