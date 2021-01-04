package com.example.demo.grokking.patterns.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

	private int startIdx;
	private final static int allowedDistinctCount = 2;
	private final char[] arr;
	private int maxLen = 0;

	MaxFruitCountOf2Types(char[] arr) {
		this.arr = arr;
	}

	//	 ['A', 'B', 'C', 'A', 'C'] -> 3 (B1[a] B2[c,c])
	int findLengthInTwoBaskets() {
		Map<Character, Integer> charCountMap = new HashMap<>();

		int arrLen = arr.length;
		for (int endIdx = 0; endIdx < arrLen; endIdx++) {
			Character endChar = arr[endIdx];
			charCountMap.put(endChar, charCountMap.getOrDefault(endChar, 0) + 1);

			this.moveStartIdx(charCountMap);
			maxLen = Math.max(maxLen, endIdx - startIdx + 1);

		}

		return maxLen;
	}

	private void moveStartIdx(Map<Character, Integer> charCountMap) {
		Character startChar = arr[startIdx];
		while (charCountMap.size() > allowedDistinctCount) {
			charCountMap.put(startChar, charCountMap.get(startChar) - 1);
			if (charCountMap.get(startChar) == 0) {
				charCountMap.remove(startChar);
			}

			startIdx++;
		}

	}
}
