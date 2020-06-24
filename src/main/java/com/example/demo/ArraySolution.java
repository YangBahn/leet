package com.example.demo;

import java.util.Arrays;
import java.util.Objects;

import static com.example.demo.DemoApplication.Printr.print;

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

			print(nums);
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

}
