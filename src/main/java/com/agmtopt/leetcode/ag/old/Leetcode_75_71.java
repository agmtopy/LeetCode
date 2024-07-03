package com.agmtopt.leetcode.ag.old;

import java.util.*;

public class Leetcode_75_71 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 1;
        System.out.println(search(nums, target));
    }

    // 简单二分查找
    public static int search(int[] nums, int target) {
        if (nums == null || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        if (1 == nums.length && target == nums[0]) {
            return 0;
        }

        int lIndex = 0;
        int rIndex = nums.length - 1;
        int medianIndex = nums.length / 2;

        while (lIndex <= rIndex) {
            if (nums[medianIndex] == target) {
                return medianIndex;
            }

            if (target < nums[medianIndex]) {
                rIndex = medianIndex -1;
            }

            if (target > nums[medianIndex]) {
                lIndex = medianIndex +1;
            }
            medianIndex =  (rIndex - lIndex) / 2 + lIndex;
        }
        return -1;
    }
}
