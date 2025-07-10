package com.agmtopt.leetcode.algorithmtrainingcamp.stack;

import java.util.ArrayList;
import java.util.List;

public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String[] tokens1 = new String[]{"2","1","+","3","*"};
        String[] tokens2 = new String[]{"4","13","5","/","+"};
        EvaluateReversePolishNotation_150_Solution solution = new EvaluateReversePolishNotation_150_Solution();

//        int result1 = solution.evalRPN(tokens1);
//        System.out.println("result1:" + result1);

        int result2 = solution.evalRPN(tokens2);
        System.out.println("result2:" + result2);
    }
}


class EvaluateReversePolishNotation_150_Solution {

    final static List<String> xs = new ArrayList<>();

    static {
        xs.add("+");
        xs.add("-");
        xs.add("*");
        xs.add("/");
    }

    public int evalRPN(String[] tokens) {
        List<Integer> cals = new ArrayList<>();

        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            String item = tokens[i];
            if (xs.contains(item)) {
                int size = cals.size();
                int rs = cal(cals.get(size - 2), cals.get(size - 1), item);
                cals.remove(size - 1);
                cals.remove(size - 2);
                cals.add(rs);
                continue;
            }
            cals.add(Integer.valueOf(item));
        }
        return cals.get(0);
    }

    private int cal(int n, int m, String x) {
        switch (x) {
            case "+":
                return n + m;
            case "-":
                return n - m;
            case "*":
                return n * m;
            case "/":
                return n / m;
        }
        return 0;
    }

}
