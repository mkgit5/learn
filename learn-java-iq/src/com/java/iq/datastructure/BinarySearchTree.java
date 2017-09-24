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

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

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
	 * 1. Start at the root node as current node.
	 * 2. If the search key’s value matches the current node’s key then found a match
	 * 
	 * 3. If search key’s value is greater than current node’s
	 * a. If the current node has a right child, search right
	 * b. Else, no matching node in the tree
	 * 
	 * 4. If search key is less than the current node’s
	 * a. If the current node has a left child, search
	 * b. Else, no matching node in the tree
	 */
	private void search(Node n, int value) {
		if (root != null) {
			if (root.getValue() == value) {
				System.out.println("Found value - " + root.getValue());
			} else if (value < root.getValue()) {
				search(root.getLeft(), value);
			} else {
				search(n.getRight(), value);
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
	 * 3. If new node’s key < current’s key
	 * a. If current node has a left child, search left
	 * b. Else add new node as current’s left child
	 * 
	 * 4. If new node’s key > current’s key
	 * a. If current node has a right child, search right
	 * b. Else add new node as current’s right child
	 */
	private void insert(Node n, int value) {
		if (n != null) {
			if (value < n.getValue()) {
				if (n.getLeft() != null) {
					insert(n.getLeft(), value);
				} else {
					Node newNode = new Node(value);
					n.setLeft(newNode);
				}
			}
			if (value > n.getValue()) {
				if (n.getRight() != null) {
					insert(n.getRight(), value);
				} else {
					Node newNode = new Node(value);
					n.setRight(newNode);
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
		while (n.getLeft() != null) {
			n = n.getLeft();
		}

		return n.getValue();
	}

	/*
	 * Performance: O(log n).
	 */
	private int maxValue(Node n) {
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n.getValue();
	}

	/*
	 * In-order:
	 * Below process is applied recursively to all the node in the tree,
	 * until either the left sub tree is empty or the right sub tree is empty.
	 * 
	 * 1. Left sub tree of the given node is visited first
	 * 2. Value at the given node is printed
	 * 3. Right sub tree of the given node is visited
	 * 
	 * Eg: 1,2,3,4,5
	 */
	private void inorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		inorderTraversal(n.getLeft());
		System.out.println(n.getValue() + " ");
		inorderTraversal(n.getRight());
	}

	/*
	 * Pre-order:
	 * Below process is applied recursively to all the node in the tree,
	 * until either the left sub tree is empty or the right sub tree is empty.
	 * 
	 * 1. Value at the given node is printed first
	 * 2. Left sub tree of the given node is visited
	 * 3. Right sub tree of the given node is visited
	 * 
	 * Eg: 1,2,3,4,5
	 */
	private void preorderTraversal(Node n) {
		if (n == null) {
			return;
		}

		System.out.println(n.getValue() + " ");
		preorderTraversal(n.getLeft());
		preorderTraversal(n.getRight());
	}

	/*
	 * Post-order:
	 * 
	 * Below process is applied recursively to all the node in the tree,
	 * until either the left sub tree is empty or the right sub tree is empty.
	 * 
	 * 1. Left sub tree of the given node is visited first
	 * 2. Right sub tree of the given node is visited
	 * 3. Value at the given node is printed
	 */
	private void postorderTraversal(Node n) {
		if (n == null) {
			return;
		}

		postorderTraversal(n.getLeft());
		postorderTraversal(n.getRight());
		System.out.println(n.getValue() + " ");
	}

}

class Node {

	private Node left;
	private Node right;
	private int value;

	public Node(int value) {
		super();
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public int getValue() {
		return value;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
