package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] nums1 = new int[]{0};

        Subsets_78_Solution solution = new Subsets_78_Solution();
        List<List<Integer>> subsets = solution.subsets(nums1);
        System.out.println("subsets:" + JSON.toJSONString(subsets));
    }

}


class Subsets_78_Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();

        if (nums.length == 1) {
            rs.add(new ArrayList<>(1));
            ArrayList<Integer> item = new ArrayList<>(1);
            item.add(nums[0]);
            rs.add(item);
            return rs;
        }

        int[] copyOfArrays = Arrays.copyOfRange(nums, 1, nums.length);
        List<List<Integer>> subResult = new Subsets_78_Solution().subsets(copyOfArrays);

        int item = nums[0];
        for (List<Integer> subItem : subResult) {
            rs.add(subItem);
            List<Integer> subItem2 =  new ArrayList<>(subItem);
            subItem2.add(item);
            rs.add(subItem2);
        }
        return rs;
    }
}
