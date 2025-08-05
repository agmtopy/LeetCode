package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

public class PowxN_50 {

    public static void main(String[] args) {
        PowxN_50_Solution solution = new PowxN_50_Solution();
        long startTime = System.nanoTime();
        double result = solution.myPow(0.00001, 2147483647);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;

        System.out.println("time:" + durationInNs + ",result:" + result);
    }

}

class PowxN_50_Solution {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                n = n+2;
            return 1 / myPow(x, -n);
        }

        double v = myPow(x, n / 2);
        if (n % 2 == 1)
            return x * v * v;
        return v * v;
    }
}
