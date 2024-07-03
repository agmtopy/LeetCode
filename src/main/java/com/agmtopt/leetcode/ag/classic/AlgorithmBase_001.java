package com.agmtopt.leetcode.ag.classic;

/**
 * 第一题:2024.07.03
 * https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class AlgorithmBase_001 {

    /**
     * 测试算法基座
     **/
    public static void main(String[] args) {

    }

    /**
     * 合并算法
     * 思路一,采用插入算法,将num2中的元素插入到nums1中
     */
    class AlgorithmBase_001_Solution_01 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                for (int j = m-1; j > 0; j--) {
                    //如果num1数组中有元素大于num2中的元素,那么将num2中的元素插入num1中的该位置
                    if (nums1[j] > nums2[j]) {

                    }
                }

            }
        }
    }
}
