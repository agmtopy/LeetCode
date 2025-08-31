package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

public class ReverseString3_557 {

  public static void main(String[] args) {
    String str1 = "Let's take LeetCode contest";

    ReverseString3_557_Solution solution = new ReverseString3_557_Solution();
    String result = solution.reverseWords(str1);

    System.out.println("result:" + result);
  }
}

class ReverseString3_557_Solution {

  public String reverseWords(String s) {
    String[] split = s.split(" ");

    StringBuffer sbf = new StringBuffer();
    for (int i = 0; i < split.length; i++) {
      String str = split[i];
      sbf.append(doReverseWords(str.toCharArray()));
      if (i != split.length - 1) {
        sbf.append(" ");
      }
    }

    return sbf.toString();
  }

  public char[] doReverseWords(char[] cas) {
    int left = 0;
    int right = cas.length - 1;

    while (left <= right) {
      char temp = cas[left];
      cas[left] = cas[right];
      cas[right] = temp;

      left++;
      right--;
    }
    return cas;
  }
}
