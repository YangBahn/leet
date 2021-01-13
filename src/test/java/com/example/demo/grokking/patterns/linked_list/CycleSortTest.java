package com.example.demo.grokking.patterns.linked_list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class CycleSortTest {

	@Test
	void sort() {
		int[] nums = new int[]{3, 1, 5, 4, 2};
		CycleSort.sort(nums);
		for (int n : nums) {
			System.out.print(n + ", ");
		}
		assertTrue(Arrays.equals(nums, new int[]{1, 2, 3, 4, 5}));
	}

	@Test
	void findMissingNumber() {
		int[] nums = new int[]{8, 3, 5, 2, 4, 6, 0, 1};
		int missing = CycleSort.findMissingNumber(nums);
		assertEquals(7, missing);
	}

	@Test
	void findAllMissingNumbers() {
		int[] nums = new int[]{2, 3, 5, 1, 1};
		List<Integer> missing = CycleSort.findAllMissingNumbers(nums);
		assertEquals(1, missing.size());
		assertEquals(4, missing.get(0));
	}

	@Test
	void findDupNumber() {
		int[] nums = new int[]{1, 4, 4, 3, 2};
		int duplicateNumber = CycleSort.findDuplicateNumber(nums);
		assertEquals(4, duplicateNumber);
	}

	@Test
	void findAllDuplicateNumbers() {
		int[] nums = new int[]{1, 4, 4, 3, 2, 2, 5};
		List<Integer> dupNums = CycleSort.findAllDuplicateNumbers(nums);
		assertEquals(2, dupNums.size());
		assertEquals(4 , dupNums.get(0));
		assertEquals(2 , dupNums.get(1));
	}
}