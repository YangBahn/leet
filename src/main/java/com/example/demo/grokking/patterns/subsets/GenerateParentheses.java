package com.example.demo.grokking.patterns.subsets;


import com.example.demo.memo_this.common.ParenthesesString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/* Problem: given N number of paranth pair, generate all possible permutations of the paranth couples*/
class GenerateParentheses {
//	static class ParenthesesString {
//		String str;
//		int openCount; // open parentheses count
//		int closeCount; // close parentheses count
//
//		public ParenthesesString(String s, int openCount, int closeCount) {
//			str = s;
//			this.openCount = openCount;
//			this.closeCount = closeCount;
//		}
//	}


	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<String>();
		Queue<ParenthesesString> queue = new LinkedList<>();
		queue.add(new ParenthesesString("", 0, 0));

		while (!queue.isEmpty()) {
			ParenthesesString curPs = queue.poll();
			// if we've reached the maximum number of open and close parentheses, add to the result
			if (curPs.openCount >= num && curPs.openCount == curPs.closeCount) {
				result.add(curPs.str);
			} else {
				if (curPs.openCount < num) {
					// if we can add an open parentheses, add it
					queue.add(new ParenthesesString(curPs.str += "(", curPs.openCount += 1, curPs.closeCount));
				}

				// if we can add a close parentheses, add it
				if (curPs.openCount > curPs.closeCount) {
					curPs.str += ")";
					curPs.closeCount += 1;
					queue.add(new ParenthesesString(curPs.str += ")", curPs.openCount, curPs.closeCount += 1));
				}

				queue.add(curPs);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> result = GenerateParentheses.generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = GenerateParentheses.generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

}