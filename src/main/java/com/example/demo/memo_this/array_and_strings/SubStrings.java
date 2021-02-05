package com.example.demo.memo_this.array_and_strings;


import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubStrings {

	public static void main(String[] args) {
		List<String> combos = PhoneNumber.letterCombinations(new int[]{2,3});
		System.out.println(combos);
	}

	// Given a string containing digits from 2-9 inclusive,
	// return all possible letter combinations that the number could represent. Return the answer in any order.
	@UtilityClass
	class PhoneNumber {
		private static final String[] table = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		private List<String> letterCombinations(int[] number) {

			List<String> result = new ArrayList<>();
			Queue<String> comboQueue = new LinkedList<>();
			comboQueue.add("");

			// each combo length should match size of numbers provided
			while (!comboQueue.isEmpty()) {
				String curCombo = comboQueue.poll();

				if (curCombo.length() == number.length)
					result.add(curCombo);

				else {

					int tableIdx = number[curCombo.length()];
					String val = table[tableIdx];
					for (int i = 0; i < val.length(); i++) {
						comboQueue.add(curCombo + val.charAt(i));
					}
				}
			}

			return result;
		}


	}


	// Given a string, find all of its permutations preserving the character sequence but changing case. Skip Numbers.
	/* Store perms and create exponetinally from the created perm
	Declare Permutations to store found perms
	(i)Loop for the length of str
		if the currentChar is letter
			(j)Loop for size of  the existing permList
				make duplicate of existing perm,
				modify the lettercase of char matching currentChar(i)
				add it back to the permList

	*/
	@UtilityClass
	class LetterCaseStringPermutation {
		List<String> findLetterCaseStringPermutations(String str) {
			List<String> permutations = new ArrayList<>();
			if (str == null)
				return permutations;
			permutations.add(str);

			for (int i = 0; i < str.length(); i++) {
				if (Character.isLetter(str.charAt(i))) {
					// we will take all existing permutations and change the letter case appropriately
					final int existingPermSize = permutations.size();


					for (int j = 0; j < existingPermSize; j++) {
						char[] permChars = permutations.get(j).toCharArray();

						if (Character.isUpperCase(permChars[i]))
							permChars[i] = Character.toLowerCase(permChars[i]);
						else
							permChars[i] = Character.toUpperCase(permChars[i]);

						permutations.add(String.valueOf(permChars));
					}
				}
			}
			return permutations;
		}

	}
	//Given an expression containing digits and operations (+, -, *),

	// todo HARD, skipped
	// find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
	@UtilityClass
	class EvaluateExpression {

		private List<Integer> diffWaysToEvaluateExpression(String input) {
			List<Integer> output = new ArrayList<>();
			boolean isNumber = !input.contains("+") && !input.contains("-") && !input.contains("*");
			if (isNumber) {
				output.add(Integer.parseInt(input));
			} else {
				operateNumbers(input, output);
			}

			return output;
		}

		private void operateNumbers(String input, List<Integer> result) {
			for (int baseIdx = 0; baseIdx < input.length(); baseIdx++) {
				boolean isOperator = !Character.isDigit(input.charAt(baseIdx));
				if (isOperator) {
					processParts(baseIdx, input, result);
				}
			}
		}

		private void processParts(int midIdx, String input, List<Integer> result) {
			char curChar = input.charAt(midIdx);
			// break the equation here into two parts and make recursively calls
			List<Integer> leftParts = EvaluateExpression.diffWaysToEvaluateExpression(input.substring(0, midIdx));
			List<Integer> rightParts = EvaluateExpression.diffWaysToEvaluateExpression(input.substring(midIdx + 1));
			for (int part1 : leftParts) {
				for (int part2 : rightParts) {
					if (curChar == '+')
						result.add(part1 + part2);
					else if (curChar == '-')
						result.add(part1 - part2);
					else if (curChar == '*')
						result.add(part1 * part2);
				}
			}
		}

		private static void evaluateExpressionRun() {
			List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
			System.out.println("Expression evaluations: " + result);

			result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
			System.out.println("Expression evaluations: " + result);
		}


	}

}
