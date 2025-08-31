package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

public class ReverseOnlyLetters_917 {

  public static void main(String[] args) {
    ReverseOnlyLetters_917_Solution solution = new ReverseOnlyLetters_917_Solution();

    String s1 = "ab-cd";
    String s2 = "Test1ng-Leet=code-Q!";

    String result = solution.reverseOnlyLetters(s2);
    System.out.println("result:" + result);

  }

}

class ReverseOnlyLetters_917_Solution {

  public String reverseOnlyLetters(String s) {
    int left = 0;
    int right = s.length() - 1;

    char[] array = s.toCharArray();

    while (left <= right) {
      char cL = array[left];
      char cR = array[right];

      if (!isElLet(cL)) {
        left++;
        continue;
      }

      if (!isElLet(cR)) {
        right--;
        continue;
      }

      array[left] = cR;
      array[right] = cL;
      left++;
      right--;
    }

    return String.valueOf(array);
  }

  private boolean isElLet(char c) {
    if (c >= 'a' && c <= 'z') {
      return true;
    }

    if (c >= 'A' && c <= 'Z') {
      return true;
    }

    return false;
  }

}
