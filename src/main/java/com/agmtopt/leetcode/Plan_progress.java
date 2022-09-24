package com.agmtopt.leetcode;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Plan_progress {

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,-1,0,1,1,0};
        int[] nums2 = new int[]{2,1,-1};
        int[] nums3 = new int[]{1, 7, 3, 6, 5, 6};
        int index = new Solution2().pivotIndex(nums1);
        System.out.println(index);
    }

}

class Solution2 {
    public int pivotIndex(int[] nums) {
        Integer lrs = 0;
        Integer rrs = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
        if (rrs -nums[0]  == 0) {
            return 0;
        }
//        rrs = rrs - nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            lrs += nums[i - 1];
            if (lrs.equals(rrs - nums[i] - lrs)) {
                return i;
            }
        }
        return -1;
    }
}
