package com.java.iq.datastructure;

/*
 * Binary Search Tree is node based binary tree data structure with the following properties:
 *
 * 1. The Left subtree contains the nodes with keys less than the node's key.
 * 2. The Right subtree contains the nodes with keys greater than the node's key.
 * 3. Both the right and left subtree should also be binary search tree.
 * 4. There should not be any duplicate nodes.
 * 
 */
public class BinarySearchTree {

	private Node root;

	public void search(int value) {
		search(root, value);
	}

	public void insert(int value) {
		insert(root, value);
	}

	public int minValue() {
		return minValue(root);
	}

	public int maxValue() {
		return maxValue(root);
	}

	public void inorderTraversal() {
		inorderTraversal(root);
	}

	public void postorderTraversal() {
		postorderTraversal(root);
	}

	public void preorderTraversal() {
		preorderTraversal(root);
	}

	/*
	 * Performance: O(log n)
	 * 
	 * 1. Start at the root node as current node. 2. If the search key’s value matches the current node’s key then found a match
	 * 
	 * 3. If search key’s value is greater than current node’s a. If the current node has a right child, search right b. Else, no matching node in the tree
	 * 
	 * 4. If search key is less than the current node’s a. If the current node has a left child, search b. Else, no matching node in the tree
	 */
	private void search(Node n, int value) {
		if (n != null) {
			if (n.value == value) {
				System.out.println("Found value - " + n.value);
			} else if (value < n.value) {
				search(n.left, value);
			} else {
				search(n.right, value);
			}

		}
	}

	/*
	 * Performance: O(log n)
	 * 
	 * 1. Always insert new node as leaf node
	 * 
	 * 2. Start at root node as current node
	 * 
	 * 3. If new node’s key < current’s key a. If current node has a left child, search left b. Else add new node as current’s left child
	 * 
	 * 4. If new node’s key > current’s key a. If current node has a right child, search right b. Else add new node as current’s right child
	 */
	private void insert(Node n, int value) {
		if (n != null) {
			if (value < n.value) {
				if (n.left != null) {
					insert(n.left, value);
				} else {
					Node newNode = new Node(value);
					n.left = newNode;
				}
			}
			if (value > n.value) {
				if (n.right != null) {
					insert(n.right, value);
				} else {
					Node newNode = new Node(value);
					n.right = newNode;
				}
			}

		} else {
			n = new Node(value);
		}
	}

	/*
	 * Performance: O(log n).
	 */
	private int minValue(Node n) {
		while (n.left != null) {
			n = n.left;
		}

		return n.value;
	}

	/*
	 * Performance: O(log n).
	 */
	private int maxValue(Node n) {
		while (n.right != null) {
			n = n.right;
		}
		return n.value;
	}

	/*
	 * Pre-order: Below process is applied recursively to all the node in the tree, until either the left sub tree is empty or the right sub tree is empty.
	 * 
	 * 1. Value at the given node is printed first 2. Left sub tree of the given node is visited 3. Right sub tree of the given node is visited
	 *
	 * 1 2 3
	 */
	private void preorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		System.out.println(n.value + " ");
		preorderTraversal(n.left);
		preorderTraversal(n.right);
	}

	/*
	 * In-order: Below process is applied recursively to all the node in the tree, until either the left sub tree is empty or the right sub tree is empty.
	 * 
	 * 1. Left sub tree of the given node is visited first 2. Value at the given node is printed 3. Right sub tree of the given node is visited
	 * 
	 * 2 1 3
	 */
	private void inorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		inorderTraversal(n.left);
		System.out.println(n.value + " ");
		inorderTraversal(n.right);
	}

	/*
	 * Post-order:
	 * 
	 * Below process is applied recursively to all the node in the tree, until either the left sub tree is empty or the right sub tree is empty.
	 * 
	 * 1. Left sub tree of the given node is visited first 2. Right sub tree of the given node is visited 3. Value at the given node is printed
	 * 
	 * 3 1 2
	 */
	private void postorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		postorderTraversal(n.left);
		postorderTraversal(n.right);
		System.out.println(n.value + " ");
	}

	class Node {

		private Node left;
		private Node right;
		private int value;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

}
