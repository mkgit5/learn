package com.java.iq.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Height of a binary tree - Iterative Method
 */
public class BinaryTreeHeight {

	int calculateHeight(Node root) {
		final Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		int height = 0;
		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}
			height++;

			while (nodeCount > 0) {
				Node node = q.peek();
				q.remove();

				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				nodeCount--;
			}
		}
		return height;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(6);
		System.out.println(new BinaryTreeHeight().calculateHeight(root));
	}

}
