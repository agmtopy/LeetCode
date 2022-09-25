package com.agmtopt.leetcode;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_75_61 {

    public static void main(String[] args) {
        Node rootNode = getNode2();

        List<Integer> preorder = new Solution().preorder(rootNode);
        System.out.println(preorder);
    }

    private static Node getNode1() {
        Node childrenNodeB1 = new Node(5, null);
        Node childrenNodeB2 = new Node(6, null);

        Node childrenNodeA2 = new Node(3, Lists.newArrayList(childrenNodeB1,childrenNodeB2));
        Node childrenNodeA1 = new Node(2, null);
        Node childrenNodeA3 = new Node(4, null);

        Node rootNode = new Node(1, Lists.newArrayList(childrenNodeA2,childrenNodeA1,childrenNodeA3));
        return rootNode;
    }

    private static Node getNode2() {
        Node childrenNodeD14 = new Node(11, null);

        Node childrenNodeC11 = new Node(11, Lists.newArrayList(childrenNodeD14));
        Node childrenNodeC12 = new Node(12, null);
        Node childrenNodeC13 = new Node(13, null);

        Node childrenNodeB6 = new Node(6, null);
        Node childrenNodeB7 = new Node(7, Lists.newArrayList(childrenNodeC11));
        Node childrenNodeB8 = new Node(8, Lists.newArrayList(childrenNodeC12));
        Node childrenNodeB9 = new Node(9, Lists.newArrayList(childrenNodeC13));
        Node childrenNodeB10 = new Node(10, null);

        Node childrenNodeA2 = new Node(2, null);
        Node childrenNodeA3 = new Node(3, Lists.newArrayList(childrenNodeB6,childrenNodeB7));
        Node childrenNodeA4 = new Node(4, Lists.newArrayList(childrenNodeB8));
        Node childrenNodeA5 = new Node(5, Lists.newArrayList(childrenNodeB9,childrenNodeB10));

        Node rootNode = new Node(1, Lists.newArrayList(childrenNodeA2,childrenNodeA3,childrenNodeA4,childrenNodeA5));
        return rootNode;
    }

    static class Solution {
        //中序遍历转前序遍历
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            //1. 方法1 采用递归的方式来处理,因为前序遍历等于root + preorder(childrenNode1...)
            if (root.children == null) {
                return arrayList;
            }

            root.children.forEach(item -> arrayList.addAll(preorder(item)));
            return arrayList;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
