package com.example.demo.memo_this.linked_list;

import com.example.demo.common.ListNode;

import java.util.HashSet;
import java.util.Stack;

class LinkedListNonBasic {


	/*
	#  traverse two nodes, compare value, load node to a placeholder node. #

	Store placeholder node's head reference
	while both nodeOne,nodeTwo are present
		Assign one of node1 or node2 to nodeInFocus whichever has smaller cur value.
		set move nodeInFocus to its next

	check if either of oneThread or twoThread have remaining nodes
		if present, attach the remaining to the end of NodeInFocus
	return placeHolder's next
	*/

	private static ListNode mergeTwoSortedLists(ListNode one, ListNode two) {

		ListNode headOfPlaceHolderNode = new ListNode(0);

		ListNode nodeInFocus = headOfPlaceHolderNode;
		ListNode oneThread = one;
		ListNode twoThread = two;
		while (oneThread != null && twoThread != null) {
			if (oneThread.val <= twoThread.val) {
				nodeInFocus.next = oneThread;
				oneThread = oneThread.next;
			} else {
				nodeInFocus.next = twoThread;
				twoThread = twoThread.next;
			}

			nodeInFocus = nodeInFocus.next;
		}

		if (oneThread == null) {
			nodeInFocus.next = twoThread;
		}
		if (twoThread == null) {
			nodeInFocus.next = oneThread;
		}

		return headOfPlaceHolderNode.next;
	}

	/*
	load all node values to a stack
	Loop both the listNode(forward) and stack(backward, pop()) while:
		 comparing each value. Return false if unequal.
		 return true
	*/
	private static boolean isPalindrome(ListNode head) {

		ListNode nodeInFocus = head;

		Stack<Integer> listValStack = new Stack<>();
		// load node values to stack
		while (nodeInFocus != null) {
			listValStack.push(nodeInFocus.val);
			nodeInFocus = nodeInFocus.next;
		}


		nodeInFocus = head;
		while (nodeInFocus != null) {
			int stackedValue = listValStack.pop();
			if (nodeInFocus.val != stackedValue)
				return false;
			nodeInFocus = nodeInFocus.next;
		}

		return true;
	}

	static boolean detectLoop(ListNode h) {
		HashSet<ListNode> s = new HashSet<>();
		ListNode nodeInFocus = h;
		while (nodeInFocus != null) {
			if (s.contains(nodeInFocus))
				return true;
			s.add(nodeInFocus);
			nodeInFocus = nodeInFocus.next;
		}

		return false;
	}


	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		one.addNext(3)
				.addNext(5).addNext(5).addNext(3).addNext(1);

		ListNode two = new ListNode(2);
		two.addNext(4).addNext(8).addNext(10);

		boolean merged = isPalindrome(one);
		System.out.println(merged);
	}
}
