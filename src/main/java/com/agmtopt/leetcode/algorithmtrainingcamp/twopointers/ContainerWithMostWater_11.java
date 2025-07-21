package com.agmtopt.leetcode.algorithmtrainingcamp.twopointers;

public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        ContainerWithMostWater_11_Solution solution = new ContainerWithMostWater_11_Solution();

        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums1 = new int[]{1, 1};

        int i = solution.maxArea(nums);
        System.out.println("result:" + i);

    }

}

class ContainerWithMostWater_11_Solution {


    public int maxArea(int[] height) {
        int max = 0;

        int lIndex = 0;
        int rIndex = height.length - 1;

        while (lIndex < rIndex) {
            int temp = Math.min(height[lIndex], height[rIndex]) * (rIndex - lIndex);
            max = Math.max(max, temp);

            if (height[lIndex] > height[rIndex]) {
                rIndex--;
                continue;
            }
            lIndex++;
        }


        return max;
    }


    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int rIndex = height.length - 1;
            while (i < rIndex) {
                int temp = Math.min(height[i], height[rIndex]) * (rIndex - i);
                if (temp > max) {
                    max = temp;
                }
                rIndex--;
            }
        }


        return max;
    }
}
