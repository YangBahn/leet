package com.example.demo.hacker_rank;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

public class HashTables {

	// todo
	public static void main(String[] args) {
//		List<Long> arr = Arrays.asList(1L, 3L, 4L, 6L, 8L, 9L, 12L, 14L, 16L, 20L, 64L, 50L);
//		List<Long> arr = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
//		long result = CountTriplets.countTriplets(arr, 3);
//		System.out.println(result);
	}

	/*
	In a given an array,find occurances of possible tripets of indices in geometric progression for a given common ratio .

	 - For each el, find duplets that makes geometric triplets
	 sort array
	 For each element [i],
	 	set base, [base+1] as left and [len - 1] as right
	 		while left < right
	 			find left ->  base*r  = [left]
	 			try right against base, left
	 			if matched
	 				count++
	 				left++, right--
	 			if right > left*2
	 				right --
	 			if left*2 > right
	 				left++
	 		move on the next base

	*/
	@UtilityClass
	private class CountTriplets {

		// given sorted list
		private static long countTriplets(int[] arr, int len, int ratio) {
			Map<Integer, Integer> leftMap = new HashMap<>();
			Map<Integer, Integer> rightMap = new HashMap<>();

			long count = 0;
			for (int i = 0; i < len; i++)
				rightMap.put(arr[i], rightMap.getOrDefault(arr[i], 0) + 1);


			for (int i = 0; i < len; i++) {
				int curVal = arr[i];

				long leftCount = 0;
				long rightCount = 0;

				if (curVal % ratio == 0)
					leftCount = leftMap.getOrDefault(curVal / ratio, 0);

				rightMap.put(curVal, rightMap.getOrDefault(curVal, 0) - 1);
				rightCount = rightMap.getOrDefault(curVal * ratio, 0);


				count += leftCount * rightCount;
				leftMap.put(curVal, leftMap.getOrDefault(curVal, 0) + 1);
			}

			return count;
		}


	}


	@UtilityClass
	private class SubString {
		/*
		Create a list of str1,
		loop str2, if any contain true, true
		*/
		private String hasCommonSub(String str1, String str2) {

			Map<Character, Integer> map = new HashMap<>();

			for (char c : str1.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			for (char c : str2.toCharArray()) {
				if (map.containsKey(c)) {
					return "Yes";
				}
			}

			return "No";
		}
	}


	@UtilityClass
	class RansomeNote {
		/* Check if all string in 'note' exists in 'mag', case senstive, count matters
			Create a freq map of each string from note
			while looping mag, check if freqMap has the key and update the count ( remove if 0)
			if false at any point, return false
		*/
		static boolean checkMagazine(String[] magazine, String[] note) {
			Map<String, Integer> freqMap = new HashMap();
			for (String word : magazine) {
				freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
			}
			for (String w : note) {
				if (!freqMap.containsKey(w)) {
					return false;
				}

				freqMap.put(w, freqMap.get(w) - 1);
				if (freqMap.get(w) == 0) {
					freqMap.remove(w);
				}
			}
			return true;
		}
	}


}
