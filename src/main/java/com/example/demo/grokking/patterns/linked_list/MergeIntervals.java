package com.example.demo.grokking.patterns.linked_list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Created by Kevin on Jan, 2021, demo
*/public class MergeIntervals {
	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {

		intervals.sort(Comparator.comparingInt(interval -> interval.start));

		Iterator<Interval> iterator = intervals.iterator();
		Interval lastInterval = iterator.next();
		int lastStart = lastInterval.start;
		int lastEnd = lastInterval.end;

		List<Interval> mergedIntervals = new LinkedList<Interval>();

		while (iterator.hasNext()) {
			Interval curInterval = iterator.next();
			if (curInterval.start <= lastEnd) {
				// since sorted, last start is smaller than any cur val
				lastEnd = Math.max(curInterval.end, lastEnd);
			} else {
				mergedIntervals.add(new Interval(lastStart, lastEnd));
				lastStart = curInterval.start;
				lastEnd = curInterval.end;
			}

		}

		mergedIntervals.add(new Interval(lastStart, lastEnd));
		return mergedIntervals;
	}

	public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {

		List<Interval> mergedIntervals = new ArrayList<>();

		int idx = 0;
		int size = intervals.size();

		// idx is at insert point after
		while (idx < size && newInterval.start > intervals.get(idx).end) {
			mergedIntervals.add(intervals.get(idx));
			idx++;
		}

		// idx is at insert point after -> merge  to new interval
		while (idx < size && newInterval.end >= intervals.get(idx).start) {
			newInterval.start = Math.min(newInterval.start, intervals.get(idx).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(idx).end);
			idx++;
		}

		mergedIntervals.add(newInterval);
		// idx is after middle -> add the rest
		while (idx < size) {
			mergedIntervals.add(intervals.get(idx));
			idx++;
		}


		return mergedIntervals;
	}

	public static Interval[] intervalIntersectionMerge(Interval[] arr1, Interval[] arr2) {
		List<Interval> intervalsIntersection = new ArrayList<Interval>();
		int arr1Len = arr1.length;
		int arr2Len = arr2.length;

		int len = Math.min(arr1Len, arr2Len);


		int i = 0;
		while (i < len) {
			Interval a = arr1[i];
			Interval b = arr2[i];
			Interval newInterval = new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
			intervalsIntersection.add(newInterval);
			i++;
		}

		// process the bigger of the two
		if (arr1Len - arr2Len != 0) {
			Interval[] shorter = arr1.length < arr2.length ? arr1 : arr2;
			Interval[] longer = arr1.length > arr2.length ? arr1 : arr2;
			int shorterLargestNum = shorter[shorter.length - 1].end;
			if (shorterLargestNum >= longer[shorter.length].start) {
				intervalsIntersection.add(new Interval(shorterLargestNum, shorterLargestNum));
			}


		}


//		int i = 0, j = 0;
//		while (i < arr1.length && j < arr2.length) {
//			// check if the interval arr[i] intersects with arr2[j]
//			// check if one of the interval's start time lies within the other interval
//			if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
//					|| (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
//				// store the intersection part
//				result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
//			}
//
//			// move next from the interval which is finishing first
//			if (arr1[i].end < arr2[j].end)
//				i++;
//			else
//				j++;
//		}

		return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
	}

	public static boolean canAttendAllAppointments(Interval[] intervals) {
// use this instead
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		// sort
		List<Interval> intervalsList = Arrays.asList(intervals);

		intervalsList.sort(Comparator.comparingInt(interval -> interval.start));

		// loop while true, exit if false
		int i = 0;
		while (intervalsList.size() - 1 > i) {
			if (intervalsList.get(i).end > intervalsList.get(i + 1).start) {
				return false;
			}
			i++;
		}
		return true;
	}
}