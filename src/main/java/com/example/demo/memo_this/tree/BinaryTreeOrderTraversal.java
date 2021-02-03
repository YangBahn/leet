package com.example.demo.memo_this.tree;

import com.example.demo.memo_this.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Create 'Level Values List (main)' to store each levels values
Create LinkedList Queue and add the first node

Repeat while the Queue is not empty
	iterate the Queue and do:
		Poll each node in queue and add it to the value list
		Reload Queue with curNode's left and/or right to Queue for next iteration if exists
	add the value list to main list
return main list

* */
class BinaryTreeOrderTraversal {

	static class BinaryTree {
		static List<List<Integer>> traverse(TreeNode node) {
			List<List<Integer>> nodeLevelsValues = new ArrayList<List<Integer>>();
			Queue<TreeNode> nodeQueue = new LinkedList<>();
			nodeQueue.offer(node);

			while (!nodeQueue.isEmpty()) {
				List<Integer> levVals = new ArrayList<>();
				int curLevSize = nodeQueue.size();

				for (int i = 0; i < curLevSize; i++) {
					TreeNode curNode = nodeQueue.poll();
					levVals.add(curNode.val);
					if (curNode.left != null) {
						nodeQueue.offer(curNode.left);
					}

					if (curNode.right != null) {
						nodeQueue.offer(curNode.right);
					}
				}


				nodeLevelsValues.add(levVals);
			}

			return nodeLevelsValues;
		}

	}


	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);


		List<List<Integer>> result = BinaryTreeOrderTraversal.BinaryTree.traverse(treeNode);
		result.forEach(list -> {

					list.forEach(n -> System.out.print(n + " "));
					System.out.println();
				}
		);


	}
}
