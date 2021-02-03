package com.example.demo.memo_this.tree;


import com.example.demo.memo_this.common.TreeNode;

/*
* Array must be sorted *
*
Divide the array in the center by getting mid index of the array,
First Half is Left and Last Half is Right
Repeat adding nodes for the range of array:
	Left - mid to start backward, --1 to start on each iteration
	Right - mid to end forward, ++1 to end on each iteration

*/
class ConvertArrayToBinaryTree {

	private static TreeNode sortedArrayToBST(int[] arr) {
		return toBst(arr, 0, arr.length - 1);
	}

	private static TreeNode toBst(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);

		node.left = toBst(arr, start, mid - 1);
		node.right = toBst(arr, mid + 1, end);

		return node;
	}


	private static void printNodes(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printNodes(node.left);
		printNodes(node.right);
	}


	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		TreeNode root = sortedArrayToBST(arr);
		System.out.println("Preorder traversal of constructed BST");
		printNodes(root);
	}
}
