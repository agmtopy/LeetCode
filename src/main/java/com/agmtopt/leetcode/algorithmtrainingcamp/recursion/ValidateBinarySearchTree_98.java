package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import com.agmtopt.leetcode.algorithmtrainingcamp.tree.TreeNode;

public class ValidateBinarySearchTree_98 {

    public static void main(String[] args) {
        TreeNode node1 = createTreeNode1();
        TreeNode node2 = createTreeNode2();

        ValidateBinarySearchTree_98_Solution solution = new ValidateBinarySearchTree_98_Solution();
        boolean validBST = solution.isValidBST(node2);
        System.out.println("validBST:" + validBST);
    }

    private static TreeNode createTreeNode1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node1, node3);
        return node2;
    }

    private static TreeNode createTreeNode2() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node3, node6);

        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5, node1, node4);
        return node5;
    }
}

class ValidateBinarySearchTree_98_Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTWithScope(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean isValidBSTWithScope(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (root.getVal() < min || root.getVal() > max) return false;
        return isValidBSTWithScope(root.getLeft(), min, root.getVal()) && isValidBSTWithScope(root.getRight(), root.getVal(), max);
    }

}
