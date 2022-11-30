package com.agmtopt.leetcode;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions/xah8k6/
 */
public class VerifyPalindrome {

    public static void main(String[] args) {
        String str = "0P";
        boolean b = Solution.majorityElement(str);
        System.out.println("flag :" + b);
    }


    class Solution {
        public static boolean majorityElement(String s) {
            //思路:使用双指针来解决这个问题

            int[] chars =
                    s.toLowerCase().codePoints().filter(item -> (item >= 97 && item <= 122) || item >= 48 && item <= 57).toArray();

            int i = 0;
            boolean flag = true;
            int j = chars.length - 1;
            while (i <= j) {
                if (chars[i] != chars[j]) {
                    flag = false;
                    break;
                }
                i++;
                j--;
            }

            return flag;
        }


        public static char[] processString(String str) {
            System.out.println(Integer.valueOf(str.toCharArray()[0]));
            return new char[]{};
        }

    }
}
