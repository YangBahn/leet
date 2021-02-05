package com.example.demo.memo_this.sorting_and_searching;

import lombok.experimental.UtilityClass;

public class SearchForRange {


	public static void main(String[] args) {
		int[] n = new int[]{1, 2, 3, 4, 5, 6};
		int target = 4;
//		int[] r = Range.searchRange(n, target);
//		for (int i : r) {
//			System.out.println(i);
//		}

	}

	@UtilityClass
	private class Range {
		int[] searchRange(int[] nums, int target) {
			int left = 0;
			int right = nums.length - 1;

			while (left < right) {
				int m = left + (right - left) / 2;
				if (nums[m] < target) {
					left = m + 1;
				} else {
					right = m;
				}
			}

			int first = left;
			if (left < nums.length && nums[left] == target) {//l is in boundary and is the target
				left = 0;
				right = nums.length - 1;
				while (left < right) {
					int m = left + (right - left + 1) / 2;
					if (nums[m] > target) {
						right = m - 1;
					} else {
						left = m;
					}
				}

				return new int[]{first, right};
			}

			return new int[]{-1, -1};
		}
	}

}
