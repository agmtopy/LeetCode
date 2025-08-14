package com.agmtopt.leetcode.algorithmtrainingcamp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class CourseScheduleIi_210 {


  public static void main(String[] args) {
    CourseScheduleIi_210_Solution solution = new CourseScheduleIi_210_Solution();

//    int[] order = solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
//    System.out.println("order:" + Arrays.toString(order));

    int[] order = solution.findOrder(2, new int[][]{});
    System.out.println("order:" + Arrays.toString(order));
  }

}

class CourseScheduleIi_210_Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    //1. 初始化邻接表和入度表
    List<List<Integer>> gList = new ArrayList<>(numCourses);
    IntStream.range(0, numCourses).forEach(index -> gList.add(new ArrayList<>()));
    int[] qs = new int[numCourses];

    for (int[] pre : prerequisites) {
      int i = pre[0];
      int j = pre[1];
      gList.get(j).add(i);
      qs[i]++;
    }

    Queue<Integer> zero = new LinkedList<>();
    for (int index = 0; index < qs.length; index++) {
      int item = qs[index];
      if (item == 0) {
        zero.add(index);
      }
    }

    int count = 0;
    int[] result = new int[numCourses];
    while (!zero.isEmpty()) {
      Integer cur = zero.poll();
      result[count] = cur;
      count++;

      for (Integer next : gList.get(cur)) {
        qs[next]--;

        if (qs[next] == 0) {
          zero.offer(next);
        }
      }
    }

    if (count != numCourses) {
      return new int[0];
    }

    return result;
  }
}
