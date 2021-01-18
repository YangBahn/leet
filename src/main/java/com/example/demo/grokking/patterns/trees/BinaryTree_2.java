package com.example.demo.grokking.patterns.trees;

public class BinaryTree_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {

        return -1;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        t1.val = t1.val + t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    public static int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private static int sum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum += root.val;
        sum = sum(root.left, sum);
        sum = sum(root.right, sum);
        return sum;
    }

    public static TreeNode getNodeAndSubByVal(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = getNodeAndSubByVal(root.left, val);

        return left == null ? getNodeAndSubByVal(root.right, val) : left;

    }


}
