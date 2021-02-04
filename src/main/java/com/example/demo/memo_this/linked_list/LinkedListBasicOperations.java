package com.example.demo.memo_this.linked_list;

/*
PrecedingNode - prev
NodeInFocus - node
FollowingNode - node.next


DELETE NODE
Replace the NodeInFocus with the FollowingNode by connecting PrecedingNode to FollowingNode

REMOVE Nth NODE
* find the matching node then reroute the PrecedingNode node to the FollowingNode
Repeat while NodeInFocus is present:
	found if node val matches n
		reroute PrecedingNode's next to nodeInFocus's next
		exit
	not found, move to next node
		reroute PrecedingNode and NodeInFocus to next


REVERSE
* Swap PrecedingNode and FollowingNode till the end
Repeat while NodeInFocus(fn) is present
	store followingNode fn
	swap FollowingNode with Preceding Node
	move focus to the stored fn
*/

import com.example.demo.common.ListNode;

import java.util.Objects;

public class LinkedListBasicOperations {

	static void deleteNthNodeByVal(ListNode nodeToDelete) {
		int newNextVal = nodeToDelete.next.val;
		ListNode newNext = nodeToDelete.next;
		nodeToDelete.val = newNextVal;
		nodeToDelete.next = newNext;
	}

	void deleteNthNodeByVal(ListNode head, int val) {

		if (Objects.requireNonNull(head).val == val) {
			head = head.next;
			return;
		}

		ListNode nodeInFocus = head;
		ListNode precedingNode = nodeInFocus;
		while (nodeInFocus != null) {
			ListNode followingNodeStore = nodeInFocus.next;
			// found
			if (nodeInFocus.val == val) {
				precedingNode.next = followingNodeStore;
				return;
			} else {
				// move to next
				precedingNode = nodeInFocus;
				nodeInFocus = followingNodeStore;
			}
		}
	}


	static void reverseLinkedList(ListNode head) {
		ListNode precedingNode = null;
		ListNode nodeInFocus = head;
		while (nodeInFocus != null) {
			ListNode followingNode = nodeInFocus.next;
			nodeInFocus.next = precedingNode;
			precedingNode = nodeInFocus;
			nodeInFocus = followingNode;
		}
	}

	public static void main(String[] args) {

	}

}
