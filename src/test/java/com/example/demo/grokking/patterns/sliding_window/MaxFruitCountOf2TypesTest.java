package com.example.demo.grokking.patterns.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxFruitCountOf2TypesTest {

	@Test
	void findLengthInTwoBaskets() {
		char[] arr = new char[]{'A', 'B', 'C', 'A', 'C'};
		MaxFruitCountOf2Types types = new MaxFruitCountOf2Types(arr);
		int count = types.findLengthInTwoBaskets();
		assertEquals(3, count);
	}

	@Test
	void findLengthInTwoBaskets2() {
		char[] arr = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};
		MaxFruitCountOf2Types types = new MaxFruitCountOf2Types(arr);
		int count = types.findLengthInTwoBaskets();
		assertEquals(5, count);
	}
}