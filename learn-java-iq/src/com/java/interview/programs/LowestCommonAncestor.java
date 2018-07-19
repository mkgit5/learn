package com.java.interview.programs;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Lowest Common Ancestor**LCA of nodes 4 and 7 is 1*LCA of nodes 2 and 5
 * is 2*LCA of nodes 2 and 7 is 1**Binary Tree:*1*2 3*4 5 6 7
 **/

public class LowestCommonAncestor {

	public static void main(String[] args) {
		final Node root = createTree();
		LowestCommonAncestor commonAncestor = new LowestCommonAncestor();
		System.out.println("LCA of 1 and 3 is " + commonAncestor.findCommonAncestorOfTwoNodes(root, 1, 3));
		System.out.println("LCA of 4 and 7 is " + commonAncestor.findCommonAncestorOfTwoNodes(root, 4, 7));
		System.out.println("LCA of 4 and 5 is " + commonAncestor.findCommonAncestorOfTwoNodes(root, 4, 5));
	}

	public int findCommonAncestorOfTwoNodes(Node root, int n1, int n2) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();

		findPath(root, n1, path1);
		findPath(root, n2, path2);
		int lca = 0;
		int i = 0;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i) != path2.get(i)) {
				break;
			}
		}
		lca = path1.get(i - 1);

		return lca;
	};

	private boolean findPath(Node root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.data);
		if (root.data == n) {
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);

		return false;

	}

	private static Node createTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;
	}

}

class Node {
	Node left;
	int data;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}
