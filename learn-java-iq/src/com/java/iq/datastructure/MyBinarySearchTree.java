package com.java.iq.datastructure;

public class MyBinarySearchTree {

	private Node root;

	public void add(int data) {
		Node n = new Node(data);
		addNodeToTree(n, root);
	}

	public void remove(int data) {
		deleteRec(root, data);
	}

	private Node deleteRec(Node root, int data) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.left = deleteRec(root.left, data);
		else if (data > root.data)
			root.right = deleteRec(root.right, data);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	private int minValue(Node root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	public void search(int data) {
		Node temp = root;
		while (temp != null) {
			if (temp.data == data) {
				System.out.println("Item found - " + data);
			} else if (data < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
	}

	private void addNodeToTree(Node newNode, Node node) {
		if (newNode.data < node.data) {
			if (node.left != null) {
				addNodeToTree(newNode, node.left);
			} else {
				node.left = newNode;
			}
		} else {
			if (node.right != null) {
				addNodeToTree(newNode, node.right);
			} else {
				node.right = newNode;
			}
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
		// TODO Auto-generated method stub

	}

}
