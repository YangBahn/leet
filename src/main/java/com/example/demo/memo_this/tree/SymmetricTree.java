package com.example.demo.memo_this.tree;


/*




* */

public class SymmetricTree {
	static class Node {
		int val;
		Node left, right;

		Node(int item) {
			val = item;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;

		static boolean isMirror(Node left, Node right) {

			boolean bothEmpty = left == null && right == null;
			if (bothEmpty)
				return true;

			boolean leftRightHaveSameVals = left != null && right != null && left.val == right.val;
			if (leftRightHaveSameVals) {
				boolean leftOfTheRootIsSymetrical = isMirror(left.left, right.right);
				boolean rightOfTheRootIsSymetrical = isMirror(left.right, right.left);
				return leftOfTheRootIsSymetrical && rightOfTheRootIsSymetrical;
			}

			return false;
		}

	}

	// Driver code
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(3);
		boolean output = BinaryTree.isMirror(tree.root.left, tree.root.right);

		if (output)
			System.out.println("Symmetric");
		else
			System.out.println("Not symmetric");
	}
}