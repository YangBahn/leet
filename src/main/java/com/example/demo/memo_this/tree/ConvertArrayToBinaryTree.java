package com.example.demo.memo_this.tree;


import com.example.demo.common.TreeNode;

/*
Array must be sorted *
Recursively:
	update mid idx to (range from start to end )/2
	Create new node with arr[new mid idx]
    the new node's left and right are added

		left's end = mid, start = 0
			decrease from mid every cycle then recurse
		right's start = mid,  end = arrLen-1
			increase from mid by one every cycle then recurse
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
