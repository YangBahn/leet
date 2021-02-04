package com.example.demo.memo_this.tree.excercise;


import com.example.demo.common.TreeNode;
import com.example.demo.common.Util;

import java.util.Arrays;

/*
Array must be sorted *
	Recurse Start
	adjust mid idx = (range from start to end )/2
	Create new node with midIndex ( this is the pointer for both left/right)
    Call recursively -
		left's end = mid, start = 0
			decrease from mid every cycle then recurse
		right's start = mid,  end = arrLen-1
			increase from mid by one every cycle then recurse
*/
class ExConvertArrayToBinarySearchTree {

	private static TreeNode sortedArrayToBST(int[] arr) {

		return null;
	}


	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		TreeNode root = sortedArrayToBST(arr);
		System.out.println("Preorder traversal of constructed BST");
		Util.printTreeNodes(root);
	}
}
