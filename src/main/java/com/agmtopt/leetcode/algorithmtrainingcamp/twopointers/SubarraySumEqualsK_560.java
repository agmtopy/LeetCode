package com.agmtopt.leetcode.algorithmtrainingcamp.twopointers;

public class SubarraySumEqualsK_560 {

    public static void main(String[] args) {
        SubarraySumEqualsK_560_Solution solution = new SubarraySumEqualsK_560_Solution();

        int[] nums = new int[]{1, 1, 1};
        int k = 2;

        int[] nums1 = new int[]{1, 1, 1};
        int k1 = 2;

        int sum = solution.subarraySum(nums1, k1);
        System.out.println("result:" + sum);
    }

}


/**
 * 求等和数组,在根据等和数组相减
 */
class SubarraySumEqualsK_560_Solution {

    public int subarraySum(int[] nums, int k) {

        int[] targers = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            targers[i + 1] = targers[i] + nums[i];
        }

        int rs = 0;
        for (int i = targers.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (targers[i] - targers[j] == k) {
                    rs++;
                }
            }
        }
        return rs;
    }
}