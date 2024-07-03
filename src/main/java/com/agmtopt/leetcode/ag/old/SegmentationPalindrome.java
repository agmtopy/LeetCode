package com.agmtopt.leetcode.ag.old;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分割回文串
 */
public class SegmentationPalindrome {

        public static void main(String[] args) {
            Solution.partition("");
        }


        class Solution {
            public static List<List<String>> partition(String s) {
                String[] split = s.split("");

                Map<String, Long> collect = Arrays.asList(split).stream().collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));

                return null;

            }
        }
}
