package com.example.demo.grokking.patterns.two_pointers;

public class TwoPointers {
	//	[1, 2, 3, 4, 6], target=6 -> 1,3
	static int[] searchTargetSum(int[] arr, int targetSum) {
		int sum = 0;
		int counter = 0;
		int leftIdx = 0;
		int rightIdx = arr.length - 1;


		while (sum != targetSum || counter <= arr.length / 2) {
			sum = arr[leftIdx] + arr[rightIdx];

			if (sum > targetSum) {
				rightIdx--;
			}

			if (sum < targetSum) {
				leftIdx++;
			}


			counter++;
		}


		return new int[]{leftIdx, rightIdx};
	}


	//[2, 3, 3, 3, 6, 9, 9] -> 4
	static int removeDupes(int[] arr) {
		int nextNonDupIdx = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[nextNonDupIdx - 1] != arr[i]) {
				arr[nextNonDupIdx] = arr[i];
				nextNonDupIdx++;
			}
		}

		return nextNonDupIdx;
	}


	static int[] squareSortedArrays(int[] arr) {

		int len = arr.length;
		int lastIdx = len - 1;
		int leftIdx = 0;
		int rightIdx = lastIdx;
		int[] squared = new int[arr.length];
		while (leftIdx <= rightIdx) {
			int lSq = arr[leftIdx] * arr[leftIdx];
			int rSq = arr[rightIdx] * arr[rightIdx];

			if (lSq > rSq) {
				squared[lastIdx--] = lSq;
				leftIdx++;
			} else {
				squared[lastIdx--] = rSq;
				rightIdx--;
			}

		}

		return squared;
	}



}
