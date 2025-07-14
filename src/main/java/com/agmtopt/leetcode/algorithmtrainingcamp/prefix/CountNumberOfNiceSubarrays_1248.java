package com.agmtopt.leetcode.algorithmtrainingcamp.prefix;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays_1248 {

    public static void main(String[] args) {
        CountNumberOfNiceSubarrays_1248_Solution sol = new CountNumberOfNiceSubarrays_1248_Solution();

        // 示例 1
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 2;
        System.out.println("Input: nums = [1,1,2,1,1], k = 3");
        System.out.println("Output: " + sol.numberOfSubarrays(nums1, k1)); // 预期输出: 2
//
//        // 示例 2
//        int[] nums2 = {2, 4, 6};
//        int k2 = 1;
//        System.out.println("Input: nums = [2,4,6], k = 1");
//        System.out.println("Output: " + sol.numberOfSubarrays(nums2, k2)); // 预期输出: 0
//
//        // 示例 3
//        int[] nums3 = {1, 2, 3, 4, 5};
//        int k3 = 2;
//        System.out.println("Input: nums = [1,2,3,4,5], k = 2");
//        System.out.println("Output: " + sol.numberOfSubarrays(nums3, k3)); // 预期输出: 4 ([1,2,3],[1,2,3,4],[2,3,4,5],[3,4,5])

    }

}

class CountNumberOfNiceSubarrays_1248_Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {

            if (num % 2 == 1) {
                currentSum++;
            }

            if (freq.containsKey(currentSum - k)) {
                count += freq.get(currentSum - k);
            }

            freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}

