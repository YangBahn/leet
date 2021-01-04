package com.example.demo.easy.linkedList;

import java.util.Stack;

public class Solution {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}


	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;


		ListNode first = head;
		int nodeCt = 0;

		while (first != null) {
			first = first.next;
			nodeCt++;
		}

		first = dummy;

		for (int i = 0; i < nodeCt - n; i++) {
			first = first.next;
		}

		first.next = first.next.next;

		return dummy.next;
	}


	private int getLength(ListNode head) {
		int count = 0;

		ListNode temp = head;

		while (temp != null) {

			temp = temp.next;
			count++;

		}

		return count;
	}


	public static void reverseList() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);


		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		System.out.println(prev);
	}

	public static ListNode mergeTwoLists() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);


		// decide head first
		ListNode l1_head = l1;
		ListNode l2_head = l2;


		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null && l2 != null) {
			return l2;
		} else if (l2 == null && l1 != null) {
			return l1;
		}

		ListNode merged = null;
		if (l1.val <= l2_head.val) {
			merged = l1_head;
			l1_head = l1_head.next;
		} else {
			merged = l2_head;
			l2_head = l2_head.next;
		}


		// loop the rest with copy of head ( tail will be consumed)
		ListNode tailHolder = merged;
		while (l1_head != null && l2_head != null) {
			ListNode temp = null;
			if (l1_head.val <= l2_head.val) {
				temp = l1_head;
				l1_head = l1_head.next;
			} else {
				temp = l2_head;
				l2_head = l2_head.next;
			}

			// both head and next are using temp for comparison below
			tailHolder.next = temp;
			tailHolder = temp;



		}

		if (l1_head != null) {
			tailHolder.next = l1_head;
		} else if (l2_head != null) {
			tailHolder.next = l2_head;
		}


		System.out.println(merged.toString());
		return merged;
	}


	public static boolean isPalindrome() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);


		Stack<Integer> vals = new Stack<>();
		ListNode temp = head;
		while(temp != null){
			vals.push(temp.val);
			temp = temp.next;
		}


		while(head != null){
			int val = vals.pop();
			if (val != head.val){
				return false;
			}
			head = head.next;
		}

		return true;
	}



	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString(){

			StringBuilder builder = new StringBuilder();
			ListNode temp = this;
			while(temp != null){
				builder.append(temp.val + " -> ");
				temp = temp.next;
			}
			return builder.toString();
		}
	}

}
