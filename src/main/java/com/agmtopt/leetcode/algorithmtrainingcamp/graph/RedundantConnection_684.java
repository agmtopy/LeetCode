package com.agmtopt.leetcode.algorithmtrainingcamp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO 挑战失败
 */
public class RedundantConnection_684 {

  public static void main(String[] args) {
    RedundantConnection_684_Solution solution = new RedundantConnection_684_Solution();

    int[][] edges  = new int[][]{{1, 2}, {1, 3}, {2, 3}};
    int[][] edges1  = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

    int[] redundantConnection = solution.findRedundantConnection(edges1);
    System.out.println("uag:" + Arrays.toString(redundantConnection));
  }

}

class RedundantConnection_684_Solution {

  public int[] findRedundantConnection(int[][] edges) {
    int nodeNum = edges.length;
    List<List<Integer>> list = Arrays.stream(edges)
        .map(row -> Arrays.stream(row)
            .boxed()
            .collect(Collectors.toList()))
        .collect(Collectors.toList());
    for (int i = list.size() - 1; 0 <= i; i--) {
      List<List<Integer>> deepCopyList = list.stream()
          .map(ArrayList::new)
          .collect(Collectors.toList());
      deepCopyList.remove(i);

      int[][] twoDArray = deepCopyList.stream()
          .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
          .toArray(int[][]::new);

      if (isUag(nodeNum, twoDArray)) {
        return edges[i];
      }
    }

    return null;
  }

  /**
   * 是否为无向循环图(即为树)
   */
  private boolean isUag(int nodeNum, int[][] edges) {
    //1. 初始化邻接表和入度表
    List<List<Integer>> graphs = new ArrayList<>();
    int[] degree = new int[nodeNum];

    IntStream.range(0, nodeNum).forEach(item -> graphs.add(new ArrayList<>()));

    for (int[] ints : edges) {
      int i = ints[0] - 1;
      int j = ints[1] - 1;

      graphs.get(j).add(i);
      degree[i]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < degree.length; i++) {
      if (degree[i] == 0) {
        queue.offer(i);
      }
    }

    Integer count = 0;
    while (!queue.isEmpty()) {
      Integer index = queue.poll();
      count++;

      for (Integer item : graphs.get(index)) {
        degree[item]--;
        if (degree[item] == 0) {
          queue.offer(item);
        }
      }
    }

    return count == nodeNum;
  }

}
