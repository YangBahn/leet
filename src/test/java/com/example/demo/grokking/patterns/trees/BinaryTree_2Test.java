package com.example.demo.grokking.patterns.trees;

import org.junit.jupiter.api.Test;

import static com.example.demo.grokking.patterns.trees.BinaryTree_2.TreeNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTree_2Test {

    @Test
    void rangeSumBST() {
    }


    @Test
    void sumRootToLeaf() {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = BinaryTree_2.sumRootToLeaf(root);
        assertEquals(38, sum);
    }

    @Test
    void getNodeAndSubByVal() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(44);
        root.left.left.right = new TreeNode(40);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode re = BinaryTree_2.getNodeAndSubByVal(root, 4);
        System.out.println(re.val);
    }

    @Test
    void mergeTrees() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(12);
        root2.left = new TreeNode(7);
        root2.left.left = new TreeNode(4);
        root2.right = new TreeNode(1);

        TreeNode merged = BinaryTree_2.mergeTrees(root, root2);
        System.out.println(merged.val);
    }
}