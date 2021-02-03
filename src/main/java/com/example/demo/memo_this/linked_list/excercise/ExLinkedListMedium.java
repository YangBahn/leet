package com.example.demo.memo_this.linked_list.excercise;

import com.example.demo.memo_this.common.ListNode;

import java.util.function.Function;


public class ExLinkedListMedium {
	static class Intersection {

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


			int oneNodeCount = countNode.apply(one);
			int twoNodeCount = countNode.apply(two);
			int nodeCountDifference;


			if (oneNodeCount > twoNodeCount) {
				nodeCountDifference = oneNodeCount - twoNodeCount;
				return findIntersection(nodeCountDifference, one, two);
			} else {
				nodeCountDifference = twoNodeCount - oneNodeCount;
				return findIntersection(nodeCountDifference, two, one);
			}
		}


		private static int findIntersection(int nodeCountDiff, ListNode longerNode, ListNode shorterNode) {

			// move longer node by count diff amount
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
				longerNode = longerNode.next;
			}

			return -1;
		}


	}

	// add up value from each matching link
	static class TwoLinkedList {
		ListNode mergeTwoLists(ListNode a, ListNode b) {


			return null;
		}
	}

	public static void main(String[] args) {
		ListNode one = ListNode.load(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		ListNode two = ListNode.load(new int[]{8, 9, 10});
		int val = Intersection.getIntersectingNodeValue(one, two);
		System.out.println(val);
	}
}
