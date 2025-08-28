package com.agmtopt.leetcode.algorithmtrainingcamp.strings;

public class JewelsAndStones_771 {

  public static void main(String[] args) {
    JewelsAndStones_771_Solution solution = new JewelsAndStones_771_Solution();

    String jewels = "aA", stones = "aAAbbbb";
    int i = solution.numJewelsInStones(jewels, stones);

    System.out.println("result:" + i);
  }

}

class JewelsAndStones_771_Solution {

  public int numJewelsInStones(String jewels, String stones) {

    int result = 0;
    for (String item : stones.split("")) {

      if (jewels.contains(item)) {
        result++;
      }
    }
    return result;
  }
}
