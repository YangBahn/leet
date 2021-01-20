package com.example.demo.grokking.patterns;


import java.util.Collections;
import java.util.PriorityQueue;

public class Heaps {

	static class MedianOfAStream {
		private PriorityQueue<Integer> minHeap, maxHeap;

		public MedianOfAStream() {
			maxHeap = new PriorityQueue<>((a, b) -> b - a);
			minHeap = new PriorityQueue<>((a, b) -> a - b);
		}

		public void insertNum(int num) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
				maxHeap.offer(num);
			} else {
				minHeap.offer(num);
			}

			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			} else if (maxHeap.size() < minHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
		}

	}

	static class SlidingWindowMedian {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		public double[] findSlidingWindowMedian(int[] nums, int k) {
			double[] result = new double[nums.length - k + 1];

			for (int i = 0; i < nums.length; i++) {
				Integer curVal = nums[i];
				if (maxHeap.size() == 0 || curVal < maxHeap.peek()) {
					maxHeap.add(curVal);
				} else {
					minHeap.add(curVal);
				}

				rebalanceHeaps(this.maxHeap, this.minHeap);

				// if we have at least 'k' elements in the sliding window
				if (i - k + 1 >= 0) {
					// add the median to the the result array
					result[i - k + 1] = getMedian(this.maxHeap, this.minHeap);

					// remove the element going out of the sliding window
					curVal = nums[i - k + 1];
					if (curVal <= maxHeap.peek()) {
						maxHeap.remove(curVal);
					} else {
						minHeap.remove(curVal);
					}
				}
			}
			return result;
		}
	}

	static class MaximizeCapital {

		public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
			int n = profits.length;
			PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
			PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

			// insert all project capitals to a min-heap
			for (int i = 0; i < n; i++)
				minCapitalHeap.offer(i);

			// let's try to find a total of 'numberOfProjects' best projects
			int availableCapital = initialCapital;
			for (int i = 0; i < numberOfProjects; i++) {
				// find all projects that can be selected within the available capital and insert them in a max-heap
				while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
					maxProfitHeap.add(minCapitalHeap.poll());

				// terminate if we are not able to find any project that can be completed within the available capital
				if (maxProfitHeap.isEmpty())
					break;

				// select the project with the maximum profit
				availableCapital += profits[maxProfitHeap.poll()];
			}

			return availableCapital;
		}

		public static int findMaximumCapital_noHeap(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
			int curProfit = 0;
			int curCapital = initialCapital;
			for (int i = 0; i < capital.length && numberOfProjects > 0; i++) {
				int profitIdx = curCapital;
				if (profitIdx > capital.length - 1) {
					profitIdx = capital.length - 1;
				}

				curProfit = profits[profitIdx];
				curCapital += curProfit;
				numberOfProjects--;
			}
			return curCapital;
		}

	}


	private static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() >= minHeap.size()) {
			return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	private static void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		// either both the heaps will have equal number of elements or max-heap will have
		// one more element than the min-heap
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		} else if (minHeap.size() + 1 < maxHeap.size()) {
			minHeap.add(maxHeap.poll());
		}
	}
}
