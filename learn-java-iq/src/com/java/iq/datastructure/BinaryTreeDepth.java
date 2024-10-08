package com.java.iq.datastructure;

/*	
 * Height or depth of a binary tree - Recursive method
 * 			
 * 	1. If tree is empty then return 0
 *	2. Else
 *    	(a) Get the max depth of left subtree recursively  i.e., 
 *        	call maxDepth( tree->left-subtree)
 *  		(a) Get the max depth of right subtree recursively  i.e., 
 *      		call maxDepth( tree->right-subtree)
 * 		(c) Get the max of max depths of left and right subtrees and add 1 to it for the current node.
 *  			max_depth = max(max depth of left subtree, max depth of right subtree) + 1
 * 		(d) Return max_depth
 * 
 * Input:
 * 					1
 * 			2				3
 * 		4		5
 * 	
 * Output: Height of tree is : 3
 * 
 */
public class BinaryTreeDepth {

	Node root;

	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	public static void main(String[] args) {
		BinaryTreeDepth tree = new BinaryTreeDepth();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		// tree.root.left.left = new Node(4);
		// tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
	}

}
