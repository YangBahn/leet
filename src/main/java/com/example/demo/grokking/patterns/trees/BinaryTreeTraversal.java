package com.example.demo.grokking.patterns.trees;


import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class BinaryTreeTraversal {


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	;

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

			result.add((double) (total / levSize));
		}

		return result;
	}

	public static int findMinDepth(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		int shortest = 0;
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

			result.add((double) (total / levSize));
		}


		return shortest;
	}
}
