package com.agmtopt.leetcode.algorithmtrainingcamp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class CourseSchedule_207 {

  public static void main(String[] args) {
    CourseSchedule_207_Solution solution = new CourseSchedule_207_Solution();

    boolean result = solution.canFinish(2, new int[][]{{1, 0}, {0, 1}});
    System.out.println("result:" + result);
  }

}

class CourseSchedule_207_Solution {


  /**
   * 优先构建邻接表和入度数组
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    //1. 初始化邻接表和入度数组
    List<List<Integer>> graph = new ArrayList<>();
    //初始化邻接表,index表示课程n作为那些课程的依赖
    IntStream.range(0, numCourses).forEach(item -> graph.add(new ArrayList<>()));
    //入度表,表示当前课程还需要依赖几个课程
    int[] indegree = new int[numCourses];

    for (int[] pre : prerequisites) {
      int i = pre[0];
      int j = pre[1];

      //设置邻接表
      graph.get(j).add(i);
      //设置入度集合
      indegree[i]++;
    }

    //2. 计算首次依赖为0的课程
    Queue<Integer> zeros = new LinkedList<>();
    IntStream.range(0, numCourses).forEach(item -> {
      if (indegree[item] == 0) {
        zeros.add(item);
      }
    });

    //3. BFS
    int count = 0;
    while (!zeros.isEmpty()) {
      Integer zero = zeros.poll();
      count++;

      for (Integer next : graph.get(zero)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          zeros.offer(next);
        }
      }
    }
    return count == numCourses;
  }
}
