package com.example.demo.grokking.patterns.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListQuizTest {

	@Test
	void isPalindrome() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + LinkedListQuiz.isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + LinkedListQuiz.isPalindrome(head));
	}
}