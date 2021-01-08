package com.example.demo.grokking.patterns.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FastAndSlowTest {

	@Test
	public void hasCycle() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle: " + FastAndSlow.LinkedListCycle.hasCycle(head));

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle: " + FastAndSlow.LinkedListCycle.hasCycle(head));
	}


	@Test
	public void findCycleStart() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		// expecting 4
		ListNode node = FastAndSlow.LinkedListCycle.findCycleStart(head);
		assertEquals(4, node.value);
	}

	@Test
	public void isHappyNum() {
		int n = 22;
		boolean isHappy = FastAndSlow.isHappyNum(23);
		assertTrue(isHappy);
	}

	@Test
	public void isHappyNum_false() {
		int n = 12;
		boolean isHappy = FastAndSlow.isHappyNum(12);
		assertFalse(isHappy);
	}

	@Test
	public void findMiddle() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode mid = FastAndSlow.findMiddle(head);
		assertEquals(3, mid.value);
	}

}