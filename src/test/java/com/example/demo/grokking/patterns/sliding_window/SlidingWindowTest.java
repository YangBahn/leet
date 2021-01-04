package com.example.demo.grokking.patterns.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWindowTest {

	@Test
	public void findMaxSumSubArray() {
		int k = 3;
		int[] arr = new int[]{2, 1, 1, 3};
		int largestSum = SlidingWindow.findMaxSumSubArray(k, arr);
		assertEquals(5, largestSum);


		arr = new int[]{4, 3, 1, 4, 2, 1, 2};
		k = 4;
		largestSum = SlidingWindow.findMaxSumSubArray(k, arr);
		assertEquals(12, largestSum);
	}

	@Test
	public void findLength() {
		String str = "arrci";
		int k = 2;

		int count = SlidingWindow.findLength(str, k);
		assertEquals(3, count);


		str = "araaci";
		k = 1;
		int count2 = SlidingWindow.findLength(str, k);
		assertEquals(2, count2);

		str = "cbbebi";
		k = 3;
		int count3 = SlidingWindow.findLength(str, k);
		assertEquals(5, count3);

	}

}