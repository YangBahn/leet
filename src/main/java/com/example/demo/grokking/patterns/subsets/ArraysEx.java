package com.example.demo.grokking.patterns.subsets;

import java.util.Arrays;
import java.util.List;

public class ArraysEx {
	public static int[] findSum(int[] arr, int n) {
		int[] result = new int[2];
		Arrays.sort(arr);
		int sml = 0;
		int lrg = arr.length - 1;

		while (sml < lrg) {

			if (n - arr[sml] == arr[lrg]) {
				result = new int[]{arr[sml], arr[lrg]};
				break;
			}

			if (n - arr[sml] < arr[lrg]) {
				lrg--;

			}
			if (n - arr[sml] > arr[lrg]) {
				sml++;
			}
		}


		return result;   // return the elements in the array whose sum is equal to the value passed as parameter
	}

	public static void main(String[] args) {
		int val = 9;
		int[] arr = {1, 2, 4, 5, 6};
		int[] result = ArraysEx.findSum(arr, val);

		for (int n : result) {
			System.out.print(n + " ");
		}

		System.out.print("\n");
		val = 27;
		arr = new int[]{1, 21, 3, 14, 5, 60, 7, 6};
		result = ArraysEx.findSum(arr, val);

		for (int n : result) {
			System.out.print(n + " ");
		}
	}

}