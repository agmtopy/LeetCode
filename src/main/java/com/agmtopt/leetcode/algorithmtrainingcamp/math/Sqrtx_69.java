package com.agmtopt.leetcode.algorithmtrainingcamp.math;

public class Sqrtx_69 {

  public static void main(String[] args) {
    Sqrtx_69_Solution solution = new Sqrtx_69_Solution();
    int result = solution.mySqrt(2147395600);

    System.out.println("result:" + result);
  }

}

class Sqrtx_69_Solution {

  public int mySqrt(int x) {
    if (x == 1) {
      return x;
    }

    for (long i = 0; i <= x / 2; i++) {
      long j = i + 1;
      System.out.println("i:" + i);
      if (i * i <= x && j * j > x) {
        return (int) i;
      }
    }

    return 0;
  }
}
