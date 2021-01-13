package com.example.demo.grokking.patterns.linked_list;


public class LinkedListQuiz {

	public static boolean isPalindrome(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// slow is the second half
		ListNode secondHalfHead = reverseNode(slow);
		// use copy since we need to reverse back later
		ListNode secHalfCopy = secondHalfHead;
		ListNode firstHalfHead = head;


		while (firstHalfHead != null && secondHalfHead != null){
			if (firstHalfHead.value != secondHalfHead.value){
				// false
				break;
			}

			firstHalfHead = firstHalfHead.next;
			secondHalfHead = secondHalfHead.next;
		}

		reverseNode(secHalfCopy);
		if (firstHalfHead == null || secondHalfHead == null){
			return true;
		}

		return false;
	}

	private static ListNode reverseNode(ListNode head){
		ListNode cur = head;
		ListNode prev = null;

		while(cur != null){
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}

}
