package com.example.demo.grokking.patterns.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subarrays {

	/*
Input: [2, 3, 5, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
	*/
	public static List<List<Integer>> findSubArrays(int[] arr, int target) {

		List<List<Integer>> subarrays = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (i == 2 || (i > 2 && i % 2 == 1)) {
				int sum = arr[i - 1] + arr[i];
				if (sum < target) {
					subarrays.add(Arrays.asList(arr[i - 2], arr[i - 1]));
					i -= 1;
				}
			} else {
				if (arr[i] < target) {
					subarrays.add(Arrays.asList(arr[i]));
				}
			}


		}


		return subarrays;
	}
}
