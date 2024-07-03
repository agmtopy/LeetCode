package com.agmtopt.leetcode.ag.old;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int element = Solution.majorityElement2(new int[]{2,2,1,1,1,2,2});
        System.out.println(element);
    }

    class Solution {
        public static int majorityElement(int[] nums) {
            int middleIndex = nums.length / 2;
            int temp = 0;

            if (nums.length == 1) {
                return nums[0];
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                    if (map.get(nums[i]) > middleIndex) {
                        temp = nums[i];
                        break;
                    }
                } else {
                    map.put(nums[i], 1);
                }
            }
            return temp;
        }

        /**
         * 同归于尽算法
         */
        public static int majorityElement2(int[] nums) {
            int temp = 0;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {

                if (count == 0) {
                    count++;
                    temp = nums[i];
                    continue;
                }

                if (temp == nums[i]) {
                    count++;
                    continue;
                }
                count--;
            }
            return temp;
        }
    }
}
