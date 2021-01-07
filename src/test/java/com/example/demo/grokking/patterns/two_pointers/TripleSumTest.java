package com.example.demo.grokking.patterns.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TripleSumTest {
	@Test
	void searchTriplets() {
		int[] arr = new int[]{-5, 2, -1, -2, 3};
		List<List<Integer>> trips = Triplets.searchTriplets(arr);
//		[[-5, 2, 3], [-2, -1, 3]]
		Arrays.asList(-5, 3, 2);
		Arrays.asList(-2, -1, 3);
//		assertTrue(trips.get(0).containsAll(Arrays.asList(-5, 3, 2)));
//		assertTrue(trips.get(1).containsAll(Arrays.asList(-2, -1, 3)));
	}

	@Test
	void searchTriplets_2() {
		int[] arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
//		List<List<Integer>> trips = TwoPointers.searchTriplets(arr);
		int val = -arr[2];
		System.out.println(val);
	}


	@Test
	void searchTriplets_alt_1() {
		int[] arr = new int[]{-2, 0, 1, 2};
		int target = 2;
		int sum = Triplets.TripletSumCloseToTarget.search_alt(arr, target);
		assertEquals(1, sum);
	}

	@Test
	void searchTriplets_alt_2() {
		int[] arr = new int[]{-3, -1, 1, 2};
		int target = 1;
		int sum = Triplets.TripletSumCloseToTarget.search_alt(arr, target);
		assertEquals(0, sum);
	}

	@Test
	void searchTriplets_alt_3() {
		int[] arr = new int[]{1, 0, 1, 1};
		int target = 100;
		int sum = Triplets.TripletSumCloseToTarget.search_alt(arr, target);
		assertEquals(3, sum);
	}

	@Test
	void tripletWithSmallerSum() {
		int[] arr = new int[]{-1, 0, 2, 3};
		int target = 3;

		int count = Triplets.TripletWithSmallerSum.searchTriplets(arr, target);
		assertEquals(2, count);
	}

	@Test
	void tripletWithSmallerSum_2() {
		int[] arr = new int[]{-1, 4, 2, 1, 3};
		int target = 5;

		int count = Triplets.TripletWithSmallerSum.searchTriplets(arr, target);
		assertEquals(4, count);
	}
}