package com.example.demo.hacker_rank;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class SherlockAndAnagrams {

	public static void main(String[] args) {
		String s = "ifailuhkqq";

		sherlockAndAnagrams(s);
	}

/*
ifailuhkqq ->  (i,i) (q,q) (i,f,a) (f,a,i)
abba -> (a) (b) (ab) (ba)

Create freq map for the each char
Grab the range in between chars
	first one is Left and second is right
	after adding anagrams between the range,

	move left to the second char if there is third,
	if not, move on to the next range
*/


	static int sherlockAndAnagrams(String s) {
		HashMap<String, Integer> freqMap = new HashMap<>();

		for (int left = 0; left < s.length(); left++) {

			for (int right = left; right < s.length(); right++) {
				char[] valC = s.substring(left, right + 1).toCharArray();
				Arrays.sort(valC);
				String subString = new String(valC);
				freqMap.put(subString, freqMap.getOrDefault(subString, 0) + 1);
			}
		}

		int anagramPairCount = 0;
		for (String key : freqMap.keySet()) {
			int count = freqMap.get(key);
			if (count > 1)
				System.out.println(key + " : " + count);
			anagramPairCount += (count * (count - 1)) / 2;
		}
		System.out.println(anagramPairCount);
		return anagramPairCount;
	}

	static void printStringLists(List<List<String>> list) {

		list.forEach(lst -> {
			list.forEach(System.out::print);
			System.out.println();
		});
	}

}
