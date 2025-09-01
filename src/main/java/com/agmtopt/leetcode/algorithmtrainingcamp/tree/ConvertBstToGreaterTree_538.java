package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

public class ConvertBstToGreaterTree_538 {

}

class ConvertBstToGreaterTree_538_Solution {
  int s = 0;
  public TreeNode convertBST(TreeNode root) {
    dfs(root);
    return root;
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }

    //先递归右子树
    dfs(node.right);
    // 右子树已经得到累加的s值,此时累加中间这个元素
    s = s+ node.val;
    node.val = s;
    //最后递归左子树
    dfs(node.left);
  }
}
