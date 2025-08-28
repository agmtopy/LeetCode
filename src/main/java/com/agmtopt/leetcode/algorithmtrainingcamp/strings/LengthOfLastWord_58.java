package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

public class LengthOfLastWord_58 {

  public static void main(String[] args) {
    String s1 = "Hello World";
    String s2 = "   fly me   to   the moon  ";
    String s3 = "luffy is still joyboy";

    LengthOfLastWord_58_Solution solution = new LengthOfLastWord_58_Solution();
    int result = solution.lengthOfLastWord(s3);

    System.out.println("result:" + result);
  }

}

class LengthOfLastWord_58_Solution {

  public int lengthOfLastWord(String s) {
    //返回0
    if (s == null || s.length() == 0) {
      return 0;
    }

    String[] split = s.split(" ");
    return split[split.length-1].length();
  }
}
