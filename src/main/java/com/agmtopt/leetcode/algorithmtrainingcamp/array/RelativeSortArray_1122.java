package com.agmtopt.leetcode.algorithmtrainingcamp.array;

import com.alibaba.fastjson2.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelativeSortArray_1122 {

  public static void main(String[] args) {
    RelativeSortArray_1122_Solution solution = new RelativeSortArray_1122_Solution();
    int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
    int[] result = solution.relativeSortArray(arr1, arr2);

    System.out.println("result:" + JSON.toJSONString(result));
  }
}

class RelativeSortArray_1122_Solution {

  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);

    List<Integer> result = new ArrayList<>();

    for (int j : arr2) {
      result.add(j);
    }

    for (int i1 : arr1) {
      if (result.contains(i1)) {
        int index = result.indexOf(i1);
        result.add(index, i1);
        continue;
      }
      result.add(i1);
    }

    for (int j : arr2) {
      int i = result.indexOf(j);
      result.remove(i);
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
