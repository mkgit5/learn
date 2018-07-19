package com.java.iq.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/*
 * Convert Skewed Binary Tree to Balanced Binary Search Tree
 * 1. Store nodes in an array, sorted array represents in-order traversal of binary search tree.
 * 2. Using the sorted array, construct Binary Search Tree.
 */
public class BalancedBinarySearchTree {

	Node root;

	public Node balanceBinaryTree() {
		createTree();
		Vector<Node> nodes = new Vector<>();
		storeNodes(root, nodes);
		return buildTree(nodes, 0, nodes.size() - 1);
	}

	private Node buildTree(Vector<Node> nodes, int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = (start + end) / 2;
			Node node = nodes.get(mid);
			node.left = buildTree(nodes, start, mid - 1);
			node.right = buildTree(nodes, mid + 1, end);
			return node;
		}
	}

	public void storeNodes(Node root, Vector<Node> nodes) {
		if (root != null) {
			storeNodes(root.left, nodes);
			nodes.add(root);
			storeNodes(root.right, nodes);
		}
	}

	public void display(Node root) {
		final Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}
			while (nodeCount > 0) {
				Node node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				nodeCount--;

				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			System.out.println();
		}

	}

	private void createTree() {
		root = new Node(30);
		root.left = new Node(20);
		root.left.left = new Node(10);
		root.left.left.left = new Node(5);
		root.left.left.left.left = new Node(1);
	}

	public static void main(String[] args) {
		BalancedBinarySearchTree tree = new BalancedBinarySearchTree();
		tree.root = tree.balanceBinaryTree();
		tree.display(tree.root);
	}

	class Node {
		Node left;
		int data;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

}
