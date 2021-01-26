package com.example.demo.grokking.patterns.two_pointers;

import com.example.demo.grokking.patterns.sliding_window.SlidingWindow2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoPointers_2 {
	static class SortedArraySquares {

		public static int[] makeSquares(int[] arr) {
			int n = arr.length;
			int[] squares = new int[n];
			int highestSquareIdx = n - 1;
			int left = 0, right = arr.length - 1;
			while (left <= right) {
				int leftSquare = arr[left] * arr[left];
				int rightSquare = arr[right] * arr[right];
				if (leftSquare > rightSquare) {
					squares[highestSquareIdx--] = leftSquare;
					left++;
				} else {
					squares[highestSquareIdx--] = rightSquare;
					right--;
				}
			}
			return squares;
		}
	}


	static class TripletSumToZero {

		/* Sort Array,
		 * then begining at the idx0 as basis (smallest), find a pair that adds up to 0
		 * 	starting with left = base + 1 and right = arr.leng -1
		 * 		Compare sum vs base num -> too big, move right --1 ,  too small, move left++
		 * 		do this repeatedly while left is smaller than the right
		 * */
		public static List<List<Integer>> searchTriplets(int[] arr) {
			Arrays.sort(arr);
			List<List<Integer>> triplets = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
					continue;
				search(-arr[i], i + 1, arr, triplets);
			}

			return triplets;
		}

		private static void search(int base, int left, int[] arr, List<List<Integer>> triplets) {
			int right = arr.length - 1;

			while (left < right) {
				int val1 = arr[left];
				int val2 = arr[right];
				int sum = val1 + val2;
				if (sum < base) {
					left++;
				} else if (sum > base) {
					right--;
				} else {
					triplets.add(Arrays.asList(-base, val1, val2));
					left++;
					right--;
				}
			}
		}
	}

	static class TripletSumCloseToTarget {

		public static int searchTriplet(int[] arr, int targetSum) {
			Arrays.sort(arr);

			int closestSum = -1;
			int right = arr.length - 1;
			for (int i = 0; i < arr.length; i++) {

				if (i > 0 && arr[i] == arr[i - 1]) {
					continue;
				}

				int left = i + 1;
				while (left < right) {
					int sum = arr[i] + arr[left] + arr[right];

					if (targetSum == sum) {
						return sum;
					}

					int diff = Math.abs(targetSum - sum);

					if (diff < targetSum - closestSum) {
						closestSum = sum;
					}

					if (diff == targetSum - closestSum) {
						closestSum = Math.min(sum, closestSum);
					}

					if (sum > targetSum) {
						right--;
					} else if (sum < targetSum) {
						left++;
					}

				}


			}

			return closestSum;
		}
	}

	static class TripletWithSmallerSum {

		public static int searchTriplets(int[] arr, int target) {
			int count = 0;
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				if (i > 0 && arr[i] == arr[i - 1]) {
					continue;
				}
				count += search(-arr[i], i + 1, arr, target);
			}
			return count;
		}

		private static int search(int baseVal, int left, int[] arr, int target) {
			int right = arr.length - 1;
			int count = 0;
			while (left < right) {
				int leftOver = target - (baseVal + arr[left]);
				if (leftOver > 0) {
					right--;
					left++;
					count += 1;
				} else {
					right--;
				}


			}

			return count;
		}
	}

	static class SubarrayProductLessThanK {

		public static List<List<Integer>> findSubarrays(int[] arr, int target) {
			List<List<Integer>> result = new ArrayList<>();
			int product = 1, left = 0;
			for (int right = 0; right < arr.length; right++) {
				product = product * arr[right];
				while (product >= target && left < arr.length)
					product = product / arr[left];
				left += 1;
				// since the product of all numbers from left to right is less than the target therefore,
				// all subarrays from left to right will have a product less than the target too; to avoid
				// duplicates, we will start with a subarray containing only arr[right] and then extend it
				List<Integer> tempList = new LinkedList<>();
				for (int i = right; i >= left; i--) {
					tempList.add(0, arr[i]);
					result.add(new ArrayList<>(tempList));
				}
			}
			return result;
		}


	}

	static class DutchFlag {

		public static void sort(int[] arr) {

			int left = 0;
			int right = arr.length - 1;

			for (int i = 0; i < arr.length - 1; i++) {


			}
		}

	}

	static class QuadrupleSumToTarget {

		public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
			List<List<Integer>> quadruplets = new ArrayList<>();
			// TODO: Write your code here
			return quadruplets;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 0, 2, 1, 0};
		DutchFlag.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ");
		arr = new int[]{2, 2, 0, 1, 2, 0};
		DutchFlag.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
}