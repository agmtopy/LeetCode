package com.agmtopt.leetcode.ag.old;

public class Leetcode_75_72 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    // 简单二分查找
    public static int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }

        int lindex = 0;
        int rindex = n;
        int mid = n / 2;

        while (lindex <= rindex) {
            if (isBadVersion(mid) ^ isBadVersion(mid + 1)) {
                return mid+1;
            }

            if (isBadVersion(mid)) {
                rindex = mid - 1;
            }

            if (!isBadVersion(mid)) {
                lindex = mid + 1;
            }
            mid = (rindex -lindex)/2 +lindex;
        }

        return -1;
    }

    public static boolean isBadVersion(int version) {
        return version > 3;
    }
}
