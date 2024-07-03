package com.agmtopt.leetcode.ag.old;

public class Leetcode_392 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        String s1 = "axc";
        String t1 = "ahbgdc";

        String s2 = "aaaaaa";
        String t2 = "bbaaaa";

        String s3 = "twn";
        String t3 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn";
        boolean a = new Leetcode_392_1().isIsomorphic(s, t);
        boolean b = new Leetcode_392_1().isIsomorphic(s1, t1);
        boolean c = new Leetcode_392_1().isIsomorphic(s2, t2);
        boolean d = new Leetcode_392_1().isIsomorphic(s3, t3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}

class Leetcode_392_1 {
    public boolean isIsomorphic(String s, String t) {
        int rIndex = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char aChar = chars[i];
            rIndex = t.indexOf(aChar);
            if(rIndex < 0){
                return false;
            }
            t = t.substring(rIndex+1);
        }
        return true;
    }
}
