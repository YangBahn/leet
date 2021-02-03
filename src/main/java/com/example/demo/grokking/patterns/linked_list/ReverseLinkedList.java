package com.example.demo.grokking.patterns.linked_list;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

	static ListNode reverse(ListNode head) {

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


	static ListNode reverseSubList(ListNode head, int p, int q) {
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

	static ListNode reverseGivenNum(ListNode head, int q) {
		ListNode current = head;
		ListNode prev = null;

		ListNode headTail = current;
		for (int i = 0; current != null && i < q; i++) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

//		head = prev;

		headTail.next = current;

		return head;
	}


	// in twos

	static ListNode reverseIn2groups(ListNode head) {

		int groupLen = 2;
		ListNode cur = head;
		ListNode prev = null;
		ListNode headEnd = head;
		for (int i = 0; i < groupLen; i++) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;

			cur = temp;
		}

		headEnd.next = cur;

		return prev;
	}

	public static ListNode reverseEveryK(ListNode head, int k) {
		if (k <= 1 || head == null)
			return head;

		ListNode current = head, previous = null;
		while (current != null) {
			ListNode lastNodeOfPreviousPart = previous;
			// after reversing the LinkedList 'current' will become the last node of the sub-list
			ListNode lastNodeOfSubList = current;
			ListNode next = null; // will be used to temporarily store the next node
			// reverse 'k' nodes
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			// connect with the previous part
			if (lastNodeOfPreviousPart != null)
				lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
			else // this means we are changing the first node (head) of the LinkedList
				head = previous;

			// connect with the next part
			lastNodeOfSubList.next = current;

			// prepare for the next sub-list
			previous = lastNodeOfSubList;
		}

		return head;
	}

	static ListNode reverseEveryK_2(ListNode head, int k) {
		if (k <= 1 || head == null)
			return head;

		ListNode current = head, previous = null;
		while (current != null) {
			ListNode lastGroupTail = previous;
			// after reversing the LinkedList 'current' will become the last node of the sub-list
			ListNode subListTail = current;
			ListNode next = null; // will be used to temporarily store the next node
			// reverse 'k' nodes
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			// connect with the previous part
			if (lastGroupTail != null)
				lastGroupTail.next = previous; // 'previous' is now the first node of the sub-list
			else // this means we are changing the first node (head) of the LinkedList
				head = previous;

			// connect with the next part
			subListTail.next = current;

			// prepare for the next sub-list
			previous = subListTail;
		}

		return head;
	}

	private static void nodePrint(String action, List<ListNode> nodeList) {
		System.out.print("\n" + action + " ->");


		List<String> labels = Arrays.asList("Prev", "Cur ", "LastN");
		for (int i = 0; i < labels.size() && nodeList.size() > i; i++) {
			String lab = labels.get(i);
			System.out.print("\n\t" + lab + ": ");
			ListNode cur = nodeList.get(i);
			while (cur != null) {
				System.out.print(cur.value + ",");
				cur = cur.next;
			}
		}
	}
}
