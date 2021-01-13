package com.example.demo.grokking.patterns.linked_list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.grokking.patterns.linked_list.MergeIntervals.*;
import static org.junit.jupiter.api.Assertions.*;


class MergeIntervalsTest {

	@Test
	void merge() {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		List<Interval> merged = MergeIntervals.merge(input);
		assertEquals(2, merged.size());
	}

	@Test
	void insertInterval() {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		MergeIntervals.insertInterval(input, new Interval(4, 6));

		assertEquals(4, input.size());


		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		input = MergeIntervals.insertInterval(input, new Interval(1, 4));

		assertEquals(2, input.size());

	}

	@Test
	void insertInterval_2() {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		input = MergeIntervals.insertInterval(input, new Interval(1, 4));

		assertEquals(2, input.size());
	}

	@Test
	void intervalIntersectionMerge() {
		Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
		Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
		Interval[] result = MergeIntervals.intervalIntersectionMerge(input1, input2);
		assertEquals(3, result.length);


		assertEquals(result[0].start, 2);
		assertEquals(result[0].end, 3);
		assertEquals(result[1].start, 5);
		assertEquals(result[1].end, 6);
		assertEquals(result[2].start, 7);
		assertEquals(result[2].end, 7);
	}
	@Test
	void canAttendAllAppointments(){
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = MergeIntervals.canAttendAllAppointments(intervals);
		assertFalse(result);
	}

	@Test
	void canAttendAllAppointments_2(){
		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		boolean result = MergeIntervals.canAttendAllAppointments(intervals1);
		assertTrue(result);
	}
}