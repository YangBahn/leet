package com.example.demo.grokking.patterns;

import java.util.*;


public class ArraySolution {

	public static int maxProfit(int[] prices) {
		int prevNum = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			int curNum = prices[i];
			if (curNum > prevNum) {
				profit += (curNum - prevNum);
			}

			prevNum = curNum;
		}


		return profit;
	}

	public static Integer singleNumber(int[] nums) {

		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 1; i += 2) {
			int cur = nums[i];
			if (cur != nums[i + 1]) {
				return cur;
			}
		}

		return nums[len - 1];

/*		bitwise Operator version
		int single = 0;
		for (int n : nums) {
			single = single ^ n;
			out.println(single + " ^ " + n + " = " + single);
		}
		return single;*/
	}

	public static void rotate(int[] nums, int k) {
		final int[] lookUp = nums.clone();
		final int len = nums.length;

		for (int i = 0; i < nums.length; i++) {
			int srcIdx = i + k;
			srcIdx = srcIdx >= len ? srcIdx % len : srcIdx;

			nums[srcIdx] = lookUp[i];

		}
	}


	public static boolean containsDuplicate(int[] nums) {

		if (Objects.isNull(nums) || nums.length == 0) return false;

		Arrays.sort(nums);
		int lastVal = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (lastVal == nums[i]) {
				return true;
			}

			lastVal = nums[i];
		}

		return false;
	}

	/*
	Given two arrays, write a function to compute their intersection.

			Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]
	Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
	*/

	public static int[] intersect(int[] nums1, int[] nums2) {


		Map<Integer, Integer> valueByCount_1 = new HashMap<>();

		for (int i = 0; i < nums1.length; i++) {
			int cur = nums1[i];

			if (valueByCount_1.containsKey(cur)) {
				valueByCount_1.put(cur, valueByCount_1.get(cur) + 1);
			} else {
				valueByCount_1.put(cur, 1);
			}
		}


		Map<Integer, Integer> valueByCount_2 = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			int cur = nums2[i];
			if (valueByCount_2.containsKey(cur)) {
				valueByCount_2.put(cur, valueByCount_2.get(cur) + 1);
			} else {
				valueByCount_2.put(cur, 1);
			}
		}

		List<Integer> intersects = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : valueByCount_1.entrySet()) {
			int arr1Val = entry.getKey();
			int arr1ValCt = entry.getValue();

			if (valueByCount_2.containsKey(arr1Val)) {
				int count = Math.min(arr1ValCt, valueByCount_2.get(arr1Val));
				for (int i = 0; i < count; i++) {
					intersects.add(arr1Val);
				}
			}
		}


		int[] result = new int[intersects.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = intersects.get(i);
		}


		return result;
	}


	public static int[] plusOne(int[] digits) {


		int lastIdx = digits.length - 1;
		if ((digits[lastIdx] + 1) < 10) {
			digits[lastIdx]++;
			return digits;
		} else {

			for (int i = digits.length - 1; i >= 0; i--) {

				int curVal = digits[i];
				if (curVal + 1 < 10) {
					digits[i] = curVal + 1;
					return digits;

				} else {
					digits[i] = 0;
					if (i == 0) {
						int[] result = new int[digits.length + 1];

						for (int j = digits.length - 1; j >= 0; j--) {
							result[j + 1] = digits[j];
						}
						result[0] = 1;
						return result;
					}
				}

			}
		}

		return digits;
	}


	//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
	public static void moveZeroes(int[] nums) {


		int lastNonZeroIdx = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] != 0) {
				nums[lastNonZeroIdx] = nums[i];
				lastNonZeroIdx++;
			}
		}

		for (int i = lastNonZeroIdx; i < len; i++) {
			nums[i] = 0;
		}
	}

	/*

	Given nums = [2, 7, 11, 15], target = 9,
	return [0, 1].
	*/
	public static int[] twoSum(int[] nums, int target) {
		int len = nums.length;


		if (target == 0) {
			int lastZeroIdx = -1;
			for (int i = 0; i < len; i++) {
				if (nums[i] == 0) {
					if (lastZeroIdx == -1) {
						lastZeroIdx = i;
					} else {
						return new int[]{lastZeroIdx, i};
					}
				}
			}
		}

		for (int i = 0; i < len; i++) {

			if ((target > 0 && nums[i] < target)) {
				int diff = target - nums[i];
				for (int j = 0; j < len; j++) {
					if (i != j && diff == nums[j]) {
						return new int[]{i, j};
					}
				}
			}

		}

		return new int[]{0, 0};
	}
/*
*
* You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
* */

	public void rotate(int[][] matrix) {

	}

}
