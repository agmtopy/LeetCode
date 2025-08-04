package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import com.agmtopt.leetcode.algorithmtrainingcamp.tree.TreeNode;

public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] args) {
        TreeNode node1 = createTreeNode1();
        TreeNode node2 = createTreeNode2();

        MaximumDepthOfBinaryTree_104_Solution solution = new MaximumDepthOfBinaryTree_104_Solution();
        int depth = solution.maxDepth(node2);
        System.out.println("depth:" + depth);
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

class MaximumDepthOfBinaryTree_104_Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()))+1;
    }
}
