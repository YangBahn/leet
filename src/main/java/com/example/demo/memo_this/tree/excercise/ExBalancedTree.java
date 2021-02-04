package com.example.demo.memo_this.tree.excercise;

import com.example.demo.common.TreeNode;
import com.example.demo.common.Util;
import lombok.experimental.UtilityClass;

import java.util.Stack;


public class ExBalancedTree {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(6)
				.setLeft(
						new TreeNode(3)
								.setLeft(new TreeNode(1))
								.setRight(new TreeNode((2))))
				.setRight(new TreeNode(9)
						.setLeft(new TreeNode(7))
						.setRight(new TreeNode(10))
				);

		Util.printTreeNodes(treeNode);

		int val = ThInTree.kthSmallest_stack(treeNode, 5);
		System.out.println("val: " + val);
	}


	/*
	while stack is not empty
		add left to stack if available

		Update kth value
			- popped.stack = kth smallest.
			- reduce k

	 	add right node to stack if possible

	*/
	@UtilityClass
	class ThInTree {
		int kthSmallest_stack(TreeNode root, int k) {

			return -1;
		}
	}


}
