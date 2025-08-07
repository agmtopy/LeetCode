package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  @TODO 解不出来
 */
public class SerializeAndDeserializeBinaryTree_297 {

    public static void main(String[] args) {

        TreeNode node1 = createTreeNode1();

        SerializeAndDeserializeBinaryTree_297_Solution solution = new SerializeAndDeserializeBinaryTree_297_Solution();
        String result = solution.serialize(node1);

        System.out.println("result:" + result);
    }

    private static TreeNode createTreeNode1() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        TreeNode treeNode3 = new TreeNode(3, treeNode4, treeNode5);

        TreeNode treeNode2 = new TreeNode(2);

        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        return treeNode1;
    }


}

class SerializeAndDeserializeBinaryTree_297_Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<String> result = new ArrayList<>();
        recursionEncodes(root, result);

        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;

        List<String> list = Arrays.asList(data.split(","));
        if(list.size()==0) return null;

        TreeNode curNode = new TreeNode(Integer.valueOf(list.get(0)));
        TreeNode left = null;
        TreeNode right = null;

        String preNode = "x";

        for (int i = 1; i < list.size(); i++) {


            list.get(i);

            curNode.left = left;
            curNode.right = right;




        }
        return null;
    }

    //递归解析
    public void recursionEncodes(TreeNode root, List<String> result) {
        if (root == null) return;

        result.add(String.valueOf(root.val));

        if (root.left == null) result.add(null);
        recursionEncodes(root.left, result);

        if (root.right == null) result.add(null);
        recursionEncodes(root.right, result);
    }

}
