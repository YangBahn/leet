package com.example.demo.memo_this.array_and_strings.excercise;

import com.example.demo.common.Interval;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.memo_this.array_and_strings.excercise.MergeIntervals.MinimumMeetingRooms.Meeting;
import static com.example.demo.memo_this.array_and_strings.excercise.MergeIntervals.MinimumMeetingRooms.findMinimumMeetingRooms;


// given intervals of time for appointments, check if doable ( no overlap)
public class MergeIntervals {
	private static class ConflictingAppointments {
		/*
		Sort intervals by start time
		Starting with first appt end time (i = 1), loop intervals:
			If prevAppt.endTime is after curAppt.startTime, return false
		true if no false found
		*/
		private static boolean canAttendAllAppointments(Interval[] intervals) {

			return true;
		}
	}


	static class MinimumMeetingRooms {
		static class Meeting {
			int start;
			int end;

			Meeting(int start, int end) {
				this.start = start;
				this.end = end;
			}
		}

		// min number of room required for the given meetings
		/*
		'minRooms'
		Sort meetings and create PriorityQueue to hold active meeting
		For each meeting, compare the meeting to an active meeting(queued) and
			remove all meetings from the heap that have an end time smaller than or equal to the start time o
			load next meeting to be active on minHeap queue
			update minRooms value
		*/
		static int findMinimumMeetingRooms(List<Meeting> meetings) {
			return -1;
		}
	}

	private static void runMinMeetingRooms() {
		List<Meeting> input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		int result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

	}

	public static void main(String[] args) {
		Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
		boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
		result = ConflictingAppointments.canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
		result = ConflictingAppointments.canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);
	}

}
