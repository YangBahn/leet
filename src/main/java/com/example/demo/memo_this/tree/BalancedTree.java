package com.example.demo.memo_this.tree;

import com.example.demo.common.TreeNode;
import com.example.demo.common.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedTree {

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
	static class ThInTree {
		static int kthSmallest_stack(TreeNode root, int k) {

			if (root == null || k <= 0) {
				return -1;
			}

			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			TreeNode node = root;
			while (!stack.isEmpty()) {
				// Load Left first to stack
				while (node != null && node.left != null) {
					stack.add(node.left);
					node = node.left;
				}
				// process last one from the stack
				node = stack.pop();
				System.out.println("k" + k + " - " + node.val);
				k--;
				if (k == 0) {
					return node.val;
				}

				// right
				node = node.right;
				if (node != null) {
					stack.push(node);
				}
			}
			return -1;
		}
	}



}
