package com.example.demo.grokking.patterns.linked_list;

public class ReverseLinkedList {

	public static ListNode reverse(ListNode head) {

		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}


	public static ListNode reverseSubList(ListNode head, int p, int q) {
		if (p == q)
			return head;

		ListNode current = head;
		ListNode prev = null;
		for (int i = 0; current != null && i < p - 1; ++i) {
			prev = current;
			current = current.next;
		}

		ListNode lastNodeOfFirstPart = prev;
		ListNode lastNodeOfSubList = current;
		ListNode next = null;

		for (int i = 0; current != null && i < q - p + 1; i++) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		if (lastNodeOfFirstPart != null)
			lastNodeOfFirstPart.next = prev;
		else
			head = prev;

		lastNodeOfSubList.next = current;

		return head;
	}

	public static ListNode reverseGivenNum(ListNode head, int q) {
		ListNode current = head;
		ListNode prev = null;

		ListNode headTail = current;
		for (int i = 0; current != null && i < q; i++) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;

		headTail.next = current;

		return head;
	}


	// in twos
	public static ListNode reverseIn2groups(ListNode head) {

		int groupLen = 2;
		ListNode cur = head;
		ListNode prev = null;
		for (int i = 0; i < groupLen; i++) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}

		head.next = cur;

		return prev;
	}
}
