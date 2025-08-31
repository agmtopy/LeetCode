package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseString2_541 {

  public static void main(String[] args) {
    ReverseString2_541_Solution solution = new ReverseString2_541_Solution();

    String s1 = "abcdefg";
    Integer k1 = 2;

    String s2 = "abcd";
    Integer k2 = 2;

    String result = solution.reverseStr(s2, k2);
    System.out.println("result:" + result);
  }

}

class ReverseString2_541_Solution {

  public String reverseStr(String s, int k) {
    List<String> result = new ArrayList<>();
    int length = s.length();
    for (int i = 0; i < length; i += 2 * k) {
      int end = Math.min(i + 2 * k, length);
      result.add(s.substring(i, end));
    }

    StringBuffer sbf = new StringBuffer();
    result.forEach(item -> {
      char[] array = item.toCharArray();
      doReverseString(array, k);
      sbf.append(array);
    });

    return sbf.toString();
  }

  public void doReverseString(char[] s, int k) {
    int left = 0;
    int right = Math.min(s.length, k) - 1;

    while (left <= right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;

      left++;
      right--;
    }
  }
}
