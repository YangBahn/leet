package com.example.demo.memo_this.tree.excercise;

import com.example.demo.common.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.*;


class ExBinaryTreeOrderTraversal {


	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);


		List<List<Integer>> result = ExBinaryTreeOrderTraversal.BinaryTree.traverse(treeNode);
		result.forEach(list -> {
					System.out.println(list);
				}
		);
	}

	/*
Create 'Level Values List (main)' to store each levels values
Create LinkedList Queue and add the first node

Repeat while the Queue is not empty
	iterate the Queue and do:
		Poll each node in queue and add it to the value list
		Reload Queue with curNode's left and/or right to Queue for next iteration if exists
	add the value list to main list
return main list
*/
	@UtilityClass
	class BinaryTree {
		List<List<Integer>> traverse(TreeNode node) {
			List<List<Integer>> result = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(node);
			while (!queue.isEmpty()) {
				int levSize = queue.size();
				List<Integer> curLevVals = new ArrayList<>();
				for (int i = 0; i < levSize; i++) {
					TreeNode cur = queue.poll();
					curLevVals.add(cur.getVal());

					if (Objects.nonNull(cur.getLeft())) {
						queue.offer(cur.getLeft());
					}

					if (Objects.nonNull(cur.getRight())) {
						queue.offer(cur.getRight());
					}
				}
				result.add(curLevVals);
			}
			return result;
		}

	}


}
