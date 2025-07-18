package com.agmtopt.leetcode.algorithmtrainingcamp.prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIIInputArrayIsSorted_167 {

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted_167_Solution solution = new TwoSumIIInputArrayIsSorted_167_Solution();

        int[] bookings = new int[]{2, 7, 11, 15};
        int[] result = solution.twoSum(bookings, 9);
        System.out.println(result);
    }

}


class TwoSumIIInputArrayIsSorted_167_Solution {


    public int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];

        int minIndex = 0;
        int maxIndex = numbers.length - 1;

        while (minIndex != maxIndex) {
            if (numbers[minIndex] + numbers[maxIndex] == target) {
                break;
            }
            if (numbers[minIndex] + numbers[maxIndex] < target) {
                minIndex++;
                continue;
            }
            maxIndex--;
        }

        rs[0] = minIndex + 1;
        rs[1] = maxIndex + 1;
        return rs;
    }


    public int[] twoSum1(int[] numbers, int target) {

        Map<Integer, List<Integer>> temp = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (temp.containsKey(numbers[i])) {
                temp.get(numbers[i]).add(i);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                temp.put(numbers[i], ls);
            }
        }

        int[] rs = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            Integer key = target - numbers[i];
            if (temp.containsKey(key)) {
                rs[0] = i + 1;
                rs[1] = i != temp.get(key).get(0) ? temp.get(key).get(0) + 1 : temp.get(key).get(1) + 1;
                break;
            }
        }
        return rs;
    }
}