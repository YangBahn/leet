package com.example.demo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GeneralizedAbbreviation {

	class AbbreviatedWord {
		StringBuilder str;
		int start;
		int count;

		public AbbreviatedWord(StringBuilder str, int start, int count) {
			this.str = str;
			this.start = start;
			this.count = count;
		}
	}

	public static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();


		return result;
	}
	
	public static void main(String[] args) {
		List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
		System.out.println("Generalized abbreviation are: " + result);

//		result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
//		System.out.println("Generalized abbreviation are: " + result);
	}
}