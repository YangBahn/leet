package com.example.demo.hacker_rank;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

	public static void main(String[] arg) {
		int[] arr = new int[]{10, 20, 30, 40, 50};
		int result = BankNotif.activityNotifications(arr, 3);
		System.out.println("count " + result);

		arr = new int[]{1, 2, 3, 4, 4};
		result = BankNotif.activityNotifications(arr, 4);
		System.out.println("count " + result);

		arr = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
		result = BankNotif.activityNotifications(arr, 5);
		System.out.println("count " + result);
	}

	@UtilityClass
	private class BankNotif {
		/* find ele greater than prior three median
		d = 3 arr[10,20,30,40,50 ] output: 1
     		first three, collect and cal median. Because , there will be a notice. The next day, our trailing expenditures are and the expenditures are .
     		This is less than so no notice will be sent. Over the period, there was one notice sent.

		create a window per three values, get median, compare it to the fourth
			start
			for end < len - 2
				get median from start, start +1, end

				start ++
				end++

		*/
		int activityNotifications(int[] expenditure, int d) {

			int notifCount = 0;
			int len = expenditure.length;


			for (int i = 0; i + d <= len; i++) {

				int median = getMedian(i, d, expenditure);

				if (median * 2 <= expenditure[d]) {
					notifCount++;
				}
			}
			return notifCount;
		}

		int getMedian(int start, int d, int[] arr) {
			int[] period = new int[d];
			for (int i = 0; i < d; i++) {
				period[i] = arr[start];
				start++;
			}

			Arrays.sort(period);
			return period[period.length / 2];
		}


	}

	private class ScoreChecker {

		class Player {
			String name;
			int score;

			Player(String name, int score) {
				this.name = name;
				this.score = score;
			}
		}

		class Checker implements Comparator<Player> {
			// complete this method
			public int compare(Player a, Player b) {
				int result = 0;
				if (a.score < b.score) {
					result = 1;
				}
				if (a.score > b.score) {
					result = -1;
				}

				if (result == 0) {
					if (a.name.toCharArray()[0] > b.name.toCharArray()[0]) {
						return 1;
					} else {
						return -1;
					}
				}

				return result;
			}
		}

	}

	@UtilityClass
	private class MarkAndToys {
		// maxumum purchase avail with given money
		private int maximumToys(int[] prices, int doe) {
			Arrays.sort(prices);
			int count = 0;

			for (int i = 0; i < prices.length; i++) {
				int toyPrice = prices[i];
				if (doe >= toyPrice) {
					count++;
					doe -= toyPrice;
				}
			}

			return count;
		}
	}

	@UtilityClass
	private class BubbleSort {
		static void countSwaps(int[] a) {
			int swapCount = 0;
			int first = 0;
			int last = 0;
			int len = a.length;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len - 1; j++) {
					int curVal = a[j];
					int nextVal = a[j + 1];
					if (curVal > nextVal) {
						a[j + 1] = curVal;
						a[j] = nextVal;
						swapCount++;

					}
				}
			}

			System.out.println("Array is sorted in " + swapCount + " swaps");
			System.out.println("First Element: " + a[0]);
			System.out.println("Last Element: " + a[len - 1]);
		}
	}
}
