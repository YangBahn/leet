package com.example.demo.memo_this.array_and_strings;


import com.example.demo.common.ParenthesesString;
import com.example.demo.common.TreeNode;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		List<List<Integer>> result = NumberArrayPermutations.findPermutations(new int[]{1, 3, 5});
		System.out.print("Here are all the permutations: " + result);

/*		List<String> result = GenerateParentheses.generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = GenerateParentheses.generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);*/
	}


	/*
	If a set has ‘n’ distinct elements it will have n!n!n! permutations.
	Input: [1,3,5]
	Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
	*/
	static class NumberArrayPermutations {

		/*
		Create 'List of Integer List' to store found permutations - completed
		Create 'queuedPerms' to line up each perm - temp
		For num in  Nums
			For each queued permutation
				For each num in permutation:
					create a copy of old permutation and add curNum
					Add it to Result if all num is processed. If not, add to 'queuedPerms'
		*/
		static List<List<Integer>> findPermutations(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			Queue<List<Integer>> queuedPerms = new LinkedList<>();
			queuedPerms.add(new ArrayList<>());

			for (int currentNumber : nums) {
				// we will take all existing permutations and add the current number to create new permutations
				int numberOfQueuedPerms = queuedPerms.size();
				for (int i = 0; i < numberOfQueuedPerms; i++) {

					// create a new permutation by adding the current number at every position
					Optional.ofNullable(queuedPerms.poll())
							.ifPresent(oldPermutation -> {
								for (int j = 0; j <= oldPermutation.size(); j++) {
									List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
									newPermutation.add(j, currentNumber);
									if (newPermutation.size() == nums.length)
										result.add(newPermutation);
									else
										queuedPerms.add(newPermutation);
								}
							});
				}
			}
			return result;
		}

		static List<List<Integer>> makeCopyAndExpandExponentially(List<Integer> oldPerm) {
			List<List<Integer>> expanded = new ArrayList<>();
			int eachArraySize = oldPerm.size() + 1;
			int numberOfPermsToGenerate = oldPerm.size();
			for (int i = 0; i <= numberOfPermsToGenerate - 1; i++) {
				List<Integer> newPerm = new ArrayList<>(oldPerm);

				int addVal = i == numberOfPermsToGenerate - 1 ?
						oldPerm.get(i - 1) + 2 : oldPerm.get(i) + 1;

				newPerm.add(addVal);
				if (newPerm.size() == eachArraySize) {
					expanded.add(newPerm);
				}
			}

			return expanded;
		}


	}


	static class GenerateParentheses {
		/*
		Create 'result list' and 'parenthQueue', load it with an empty ParentheseString
		repeat while parenthQueue.isNotEmpty:
			poll last added on the queue do either of:
				1. current parenth is complete (isClosed and isAtMaxPairCount), add it toe result
				2. Not complete, load the queue with ,either or both
					There is more room to add another pair
					Is unbalanced. Add closeing parenth.
		*/
		static List<String> generateBalancedParentheses(int maxPairCount) {
			List<String> result = new ArrayList<String>();
			Queue<ParenthesesString> parenthQueue = new LinkedList<>();
			parenthQueue.add(new ParenthesesString("", 0, 0));
			while (!parenthQueue.isEmpty()) {
				ParenthesesString parenthStr = parenthQueue.poll();

				// if we've reached the maximum number of open and close parentheses, add to the result
				if (parenthStr.isClosedAt(maxPairCount)) {
					result.add(parenthStr.str);
				} else {
					if (parenthStr.openCount < maxPairCount) // if we can add an open parentheses, add it
						parenthQueue.add(new ParenthesesString(parenthStr.str + "(", parenthStr.openCount + 1, parenthStr.closeCount));

					if (parenthStr.openCount > parenthStr.closeCount) // if we can add a close parentheses, add it
						parenthQueue.add(new ParenthesesString(parenthStr.str + ")", parenthStr.openCount, parenthStr.closeCount + 1));
				}
			}
			return result;
		}

	}


	//Given a number ‘n’, write a function to return all structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’?
// Binary Search tree , left smaller, right bigger
	static class UniqueTrees {
		public static List<TreeNode> findUniqueTrees(int n) {
			if (n <= 0)
				return new ArrayList<TreeNode>();
			return findUniqueTreesRecursive(1, n);
		}

		static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
			List<TreeNode> result = new ArrayList<>();
			// only one tree at root, setting left/right as null
			if (start > end) {
				result.add(null);
				return result;
			}

			// bit of sliding window here, i is the gap between, hence we can make i number of roots
			for (int thRoot = start; thRoot <= end; thRoot++) {
				// making 'i' root of the tree
				List<TreeNode> leftSubtrees = findUniqueTreesRecursive(start, thRoot - 1);
				// right is always bigger by 1, hence thRoot + 1
				List<TreeNode> rightSubtrees = findUniqueTreesRecursive(thRoot + 1, end);

				result.addAll(createOneWholeLevel(thRoot, leftSubtrees, rightSubtrees));

			}
			return result;
		}

		private static List<TreeNode> createOneWholeLevel(int thRoot, List<TreeNode> leftSubtrees, List<TreeNode> rightSubtrees) {
			List<TreeNode> result = new ArrayList<>();
			for (TreeNode leftTree : leftSubtrees) {
				for (TreeNode rightTree : rightSubtrees) {
					TreeNode root = new TreeNode(thRoot);
					root.left = leftTree;
					root.right = rightTree;
					result.add(root);
				}
			}

			return result;
		}
	}
}
