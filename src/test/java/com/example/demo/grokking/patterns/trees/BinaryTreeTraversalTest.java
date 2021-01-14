package com.example.demo.grokking.patterns.trees;


import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.demo.grokking.patterns.trees.BinaryTreeTraversal.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTraversalTest {


	@Test
	public void traverse(){
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = BinaryTreeTraversal.traverse(root);
		System.out.println("Level order traversal: " + result);
//		assertEquals(3, result.size());
	}

	@Test
	public void traverseReverse(){
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = BinaryTreeTraversal.reverseTraverse(root);
		System.out.println("Level order traversal: " + result);
//		assertEquals(3, result.size());
	}

	@Test
	public void zigzagReverse(){
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = BinaryTreeTraversal.zigZagTraverse(root);
		System.out.println("Level order traversal: " + result);
//		assertEquals(3, result.size());
	}
}