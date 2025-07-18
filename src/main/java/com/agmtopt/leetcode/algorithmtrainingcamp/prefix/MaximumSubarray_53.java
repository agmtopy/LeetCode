package com.agmtopt.leetcode.algorithmtrainingcamp.prefix;

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        MaximumSubarray_53__Solution solution = new MaximumSubarray_53__Solution();

        int[] bookings = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(bookings);
        System.out.println(result);
    }
}

class MaximumSubarray_53__Solution {
    public int maxSubArray(int[] nums) {
        //1. 计算前缀和
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int maxRs = Integer.MIN_VALUE ;
        int minRs = Integer.MAX_VALUE;

        for (int i = 0; i < prefix.length; i++) {
            maxRs = Math.max(maxRs,prefix[i] - minRs);
            minRs = Math.min(minRs,prefix[i]);
        }

        return maxRs;
    }
}
