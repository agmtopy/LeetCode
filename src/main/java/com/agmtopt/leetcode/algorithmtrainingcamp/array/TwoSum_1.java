package com.agmtopt.leetcode.algorithmtrainingcamp.array;

public class TwoSum_1 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TwoSum_1_Solution solution = new TwoSum_1_Solution();
//        int[] ints1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ints2 = solution.twoSum(new int[]{3,2,4}, 6);
    }

}

class TwoSum_1_Solution {
    public int[] twoSum(int[] nums, int target) {
        int minIndex = 0;
        int maxIndex = nums.length - 1;

        int[] result = new int[2];

        while (minIndex != maxIndex) {
            for (int i = minIndex + 1; i <= maxIndex; i++) {
                if (nums[minIndex] + nums[i] == target) {
                    result[0] = minIndex;
                    result[1] = i;

                    maxIndex = minIndex;
                    break;
                }
            }

            if (maxIndex != minIndex) {
                minIndex++;
            }
        }
        return result;
    }
}