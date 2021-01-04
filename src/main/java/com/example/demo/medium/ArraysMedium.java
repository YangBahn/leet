package com.example.demo.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArraysMedium {


	public static void setZeroes(int[][] matrix) {

		if (matrix.length == 1) {

			List<Integer> rowList = new ArrayList<>();
			for (int n : matrix[0]) {
				rowList.add(n);
			}

			if (rowList.contains(0)) {
				for (int i = 0; i < matrix[0].length; i++) {
					matrix[0][i] = 0;
				}
			}


		} else {
			Map<Integer, List<Integer>> zeroMap = mapZeroLocations(matrix);


			List<Integer> colZeroIndexes = zeroMap.values().stream().flatMap(List::stream).collect(Collectors.toList());

			for (int i = 0; i < matrix.length; i++) {
				if (zeroMap.containsKey(i)) {
					java.util.Arrays.fill(matrix[i], 0);
				}

				for (int j = 0; j < matrix[i].length; j++) {
					if (colZeroIndexes.contains(j)) {
						matrix[i][j] = 0;
					}
				}

			}

		}


	}


	private static Map<Integer, List<Integer>> mapZeroLocations(int[][] matrix) {

		Map<Integer, List<Integer>> zeroMap = new HashMap<>();

		int rowCount = matrix.length;
		for (int i = 0; i < rowCount; i++) {
			int[] cols = matrix[i];
			int colCount = cols.length;
			for (int j = 0; j < colCount; j++) {

				if (cols[j] == 0) {
					if (!zeroMap.containsKey(i)) {
						List<Integer> zeroIdxInRow = new ArrayList<>();
						zeroIdxInRow.add(j);
						zeroMap.put(i, zeroIdxInRow);
					} else {
						zeroMap.get(i).add(j);
					}
				}
			}


		}


		return zeroMap;
	}


}
