package com.example.demo.common;


public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(){}

	public ListNode(int x) {
		val = x;
	}

	public ListNode addNext(int val) {
		next = new ListNode(val);
		return next;
	}

	public static ListNode load(int[] n) {
		ListNode returnNode = new ListNode(n[0]);
		ListNode nodeInFocus = returnNode;
		for (int num : n) {
			nodeInFocus = nodeInFocus.addNext(num);
		}
		return returnNode.next;
	}

	public void print() {
		ListNode temp = this;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
