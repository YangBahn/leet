package com.example.demo.grokking.patterns.subsets;

import java.util.*;

class LetterCaseStringPermutation {

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		if (str == null)
			return permutations;

		permutations.add(str);
		// process every character of the string one by one
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) { // only process characters, skip digits
				// we will take all existing permutations and change the letter case appropriately
				int n = permutations.size();
				for (int j = 0; j < n; j++) {
					char[] chs = permutations.get(j).toCharArray();
					// if the current character is in upper case change it to lower case or vice versa
					if (Character.isUpperCase(chs[i]))
						chs[i] = Character.toLowerCase(chs[i]);
					else
						chs[i] = Character.toUpperCase(chs[i]);
					permutations.add(String.valueOf(chs));
				}
			}
		}
		return permutations;
	}

	private static List<List<Character>> createCaps(List<Character> chars, int curCharPointer) {
		List<List<Character>> converts = new ArrayList<>();

		chars.add(curCharPointer, Character.toUpperCase(chars.get(curCharPointer)));
		for (int i = 0; i < chars.size(); i++) {
			List<Character> copy = new ArrayList<>(chars);
			copy.add(i, Character.toUpperCase(copy.get(i)));
			converts.add(copy);
		}

		return converts;
	}

	/*
	private static List<List<Integer>> createSubsets(List<Integer> subset, int num) {
		List<List<Integer>> newSubsets = new ArrayList<>();
		for (int i = 0; i <= subset.size(); i++) {
			List<Integer> copy = new ArrayList<>(subset);
			copy.add(i, num);
			newSubsets.add(copy);
		}

		return newSubsets;
	}
*/

	public static void main(String[] args) {

		List<Character> chars = new ArrayList<>();
		chars.add('a');
		chars.add('b');
		chars.add('c');
		List<String> result = LetterCaseStringPermutation.createCaps(chars, 1));
//		List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

//		result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
//		System.out.println(" String permutations are: " + result);
	}
}
