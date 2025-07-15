package com.agmtopt.leetcode.algorithmtrainingcamp.prefix;

public class RangeSumQuery2dImmutable_304 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        RangeSumQuery2dImmutable_304_Solution solution = new RangeSumQuery2dImmutable_304_Solution(matrix);
        System.out.println("result:"+ solution.sumRegion(2,1,4,3));
    }
}

class RangeSumQuery2dImmutable_304_Solution {

    private int[][] matrixSum = null;

    public RangeSumQuery2dImmutable_304_Solution(int[][] matrix) {
        matrixSum = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixSum[i + 1][j + 1] = matrix[i][j] + matrixSum[i + 1][j] + matrixSum[i][j + 1] - matrixSum[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixSum[row1][col1] + matrixSum[row2 + 1][col2 + 1] - matrixSum[row2 + 1][col1] - matrixSum[row1][col2 + 1] ;
    }


}
