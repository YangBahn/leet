package com.example.demo.memo_this.tree;

import java.util.*;

// load left/right to a Queue(linkedList) while node has left or right
// process each
public class BinaryTreeOrderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int x) {
			val = x;
			left = right = next = null;
		}
	}

	static class BinaryTree {
		Node root;

		public static List<List<Integer>> traverse(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			Queue<TreeNode> que = new LinkedList<>();
			que.offer(root);
			while (!que.isEmpty()) {
				int levSize = que.size();
				List<Integer> lev = new ArrayList<>();

				for (int i = 0; i < levSize; i++) {
					TreeNode curNode = que.poll();
					lev.add(Objects.requireNonNull(curNode).val);

					if (curNode.left != null) {
						que.offer(curNode.left);
					}

					if (curNode.right != null) {
						que.offer(curNode.right);
					}
				}

				result.add(lev);
			}
			return result;
		}
	}


	public static void main(String[] args) {
		TreeNode tree_level = new TreeNode(1);
		tree_level.root.left = new TreeNode(2);
		tree_level.root.right = new TreeNode(3);
		tree_level.root.left.left = new TreeNode(4);
		tree_level.root.left.right = new TreeNode(5);
		List<List<Integer>> result = BinaryTreeOrderTraversal.BinaryTree.traverse(tree_level);
		System.out.println("Level order traversal of binary tree is - ");

	}
}
