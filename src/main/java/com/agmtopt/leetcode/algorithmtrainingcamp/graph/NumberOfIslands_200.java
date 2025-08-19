package com.agmtopt.leetcode.algorithmtrainingcamp.graph;

public class NumberOfIslands_200 {

  public static void main(String[] args) {

    NumberOfIslands_200_Solution solution = new NumberOfIslands_200_Solution();
    char[][] grid = createGrid2();

    int i = solution.numIslands(grid);
    System.out.println("result:" + i);
  }

  private static char[][] createGrid1() {
    return new char[][]{{'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
  }
  private static char[][] createGrid2() {
    return new char[][]{
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
  }
}

class NumberOfIslands_200_Solution {

  private void dfs(char[][] grid, int i, int j) {
    int lsize = grid.length;
    int nsize = grid[0].length;

    if (i < 0 || j < 0 || i >= lsize || j >= nsize || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';

    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int lsize = grid.length;
    int nsize = grid[0].length;

    int resultNum = 0;

    for (int i = 0; i < lsize; i++) {
      for (int j = 0; j < nsize; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          resultNum++;
        }
      }
    }

    return resultNum;
  }
}
