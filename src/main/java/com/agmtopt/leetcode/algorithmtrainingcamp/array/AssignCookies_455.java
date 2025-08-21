package com.agmtopt.leetcode.algorithmtrainingcamp.array;

import java.util.Arrays;

public class AssignCookies_455 {

  public static void main(String[] args) {
    AssignCookies_455_Solution solution = new AssignCookies_455_Solution();

    int[] g = new int[]{10, 9, 8, 7};
    int[] s = new int[]{5, 6, 7, 8};

    int result = solution.findContentChildren(g, s);

    System.out.println("result:" + result);
  }

}

class AssignCookies_455_Solution {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int result = 0;

    int j = 0;
    for (int i = 0; i < g.length; i++) {

      if (j >= s.length) {
        break;
      }

      do {
        if (s[j] >= g[i]) {
          result++;
          j++;
          break;
        }
        j++;
      } while (j < s.length);
    }

    return result;
  }

}

