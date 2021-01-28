package com.example.demo;

import com.example.demo.grokking.patterns.MyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest {


	@Test
	public void get() {
	}

	@Test
	public void addAtHead() {
	}

	@Test
	public void addAtTail() {
	}

	@Test
	public void addAtIndex() {

		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtIndex(0, 0);

		linkedList.addAtIndex(3, 3);
		assertEquals(-1, linkedList.get(3));

		linkedList.addAtIndex(2, 2);
		assertEquals(-1, linkedList.get(2));

		linkedList.addAtIndex(1, 1);
		assertEquals(1, linkedList.get(1));

		linkedList.addAtIndex(2, 2);
		assertEquals(2, linkedList.get(2));

		linkedList.addAtIndex(0, 10);
		assertEquals(10, linkedList.get(0));

		linkedList.addAtIndex(6, 6);
		linkedList.addAtIndex(6, -1);

	}

	@Test
	public void deleteAtIndex() {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtIndex(0, 0);
		linkedList.addAtIndex(1, 1);
		linkedList.addAtIndex(2, 2);
		linkedList.addAtIndex(3, 3);
		linkedList.addAtIndex(4, 4);

		linkedList.deleteAtIndex(4);
		assertEquals(-1, linkedList.get(4));
		assertEquals(1, linkedList.get(1));


		linkedList.deleteAtIndex(2);
		assertEquals(-1, linkedList.get(3));


		linkedList.deleteAtIndex(0);
		assertEquals(1, linkedList.get(0));

	}


	@Test
	public void mix() {
//["MyLinkedList","addAtHead",
// "deleteAtIndex",

// "addAtHead",
// "addAtHead",
// "addAtHead",
// "addAtHead",
// "addAtHead",
//
// "addAtTail","get","deleteAtIndex","deleteAtIndex"]
//[[],[2],[1]
// ,[2],[7],[3],[2],
//
// [5],[5],[5]
// [6],[4]]
		MyLinkedList ll2 = new MyLinkedList();
		ll2.addAtHead(2);
		ll2.deleteAtIndex(1);
		ll2.addAtHead(2);
		ll2.addAtHead(7);
		ll2.addAtHead(3);
		ll2.addAtHead(2);
		ll2.addAtTail(5);
		ll2.get(5);
		ll2.deleteAtIndex(5);
		ll2.deleteAtIndex(5);


	}


}