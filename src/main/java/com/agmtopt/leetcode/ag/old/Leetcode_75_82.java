package com.agmtopt.leetcode.ag.old;

import org.jetbrains.annotations.NotNull;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.DelayQueue;

public class Leetcode_75_82 {

    public static void main(String[] args) {
        System.out.println();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getList(root, p);
        List<TreeNode> path_q = getList(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getList(TreeNode root, TreeNode target) {
        List<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != target) {
            deque.add(node);
            if (node.val < target.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        deque.add(node);
        return deque;
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
