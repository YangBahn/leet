package com.example.demo.hacker_rank;

import java.util.*;

class StringManipulation {

	public static void main(String[] args) {

		long count = CommonChild.commonChild("ABCDEF", "FBDAMN");
		System.out.println(count);

		String str1 = "SHINCHAN";
		String str2 = "NOHARAAA";
		count = CommonChild.commonChild(str1, str2);
		System.out.println(count);

	}

// todo
	private static class CommonChild {
		//		get max length of a child string possible from the given two strings : sally,harry -> 2 ( ay)
		static int commonChild(String s1, String s2) {
			int s1Len = s1.length();
			int s2Len = s2.length();
			char[] s1Arr = s1.toCharArray();
			char[] s2Arr = s2.toCharArray();

			int[][] table = new int[s1Len + 1][s2Len + 1];

			int result = 0;

			for (int i = 0; i <= s1Len; i++) {
				for (int j = 0; j <= s2Len; j++) {

					if (i == 0 || j == 0) {
						table[i][j] = 0;

					} else if (s1Arr[i - 1] == s2Arr[j - 1]) {
						table[i][j] = table[i - 1][j - 1] + 1;
						result = Integer.max(result, table[i][j]);

					} else {

						table[i][j] = 0;
					}


				}
			}
			return result;
		}



	}

	// todo
	private static class SpecialStringAgain {

		static long substrCount(int n, String s) {


			return 1;
		}


		// find number of subsets possible in a given string
		static long countAllPalindromsInSubSets(String s) {

			List<String> subs = findAllSubStrings(s);
			return countPalidroms(subs);
		}

		private static int countPalidroms(List<String> strings) {
			int count = 0;

			for (String str : strings) {
				if (str.length() == 1) {
					System.out.println(str);

					count++;
				} else if (str.length() > 1) {
					int front = 0;
					int back = str.length() - 1;

					boolean isPal = true;
					while (front < back && isPal) {
						if (str.charAt(front) != str.charAt(back)) {
							isPal = false;
						}
						front++;
						back--;
					}

					if (isPal) {
						System.out.println(str);
						count++;
					}
				}
			}


			return count;
		}

		private static List<String> findAllSubStrings(String s) {
			List<String> subStrings = new ArrayList<>();

			for (int i = 0; i < s.length(); i++) {
				char curChar = s.charAt(i);
				String sub = String.valueOf(curChar);
				subStrings.add(sub);
				for (int j = i + 1; j < s.length(); j++) {
					sub = sub.concat(String.valueOf(s.charAt(j)));
					subStrings.add(sub);
				}
			}

			return subStrings;
		}
	}

	/* Given a string, check if each char has same frequences. One char can be removed. IF yes, return YES or NO*/
	private static class SherlockAndValidString {

		/*
		Make a freq Map, get the least repeat char, see if the rest match the count or will if only one is removed
		check against min then max for diff counts
		*/
		static String isValid(String s) {
			Map<Character, Integer> freqMap = new HashMap<>();
			for (char c : s.toCharArray())
				freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);


			Map.Entry<Character, Integer> minEntry = freqMap.entrySet().stream()
					.min(Comparator.comparingInt(Map.Entry::getValue)).get();

			int minOccurCOunt = freqMap.values().stream().filter(integer -> integer.equals(minEntry.getValue())).mapToInt(integer -> integer).sum();

			Map.Entry<Character, Integer> maxEntry = freqMap.entrySet().stream()
					.max(Comparator.comparingInt(Map.Entry::getValue)).get();
			int maxOccurCount = freqMap.values().stream().filter(integer -> integer.equals(maxEntry.getValue())).mapToInt(integer -> integer).sum();

			int minDiff = 0;
			int maxDiff = 0;
			for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {

				minDiff += entry.getValue() - minEntry.getValue();
				maxDiff += maxEntry.getValue() - entry.getValue();
			}

			if (maxOccurCount == 1) minDiff -= 1;
			if (minOccurCOunt == 1) maxDiff -= 1;

			if ((maxDiff < 2 || minDiff < 2)) {
				return "YES";
			}

			return "NO";
		}

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
