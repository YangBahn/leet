package com.example.demo.hacker_rank;

import com.example.demo.common.Util;
import lombok.ToString;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Greedy {

	public static void main(String[] args) {
		long[] arrA = new long[]{2L, 3L, 2L};
		long result = MinTimeRequired.minTime(arrA, 10);
		System.out.println(result);

		arrA = new long[]{4L, 5L, 6L};
		result = MinTimeRequired.minTime(arrA, 12);
		System.out.println(result);

	}


	private static class MinTimeRequired {
		private static long minTime(long[] arr, long goal) {
			boolean complete = false;
			int days = 0;
			while (!complete) {
				days++;

				int items = 0;
				for (long l : arr) {
					items += (days / l);
				}

				if (items >= goal) {
					complete = true;
				}


			}

			return days;

		}
	}

	// todo:
	private static class TripleSums {

		static long triplets(int[] a, int[] b, int[] c) {

			UnaryOperator<int[]> sortDistinct = arr -> Arrays.stream(arr).distinct().sorted().toArray();

			long count = 0;
			a = sortDistinct.apply(a);
			b = sortDistinct.apply(b);
			c = sortDistinct.apply(c);

			for (int bVal : b) {
				long c1 = getValidIndex(a, bVal) + 1;
				long c3 = getValidIndex(c, bVal) + 1;
				count += c1 * c3;
			}

			return count;
		}


		static int getValidIndex(int[] arr, int num) {
			int left = 0;
			int right = arr.length - 1;
			int count = -1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (arr[mid] <= num) {
					count = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			return count;
		}
	}

	private static class FindPairs {

		/* count the number of pairs whose abs diff matches k

		 sort array


		*/
		private static int pairs(int k, int[] arr) {
			int count = 0;
			Arrays.sort(arr);
			int fast = 1;
			for (int i = 0; i < arr.length - 1; i++) {
				int cur = arr[i];

				for (int j = i + 1; j < arr.length; j++) {
					int diff = Math.abs(arr[j] - cur);

					if (diff == k) {
						count++;
						break;
					}
				}
			}

			return count;
		}
	}

	@ToString
	private static class IceCreamParlor {
		/* Get Ids of the two icreams whose cost sum matches money
		 *
		 * Make IceCream List
		 * Use two pointers to find the sum that matches money
		 *
		 */
		static class IceCream {
			int id;
			int cost;

			IceCream(int id, int cost) {
				this.id = id;
				this.cost = cost;
			}

			int getCost() {
				return this.cost;
			}


		}

		static void whatFlavors(int[] cost, int money) {

			List<IceCream> creams = IntStream.range(0, cost.length)
					.mapToObj(idx -> new IceCream(idx + 1, cost[idx]))
					.sorted(Comparator.comparingInt(IceCream::getCost))
					.collect(Collectors.toList());


			int left = 0;
			int right = creams.size() - 1;


			while (left < right) {
				IceCream leftCream = creams.get(left);
				IceCream rightCream = creams.get(right);
				int sum = leftCream.cost + rightCream.cost;

				if (sum == money) {
					String ids = leftCream.id < rightCream.id ? leftCream.id + " " + rightCream.id : rightCream.id + " " + leftCream.id;
					System.out.println(ids);
					return;
				}

				if (sum < money)
					left++;

				if (sum > money)
					right--;

			}


		}


	}

	private static class MaxMinDiff {
		// create an array with k number of elements from given array with least max - min value, in order

		/* Create subsets w k elements, calculate the diff, return the smallest

		 */
		static int maxMin(int k, int[] arr) {
			Arrays.sort(arr);
			int smallestDiff = Integer.MAX_VALUE;
			for (int i = 0; i <= arr.length - k; i++) {
				int curMin = Integer.MAX_VALUE;
				int curMax = Integer.MIN_VALUE;
				for (int j = 0; j < k; j++) {
					int val = arr[j + i];
					curMax = Math.max(val, curMax);
					curMin = Math.min(val, curMin);
				}

				smallestDiff = Math.min(smallestDiff, curMax - curMin);
			}

			return smallestDiff;
		}

	}


	private static class GreedyFlorist {

		/* k = num of ppl, c = flower prices
			Each additional purchase by a same individual will double the next price. Find the minimum to buy all flowers

		Create a map - k , listCosts, distributing costs in round robin fashion, using queue
		Create a queue of k while flower exists


		*/
		static int getMinimumCost(int k, int[] c) {
			Map<Integer, List<Integer>> costsByK = distributeCostToEachK(k, c);

			int total = 0;
			for (List<Integer> costs : costsByK.values()) {
				int cost = calculateCosts(costs);
				total += cost;
			}

			return total;
		}

		static int calculateCosts(List<Integer> costs) {
			int total = 0;
			for (int i = 0; i < costs.size(); i++) {
				int curCost = costs.get(i);
				total += (i + 1) * curCost;
			}
			return total;
		}

		static Map<Integer, List<Integer>> distributeCostToEachK(int k, int[] c) {
			Arrays.sort(c);
			Map<Integer, List<Integer>> costsByPerson = new HashMap<>();
			int curK = 0;
			for (int i = c.length - 1; i >= 0; i--) {
				int curFlower = c[i];
				List<Integer> personCostList = costsByPerson.getOrDefault(curK, new ArrayList<>());
				personCostList.add(curFlower);
				costsByPerson.put(curK, personCostList);

				if (curK == k - 1) {
					curK = 0;
				} else {
					curK++;
				}
			}
			return costsByPerson;
		}

	}

	private static class MinAbsDiff {

		static int minimumAbsoluteDifference(int[] arr) {
			int minAbsDiff = Integer.MAX_VALUE;
			Arrays.sort(arr);
			Util.printArr(arr);
			int lastVal = arr[0];

			for (int i = 1; i < arr.length; i++) {
				int diff = Math.abs(lastVal - arr[i]);
				minAbsDiff = Math.min(diff, minAbsDiff);
				lastVal = arr[i];
			}


			return minAbsDiff;
		}
	}
}