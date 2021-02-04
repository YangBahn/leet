package com.example.demo.memo_this.array_and_strings.excercise;


import com.example.demo.common.ParenthesesString;
import com.example.demo.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExcPermutations {

	public static void main(String[] args) {
//		List<List<Integer>> result = NumberArrayPermutations.findPermutations(new int[]{1, 3, 5});
//
//		result = NumberArrayPermutations.makeCopyAndExpandExponentially(Arrays.asList(1, 2, 3));
//		System.out.print("Here are all the permutations: " + result);
//

		List<String> result = GenerateParentheses.generateBalancedParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = GenerateParentheses.generateBalancedParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

	static class NumberArrayPermutations {

		/*
		Create 'List of Integer List' to store found permutations - completed
		Create 'queuedPerms' to line up each perm - temp
		Loop given Nums for each number

			Loop queued permutations

				Loop the integers in each generated permutation and do:
					create a copy of old permutation and add curNum
					Add it to Result if all num is processed. If not, add to 'queuedPerms'
		*/
		static List<List<Integer>> findPermutations(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			Queue<List<Integer>> queue = new LinkedList<>();
			queue.offer(new ArrayList<>());

			for (int curNum : nums) {
				// queue size shouldn't change during loop
				final int queuedNumbersCount = queue.size();
				for (int i = 0; i < queuedNumbersCount; i++) {
					List<Integer> inProcess = queue.poll();
					// <= since we need to create a new one as well
					for (int j = 0; j <= inProcess.size(); j++) {
						List<Integer> copy = new ArrayList<>(inProcess);
						copy.add(j, curNum);
						if (copy.size() == nums.length) {
							result.add(copy);
						} else {
							queue.offer(copy);
						}
					}
				}
			}

			return result;
		}

		static List<List<Integer>> makeCopyAndExpandExponentially(List<Integer> oldPerm) {

			List<List<Integer>> expanded = new ArrayList<>();
			int arraySizeCap = oldPerm.size() + 1;
			int numberOfPermsToGenerate = oldPerm.size();
			for (int i = 0; i <= numberOfPermsToGenerate - 1; i++) {
				List<Integer> newPerm = new ArrayList<>(oldPerm);

				int addVal = i == numberOfPermsToGenerate - 1 ?
						oldPerm.get(i - 1) + 2 : oldPerm.get(i) + 1;

				newPerm.add(addVal);
				if (newPerm.size() == arraySizeCap) {
					expanded.add(newPerm);
				}
			}

			return expanded;
		}
	}


	// generate all possible whole parentheses at k count
	static class GenerateParentheses {
		/*
		Create 'result list' and 'parenthQueue', load it with an empty ParentheseString
		while parenthQueue.isNotEmpty:
			poll last added on the queue do either of:
				1. current parenth is complete (isClosed and isAtMaxPairCount), add it toe result
				2. Not complete, load the queue with ,either or both
					There is more room to add another pair
					Is unbalanced. Add closeing parenth.
		*/
		static List<String> generateBalancedParentheses(int maxPairCount) {
			List<String> result = new ArrayList<String>();
			Queue<ParenthesesString> pStringQueue = new LinkedList<>();
			pStringQueue.add(new ParenthesesString("", 0, 0));

			while (!pStringQueue.isEmpty()) {
				ParenthesesString lastParenthese = pStringQueue.poll();
				if (lastParenthese.isClosedAt(maxPairCount)) {
					result.add(lastParenthese.str);
				} else {

					if (lastParenthese.openCount < maxPairCount) {
						pStringQueue.add(new ParenthesesString(lastParenthese.str + "{", lastParenthese.openCount + 1, lastParenthese.closeCount));
					}
					if (lastParenthese.openCount > lastParenthese.closeCount) {
						pStringQueue.add(new ParenthesesString(lastParenthese.str + "}", lastParenthese.openCount, lastParenthese.closeCount + 1));
					}
				}
			}
			return result;
		}

	}

	// todo skipped
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

			return result;
		}
	}
}
