package com.agmtopt.leetcode;

public class Leetcode_75_41 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices1 = new int[]{7,6,4,3,1};
        System.out.println(new Leetcode_75_41.Solution().maxProfit(prices1));
    }


    static class Solution {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            int min = prices[0];
            int max = 0;

            for (int i = 0; i < length; i++) {
                if (prices[i] - min > max) {
                    max = prices[i] - min;
                }
                if (min > prices[i]) {
                    min = prices[i];
                }
            }
            return max;
        }
    }
}
