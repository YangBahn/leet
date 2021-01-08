package com.example.demo.grokking.patterns.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SubarraysTest {
	@Test
	public void findSubArraysSmallerThanTarget_1() {
		int[] arr = new int[]{2, 5, 3, 10};
		int target = 30;
		List<List<Integer>> arrays = Subarrays.findSubArrays(arr, target);
		assertEquals(6, arrays.size());

	}

	@Test
	public void findSubArraysSmallerThanTarget_2() {
		int[] arr = new int[]{8, 2, 6, 5};
		int target = 50;
		List<List<Integer>> smallerArrs = Subarrays.findSubArrays(arr, target);
		assertEquals(7, smallerArrs.size());

		assertTrue(Arrays.asList(2).equals(smallerArrs.get(0)));
	}
}