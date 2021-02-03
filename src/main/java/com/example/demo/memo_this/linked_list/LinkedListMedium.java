package com.example.demo.memo_this.linked_list;

import com.example.demo.memo_this.common.ListNode;

import java.util.function.Function;


public class LinkedListMedium {

	public static void main(String[] args) {
		ListNode one = ListNode.load(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		ListNode two = ListNode.load(new int[]{8, 9, 10, 4});
//		int val = Intersection.getIntersectingNodeValue(one, two);
//		System.out.println(val);

		ListNode result = new TwoLinkedList().addUpTwoListValues(one, two);
		result.print();
	}


	static class Intersection {

		// Make sure two lists are same len then return firstNode match bt two.
		/*
		Sync the both nodes length:
			Count both nodes move head of the bigger by length diff amount
		For each node of both nodes, compare values
			return true if any equal
		*/

		static int getIntersectingNodeValue(ListNode one, ListNode two) {
			final Function<ListNode, Integer> countNode = node -> {
				ListNode current = node;
				int count = 0;
				while (current != null) {
					count++;
					current = current.next;
				}

				return count;
			};


			int nodeOneLen = countNode.apply(one);
			int nodeTwoLen = countNode.apply(two);
			int nodeLenDiff;

			if (nodeOneLen > nodeTwoLen) {
				nodeLenDiff = nodeOneLen - nodeTwoLen;
				return findIntersection(nodeLenDiff, one, two);
			} else {
				nodeLenDiff = nodeTwoLen - nodeOneLen;
				return findIntersection(nodeLenDiff, two, one);
			}
		}

		private static int findIntersection(int nodeCountDiff, ListNode longerNode, ListNode shorterNode) {
			// move longer node by count diff amount
			// we can do this because post intersection values must be the same
			for (int i = 0; i < nodeCountDiff; i++) {
				if (longerNode == null) {
					return -1;
				}
				longerNode = longerNode.next;
			}


			while (longerNode != null && shorterNode != null) {
				if (longerNode.val == shorterNode.val) {
					return longerNode.val;
				}
				longerNode = longerNode.next;
				shorterNode = shorterNode.next;
			}

			return -1;
		}


	}

	// add up value from each matching link
//	Input: l1 = [2,4,3], l2 = [5,6,4]
//	Output: [7,0,8]
//	Explanation: 342 + 465 = 807.
	static class TwoLinkedList {

		ListNode addUpTwoListValues(ListNode nodeOne, ListNode nodeTwo) {
			ListNode result = null;

			if (nodeOne == null) {
				return nodeTwo;
			}
			if (nodeTwo == null) {
				return nodeOne;
			}

			int nodeOneSize = getsize(nodeOne);
			int nodeTwoSize = getsize(nodeTwo);

			// keeping one larger for simplicity
			if (nodeOneSize < nodeTwoSize) {
				ListNode oldNodeOne = nodeOne;
				nodeOne = nodeTwo;
				nodeTwo = oldNodeOne;
			}
			// move diff. number of nodes in node1
			int diff = Math.abs(nodeOneSize - nodeTwoSize);
			while (diff > 0) {
				nodeOne = nodeOne.next;
				diff--;
			}


			int carry = 0;
			result = addUpTwoNodes(nodeOne, nodeTwo, carry, result);

			// if some carry is still there, add a new node to
			// the front of the result list. e.g. 999 and 87
			if (carry > 0)
				push(carry, 3, nodeOne, nodeTwo, result);
			return result;
		}

/*		void syncNodesSize(ListNode nodeOne, ListNode nodeTwo) {
			int nodeOneSize = getsize(nodeOne);
			int nodeTwoSize = getsize(nodeTwo);

			// keeping one larger for simplicity
			if (nodeOneSize < nodeTwoSize) {
				ListNode oldNodeOne = nodeOne;
				nodeOne = nodeTwo;
				nodeTwo = oldNodeOne;
			}

			// move diff. number of nodes in node1
			int diff = Math.abs(nodeOneSize - nodeTwoSize);
			while (diff > 0) {
				nodeOne = nodeOne.next;
				diff--;
			}


		}*/

		ListNode addUpTwoNodes(ListNode nodeOne, ListNode nodeTwo, int carry, ListNode result) {
			// Since the function assumes linked lists are of
			// same size, check any of the two head pointers
			if (nodeOne == null)
				return null;

			// Recursively add remaining nodes and get the carry
			addUpTwoNodes(nodeOne.next, nodeTwo.next, carry, result);

			// add digits of current nodes and propagated carry
			int sum = nodeOne.val + nodeTwo.val + carry;
			carry = sum / 10;
			sum = sum % 10;

			push(sum, 3, nodeOne, nodeTwo, result);
			return result;
		}

		void push(int val, int list, ListNode nodeOne, ListNode nodeTwo, ListNode result) {
			ListNode newnode = new ListNode(val);
			if (list == 1) {
				newnode.next = nodeOne;
				nodeOne = newnode;
			} else if (list == 2) {
				newnode.next = nodeTwo;
				nodeTwo = newnode;
			} else {
				newnode.next = result;
				result = newnode;
			}

		}


		int getsize(ListNode head) {
			int count = 0;
			while (head != null) {
				count++;
				head = head.next;
			}
			return count;
		}

	}


}
