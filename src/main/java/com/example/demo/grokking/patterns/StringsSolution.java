package com.example.demo.grokking.patterns;

import java.util.Objects;

public class StringsSolution {

	/*
	Input: "A man, a plan, a canal: Panama"
	Output: true
	*/
	public static boolean isPalindrome(String s) {

		StringBuilder builder = new StringBuilder();
		for (char c : s.toLowerCase().toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				builder.append(c);
			}
		}

		s = builder.toString();

		if (s.length() == 1) {
			return true;
		}

		int halfLen = s.length() / 2;
		for (int i = 0; i < halfLen; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}

		}

		return true;
	}


	/*
	Input: haystack = "hello", needle = "ll"
	Output: 2
	*/
	public static int strStr(String haystack, String needle) {


		if (needle == null || needle.length() == 0) {
			return 0;
		}

		if (haystack == null || haystack.isEmpty() || !haystack.contains(needle)) {
			return -1;
		}


		char[] stackArr = haystack.toCharArray();
		char[] needleArr = needle.toCharArray();

		int lastValidIdx = stackArr.length - (needleArr.length - 1);
		for (int i = 0; i < lastValidIdx; i++) {
			char firstNeedleChar = needleArr[0];

			if (stackArr[i] == firstNeedleChar) {
				int stackCharIdxCounter = i + 1;
				int needlCharIdxCounter = 1;
				boolean charMatched = true;
				while (charMatched && needleArr.length > needlCharIdxCounter) {
					char stackChar = stackArr[stackCharIdxCounter];
					char needleChar = needleArr[needlCharIdxCounter];

					if (stackChar != needleChar) {
						charMatched = false;
					} else {
						stackCharIdxCounter++;
						needlCharIdxCounter++;
					}

				}

				if (needleArr.length == needlCharIdxCounter) {
					return i;
				}
			}
		}

		return -1;

	}

	/*
	Input: ["flower","flow","flight"]
	Output: "fl"
	*/
	public static String longestCommonPrefix(String[] strs) {

		if ( strs.length == 0) {
			return "";
		}

		if ( strs.length == 1 && Objects.nonNull(strs[0])) {
			return strs[0];
		}

		for (String str : strs) {
			if (str == null || str.length() == 0) {
				return "";
			}
		}


		StringBuilder builder = new StringBuilder();
		int prefixIdx = 0;
		int arrLen = strs.length;

		Character charToMatch = strs[0].toCharArray()[prefixIdx];
		while(Objects.nonNull(charToMatch) ) {
			for (int i = 0; i < arrLen; i++) {

				int strLen = strs[i].toCharArray().length;

				if (strLen == prefixIdx) {
					charToMatch = null;
					break;
				}

				if (charToMatch !=  strs[i].toCharArray()[prefixIdx]) {
					charToMatch = null;
					break;
				}

				if (i == arrLen - 1) {
					builder.append(charToMatch);
					prefixIdx++;

					if (strLen == prefixIdx) {
						charToMatch = null;
					} else {

						charToMatch = strs[i].toCharArray()[prefixIdx];
					}

				}
			}
		}

		return builder.toString();

	}






}
