package com.example.demo.grokking.patterns.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {


	static int findMinSubArray(int S, int[] arr) {
		int smallestElCt = arr.length;
		int startIdx = 0;
		int sum = 0;
		for (int endIdx = 0; endIdx < arr.length; endIdx++) {

			sum += arr[endIdx];

			if (sum >= S) {
				int curElCount = endIdx - startIdx + 1;
				if (curElCount == 1) {
					return 1;
				}

				if (smallestElCt > curElCount) {
					smallestElCt = curElCount;
				}
				sum -= arr[startIdx];

				startIdx++;
				if (arr[startIdx] + arr[endIdx] >= S) {
					smallestElCt = smallestElCt - 1;
					startIdx++;
				}

			}

		}

		return smallestElCt;
	}


	public static int findMaxSumSubArray(int k, int[] arr) {
		// TODO: Write your code here
		int sum = 0;
		int largestSum = 0;
		int startIndx = 0;

		for (int endIdx = 0; endIdx < arr.length; endIdx++) {
			sum += arr[endIdx];
			if (endIdx - startIndx + 1 == k) {
				if (largestSum < sum) {
					largestSum = sum;
				}

				sum -= arr[startIndx];
				startIndx++;
			}

		}

		return largestSum;
	}


	// todo refactor
	//	Input: String="araaci", K=2
	public static int findLength(String str, int k) {
		char[] chars = str.toCharArray();
		int startIdx = 0;
		int largestCount = 0;
		List<Character> list = new ArrayList<>();
		int distinctCount = 0;
		for (int endIdx = 0; endIdx < chars.length; endIdx++) {

			if (distinctCount >= k) {
				if (!list.contains(chars[endIdx])) {
					if (list.size() > largestCount) {
						largestCount = list.size();
						list.remove(startIdx);
						if (!list.contains(chars[endIdx])) {
							distinctCount--;
						}

						startIdx++;
					}
				} else {
					list.add(chars[endIdx]);
				}

			} else {
				if (!list.contains(chars[endIdx])) {
					distinctCount++;
				}
				list.add(chars[endIdx]);
			}

		}

		return largestCount;
	}


}
