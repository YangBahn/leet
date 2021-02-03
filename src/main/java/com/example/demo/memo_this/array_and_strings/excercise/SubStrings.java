package com.example.demo.memo_this.array_and_strings.excercise;


import java.util.ArrayList;
import java.util.List;

public class SubStrings {


// Given a string, find all of its permutations preserving the character sequence but changing case.

	static class LetterCaseStringPermutation {
		static List<String> findLetterCaseStringPermutations(String str) {
			List<String> permutations = new ArrayList<>();

			return permutations;
		}
	}

	//Given an expression containing digits and operations (+, -, *),
// find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
	static class EvaluateExpression {
		static List<Integer> diffWaysToEvaluateExpression(String input) {
			List<Integer> result = new ArrayList<>();

			return result;
		}
	}

	// todo skipp for now
	private void evaluateExpressionRun() {
		List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
		System.out.println("Expression evaluations: " + result);

		result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
		System.out.println("Expression evaluations: " + result);
	}

	public static void main(String[] args) {

	}
}
