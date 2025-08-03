package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_ii_047 {

    public static void main(String[] args) {
        Permutations_ii_047_Solution solution = new Permutations_ii_047_Solution();

        int[] params = new int[]{1, 2, 3};
        int[] params1 = new int[]{0, 1};
        int[] params2 = new int[]{1};

        List<List<Integer>> rs = solution.permuteUnique(params);
        System.out.println("result:" + rs);
    }

}

class Permutations_ii_047_Solution {

    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> tempRs = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        subMethod(nums, rs, 0, tempRs);
        return rs;
    }


    private void subMethod(int[] nums, List<List<Integer>> rs, int index, List<Integer> tempRs) {
        if (nums.length == index) {
            rs.add(new ArrayList<>(tempRs));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //该元素已被使用过,直接返回
            if (vis[i]) continue;
            //重复元素并且已被使用过,直接返回
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue;

            tempRs.add(nums[i]);
            vis[i] = true;
            subMethod(nums, rs, index + 1, tempRs);

            //剪枝
            vis[i] = false;
            tempRs.remove(index);
        }
    }

}
