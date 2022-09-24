package com.agmtopt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_75 {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";

        String s1 = "bbbaaaba";
        String t1 = "aaabbbba";

        String s2 = "egg";
        String t2 = "add";
        boolean b = new Leetcode_751().isIsomorphic(s1, t1);
        System.out.println(b);
    }
}

class Leetcode_751 {
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if(preIndexOfs[chars[i]] != preIndexOft[chart[i]]){
                return false;
            }
            preIndexOfs[chars[i]] = i+1;
            preIndexOft[chart[i]] = i+1;
        }
        return true;
    }
}
