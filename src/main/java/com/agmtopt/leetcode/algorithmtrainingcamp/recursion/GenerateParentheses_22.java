package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses_22 {

    public static void main(String[] args) {
        GenerateParentheses_22_Solution solution = new GenerateParentheses_22_Solution();
        List<String> result = solution.generateParenthesis(4);

        System.out.println("result size:" + result.size());
        System.out.println("result:" + result);
    }

}

class GenerateParentheses_22_Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            ArrayList<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }


        List<String> strings = generateParenthesis(n - 1);
        ArrayList<String> result = new ArrayList<>();
        strings.forEach(item -> {
            String v1 = "(" + item + ")";
            String v2 = "()" + item;
            String v3 = item + "()";
            result.add(v1);
            result.add(v2);
            result.add(v3);
        });

        if(n%2==0) generateParenthesis(n/2);


        return result.stream().distinct().collect(Collectors.toList());
    }
}
