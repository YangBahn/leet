package com.example.demo.hacker_rank;

import java.util.Arrays;

public class DynamicProgramming {
	private static class MaxArraySum {
		// Complete the maxSubsetSum function below.
		private static int maxSubsetSum(int[] arr) {
			Arrays.sort(arr);


			return -1;
		}

		private static int maxSumTriplets(int base, int left, int target, int[] arr) {
			int maxSum = target;
			int right = arr.length - 1;


			while (left < right) {
				int sum = arr[base] + arr[left] + arr[right];
				if (maxSum > sum) {
					left++;
				} else if (maxSum < sum) {
					maxSum = sum;


				}


			}


			return maxSum;
		}
	}
}
