package com.agmtopt.leetcode.ag.old;

import org.jetbrains.annotations.NotNull;

public class Leetcode_75_81 {

    public static void main(String[] args) {
        TreeNode t2 = getTreeNode5();
        boolean validBST = isValidBST(t2);
        System.out.println(validBST);
    }

    @NotNull
    private static TreeNode getTreeNode5() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6, t3, t7);
        TreeNode t5 = new TreeNode(5, t4, t6);
        return t5;
    }


    @NotNull
    private static TreeNode getTreeNode4() {
        TreeNode t1 = new TreeNode(-1);
        TreeNode t2 = new TreeNode(2, t1, null);
        return t2;
    }


    @NotNull
    private static TreeNode getTreeNode3() {
        TreeNode t1 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2, t1, t3);
        return t2;
    }

    @NotNull
    private static TreeNode getTreeNode1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(3, t1, t3);
        return t2;
    }


    @NotNull
    private static TreeNode getTreeNode2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(3, t3, t6);
        TreeNode t2 = new TreeNode(5, t1, t4);
        return t2;
    }


    // 简单二分查找
    public static boolean isValidBST(TreeNode root) {
        return doIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean doIsValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return doIsValidBST(root.left, lower, root.val) && doIsValidBST(root.right, root.val, upper);
    }


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
}
