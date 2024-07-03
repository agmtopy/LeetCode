package com.agmtopt.leetcode.ag.old;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class WordSplitting {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Lists.newArrayList("leet","code");
        boolean b = Solution.wordBreak(s, wordDict);
        System.out.println(b);
    }

    class Solution {
        public static boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            HashSet<String> wordSet = new HashSet<>(wordDict);

            dp[0] = true;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    while (dp[j] && wordSet.contains(s.substring(j, i))) {
                    System.out.println("对比:" + s.substring(j, i) );
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

}
