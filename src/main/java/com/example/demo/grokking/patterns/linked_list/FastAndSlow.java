package com.example.demo.grokking.patterns.linked_list;


import java.util.function.Function;

public class FastAndSlow {


	static class LinkedListCycle {
		public static boolean hasCycle(ListNode head) {

			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.next != null) {

				if (slow.next.value >= fast.value) {
					return true;
				}

				slow = slow.next;
				fast = fast.next.next;
			}

			return false;
		}

		public static ListNode findCycleStart(ListNode head) {

			ListNode slow = head;
			ListNode fast = head.next;

			while (slow != fast) {
				System.out.println("Slow: " + slow.value + " fast: " + fast.value);
				slow = slow.next;
				fast = fast.next.next;

			}

			return slow;
		}
	}


	public static boolean isHappyNum(int num) {

		Function<Integer, Integer> calc = n -> {
			char[] numChars = String.valueOf(n).toCharArray();
			int sum = 0;
			for (char numChar : numChars) {
				int digit = Integer.parseInt(String.valueOf(numChar));
				sum += digit * digit;
			}
			return sum;
		};

		int slow = num;
		int fast = num;

		while (slow != fast || slow == num) {
			slow = calc.apply(slow);
			fast = calc.apply(calc.apply(fast));
			if (slow == 1 || fast == 1) {
				return true;
			}
		}


		return false;
	}


	public static ListNode findMiddle(ListNode head) {
		ListNode s = head;
		ListNode f = head;
		while (f.next != null) {
			s = s.next;
			f = f.next.next;
		}

		return s;
	}

}
