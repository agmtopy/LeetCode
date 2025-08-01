package com.agmtopt.leetcode.algorithmtrainingcamp.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_46 {

    public static void main(String[] args) {

        Permutations_46_Solution solution = new Permutations_46_Solution();

        int[] params = new int[]{1,2,3};
        int[] params1 = new int[]{0,1};
        int[] params2 = new int[]{1};

        List<List<Integer>> rs = solution.permute(params2);
        System.out.println("result:" + rs);
    }

}

class Permutations_46_Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        return subMethod(list).stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }


    /**
     * 全排列
     */
    public List<LinkedList<Integer>> subMethod(List<Integer> nums) {
        List<LinkedList<Integer>> result = new ArrayList<>();

        //跳出递归条件
        LinkedList<Integer> temp = new LinkedList<>();
        if (nums.size() == 1) {
            temp.add(nums.get(0));
            result.add(temp);
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            ArrayList<Integer> tempList = new ArrayList<>(nums);
            tempList.remove(i);
            List<LinkedList<Integer>> permute = subMethod(tempList);
            permute.stream().forEach(item -> item.addFirst(num));
            result.addAll(permute);
        }
        return result;
    }

}
