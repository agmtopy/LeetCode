package com.agmtopt.leetcode.algorithmtrainingcamp.array;

import java.util.LinkedList;

public class PlusOne_66 {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test3() {
        PlusOne_66_Solution solution = new PlusOne_66_Solution();
        int[] result = solution.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
        System.out.println("result1:" + result);
    }

    public static void test2() {
        PlusOne_66_Solution solution = new PlusOne_66_Solution();
        int[] result = solution.plusOne(new int[]{9});
        System.out.println("result1:" + result);
    }

    public static void test1() {
        PlusOne_66_Solution solution = new PlusOne_66_Solution();
        int[] result = solution.plusOne(new int[]{1,2,3});
        System.out.println("result1:" + result);
    }
}


class PlusOne_66_Solution {

    public int[] plusOne(int[] digits) {
        LinkedList<Integer> rl = new LinkedList<>();

        int target = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (target>0  && digit == 9) {
                rl.add(0);
                continue;
            }
            rl.add(digit+target);
            target = 0;
        }

        if(target!=0){
            rl.add(target);
        }

        int[] result = new int[rl.size()];
        for (int i = rl.size() - 1; i >= 0; i--) {
            result[rl.size() - 1 - i] = rl.get(i);
        }
        return result;
    }

}
