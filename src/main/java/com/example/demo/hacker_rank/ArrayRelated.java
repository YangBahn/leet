package com.example.demo.hacker_rank;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayRelated {

	public static void main(String[] args) {
		int[] arr = new int[]{4, 1, 2, 3};
		int result = NewYearChaosSwap.bribe(arr);
		printArr(arr);
		System.out.println(result);

		arr = new int[]{1, 2, 3, 5, 4, 6};
		result = MinimumSwaps.count(arr);
		System.out.println("swap count " + result);
	}

	/* Given an array, find out how many swaps would be required to sort it
	 for element in array
	 	count number of swapping of  eg. arr[i] = arr[arr[i]] occurs
	*/
	@UtilityClass
	class MinimumSwaps {
		private int count(int[] arr) {
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				int curVal = arr[i];
				if (curVal - 1 != i) {
					int tempVal = arr[curVal - 1];
					arr[curVal - 1] = curVal;
					arr[i] = tempVal;
					count++;
				}
			}
			printArr(arr);

			return count;
		}
	}

	@UtilityClass
	class NewYearChaosSwap {
		/*
		Given  an unsorted array, find out  an element with most skips of order
		eg.{3,2,1} -> 3 skipped 1 and 2 so 2.

		for each element, compare it's index vs it's value
			get the diff and update max diff if new max found
		*/

		private int bribe(int[] arr) {
			int maxBribe = -1;
			for (int i = 0; i < arr.length; i++) {
				int val = arr[i];
				// bribed if value - 1 > idx
				if (val - 1 > i) {
					// absolute diff represents # of ppl bribed
					int diff = Math.abs((val - 1) - i);
					maxBribe = Math.max(maxBribe, diff);
				}
			}
			return maxBribe;
		}

	}

	/*
	rotate given array  k times
	*/
	private int[] rotate(int[] arr, int k) {
		int len = arr.length;
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			int curVal = arr[i];
			int newIdx = i + k;
			if (newIdx + k >= len) {
				newIdx = newIdx % len;
			}
			result[newIdx] = curVal;
		}
		return result;
	}

	private void printArr(int[] arr) {
		for (int n : arr) {
			System.out.print(n + ",");
		}
		System.out.println();
	}

	private int maxHrGlassSum(int[][] arr, int row, int column) {

		// top left cells of hour glasses.
		int max_sum = Integer.MIN_VALUE;
		for (int i = 0; i < row - 2; i++) {
			for (int j = 0; j < column - 2; j++) {
				int top = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
				int mid = arr[i + 1][j + 1];
				int bottom = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				int sum = top + mid + bottom;
				max_sum = Math.max(max_sum, sum);
			}
		}
		return max_sum;
	}


}