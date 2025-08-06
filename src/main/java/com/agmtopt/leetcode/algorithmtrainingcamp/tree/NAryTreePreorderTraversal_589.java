package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal_589 {

    public static void main(String[] args) {
        Node node0 = createNode0();

        NAryTreePreorderTraversal_589_Solution solution = new NAryTreePreorderTraversal_589_Solution();
        List<Integer> result = solution.preorder(node0);

        System.out.println("result:" + result);

    }

    private static Node createNode0() {
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node3 = new Node(3, Lists.newArrayList(node5, node6));

        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node node1 = new Node(1, Lists.newArrayList(node3, node2, node4));
        return node1;
    }

}

class NAryTreePreorderTraversal_589_Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public void recursion(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);

        if (root.children == null) return;
        root.children.forEach(item -> recursion(item, result));
    }
}
