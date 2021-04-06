package com.example.demo.memo_this.array_and_strings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Divide into two processes
	One- to loop each number in the array
	two- to find other duplets to match the looped number

(Sort Array first)
 1. Process One (main)
  Loops each value in array and feed to Process Two:
 	BaseVal - this is the target number to match by adding up two other values.
 	Left Index - this is the 'small' side of the values
 	Right Index - this is the 'large' side of the values
 	Array - given array
 	triplets list - collection of triplets found after each run of Process Two

 2.	Process Two (helper)
 	It tries to find a pair of left and right values that matches the BaseVal(target) by:
 	Iterate while left index(small) is smaller than right index (lrg):
 	On each iteration, it sums leftVal/rightVal and compare to BaseVal.
 	Based on the comparision it either:
 		a. increases left index
 			when sum is smaller than BaseVal(target). This increases left/right sum value.
 		b. decreases right index
 			when sum is bigger thant the BaseVal. This decreases left/right sum value.
 		c. adds the found triplet ( base, leftVal, rightVal ) and increase both left index and decrease right index
			when sum matches the target. Both left and right idx updates to move onto next find

*/
public class TripletSumToZero {

	private static List<List<Integer>> searchTriplets(int[] arr) {

		Arrays.sort(arr);
		List<List<Integer>> triplets = new ArrayList<>();
		int numberOfBaseValueToLoop = arr.length - 3;

		for (int baseValue = 0; baseValue <= numberOfBaseValueToLoop; baseValue++) {

			if (baseValue > 0) {
				boolean isDuplicateValue = arr[baseValue] == arr[baseValue - 1];
				if (isDuplicateValue) {
					continue;
				}
			}

			searchPair(arr, -arr[baseValue], baseValue + 1, triplets);
		}

		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {

		int right = arr.length - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == targetSum) {
				triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left++;
				right--;

				while (arr[left] == arr[left - 1]) {
					left++;
				}

				while (arr[right] == arr[right + 1]) {
					right--;
				}

			} else if (sum < targetSum) {
				left++;
			} else {
				right--;
			}
		}

	}


	public static void main(String[] arg) {
		int[] input = new int[]{-3, 0, 1, 2, -1, 1, -2};
		List<List<Integer>> tripsToZero = searchTriplets(input);
		System.out.println(tripsToZero);
	}
}
