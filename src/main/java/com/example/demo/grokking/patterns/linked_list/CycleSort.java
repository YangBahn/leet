package com.example.demo.grokking.patterns.linked_list;


import java.util.ArrayList;
import java.util.List;

public class CycleSort {
	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int expectedVal = i + 1;
			if (nums[i] != expectedVal) {
				nums[expectedVal - 1] = nums[i];
				nums[i] = expectedVal;
			}
		}
	}


	public static int findMissingNumber(int[] nums) {

		int fullRangeSum = 0;
		int actualSum = 0;

		for (int i = 0; i < nums.length + 1; i++) {
			fullRangeSum += i;

			if (i < nums.length) {
				actualSum += nums[i];
			}
		}

		return fullRangeSum - actualSum;
	}

	public static List<Integer> findAllMissingNumbers(int[] nums) {

		List<Integer> missing = new ArrayList<>();
		int i = 0;
		int swapIdx = 0;
		while (i < nums.length) {
			int curVal = nums[i];
			int expectedVal = nums[curVal - 1];
			if (curVal != expectedVal) {
				swapIdx = curVal - 1;
				int swapVal = nums[swapIdx];
				nums[i] = swapVal;
				nums[swapIdx] = curVal;
			} else {
				i++;
			}
		}


		for (int k = 0; k < nums.length; k++) {
			if (nums[k] != k + 1) {
				missing.add(k + 1);
			}
		}

		return missing;
	}

	public static int findDuplicateNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				if (nums[i] == nums[nums[i] - 1]) {
					return nums[i];
				} else {
					nums[nums[i] - 1] = nums[i];
					nums[i] = nums[nums[i] - 1];
				}
			}
		}
		return -1;
	}

	public static List<Integer> findAllDuplicateNumbers(int[] nums) {
		List<Integer> duplicateNumbers = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int curVal = nums[i];
			if (curVal != i + 1) {
				int swapIdx = curVal - 1;
				if (curVal == nums[swapIdx]) {
					duplicateNumbers.add(curVal);
				} else {
					nums[swapIdx] = curVal;
					nums[i] = nums[swapIdx];
				}
			}
		}


		return duplicateNumbers;
	}
}
