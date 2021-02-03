package com.example.demo.memo_this.linked_list.excercise;

import com.example.demo.memo_this.common.ListNode;

import java.util.*;

class ExLinkedListNonBasic {

	public static void main(String[] args) {

		ListNode one = ListNode.load(new int[]{1, 3, 5, 6});
		one.print();
		ListNode two = ListNode.load(new int[]{2, 4, 7});
		two.print();
//		ListNode mergeResult = mergeTwoSortedLists(one, two);

		// Palin
		System.out.println("\nRunning palindrom problem");
		ListNode palNode = ListNode.load(new int[]{1, 2, 4, 2, 1});
		palNode.print();
		boolean isPal = isPalindrome(palNode);
		System.out.println("is it pal? " + isPal);

		System.out.println("\nRunning palindrom problem2");
		palNode = ListNode.load(new int[]{4, 3, 2, 1, 7, 3, 4});
		palNode.print();
		isPal = isPalindrome(palNode);
		System.out.println("is it pal? " + isPal);

		// cyclic loop
		System.out.println("\nChecking cyclic list");
		ListNode cy = ListNode.load(new int[]{1, 2, 3, 4, 1});
		cy.print();
		System.out.println("Cyclic?? " + detectLoop(cy));


		System.out.println("\nChecking cyclic list");
		cy = ListNode.load(new int[]{1, 2, 3, 4,5});
		cy.print();
		System.out.println("Cyclic?? " + detectLoop(cy));
	}


	/*
	#  traverse two nodes, compare value, load node to a placeholder node. #

	Store placeholder node's head reference

	while both nodeOne,nodeTwo are present
		compare vals of one and two
			set NodeInFocus to whichever is has smaller value
			set the focus node to next

	check if either of oneThread or twoThread have remaining nodes
		if present, attach the remaining to the end of NodeInFocus

	return placeHolder's next
	*/
	private static ListNode mergeTwoSortedLists(ListNode one, ListNode two) {
		ListNode placeholder = new ListNode(0);

		ListNode nodeInFocus = placeholder;
		while (one != null && two != null) {
			if (one.val < two.val) {
				nodeInFocus.next = new ListNode(one.val);
				one = one.next;
			} else {
				nodeInFocus.next = new ListNode(two.val);
				two = two.next;
			}
			nodeInFocus = nodeInFocus.next;
		}

		while (one != null) {
			nodeInFocus.next = one;
			one = one.next;
		}

		while (two != null) {
			nodeInFocus.next = two;
			two = two.next;
		}

		return placeholder.next;

	}

	/*
	load all node values to a stack
	while both the listNode(forward) and stack(backward, pop()) :
		 comparing each value. Return false if unequal.
		 return true
	*/
	private static boolean isPalindrome(ListNode head) {

		Stack<ListNode> stack = new Stack<>();
		ListNode node = head;
		while (node != null) {
			stack.push((new ListNode(node.val)));
			node = node.next;
		}

		while (head != null) {
			if (head.val != stack.pop().val) {
				return false;
			}
			head = head.next;
		}


		return true;
	}

	static boolean detectLoop(ListNode h) {
		List<Integer> vals = new ArrayList<>();
		ListNode cur = h;
		while (cur != null) {
			if (vals.contains(cur.val)) {
				return true;
			}
			vals.add(cur.val);
			cur = cur.next;
		}

		return false;
	}


}
