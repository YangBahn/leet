package com.example.demo.grokking.patterns.tree_depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PathSum {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        sum = sum - root.val;
        return hasPath(root.left, sum) || hasPath(root.right, sum);
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static List<List<TreeNode>> findAllLeafPaths(TreeNode node) {
        List<List<TreeNode>> allPaths = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();

        leafPaths(node, path, allPaths);
        return allPaths;
    }

    private static void leafPaths(TreeNode node, List<TreeNode> path, List<List<TreeNode>> allPaths) {
        if (node == null) {
            return;
        }

        path.add(node);
        if (node.left == null && node.right == null) {
            allPaths.add(path);

            allPaths.add(new ArrayList<>(path));
        } else {

            leafPaths(node.left, path, allPaths);
            leafPaths(node.right, path, allPaths);
        }

        path.remove(path.size() - 1);
    }

    public static int findSumOfPathNumbers(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        sumPathNum(root, path, all);

        return all.stream()
                .map(integers -> integers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .map(Integer::valueOf)
                .mapToInt(Integer::intValue).sum();
    }


    private static void sumPathNum(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(path));
        } else {

            sumPathNum(node.left, path, allPaths);
            sumPathNum(node.right, path, allPaths);
        }

        path.remove(path.size() - 1);
    }

    public static boolean findPathWithGivenSequence(TreeNode root, int[] sequence) {
        List<Integer> list = new LinkedList<>();

        return false;
    }

    public static void findTheLowestCommonAncestor() {
    }
}
