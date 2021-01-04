package com.example.demo.grokking.patterns.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class NoRepeatSubString {

	// "aabccbb" -> 3
	public static int findLength(String str) {
		// TODO: Write your code here
		int maxLen = 0;
		List<Character> ref = new ArrayList<>();
		char[] chars = str.toCharArray();
		for (int endIdx = 0; endIdx < chars.length; endIdx++) {
			Character endChar = chars[endIdx];
			if (!ref.contains(endChar)) {
				ref.add(endChar);
			} else {
				maxLen = Math.max(maxLen, ref.size());

				ref.clear();
				ref.add(endChar);
			}
		}


		return maxLen;
	}
}
