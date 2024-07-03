package com.agmtopt.leetcode.ag.old;

public class TopInterviewQuestion {


    public static void main(String[] args) {
        int number = Solution.singleNumber(new int[]{1, 2, 3,4,9, 4, 3, 2, 1});
        System.out.println(number);
    }


    class Solution {
        public static int singleNumber(int[] nums) {
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp ^= nums[i];
            }
            return temp;

        }
    }
}
