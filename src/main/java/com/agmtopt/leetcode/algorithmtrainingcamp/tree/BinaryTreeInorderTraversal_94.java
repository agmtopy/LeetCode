package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历指的是:先访问左节点 -> 中间节点  -> 右节点
 */
public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {
        TreeNode node1 = createTreeNode1();
        TreeNode node2 = createTreeNode2();

        BinaryTreeInorderTraversal_94_Solution solution = new BinaryTreeInorderTraversal_94_Solution();
        List<Integer> result = solution.inorderTraversal(node2);
        System.out.println("result:" + result);
    }

    private static TreeNode createTreeNode1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        return node1;
    }

    private static TreeNode createTreeNode2() {
        TreeNode node1 = new TreeNode(1, null, null);
        return node1;
    }

}

class BinaryTreeInorderTraversal_94_Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        this.recursion(root, rs);
        return rs;
    }

    public void recursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        recursion(root.getLeft(), result);
        result.add(root.val);
        recursion(root.getRight(), result);
    }
}
