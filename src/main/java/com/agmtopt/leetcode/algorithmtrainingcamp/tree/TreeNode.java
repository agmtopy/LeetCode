package com.agmtopt.leetcode.algorithmtrainingcamp.tree;

import lombok.ToString;

@ToString
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return this.val;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TreeNode)) return false;
        final TreeNode other = (TreeNode) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getVal() != other.getVal()) return false;
        final Object this$left = this.getLeft();
        final Object other$left = other.getLeft();
        if (this$left == null ? other$left != null : !this$left.equals(other$left)) return false;
        final Object this$right = this.getRight();
        final Object other$right = other.getRight();
        if (this$right == null ? other$right != null : !this$right.equals(other$right)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TreeNode;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getVal();
        final Object $left = this.getLeft();
        result = result * PRIME + ($left == null ? 43 : $left.hashCode());
        final Object $right = this.getRight();
        result = result * PRIME + ($right == null ? 43 : $right.hashCode());
        return result;
    }
}