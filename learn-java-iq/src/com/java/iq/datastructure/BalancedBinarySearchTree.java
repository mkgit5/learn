package com.java.iq.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/*
 * A balanced binary tree is also known as a height-balanced tree.
 * A balanced binary tree or height-balanced binary tree is such a tree whose left and right subtrees' heights differ by not more than 1, 
 * which means the height difference could be -1, 0, and 1. 
 * 
 * Convert Skewed Binary Tree to Balanced Binary Search Tree
 * 1. Store nodes in an array, sorted array represents in-order traversal of binary search tree.
 * 2. Using the sorted array, construct Binary Search Tree.
 * 
 * Input:
 * 					3
 * 				2
 * 			1
 * 		5
 * 	6
 * 
 * Output:
 * 					1
 * 			6				2
 * 				5				3
 * 
 */
public class BalancedBinarySearchTree {

	Node root;

	public Node balanceBinaryTree() {
		createTree();
		Vector<Node> nodes = new Vector<>();
		storeNodes(root, nodes);
		return buildTree(nodes, 0, nodes.size() - 1);
	}

	private void createTree() {
		root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.left.left = new Node(5);
		root.left.left.left.left = new Node(6);
	}

	public void storeNodes(Node root, Vector<Node> nodes) {
		if (root != null) {
			storeNodes(root.left, nodes);
			nodes.add(root);
			storeNodes(root.right, nodes);
		}
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

	public static void main(String[] args) {
		BalancedBinarySearchTree tree = new BalancedBinarySearchTree();
		tree.root = tree.balanceBinaryTree();
		tree.display(tree.root);
	}

}
