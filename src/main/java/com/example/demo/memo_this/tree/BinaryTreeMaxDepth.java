package com.example.demo.memo_this.tree;


import java.util.Optional;
import java.util.function.Function;

/*
From the given original root,
	rehash get largest depth from mLeft
	rehash get largest depth from mRight
	return whichever is bigger

( can be merged to the method above as recursion)
get largest depth from mLeft/mRight
	sub left depth + 1 if left of mLeft/mRight exists
	sub right depth + 1 if right of mLeft/mRight exists
	return whichever is greater

* */
public class BinaryTreeMaxDepth {
	private static class Node {
		int value;
		Node left, right;

		Node(int val) {
			value = val;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;

		int leftDepth;
		int rightDepth;

		int maxDepth(Node root) {
			return Optional.ofNullable(root)
					.map(rt -> {
						// Get the depth of the left and right subtree
						leftDepth += maxDepth(root.left);
						rightDepth += maxDepth(root.right);

						// these are subs of the L/R above, only one is needed
						return Math.max(rightDepth, leftDepth) + 1;
					}).orElse(0);
		}
	}

	// Driver code
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.right.right.left = new Node(8);
		tree.root.right.left.right = new Node(7);
		System.out.println("Max depth: " + tree.maxDepth(tree.root));
	}
}