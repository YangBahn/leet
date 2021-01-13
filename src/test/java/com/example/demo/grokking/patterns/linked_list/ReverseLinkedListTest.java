package com.example.demo.grokking.patterns.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ReverseLinkedListTest {



	@Test
	void reverse() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);

		ListNode rev = ReverseLinkedList.reverse(head);
		assertNotNull(rev);
		ListNode cur = rev;
		printLinkedList(cur);

		assertEquals(10, rev.value);
		assertEquals(8, rev.next.value);
		assertEquals(6, rev.next.next.value);
	}

	@Test
	void reverseSubList(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = ReverseLinkedList.reverseSubList(head, 2, 4);
		printLinkedList(result);
	}


	@Test
	void reverseGivenNum(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		ListNode result = ReverseLinkedList.reverseGivenNum(head, 2);
		printLinkedList(result);

	}


	private void printLinkedList(ListNode head){
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.value + ",");
			cur = cur.next;
		}
		System.out.print("\n");
	}
}