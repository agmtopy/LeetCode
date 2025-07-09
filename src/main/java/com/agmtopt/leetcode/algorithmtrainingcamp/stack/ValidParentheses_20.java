package com.agmtopt.leetcode.algorithmtrainingcamp.stack;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses_20 {


    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        String text1 = new String("()[]{}");
        String text2 = new String("(]");
        String text3 = new String("([])");
        String text4 = new String("([)]");

        ValidParentheses_20_Solution solution = new ValidParentheses_20_Solution();

        Boolean result1 = solution.isValid(text1);
        System.out.println("result1:" + result1);

        Boolean result2 = solution.isValid(text2);
        System.out.println("result2:" + result2);

        Boolean result3 = solution.isValid(text3);
        System.out.println("result3:" + result3);

        Boolean result4 = solution.isValid(text4);
        System.out.println("result4:" + result4);

    }

}

class ValidParentheses_20_Solution {

    public boolean isValid(String s) {
        if (s == null) return false;

        List<String> ls1 = new ArrayList<>();
        ls1.add("(");
        ls1.add("[");
        ls1.add("{");

        List<String> ls2 = new ArrayList<>();
        ls2.add(")");
        ls2.add("]");
        ls2.add("}");

        String[] split = s.split("");
        List<String> rs = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];

            if (ls1.contains(s1)) {
                rs.add(ls2.get(ls1.indexOf(s1)));
                continue;
            }

            if (!ls1.contains(s1)) {
                if(rs.size() > 0 && rs.get(rs.size()-1).equals(s1)) {
                    rs.remove(rs.size()-1);
                    continue;
                }
                return false;
            }
        }
        return rs.isEmpty();
    }

}
