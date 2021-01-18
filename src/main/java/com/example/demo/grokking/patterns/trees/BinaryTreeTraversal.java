package com.example.demo.grokking.patterns.trees;


import java.util.*;

public class BinaryTreeTraversal {

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

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int levSize = que.size();
			List<Integer> lev = new ArrayList<>();

			for (int i = 0; i < levSize; i++) {
				TreeNode curNode = que.poll();
				lev.add(curNode.val);

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

	public static List<List<Integer>> reverseTraverse(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();

		Queue<TreeNode> que = new LinkedList<>();
		Deque<List<Integer>> rev = new ArrayDeque<List<Integer>>();

		que.offer(root);
		while (!que.isEmpty()) {
			int levSize = que.size();
			List<Integer> lev = new ArrayList<>();

			for (int i = 0; i < levSize; i++) {
				TreeNode curNode = que.poll();
				lev.add(curNode.val);

				if (curNode.left != null) {
					que.offer(curNode.left);
				}

				if (curNode.right != null) {
					que.offer(curNode.right);
				}

			}
			rev.addFirst(lev);
		}

		result = new ArrayList<>(rev);
		return result;
	}

	public static List<List<Integer>> zigZagTraverse(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();

		Queue<TreeNode> que = new LinkedList<>();

		int curLevel = 0;
		que.offer(root);
		while (!que.isEmpty()) {
			curLevel++;
			int levSize = que.size();
			List<Integer> lev = new ArrayList<>();

			for (int i = 0; i < levSize; i++) {
				TreeNode curNode = que.poll();
				lev.add(curNode.val);

				if (curNode.right != null) {
					que.offer(curNode.right);
				}

				if (curNode.left != null) {
					que.offer(curNode.left);
				}
			}

			if (curLevel % 2 == 1) {
				Collections.reverse(lev);
			}

			result.add(lev);
		}


		return result;
	}

	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int levSize = que.size();
			List<Integer> lev = new ArrayList<>();
			double total = 0;
			for (int i = 0; i < levSize; i++) {
				TreeNode curNode = que.poll();
				lev.add(curNode.val);
				total += curNode.val;

				if (curNode.left != null) {
					que.offer(curNode.left);
				}

				if (curNode.right != null) {
					que.offer(curNode.right);
				}

			}

			result.add(total / levSize);
		}

		return result;
	}

	public static int findMinDepth(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int levSize = que.size();
			List<Integer> lev = new ArrayList<>();
			double total = 0;
			for (int i = 0; i < levSize; i++) {
				TreeNode curNode = que.poll();
				lev.add(curNode.val);
				total += curNode.val;

				if (curNode.left != null) {
					que.offer(curNode.left);
				}

				if (curNode.right != null) {
					que.offer(curNode.right);
				}

			}

			result.add(lev);
		}

		int lastLen = 1;
		for (int i = 1; i < result.size(); i++) {
			if (result.get(i).size() != lastLen * 2) {
				return i;
			}
		}

		return result.size();
	}

	public static TreeNode findSuccessor(TreeNode root, int key) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			// insert the children of current node in the queue
			if (currentNode.left != null)
				queue.offer(currentNode.left);
			if (currentNode.right != null)
				queue.offer(currentNode.right);

			// break if we have found the key
			if (currentNode.val == key)
				break;
		}

		return queue.peek();
	}

	public static void connectLevelOrderSiblings(TreeNode root) {

		Queue<TreeNode> que = new LinkedList<>();
		root.next = null;
		que.offer(root);
		while (!que.isEmpty()) {
			int levSize = que.size();
			List<TreeNode> lev = new ArrayList<>();

			for (int i = 0; i < levSize; i++) {
				TreeNode curNode = que.poll();
				lev.add(curNode);

				if (curNode.left != null) {
					que.offer(curNode.left);
				}

				if (curNode.right != null) {
					que.offer(curNode.right);
				}
			}

			for (int i = 0; i < levSize; i++) {
				TreeNode cur = lev.get(i);
				if (i == levSize - 1) {
					cur.next = null;
				} else {
					cur.next = lev.get(i + 1);
				}

			}

		}

	}
}
