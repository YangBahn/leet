package com.example.demo.grokking.patterns.subsets;

import java.util.*;

class Permutations {

	public static List<List<Integer>> findPermutations(int[] nums) {
		Queue<List<Integer>> temp = new LinkedList<>();
		temp.add(new ArrayList<>());
		for (int curNum : nums) {
			int rsize = temp.size();
			for (int j = 0; j < rsize; j++) {
				temp.addAll(createSubsets(temp.poll(), curNum));
			}
		}
		return new ArrayList<>(temp);
	}

	private static List<List<Integer>> createSubsets(List<Integer> subset, int num) {
		List<List<Integer>> newSubsets = new ArrayList<>();
		for (int i = 0; i <= subset.size(); i++) {
			List<Integer> copy = new ArrayList<>(subset);
			copy.add(i, num);
			newSubsets.add(copy);
		}

		return newSubsets;
	}

	public static void main(String[] args) {

		List<List<Integer>> result = Permutations.findPermutations(new int[]{1, 3, 5});
		System.out.print("Here are all the permutations: " + result);
	}
}