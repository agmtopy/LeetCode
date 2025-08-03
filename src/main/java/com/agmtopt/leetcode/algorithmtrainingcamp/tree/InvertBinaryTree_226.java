package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {
        InvertBinaryTree_226_Solution solution = new InvertBinaryTree_226_Solution();

        TreeNode node1 = createTree1();

        solution.invertTree(node1);
        System.out.println("result:" + JSON.toJSONString(node1));
    }

    private static TreeNode createTree1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);

        TreeNode node4 = new TreeNode(4, node2, node7);

        return node4;
    }
}


/**
 * 递归+tree结构
 */
class InvertBinaryTree_226_Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        if (root.left != null) invertTree(root.left);

        if (root.right != null) invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}