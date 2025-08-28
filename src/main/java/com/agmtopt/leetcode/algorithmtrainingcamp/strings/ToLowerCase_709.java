package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

public class ToLowerCase_709 {

  public static void main(String[] args) {
    String str = "LOVELY";

    ToLowerCase_709_Solution solution = new ToLowerCase_709_Solution();
    String result = solution.toLowerCase(str);

    System.out.println("result:" + result);
  }

}

class ToLowerCase_709_Solution {

  public String toLowerCase(String s) {
    StringBuffer sbf = new StringBuffer();

    for (char cr : s.toCharArray()) {
      if (cr > 64 && cr < 91) {
        cr = (char) (cr + 32);
      }
      sbf.append(cr);
    }

    return sbf.toString();
  }
}
