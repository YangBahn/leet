package com.example.demo.grokking.patterns.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Triplets {
	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);

		int l = 0;
		int r = arr.length - 1;
		boolean goLeft = true;

		while (l < r && l + 1 != r - 1) {

			if (goLeft) {
				int innerR = r - 1;
				int sum = arr[l] + arr[r] + arr[innerR];
				while (sum > 0 && innerR > l) {
					innerR -= 1;
					sum = arr[l] + arr[r] + arr[innerR];

				}

				if (sum == 0) {
					triplets.add(Arrays.asList(arr[l], arr[innerR], arr[r]));
				}

				l++;
				goLeft = false;

			} else {
				int innerL = l + 1;
				int sum = arr[r] + arr[l] + arr[l + 1];
				while (sum < 0 && innerL < r) {
					innerL += 1;
					sum = arr[l] + arr[innerL] + arr[r];

				}

				if (sum == 0) {
					triplets.add(Arrays.asList(arr[l], arr[innerL], arr[r]));

				}

				r--;
				goLeft = true;
			}

		}

		HashSet<List<Integer>> set = new HashSet<>(triplets);
		triplets = new ArrayList<>(set);
		return triplets;
	}


	static class TripletSumToZero {
		public static List<List<Integer>> searchTriplets(int[] arr) {
			Arrays.sort(arr);
			List<List<Integer>> triplets = new ArrayList<>();
			for (int i = 0; i < arr.length - 2; i++) {
				if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
					continue;
				searchPair(arr, -arr[i], i + 1, triplets);
			}

			return triplets;
		}

		private static void searchPair(int[] arr, int targetSum, int l, List<List<Integer>> triplets) {
			int r = arr.length - 1;
			while (l < r) {
				int sum = arr[l] + arr[r];
				if (sum == targetSum) {
					triplets.add(Arrays.asList(-targetSum, arr[l], arr[r]));
					l++;
					r--;

					while (arr[l] == arr[l - 1]) {
						l++;
					}

					while (arr[r] == arr[r + 1]) {
						r--;
					}


				} else if (sum < targetSum) {
					l++;
				} else {
					r--;
				}
			}

		}
	}

	static class TripletSumCloseToTarget {

		public static int searchTriplet(int[] arr, int targetSum) {
			Arrays.sort(arr);
			int closesSmallestSum = -1;
			int lastSmallestDiff = -1;

			for (int targetIdx = 0; targetIdx < arr.length - 2; targetIdx++) {
				boolean isDup = targetIdx > 0 && arr[targetIdx] == arr[targetIdx - 1];
				if (!isDup) {
					int base = arr[targetIdx];
					int left = targetIdx + 1;
					int sum = getPairSumClosestToTarget(base, targetSum, left, arr);
					int diff = Math.abs(sum - targetSum);
					if (targetIdx == 0 || (diff < lastSmallestDiff)) {
						closesSmallestSum = sum;
						lastSmallestDiff = diff;
					}
				}


			}
			return closesSmallestSum;
		}

		private static int getPairSumClosestToTarget(int base, int target, int l, int[] arr) {
			int r = arr.length - 1;
			int smallestSum = -1;
			int smallestDiff = -1;
			while (l < r) {
				int curSum = arr[r] + arr[l] + base;
				if (curSum == target) {
					return curSum;
				}

				int diff = Math.abs(target - curSum);
				if (smallestDiff == -1 || smallestDiff > diff) {
					smallestDiff = diff;
					smallestSum = curSum;

				}

				if (curSum > target) {
					r--;
					while (arr[r + 1] == arr[r] && l < r) {
						r--;
					}
				} else {
					l++;
					while (arr[l - 1] == arr[l] && l < r) {
						l++;
					}
				}
			}
			return smallestSum;
		}

		static int search_alt(int[] arr, int targetSum) {
			int smallestDiff = Integer.MAX_VALUE;
			int smallestSum = Integer.MAX_VALUE;

			int r = arr.length - 1;
			for (int i = 0; i < arr.length - 2; i++) {
				int startVal = arr[i];
				int l = i + 1;
				int lVal = arr[l];

				int sum = startVal + lVal + arr[r];
				int diff = Math.abs(targetSum - sum);
				if (diff == 0) {
					return sum;
				}


				if (diff < smallestDiff) {
					smallestDiff = diff;
					smallestSum = sum;
				} else if (diff == smallestDiff) {
					smallestSum = Math.min(sum, smallestSum);
				}

				while (l < r) {
					if (sum < targetSum) {
						l++;
					} else {
						r--;
					}
				}

			}


			return smallestSum;
		}
	}

	static class TripletWithSmallerSum {

		/*
		Input: [-1, 0, 2, 3], target=3
		Output: 2
		* */
		public static int searchTriplets(int[] arr, int target) {

			Arrays.sort(arr);
			int count = 0;
			for (int i = 0; i < arr.length - 2; i++) {
				int left = i + 1;
				int right = arr.length - 1;
				int targetSum = target - arr[i];
				while (left < right) {
					int leftRightSum = arr[left] + arr[right];
					if (leftRightSum < targetSum) {
						int diff = right - left;
						count += diff;
						left++;
					} else {
						right--;
					}
				}

			}
			return count;
		}
	}
}
