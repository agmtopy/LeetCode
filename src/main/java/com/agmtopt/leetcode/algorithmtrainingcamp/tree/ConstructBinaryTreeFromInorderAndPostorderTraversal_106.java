package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import com.alibaba.fastjson2.JSON;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {

  public static void main(String[] args) {
    int[] inorder = new int[]{9, 3, 15, 20, 7};
    int[] postorder = new int[]{9, 15, 7, 20, 3};

    ConstructBinaryTreeFromInorderAndPostorderTraversal_106_Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal_106_Solution();
    TreeNode node = solution.buildTree(inorder, postorder);

    System.out.println(JSON.toJSONString(node));
  }

}

class ConstructBinaryTreeFromInorderAndPostorderTraversal_106_Solution {

  private Map<Integer, Integer> inOrderMap = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Integer size = inorder.length;
    for (int i = 0; i < size; i++) {
      inOrderMap.put(inorder[i], i);
    }

    return recursion(postorder, postorder, 0, size - 1, 0, size - 1);
  }

  public TreeNode recursion(int[] postOrder, int[] inOrder, int post_left, int post_right,
      int in_left, int in_right) {

    if (post_right < post_left || in_right < in_left) {
      return null;
    }

    //1. 获取root节点
    int rootVal = postOrder[post_right];
    TreeNode rootNode = new TreeNode(rootVal);

    //2. 寻找根节点在中序数组中的位置
    Integer root_in_index = inOrderMap.get(rootVal);

    //3. 计算左子树的节点数量
    Integer leftSize = root_in_index - in_left;

    //4. 寻找左节点
    rootNode.left = recursion(postOrder, inOrder, post_left, post_left + leftSize - 1, in_left,
        root_in_index - 1);

    //5. 寻找右节点
    rootNode.right = recursion(postOrder, inOrder, post_left + leftSize, post_right - 1,
        root_in_index + 1, in_right);

    return rootNode;
  }
}