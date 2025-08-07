package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NAryTreeLevelOrderTraversal_429 {

    public static void main(String[] args) {
        Node root1 = createNode1();

        NAryTreeLevelOrderTraversal_429_Solution solution = new NAryTreeLevelOrderTraversal_429_Solution();
        List<List<Integer>> rs = solution.levelOrder(root1);

        System.out.println("result:" + rs);
    }

    private static Node createNode1() {
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node3 = new Node(3, Lists.newArrayList(node5,node6));
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node node1 = new Node(1,Lists.newArrayList(node3,node2,node4));

        return node1;
    }

}

class NAryTreeLevelOrderTraversal_429_Solution {

    public List<List<Integer>> levelOrder(Node root) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        recursion(root, 0, hashMap);
        return new ArrayList<>(hashMap.values());
    }

    public void recursion(Node root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) return;

        //处理当前深度的节点
        List<Integer> value = map.getOrDefault(level, new ArrayList<Integer>());
        value.add(root.val);
        map.put(level, value);

        if(root.children == null) return;
        root.children.forEach(item -> recursion(item, level + 1, map));
    }

}
