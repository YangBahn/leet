package com.example.demo.hacker_rank;

import java.util.HashMap;
import java.util.Map;

class StringManipulation {

	public static void main(String[] args) {
		int result = AlternatingCharacters.alternatingCharacters("AABAAB");
		System.out.println(result);
	}

	private static class AlternatingCharacters {

		// given string, find out how many chars need to be removed to not have adjcent repeats
		/*
		loop each char while storing last,
			 if cur is same then increase count

		 */
		private static int alternatingCharacters(String s) {
			int count = 0;
			char last = 0;
			for (char c : s.toCharArray()) {
				if (c == last) count++;
				last = c;
			}
			return count;
		}

	}

	private static class MakingAnagrams {
		// find out how many letters need to be deleted to make string a,b anagrams
		// eg. cde, abc -> 4 ( only c)
		/*
		map the freq of both strings for map1
		While looping string b,
			Count the number of matching strings
		return a.len - matching# +  b.len - matching#
		*/
		private static int makeAnagram(String a, String b) {
			int matchedCharCount = getMatchedCount(a, b);
			return a.length() - matchedCharCount + (b.length() - matchedCharCount);
		}

		private static int getMatchedCount(String a, String b) {
			int count = 0;
			Map<Character, Integer> mapA = new HashMap<>();
			for (char c : a.toCharArray())
				mapA.put(c, mapA.getOrDefault(c, 0) + 1);

			for (char bChar : b.toCharArray()) {
				if (mapA.containsKey(bChar)) {
					count++;
					mapA.put(bChar, mapA.get(bChar) - 1);
					if (mapA.get(bChar) == 0) {
						mapA.remove(bChar);
					}
				}
			}

			return count;
		}

	}

}
