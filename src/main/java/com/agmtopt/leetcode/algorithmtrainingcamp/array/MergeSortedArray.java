package com.agmtopt.leetcode.algorithmtrainingcamp.array;

public class MergeSortedArray {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test4() {
        int[] nums1 = new int[]{0, 0, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};

        MergeSortedArraySolution solution = new MergeSortedArraySolution();
        solution.merge2(nums1, 0, nums2, 5);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static void test3() {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};

        MergeSortedArraySolution solution = new MergeSortedArraySolution();
        solution.merge2(nums1, 1, nums2, 1);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static void test2() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{2};

        MergeSortedArraySolution solution = new MergeSortedArraySolution();
        solution.merge2(nums1, 0, nums2, 1);
        for (int num : nums1) {
            System.out.print(num + ",");
            System.out.println();
        }
    }

    public static void test1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        MergeSortedArraySolution solution = new MergeSortedArraySolution();
        solution.merge2(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
}

class MergeSortedArraySolution {
    /**
     * 使用同一个数组nums1,倒叙进行处理
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if (n == 0) {
            return;
        }

        for (int i = m - 1; i >= -1; ) {
            for (int j = n - 1; j >= -1; ) {
                if (i + j == -2) {
                    return;
                }

                if (i == -1) {
                    nums1[j] = nums2[j];
                    j--;
                    continue;
                }

                if (j == -1) {
                    return;
                }

                if (nums2[j] >= nums1[i]) {
                    nums1[i + j + 1] = nums2[j];
                    j--;
                } else {
                    nums1[i + j + 1] = nums1[i];
                    i--;
                }
            }
        }
    }

    /**
     * 正序,采用新的一个数组来存放
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] target = new int[m + n];
        int mi = 0;
        int ni = 0;

        for (int i = 0; i < m + n; i++) {
            if (mi == m) {
                target[i] = nums2[ni];
                ni++;
                continue;
            }

            if (ni == n) {
                target[i] = nums1[mi];
                mi++;
                continue;
            }

            if (nums1[mi] <= nums2[ni]) {
                target[i] = nums1[mi];
                mi++;
                continue;
            }

            if (nums1[mi] > nums2[ni]) {
                target[i] = nums2[ni];
                ni++;
            }
        }

        // 赋值给nums1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = target[i];
        }
    }


    /**
     * 倒序,不增加新的索引的方式
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[p] = nums1[m-1];
                m--;
            } else {
                nums1[p] = nums2[n-1];
                n--;
            }
            p--;
        }
    }
}
