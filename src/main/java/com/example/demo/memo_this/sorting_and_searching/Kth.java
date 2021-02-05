package com.example.demo.memo_this.sorting_and_searching;


import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Kth {

	// no excercise needed
	@UtilityClass
	class KthLargetst {

		int findKthLargest(int[] arr, int k) {
			Arrays.sort(arr);

			return arr[(arr.length) - k];

		}
	}

	public static void main(String[] arg) {
		int[] arr = new int[]{4, 2, 1, 3, 5, 0};
		int kthLrgst = KthLargetst.findKthLargest(arr, 2);
		System.out.println(kthLrgst);
	}

	// SLIDING
	@UtilityClass
	private class LongestSubstringKDistinct {

		//	Given a string, find the length of the longest substring in it with no more than K distinct characters.

		/*
		Declare charFreqMap, startIdx and maxLength
		Loop for the len fo the given string then:
			update the count of the iChar in the map,

			if the count either matches k or larger than :
				matches -  update the maxLength to whichever is larger
					if the startChar counted towards freq count, subtract countin freq, remove if count is 0
					move up the start idx and

		*/
		int findLength(String str, int k) {
			Map<Character, Integer> countByChar = new HashMap<>();
			int start = 0;
			int lastLongestCount = 0;

			for (int end = 0; end < str.length(); end++) {
				char curChar = str.charAt(end);
				countByChar.putIfAbsent(curChar, 0);
				countByChar.put(curChar, countByChar.get(curChar) + 1);
				if (countByChar.get(curChar) >= k) {
					if (str.charAt(start) == curChar) {
						countByChar.put(curChar, countByChar.get(curChar) - 1);
						if (countByChar.get(curChar) < 1) {
							countByChar.remove(curChar);
						}
					} else {
						System.out.println(curChar + " count: " + countByChar.get(curChar));
						lastLongestCount = Math.max(lastLongestCount, end + 1 - start);
					}
					start++;
				}

			}

			return lastLongestCount;
		}

	}
}
