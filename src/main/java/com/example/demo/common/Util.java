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

	public static void printArr(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length ; i++) {
			String val = String.valueOf(arr[i]);
			if (i < arr.length - 1) {
				val = val +",";
			}
			System.out.print(val);

		}
		System.out.print("]\t");


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