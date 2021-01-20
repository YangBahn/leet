package com.example.demo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());
		for (int curNum : nums) {
			// declare len here since subsets size will increase with i iteration
			int len = subsets.size();
			for (int i = 0; i < len; i++) {
				List<Integer> copy = new ArrayList<>(subsets.get(i));
				copy.add(curNum);
				subsets.add(copy);
			}
		}

		return subsets;
	}

	static class SubsetWithDuplicates {

		public static List<List<Integer>> findSubsets(int[] nums) {
			List<List<Integer>> subsets = new ArrayList<>();
			subsets.add(new ArrayList<>());
			Arrays.sort(nums);
			int lastNum = -1;
			for (int curNum : nums) {
				int subsetLen = subsets.size();
				if (curNum != lastNum) {
					for (int i = 0; i < subsetLen; i++) {
						List<Integer> copy = new ArrayList<>(subsets.get(i));
						copy.add(curNum);
						subsets.add(copy);
					}
				} else {
					// if same num, add it to only the last subsets
					List<Integer> copy = new ArrayList<>(subsets.get(subsetLen - 1));
					copy.add(curNum);
					subsets.add(copy);

				}

				lastNum = curNum;
			}


			return subsets;
		}

	}

	public static void main(String[] args) {
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[]{1, 3, 3});
		System.out.println("Here is the list of subsets: " + result);

		result = SubsetWithDuplicates.findSubsets(new int[]{1, 5, 3, 3});
		System.out.println("Here is the list of subsets: " + result);
	}
}
