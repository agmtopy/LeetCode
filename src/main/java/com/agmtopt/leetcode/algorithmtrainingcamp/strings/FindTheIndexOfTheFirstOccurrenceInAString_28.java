package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

public class FindTheIndexOfTheFirstOccurrenceInAString_28 {

  public static void main(String[] args) {
    String haystack = "sadbutsad", needle = "sad";
    String haystack1 = "leetcode", needle1 = "leeto";
    String haystack2 = "hello", needle2 = "ll";

    FindTheIndexOfTheFirstOccurrenceInAString_28_Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString_28_Solution();
    int result = solution.strStr(haystack2, needle2);

    System.out.println("result:" + result);
  }

}

class FindTheIndexOfTheFirstOccurrenceInAString_28_Solution {

  public int strStr(String haystack, String needle) {
    int index = -1;

    for (int i = 0; i < haystack.length(); i++) {
      if (i + needle.length() > haystack.length()) {
        break;
      }

      String str = haystack.substring(i, i+needle.length());
      if (str.equals(needle)) {
        index = i;
        break;
      }
    }

    return index;
  }
}