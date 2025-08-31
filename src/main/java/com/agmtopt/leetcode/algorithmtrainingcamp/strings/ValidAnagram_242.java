package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

import java.util.Arrays;

public class ValidAnagram_242 {

  public static void main(String[] args) {
    ValidAnagram_242_Solution solution = new ValidAnagram_242_Solution();
    String s1 = "anagram", t1 = "nagaram";

    boolean result = solution.isAnagram(s1, t1);
    System.out.println("result:" + result);
  }

}

class ValidAnagram_242_Solution {

  public boolean isAnagram(String s, String t) {

    if(s.length() != t.length()){
      return false;
    }

    String[] ss = s.split("");
    Arrays.sort(ss);

    String[] ts = t.split("");
    Arrays.sort(ts);

    int i = 0;
    while (i < s.length()) {
      if (ss[i].equals(ts[i])) {
        i++;
        continue;
      }
      return false;
    }

    return true;
  }
}
