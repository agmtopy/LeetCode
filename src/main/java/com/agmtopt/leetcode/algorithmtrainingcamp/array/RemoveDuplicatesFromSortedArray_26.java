package com.agmtopt.leetcode.algorithmtrainingcamp.array;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test2() {
        int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArray_26_Solution solution = new RemoveDuplicatesFromSortedArray_26_Solution();
        int i = solution.removeDuplicates1(nums1);
        System.out.println("返回数组长度:" + i + ",");
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }


    public static void test1() {
        int[] nums1 = new int[]{1, 1, 2};
        RemoveDuplicatesFromSortedArray_26_Solution solution = new RemoveDuplicatesFromSortedArray_26_Solution();
        int i = solution.removeDuplicates1(nums1);
        System.out.println("返回数组长度:" + i + ",");
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
}

class RemoveDuplicatesFromSortedArray_26_Solution {

    /**
     * 采用双指针的方式进行处理
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while (j != nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j++];
                i++;
            } else {
                nums[i] = nums[j++];
            }
        }
        return i + 1;
    }

    /**
     * 采用遍历数组加维护唯一值的位置的方法
     */
    public int removeDuplicates1(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[ptr]) {
                nums[ptr + 1] = nums[i];
                ptr++;
            }
        }
        return ptr + 1;
    }
}
