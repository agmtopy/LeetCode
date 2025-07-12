package com.agmtopt.leetcode.algorithmtrainingcamp.stack;

import java.util.LinkedList;

public class BasicCalculator_224 {


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String str1 = "1 + 1";
        String str2 = " 2-1 + 2 ";
        String str3 = "(1+(4+5+2)-3)+(6+8)";
        String str4 = "1-(     -2)";
        String str5 = "-2+ 1";
        BasicCalculator_224_Solution solution = new BasicCalculator_224_Solution();


        int result1 = solution.calculate(str1);
        System.out.println("result1:" + result1);

        int result2 = solution.calculate(str2);
        System.out.println("result2:" + result2);

        int result3 = solution.calculate(str3);
        System.out.println("result3:" + result3);

        int result4 = solution.calculate(str4);
        System.out.println("result4:" + result4);

        int result5 = solution.calculate(str5);
        System.out.println("result5:" + result5);
    }

}

class BasicCalculator_224_Solution {

    public int calculate(String s) {
        String ss = s.replace(" ", "");
        return this.calculateDimension(ss);
    }

    private int calculateDimension(String s) {
        int result = 0;
        int sign = 1;

        LinkedList<Integer> ops = new LinkedList<>();
        ops.push(1);
        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            int is = index;
            switch (c) {
                case '(':
                    ops.push(sign);
                    is++;
                    break;
                case ')':
                    ops.pop();
                    is++;
                    break;
                case '+':
                    sign = ops.peek();
                    is++;
                    break;
                case '-':
                    sign = -ops.peek();
                    is++;
                    break;
            }

            if (is != index) {
                index = is;
                continue;
            }

            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = 10 * num + (s.charAt(index) - '0');
                index++;
            }
            result = result + sign * num;
        }
        return result;
    }
}
