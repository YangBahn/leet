package com.example.demo.grokking.patterns.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindow2 {


	static class LongestSubstringKDistinct {
		public static int findLength(String str, int k) {

			Map<Character, Integer> countByChar = new HashMap<>();
			int start = 0;
			int lastLongestCount = 0;
			System.out.println("\n" + str);

			for (int end = 0; end < str.length(); end++) {
				char curChar = str.charAt(end);
				countByChar.put(curChar, countByChar.getOrDefault(curChar, 0) + 1);

				while (countByChar.size() > k) {
					char startChar = str.charAt(start);

					countByChar.put(startChar, countByChar.get(startChar) - 1);
					if (countByChar.get(startChar) < 1) {
						countByChar.remove(startChar);
					}
					start++;
				}
				lastLongestCount = Math.max(lastLongestCount, end - start + 1);

			}

			return lastLongestCount;
		}

	}


	static class CharacterReplacement {
		public static int findLength(String str, int k) {
			// TODO: Write your code here
			int maxLen = 0;
			int start = 0;
			int maxRepeatLetterCount = 0;
			Map<Character, Integer> lookUp = new HashMap<Character, Integer>();
			for (int end = 0; end < str.length(); end++) {
				char rightChar = str.charAt(end);
				lookUp.put(rightChar, lookUp.getOrDefault(rightChar, 0) + 1);
				maxRepeatLetterCount = Math.max(maxRepeatLetterCount, lookUp.get(rightChar));

				int charToReplace = (end - start + 1) - maxRepeatLetterCount;
				if (charToReplace > k) {
					char leftChar = str.charAt(start);
					lookUp.put(leftChar, lookUp.get(leftChar) - 1);
					start++;
				}

				maxLen = Math.max(maxLen, end - start + 1);
			}

			return maxLen;

		}

	}

	static class ReplacingOnes {
		public static int findLength(int[] arr, int k) {
			int oneRepeatCt = 0;
			int start = 0;
			int maxLen = 0;
			for (int end = 0; end < arr.length; end++) {
				int cur = arr[end];
				if (cur == 1) {
					oneRepeatCt += 1;
				}


				if (end - start + 1 - oneRepeatCt > k) {
					if (arr[start] == 1) {
						oneRepeatCt -= 1;
					}
					start++;
				}

				maxLen = Math.max(maxLen, end - start + 1);
			}

			// TODO: Write your code here
			return maxLen;
		}
	}

	static class StringPermutation {
		public static boolean findPermutation(String str, String pattern) {
			// create map for both Str and pattern
			// if strMap contains all key/val from patterh, return true
			Map<Character, Integer> lookUp = new HashMap<>();
			for (char c : pattern.toCharArray()) {
				lookUp.put(c, lookUp.getOrDefault(c, 0) + 1);
			}
			int matchCt = 0;
			int left = 0;
			for (int right = 0; right < str.length(); right++) {
				char cur = str.charAt(right);
				if (lookUp.containsKey(cur)) {
					lookUp.put(cur, lookUp.get(cur) - 1);

					if (lookUp.get(cur) == 0) {
						matchCt++;
					}
				}


				if (matchCt <= lookUp.size()) {
					return true;
				}

				if (right >= pattern.length() - 1) {
					char leftChar = str.charAt(left);
					if (lookUp.containsKey(leftChar)) {
						if (lookUp.get(leftChar) == 0) {
							matchCt--;
						}

						lookUp.put(leftChar, lookUp.get(leftChar) + 1);

					}
					left++;
				}

			}


			return false;
		}
	}


	static class StringAnagrams {
		public static List<Integer> findStringAnagrams(String str, String pattern) {
			List<Integer> resultIndices = new ArrayList<Integer>();
			Map<Character, Integer> tempMap = new HashMap<>();
			for (char c : pattern.toCharArray()) {
				tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
			}

			int start = 0;
			int matchCt = 0;
			for (int end = 0; end < str.length(); end++) {
				char curChar = str.charAt(end);
				if (tempMap.containsKey(curChar)) {
					tempMap.put(curChar, tempMap.get(curChar) - 1);
					if (tempMap.get(curChar) < 1) {
						matchCt++;
					}
				}

				if (matchCt == tempMap.size()) {
					resultIndices.add(end);


				}

				if (end >= pattern.length() - 1) {

					char leftChar = str.charAt(start++);
					if (tempMap.containsKey(leftChar)) {
						if (tempMap.get(leftChar) == 0) {
							matchCt--;
						}
						tempMap.put(leftChar, tempMap.get(leftChar) + 1);
					}
				}

			}


			// TODO: Write your code here
			return resultIndices;
		}
	}

	static class MinimumWindowSubstring {
		public static String findSubstring(String str, String pattern) {
			int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
			Map<Character, Integer> charFrequencyMap = new HashMap<>();
			for (char chr : pattern.toCharArray())
				charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

			// try to extend the range [windowStart, windowEnd]
			for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
				char rightChar = str.charAt(windowEnd);
				if (charFrequencyMap.containsKey(rightChar)) {
					charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
					if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
						matched++;
				}

				// shrink the window if we can, finish as soon as we remove a matched character
				while (matched == pattern.length()) {
					if (minLength > windowEnd - windowStart + 1) {
						minLength = windowEnd - windowStart + 1;
						subStrStart = windowStart;
					}

					char leftChar = str.charAt(windowStart++);
					if (charFrequencyMap.containsKey(leftChar)) {
						// note that we could have redundant matching characters, therefore we'll decrement the
						// matched count only when a useful occurrence of a matched character is going out of the window
						if (charFrequencyMap.get(leftChar) == 0)
							matched--;
						charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
					}
				}
			}

			return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
		}
	}

	public static void main(String[] args) {
		System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
		System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
		System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));

	}
}
