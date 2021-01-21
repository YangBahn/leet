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
			Character curChar = str.charAt(i);

			// only process characters, skip digits
			if (Character.isLetter(curChar)) {
				// we will take all existing permutations and change the letter case appropriately
				int existingPermSize = permutations.size();
				for (int permutIdx = 0; permutIdx < existingPermSize; permutIdx++) {
					String copy = permutations.get(permutIdx);
					char curCharMatch = copy.charAt(i);
					// if the current character is in upper case change it to lower case or vice versa
					if (Character.isUpperCase(curCharMatch)) {
						copy = copy.replace(curCharMatch, Character.toLowerCase(curCharMatch));
					} else {
						copy = copy.replace(curCharMatch, Character.toUpperCase(curCharMatch));

					}
					permutations.add(copy);
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


		List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}
}
