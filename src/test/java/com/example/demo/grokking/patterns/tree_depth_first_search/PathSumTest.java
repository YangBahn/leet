package com.example.demo.grokking.patterns.tree_depth_first_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.demo.grokking.patterns.tree_depth_first_search.PathSum.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PathSumTest {
    @Test
    void hasPathToSum() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        boolean re = hasPath(root, 28);
        assertTrue(re);
    }


    @Test
    void findPaths() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
    }

    @Test
    void findPathsRecursive() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> allPaths = PathSum.findPaths(root, 23);
        allPaths.forEach(p -> {
            System.out.println();
            p.forEach(tree -> {
                System.out.print(tree + " ");
            });
        });
    }


    @Test
    void findAllPaths() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
        List<List<TreeNode>> allPaths = findAllLeafPaths(root);
        allPaths.forEach(p -> {
            System.out.println();
            p.forEach(tree -> {
                System.out.print(tree.val + " ");
            });
        });
    }


    @Test
    void findSumOfPathNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + PathSum.findSumOfPathNumbers(root));
    }
}