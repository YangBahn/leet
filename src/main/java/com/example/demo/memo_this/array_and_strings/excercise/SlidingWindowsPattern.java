package com.example.demo.memo_this.array_and_strings.excercise;

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

			int maxLength = 0;

			return maxLength;
		}

		private static void subtractWinStartCount(Map<Character, Integer> fruitFreqMap, char winStartFruit) {

		}

		private static void addFruitCount(Map<Character, Integer> fruitFrequencyMap, char winEndFruit) {

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

			return false;
		}

		private static int update_frequency_map_and_match_count(char leftChar, Map<Character, Integer> patternCharFrequencyMap, int matched) {

			return matched;
		}

		private static int update_frequency_map_if_match_found(char strRightChar, Map<Character, Integer> patternCharFrequencyMap, int matchCount) {


			return matchCount;
		}

		private static Map<Character, Integer> mapCharFrequencyCount(String pattern) {
			Map<Character, Integer> charFrequencyMap = new HashMap<>();
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

