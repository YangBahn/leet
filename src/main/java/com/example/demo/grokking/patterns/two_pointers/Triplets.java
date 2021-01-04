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
			// TODO: Write your code here
			return -1;
		}
	}

}
