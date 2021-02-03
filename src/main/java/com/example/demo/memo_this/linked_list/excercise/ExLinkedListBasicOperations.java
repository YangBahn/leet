package com.example.demo.memo_this.linked_list.excercise;

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

import com.example.demo.memo_this.common.ListNode;

import java.util.Objects;

public class ExLinkedListBasicOperations {

	public static void main(String[] args) {
		ListNode node = ListNode.load(new int[]{1, 2, 3, 4});
		node.print();

		ListNode rev = reverse(node);
		rev.print();
	}

	private static void delete(ListNode toDel) {
		ListNode next = toDel.next;
		toDel.val = next.val;
		toDel.next = next.next;
	}

	private static void deleteNthNode(ListNode head, int nth) {
		ListNode prev = head;
		int count = 1;
		// 0,1
		while (count < nth - 1) {
			prev = prev.next;
			count++;
		}
		ListNode nthNode = prev.next;
		prev.next = prev.next.next;
		nthNode.next = null;
	}

	private static ListNode reverse(ListNode head){
		ListNode prev =  null;
		ListNode cur = head;
		while(cur != null){
			ListNode nextStore = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextStore;
		}

		return prev;
	}

}
