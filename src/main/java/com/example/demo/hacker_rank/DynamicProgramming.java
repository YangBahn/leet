package com.example.demo.hacker_rank;

import com.example.demo.common.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {

	public static void main(String[] args) {
		int[] arr = new int[]{-2, 1, 3, -4, 5};
		Util.printArr(arr);
		System.out.println();
		int result = MaxArraySum.maxSubsetSum2(arr);
		System.out.println(result);
	}

	private static class MaxArraySum {
		// Complete the maxSubsetSum function below.
		private static int maxSubsetSum(int[] arr) {
			List<List<Integer>> subsets = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				List<List<Integer>> curSubsets = getNonAdjSubsets(arr, i);
				subsets.addAll(curSubsets);
			}

			int max = Integer.MIN_VALUE;
			for (List<Integer> sub : subsets) {
				max = Math.max(sub.stream().reduce(Integer::sum).get(), max);
			}

			return max;
		}


		private static List<List<Integer>> getNonAdjSubsets(int[] arr, int n) {
			List<List<Integer>> subsets = new ArrayList<>();
			List<Integer> nonAdjNums = new ArrayList<>();
			nonAdjNums.add(arr[n]);
			for (int i = n + 2; i < arr.length; i += 2) {
				nonAdjNums.add(arr[i]);
			}
			subsets.add(nonAdjNums);

			int right = n + 2 + 1;
			for (int i = right; i < arr.length; i++) {
				List<Integer> curSet = new ArrayList<>();
				curSet.add(arr[n]);
				curSet.add(arr[i]);
				subsets.add(curSet);
			}

			return subsets;
		}

		// Complete the maxSubsetSum function below.
		static int maxSubsetSum2(int[] arr) {
			int len = arr.length;
			int[] maxUpTo = new int[len];

			for (int i = 0; i < len; i++) {
				int val = arr[i];
				int valOrZero = Math.max(0, val);

				int max1 = get(maxUpTo, i - 1);
				int max2 = get(maxUpTo, i - 2);

				maxUpTo[i] = Math.max(max1, max2 + valOrZero);
			}
			return maxUpTo[len -1];
		}

		private static int get(int[] values, int index) {
			if (index < 0) {
				return 0;
			} else {
				return values[index];
			}
		}

	}
}
