package com.example.demo.memo_this.tree;

import com.example.demo.memo_this.common.TreeNode;

public class BalancedTree {


	int kthSmallest(TreeNode root, int k) {

		return 0;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
//		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);


	}
}
