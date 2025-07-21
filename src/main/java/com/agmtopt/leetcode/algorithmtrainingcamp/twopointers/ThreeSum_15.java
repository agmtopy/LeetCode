package com.agmtopt.leetcode.algorithmtrainingcamp.twopointers;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        ThreeSum_15_Solution solution = new ThreeSum_15_Solution();

        int[] bookings = new int[]{2, 7, 11, 15};
        int[] bookings1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] bookings2 = new int[]{0, 0, 0};
        int[] bookings3 = new int[]{0, 0, 0, 0};
        int[] bookings4 = new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10};
        int[] bookings5 = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> result = solution.threeSum(bookings5);
        System.out.println(JSON.toJSONString(result));
    }
}


class ThreeSum_15_Solution {

    /**
     * 简化为target不固定的两数之和问题..
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //对数组进行排序
        Arrays.sort(nums);

        int size = nums.length;
        for (int i = 0; i < size; i++) {

            //如果nums[i] > 0,说明后面的元素都大于0,不可能在出现num[i]+num[i+x]+num[i+y]大于零的场景处理
            if (nums[i] > 0) {
                return result;
            }

            //目标相同的数组进行跳过/排除
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lIndex = i + 1;
            int rIndex = size - 1;

            while (lIndex < rIndex) {
                int target = nums[lIndex] + nums[rIndex] + nums[i];
                if (target == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[lIndex]);
                    item.add(nums[rIndex]);
                    result.add(item);

                    while (lIndex<rIndex && nums[lIndex] == nums[lIndex+1]) lIndex++;
                    while (lIndex<rIndex && nums[rIndex-1] == nums[rIndex]) rIndex--;
                    lIndex++;
                    rIndex--;
                }

                if (target < 0) {
                    lIndex++;
                }

                if (target > 0) {
                    rIndex--;
                }
            }
        }
        return result;
    }
}