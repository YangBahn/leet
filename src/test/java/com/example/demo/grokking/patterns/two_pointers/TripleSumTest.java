package com.example.demo.grokking.patterns.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TripleSumTest {
	@Test
	void searchTriplets(){
		int[] arr = new int[]{-5, 2, -1, -2, 3};
		List<List<Integer>> trips = Triplets.searchTriplets(arr);
//		[[-5, 2, 3], [-2, -1, 3]]
		Arrays.asList(-5,3,2);
		Arrays.asList(-2,-1,3);
		assertTrue(trips.get(0).containsAll(Arrays.asList(-5,3,2)));
		assertTrue(trips.get(1).containsAll(Arrays.asList(-2,-1,3)));
	}

	@Test
	void searchTriplets_2(){
		int[] arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
//		List<List<Integer>> trips = TwoPointers.searchTriplets(arr);
		int val = -arr[2];
		System.out.println(val);
	}
}