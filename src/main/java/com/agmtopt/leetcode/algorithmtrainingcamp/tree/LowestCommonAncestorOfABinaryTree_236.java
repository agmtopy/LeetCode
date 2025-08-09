package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTree_236 {

  public static void main(String[] args) {

    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);

    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2, node7, node4);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    TreeNode node5 = new TreeNode(5, node6, node2);
    TreeNode node1 = new TreeNode(1, node0, node8);

    TreeNode node3 = new TreeNode(3, node5, node1);

    LowestCommonAncestorOfABinaryTree_236_Solution solution = new LowestCommonAncestorOfABinaryTree_236_Solution();

    TreeNode node = solution.lowestCommonAncestor(node3, node5, node4);
    System.out.println("node:" + node.val);

  }

}

class LowestCommonAncestorOfABinaryTree_236_Solution {

  private Map<Integer, TreeNode> map = new HashMap<>();
  private Set<Integer> set = new HashSet<>();

  private void dfs(TreeNode root) {
    if (root.left != null) {
      map.put(root.left.getVal(), root);
      dfs(root.left);
    }

    if (root.right != null) {
      map.put(root.right.getVal(), root);
      dfs(root.right);
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root);

    while (p != null) {
      set.add(p.val);
      p = map.get(p.val);
    }

    while (q != null) {

      if (set.contains(q.val)) {
        return q;
      }
      q = map.get(q.val);
    }

    return null;
  }

}

/**
 * 内存超过限制
 */
class LowestCommonAncestorOfABinaryTree_236_Solution1 {

  private Map<TreeNode, List<Integer>> treeMap = new HashMap<>();
  private Map<Integer, TreeNode> valMap = new HashMap<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    recursion(root, new ArrayList<>(), p, q);

    List<Integer> pIndex = treeMap.get(p);
    List<Integer> qIndex = treeMap.get(q);

    int lastEqualIndex = -1; // -1 表示没有相等的元素
    for (int i = 0; i < Math.min(qIndex.size(), pIndex.size()); i++) {
      if (qIndex.get(i).equals(pIndex.get(i))) {
        lastEqualIndex = i;
      } else {
        // 一旦不相等就结束
        break;
      }
    }
    return valMap.get(qIndex.get(lastEqualIndex));
  }

  public void recursion(TreeNode root, List<Integer> indexValue, TreeNode p, TreeNode q) {
    if (root == null) {
      return;
    }

    //1. 处理当前root节点
    indexValue.add(root.val);
    valMap.put(root.val, root);
    if (root == p || root == q) {
      treeMap.put(root, indexValue);
    }

    if (treeMap.containsKey(p) && treeMap.containsKey(q)) {
      return;
    }

    //2. 处理left节点
    this.recursion(root.left, new ArrayList<>(indexValue), p, q);

    //3. 处理right节点
    this.recursion(root.right, new ArrayList<>(indexValue), p, q);
  }

}