package com.agmtopt.leetcode.ag.old;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2 = {2, 5, 6};
        int n1 = 3;

        int[] nums11 = {0};
        int m11 = 0;
        int[] nums21 = {1};
        int n11 = 1;

        int[] nums13 = {4, 5, 6, 0, 0, 0};
        int m13 = 3;
        int[] nums23 = {1, 2, 3};
        int n13 = 3;


        Solution.majorityElement(nums1, m1, nums2, n1);

        Arrays.stream(nums1).forEach(System.out::println);
    }


    class Solution {
        public static void majorityElement(int[] nums1, int m, int[] nums2, int n) {
            int[] target = new int[m + n];

            int mi = 0;
            int ni = 0;

            for (int i = 0; i < target.length; i++) {
                if (mi < m && ni < n) {
                    if (nums1[mi] < nums2[ni]) {
                        target[i] = nums1[mi];
                        mi++;
                    } else {
                        target[i] = nums2[ni];
                        ni++;
                    }
                    continue;
                }

                if (mi == m) {
                    target[i] = nums2[ni];
                    ni++;
                    continue;
                }

                if (ni == n) {
                    target[i] = nums1[mi];
                    mi++;
                }
            }


            for (int i = 0; i < target.length; i++) {
                nums1[i] = target[i];
            }

        }
    }
}
