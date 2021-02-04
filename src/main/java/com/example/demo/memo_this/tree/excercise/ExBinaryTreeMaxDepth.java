package com.example.demo.memo_this.tree.excercise;


import com.example.demo.common.TreeNode;
import com.example.demo.common.Util;
import lombok.experimental.UtilityClass;

/*
From the given original root,
	repeat to get largest depth from mLeft
	repeat to get largest depth from mRight
	return whichever is bigger

( can be merged to the method above as recursion)
get largest depth from mLeft/mRight
	sub left depth + 1 if left of mLeft/mRight exists
	sub right depth + 1 if right of mLeft/mRight exists
	return whichever is greater

* */
class ExBinaryTreeMaxDepth {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(6)
				.setLeft(
						new TreeNode(3)
								.setLeft(new TreeNode(14))
								.setRight(new TreeNode(14).setLeft(new TreeNode(11)))
				)
				.setRight(
						new TreeNode(9)
								.setLeft(new TreeNode(7))
								.setRight(new TreeNode(10)
										.setLeft(new TreeNode(8)))
				);

		Util.printTreeNodes(tree);
		int d = TreeMaxDepth.getMaxDepth(tree, 0, 0);
		System.out.println("max depth is " + d);
	}

	@UtilityClass
	class TreeMaxDepth {
		int getMaxDepth(TreeNode node, int leftDepth, int rightDepth) {

			if (node.left != null) {
				leftDepth += 1;
				leftDepth = getMaxDepth(node.left, leftDepth, rightDepth);
			}

			if (node.right != null) {
				rightDepth += 1;
				rightDepth = getMaxDepth(node.right, leftDepth, rightDepth);
			}

			return Math.max(leftDepth, rightDepth);
		}


	}
}