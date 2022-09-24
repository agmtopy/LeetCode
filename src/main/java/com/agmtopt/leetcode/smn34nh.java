package com.agmtopt.leetcode;

import java.util.Arrays;

public class smn34nh {
    public static void main(String[] args) {
        Arrays.asList(new Solution1().runningSum(new int[]{1, 2, 3, 4}))
                .forEach(i -> System.out.println(i));
    }
}

class Solution1 {
    public int[] runningSum(int[] nums) {
        int[] rs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                rs[i] = nums[0];
                continue;
            }
            rs[i] = rs[i - 1] + nums[i];
        }
        return rs;
    }
}