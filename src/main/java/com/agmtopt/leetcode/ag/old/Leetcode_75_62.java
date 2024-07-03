package com.agmtopt.leetcode.ag.old;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_75_62 {

    public static void main(String[] args) {

    }
    static class Solution {
        //中序遍历转前序遍历
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            if (root == null) {
                return ret;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<Integer>();

                for (int i = 1; i < queue.size(); i++) {
                    TreeNode poll = queue.poll();
                    level.add(poll.val);

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }

                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                ret.add(level);
            }
            return ret;
        }
    }

    public class TreeNode {
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
