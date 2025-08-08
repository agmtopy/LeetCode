package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

}

class ConstructBinaryTreeFromPreorderAndInorderTraversal_105_Solution {

  private Map<Integer, Integer> inorderMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    int size = inorder.length;

    for (int i = 0; i < size; i++) {
      inorderMap.put(inorder[i], i);
    }

    return recursion(preorder, inorder, 0, size - 1, 0, size - 1);
  }

  public TreeNode recursion(int[] preOrder, int[] inOrder, int pre_left, int pre_right, int in_left,
      int in_right) {
    if (pre_right < pre_left) {
      return null;
    }

    //1. 构建根节点
    int rootVal = preOrder[pre_left];
    TreeNode rootNode = new TreeNode(rootVal);

    //2. 寻找根节点在中序遍历中的位置
    Integer root_in_index = inorderMap.get(rootVal);

    //3. 计算左子树的节点数量
    int leftSize = root_in_index - in_left;

    //4. 构建左子树
    rootNode.left = recursion(preOrder, inOrder, pre_left + 1, pre_left + leftSize, in_left,
        root_in_index - 1
    );

    //5. 构建右子树
    rootNode.right = recursion(preOrder, inOrder, pre_left + leftSize + 1, pre_right,
        root_in_index + 1,
        in_right);

    //6. 返回
    return rootNode;
  }

}
