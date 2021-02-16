package com.example.demo.hacker_rank;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayRelated {

	public static void main(String[] args) {
		int[] arr = new int[]{4, 3, 1, 2};
		int result = Sorting.getMinSwapsToSort(arr);
		System.out.println(result);


		arr = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
//		NewYearChaosSwap.minimumBribes(arr);

	}


	/*
	Input: nums = [1,2,3,4]
	Output: [1,3,6,10]
	Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].*/
	@UtilityClass
	class MathAndNumbers {
		private int[] addUpNumbersInArray(int[] nums) {

			return new int[]{2};
		}
	}

	/* Given an array, find out how many swaps would be required to sort it
	 for element in array
	 	count number of swapping of  eg. arr[i] = arr[arr[i]] occurs
	*/
	@UtilityClass
	class Sorting {
				/*
		while looping elements,
		check for the number of smaller values
		OR
		value == index - 1
		*/

		static void minBribedSwaps(int[] arr) {
			int len = arr.length;
			int bribeCount = 0;
			for (int i = 0; i < arr.length; i++) {
				int curVal = arr[i];
				// value is in right index, no bribe
				int diff = curVal - (i + 1);

				if (diff > 2) {
					System.out.println("Too chaotic");
					return;
				} else {
					int nextPossibleVal = Math.max(0, curVal - 2);
					for (int j = nextPossibleVal; j < i; j++) {
						if (arr[j] > arr[i]) bribeCount++;
					}
				}
			}
			System.out.println(bribeCount);
		}

		static int getMinSwapsToSort(int[] arr) {
			int count = 0;
			int len = arr.length;
			int i = 0;
			while (i < len) {
				// compare the value and the idex of the value
				int j = arr[i] - 1;
				if (arr[i] != arr[j]) {
					int curVal = arr[i];
					arr[i] = arr[j];
					arr[j] = curVal;
					count++;
				} else {
					i++;
				}
			}
			return count;
		}
	}

	@UtilityClass
	private class MatrixAndGraph {
		/*
rotate given array  k times
*/
		private int[] rotLeft(int[] a, int k) {
			int len = a.length;
			int[] result = new int[len];
			for (int i = 0; i < len; i++) {
				int curVal = a[i];
				int diff = i - k;
				if (diff < 0) {
					diff = len + diff;
				}
				result[diff] = curVal;
			}
			return result;
		}

		static int hourglassSum(int[][] arr) {
			int len = 6;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < len - 2; i++) {
				for (int j = 0; j < len - 2; j++) {
					int top = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
					int mid = arr[i + 1][j + 1];
					int bottom = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
					int sum = top + mid + bottom;
					max = Math.max(max, sum);
				}
			}
			return max;
		}
	}


	public static void printArr(int[] arr) {
		for (int n : arr) {
			System.out.print(n + ",");
		}
		System.out.println();
	}
}