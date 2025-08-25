package com.agmtopt.leetcode.algorithmtrainingcamp.math;

public class ClimbingStairs_70 {

}

class ClimbingStairs_70_Solution {

  public int climbStairs(int n) {
    int p, q = 0, r = 1;
    for (int i = 0; i < n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
