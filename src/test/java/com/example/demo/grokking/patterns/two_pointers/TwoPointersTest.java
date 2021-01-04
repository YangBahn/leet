package com.example.demo.grokking.patterns.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPointersTest {
	@Test
	void search() {
		int[] arr = new int[]{1, 2, 3, 4, 8};
		int target = 6;
		int[] vals = TwoPointers.searchTargetSum(arr, target);

		assertTrue(Arrays.equals(new int[]{1, 3}, vals));
	}

	@Test
	void search2() {
		int[] arr = new int[]{2, 5, 9, 11};
		int target = 11;
		int[] vals = TwoPointers.searchTargetSum(arr, target);

		assertTrue(Arrays.equals(new int[]{0, 2}, vals));
	}

	@Test
	void removeDupes() {
		int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
		int count = TwoPointers.removeDupes(arr);
		assertEquals(4, count);
	}

	@Test
	void removeDupes_2() {
		int[] arr = new int[]{2, 2, 2, 11};
		int count = TwoPointers.removeDupes(arr);
		assertEquals(2, count);
	}

	@Test
	void squareSortedArrays() {
		int[] arr = new int[]{-2, -1, 0, 2, 3};
		int[] squared = TwoPointers.squareSortedArrays(arr);
		assertTrue(Arrays.equals(new int[]{0, 1, 4, 4, 9}, squared));

	}

	@Test
	void squareSortedArrays_2() {
		int[] arr = new int[]{-9, -5, -4, -3, -2, -1, 0, 2, 2, 3};
		int[] squared = TwoPointers.squareSortedArrays(arr);
//		assertTrue(Arrays.equals(new int[]{0, 1, 1, 4, 4, 9, 9}, squared));
	}

	@Test
	void squareSortedArrays_3() {
		int[] arr = new int[]{-3, -1, 0, 1, 2};
		int[] squared = TwoPointers.squareSortedArrays(arr);
//		assertTrue(Arrays.equals(new int[]{0, 1, 1, 4, 9}, squared));
	}


}