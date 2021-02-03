package com.example.demo.memo_this.array_and_strings.excercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Divide into two processes
	One- to loop each number in the array
	two- to find two numbers whose sum matchs the base number

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
			skip left and right values if their prevous value is same as cur

*/

// find three numbers that sums up to zero
public class TripletSumToZero {

	private static List<List<Integer>> searchTriplets(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			// add filter for same val
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}

			searchPair(arr, -arr[i], i + 1, triplets);
		}

		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
		int right = arr.length - 1;
		while (left < right) {
			int leftVal = arr[left];
			int rightVal = arr[right];
			int sum = leftVal + rightVal;
			if (sum < targetSum) {
				left++;
			} else if (sum > targetSum) {
				right--;
			} else {
				triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left += 1;
				right -= 1;
				while (arr[left] == arr[left - 1]) {
					left++;
				}
				while (arr[right] == arr[right + 1]) {
					right--;
				}
			}

		}

	}


	public static void main(String[] arg) {
		int[] input = new int[]{-3, 0, 1, 2, -1, 1, -2};
		// -3 -2 -1 0 1 0 1 2
		List<List<Integer>> tripsToZero = searchTriplets(input);
		System.out.println(tripsToZero);
	}
}
