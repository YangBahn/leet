package com.example.demo.grokking.patterns.trees;


import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.demo.grokking.patterns.trees.BinaryTreeTraversal.TreeNode;
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
	public void zigzagTraverse(){
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
	@Test
	public void levAvergeTraverse(){
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double>result = BinaryTreeTraversal.findLevelAverages(root);
		System.out.println("Level order traversal: " + result);
//		assertEquals(3, result.size());
	}

    @Test
    public void traverseFindMinDepth() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int minLev = BinaryTreeTraversal.findMinDepth(root);

        assertEquals(2, minLev);
    }

    @Test
    public void traversefindSuccessor() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = BinaryTreeTraversal.findSuccessor(root, 1);
        if (result != null)
            System.out.println(result.val + " ");
        result = BinaryTreeTraversal.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }

    @Test
    void connectLevelOrderSiblings() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        BinaryTreeTraversal.connectLevelOrderSiblings(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        printLevelOrder(root);


    }

    private void printLevelOrder(TreeNode nextLevelRoot) {

        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}