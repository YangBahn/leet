package com.example.demo.memo_this.array_and_strings;


import java.util.ArrayList;
import java.util.List;

public class SubStrings {


// Given a string, find all of its permutations preserving the character sequence but changing case.

	static class LetterCaseStringPermutation {
		static List<String> findLetterCaseStringPermutations(String str) {
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
	}

	//Given an expression containing digits and operations (+, -, *),
// find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
	static class EvaluateExpression {
		static List<Integer> diffWaysToEvaluateExpression(String input) {
			List<Integer> result = new ArrayList<>();
			// base case: if the input string is a number, parse and add it to output.
			if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
				result.add(Integer.parseInt(input));
			} else {
				for (int i = 0; i < input.length(); i++) {
					char chr = input.charAt(i);
					if (!Character.isDigit(chr)) {
						// break the equation here into two parts and make recursively calls
						List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
						List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
						for (int part1 : leftParts) {
							for (int part2 : rightParts) {
								if (chr == '+')
									result.add(part1 + part2);
								else if (chr == '-')
									result.add(part1 - part2);
								else if (chr == '*')
									result.add(part1 * part2);
							}
						}
					}
				}
			}
			return result;
		}
	}

	private void evaluateExpressionRun() {
		List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
		System.out.println("Expression evaluations: " + result);

		result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
		System.out.println("Expression evaluations: " + result);
	}

	public static void main(String[] args) {

	}
}
