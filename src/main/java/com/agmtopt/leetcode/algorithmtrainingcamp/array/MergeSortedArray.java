package com.agmtopt.leetcode.algorithmtrainingcamp.array;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        MergeSortedArraySolution solution = new MergeSortedArraySolution();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }
}

class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            nums1 = nums2;
            return;
        }

        if (n == 0) {
            return;
        }

        for (int i = m - 1; i >= 0; ) {
            for (int j = n - 1; j >= 0; ) {
                if (nums2[j] > nums1[i]) {
                    nums1[i + j + 1] = nums2[j];
                    j--;
                } else {
                    nums1[i + j + 1] = nums1[i];
                    i--;
                }
            }
        }
    }
}
