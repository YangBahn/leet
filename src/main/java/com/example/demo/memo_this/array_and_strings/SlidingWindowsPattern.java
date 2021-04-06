package com.example.demo.memo_this.array_and_strings;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowsPattern {

	static class MaxFruitCountOf2Types {

		// put fruits into two baskets with max count in each basket.  Only one type of fruit per basket, can't skip fruit after start
		/*
		Create fruit freq map - Char, Int
		for each fruit, add count to the freq map.
			repeat while fruit type in the map is greater than numberOfBaskets.
				- update the startFruit count from map, remove if 0

			update maxFruitCOunt - end - start + 1
		return maxFruitCount(length)
		 */
		static int findLength(char[] fruits) {
			int winStart = 0;
			int maxLength = 0;
			Map<Character, Integer> fruitFreqMap = new HashMap<>();
			// try to extend the range [windowStart, windowEnd]
			for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
				addFruitCount(fruitFreqMap, fruits[windowEnd]);

				// shrink the sliding window, until we are left with '2' fruits in the frequency map
				int numberOfBaskets = 2;
				while (fruitFreqMap.size() > numberOfBaskets) {
					char winStartFruit = fruits[winStart];
					subtractWinStartCount(fruitFreqMap, winStartFruit);
					winStart++; // shrink the window
				}
				maxLength = Math.max(maxLength, windowEnd - winStart + 1);
			}

			return maxLength;
		}

		private static void subtractWinStartCount(Map<Character, Integer> fruitFreqMap, char winStartFruit) {
			int winStartFruitCount = fruitFreqMap.get(winStartFruit) - 1;
			fruitFreqMap.put(winStartFruit, winStartFruitCount);

			if (winStartFruitCount == 0) {
				fruitFreqMap.remove(winStartFruit);
			}
		}

		private static void addFruitCount(Map<Character, Integer> fruitFrequencyMap, char winEndFruit) {
			int fruitCount = fruitFrequencyMap.getOrDefault(winEndFruit, 0) + 1;
			fruitFrequencyMap.put(winEndFruit, fruitCount);
		}
	}


	static class StringPermutation {

		// find out whether str contains any permutation of given pattern
		/*
		Map each char frequency count of Pattern
		Loop, for each char in str, using start and end pointers as a sliding window, look for match in Map

				case 1: Match Found
					Reduce the char freq count in Map.
					If freq count is 0, increase matched count,

				case 2: All Match, all chars matched against Pattern (match count is equal to freq map key counts)
					return true;

				case 3: None Match, all chars in Pattern checked without finding any match:
					move left (start) index and backtrack changes made to map and matched count
						increase char count in map if last left char matched in map
							decrease Match count if the last match resulted char count becoming 0


		return false if match was not found till this point
		*/

		static boolean findPermutation(String str, String pattern) {
			int windowStart = 0;
			int matched = 0;


			Map<Character, Integer> patternCharFrequencyMap = mapCharFrequencyCount(pattern);

			// our goal is to match all the characters from the 'charFrequencyMap' with the current window
			// try to extend the range [windowStart, windowEnd]
			for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
				char strRightChar = str.charAt(windowEnd);

				matched = update_frequency_map_if_match_found(strRightChar, patternCharFrequencyMap, matched);

				boolean all_char_in_pattern_matched = matched == patternCharFrequencyMap.size();
				if (all_char_in_pattern_matched) {
					return true;
				} else {
					// shrink the window by one character & update map
					boolean all_chars_in_pattern_used = windowEnd >= pattern.length() - 1;
					if (all_chars_in_pattern_used) {
						char leftChar = str.charAt(windowStart++);
						matched = update_frequency_map_and_match_count(leftChar, patternCharFrequencyMap, matched);
					}
				}
			}

			return false;
		}

		private static int update_frequency_map_and_match_count(char leftChar, Map<Character, Integer> patternCharFrequencyMap, int matched) {

			if (patternCharFrequencyMap.containsKey(leftChar)) {
				if (patternCharFrequencyMap.get(leftChar) == 0)
					matched--; // before putting the character back, decrement the matched count
				// put the character back for matching
				patternCharFrequencyMap.put(leftChar, patternCharFrequencyMap.get(leftChar) + 1);
			}
			return matched;
		}

		private static int update_frequency_map_if_match_found(char strRightChar, Map<Character, Integer> patternCharFrequencyMap, int matchCount) {

			if (patternCharFrequencyMap.containsKey(strRightChar)) {
				// decrement the frequency of the matched character
				patternCharFrequencyMap.put(strRightChar, patternCharFrequencyMap.get(strRightChar) - 1);

				if (patternCharFrequencyMap.get(strRightChar) == 0) // character is completely matched
					matchCount++;

			}

			return matchCount;
		}

		private static Map<Character, Integer> mapCharFrequencyCount(String pattern) {
			Map<Character, Integer> charFrequencyMap = new HashMap<>();
			for (char chr : pattern.toCharArray())
				charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
			return charFrequencyMap;
		}

		public static void main(String[] args) {
			System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
			System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
			System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
			System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
		}
	}

}

