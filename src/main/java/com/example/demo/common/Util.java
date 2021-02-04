package com.example.demo.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {
	public void printTreeNodes(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTreeNodes(node.left);
		printTreeNodes(node.right);
	}

	public TreeNode getBasicTree() {
		return new TreeNode(6)
				.setLeft(
						new TreeNode(3)
								.setLeft(new TreeNode(1))
								.setRight(new TreeNode((2))))
				.setRight(new TreeNode(9)
						.setLeft(new TreeNode(7))
						.setRight(new TreeNode(10))
				);

	}


}