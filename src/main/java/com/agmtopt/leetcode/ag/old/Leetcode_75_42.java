package com.agmtopt.leetcode.ag.old;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_75_42 {

    public static void main(String[] args) {
        String s0 = "abccccdd";
        String s1 = "a";
        String s2 = "bb";
        System.out.println(new Leetcode_75_42.Solution().longestPalindrome(s0));
    }


    static class Solution {
        public int longestPalindrome(String s) {
            if (s == null) {
                return 0;
            }

            if (s.length() == 1) {
                return 1;
            }

            Map<Character, Integer> map = new HashMap<>();

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    map.put(chars[i], map.get(chars[i]) + 1);
                } else {
                    map.put(chars[i], 1);
                }
            }

            final int[] ototal = {map.values().stream().filter(i -> i % 2 == 0).mapToInt(i -> i).sum(), 0};

            map.values().stream().filter(i -> i % 2 == 1).forEach(i -> {
                ototal[0] = ototal[0] + i - 1;
                ototal[1] = 1;
            });
            return ototal[0] + ototal[1];
        }
    }
}
