package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

	public static void mergeTwo(){
		int arr1[] = {1, 3, 4, 5,0,0,0,0};
		int arr2[] = {2, 4, 6, 8};
		int m = 4;
		int n = 4;


		List<Integer> set = new ArrayList<>();

		for (int i = 0; i < arr1.length/2; i++) {
			set.add(arr1[i]);

		}

		for (int i : arr2){
			set.add(i);
		}

		Collections.sort(set);


		for (int i = 0; i < arr1.length ; i++) {
			arr1[i] = set.get(i);
		}

		Arrays.stream(arr1).forEach(System.out::println);


	}

}
