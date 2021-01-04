package com.example.demo.grokking.patterns.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoRepeatSubStringTest {

	@Test
	void findLength(){
		String str = "aabccbb";
		int maxLen = NoRepeatSubString.findLength(str);
		assertEquals(3, maxLen);
	}


	@Test
	void findLength2(){
		String str = "abccde";
		int maxLen = NoRepeatSubString.findLength(str);
		assertEquals(3, maxLen);
	}
}