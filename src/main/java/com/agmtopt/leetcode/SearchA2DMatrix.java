package com.agmtopt.leetcode;

/**
 * 搜索二维矩阵
 */
public class SearchA2DMatrix {


    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target1 = 5;

        int[][] matrix2 = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target2 = 20;

        int[][] matrix3 = new int[][]{{-1, 3}};
        int target3 = 3;

        boolean flag = Solution.majorityElement(matrix3, target3);
        System.out.println(flag);
    }


    class Solution {
        public static boolean majorityElement(int[][] matrix, int target) {
            // 行数
            int row = 0;
            // 列数
            int col = matrix[0].length - 1;

            boolean flag = false;
            while (col >= 0 && row <= matrix.length - 1) {
                if (matrix[row][col] == target) {
                    flag = true;
                    break;
                }

                // 右上角值小于目标值时,row++,表示向下移动
                if (matrix[row][col] < target) {
                    row++;
                } else {
                    //右上角值大于目标值时,col--,表示向左移动
                    col--;
                }
            }
            return flag;
        }
    }

}
