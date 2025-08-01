package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public static void main(String[] args) {
        Combinations_77_Solution solution = new Combinations_77_Solution();
        List<List<Integer>> rs = solution.combine(4, 2);
        System.out.println("rs:" + JSON.toJSONString(rs));
    }
}


class Combinations_77_Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.subMethod(1, n, k);
        return result;
    }

    /**
     * 递归方法
     */
    private void subMethod(int i, int n, int k) {
        if (temp.size() + n - i + 1 < k) return;

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(i);
        subMethod(i + 1, n, k);
        //回溯,撤销上一步的选择,
        temp.remove(temp.size() - 1);
        subMethod(i + 1, n, k);
    }
}