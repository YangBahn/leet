package com.example.demo;


public class MyLinkedList {
	public int length;
	public Node head;


	public class Node {
		public int val;
		public Node next;

		Node(int val) {
			this.val = val;
		}
	}

	/**
	 * Initialize your data structure here.
	 */
	public MyLinkedList() {
		this.length = 0;
		this.head = null;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
	 */
	public int get(int index) {
		if (index < 0 || index >= this.length) {
			return -1;
		}

		int counter = 0;
		Node node = head;

		while (counter < index) {

			node = node.next;
			counter++;
		}



		return node.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node newHead = new Node(val);
		newHead.next = head;
		head = newHead;
		this.length++;
//		print();
	}

	/**
	 * Append a node of value val to the last element of the linked list.
	 */
	public void addAtTail(int val) {

		if (this.length == 0) {
			addAtHead(val);
			return;
		}
		Node curNode = head;
		while (curNode.next != null) {
			curNode = curNode.next;
		}


		Node newNode = new Node(val);
		curNode.next = newNode;
		newNode.next = null;
		this.length++;


//		Node newNode = new Node(val);
//		Node temp = head;
//		while(temp.next != null) {
//			temp = temp.next;
//		}
//		temp.next = newNode;
//		newNode.next = null;
//		this.length++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
	 */
	public void addAtIndex(int index, int val) {
		if ((index) == this.length) {
			addAtTail(val);
			return;
		}

		if (index > this.length) {
			return;
		}
		if (index == 0) {
			addAtHead(val);
			return;
		}

		Node cur = head;
		int i = 0;

		while (i < index - 1) {
			cur = cur.next;
			i++;
		}

		Node newNode = new Node(val);

		newNode.next = cur.next;
		cur.next = newNode;


		this.length++;

//		System.out.println("\nAdd at index " + index + "/" + val);
//		print();
	}

	/**
	 * Delete the index-th node in the linked list, if the index is valid.
	 */
	public void deleteAtIndex(int index) {

		if(index < 0 || index >= this.length) {
			return;
		}

		if (index == 0) {
			head = head.next;
			return;
		}


		int i = 0;
		Node cur = head;
		Node pre = null;
		while (i < index) {


			pre = cur;
			cur = cur.next;
			i++;
		}


		pre.next = cur.next;
		this.length--;
	}

	void print() {

		MyLinkedList.Node cur = head;
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (cur != null) {
			builder.append(i + "=" + cur.val + ",");
			cur = cur.next;
			i++;
		}


		System.out.println(builder.toString());
	}

}