package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Code_304 {
    //前缀数组 和 差分数组
    /**
     * 给定一个二维矩阵 matrix，以下类型的多个请求：
     *
     * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
     * 实现 NumMatrix 类：
     *
     * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
     * int sumRegion(int row1, int col1, int row2, int col2)返回 左上角 (row1,col1)、右下角(row2,col2) 所描述的子矩阵的元素 总和 。
     */

    int[][] preSum;
    public void NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        preSum = new int[y+1][x+1];
        for (int i=1; i<preSum.length; i++) {
            for (int j=1; j<preSum[0].length; j++) {
                preSum[i][j] = matrix[i-1][j-1] + preSum[i][j-1] + preSum[i-1][j] - preSum[i-1][j-1];
            }
        }
        System.out.println();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }

    /**
     * 示例 1：
     * 输入:
     * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
     * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
     * 输出:
     * [null, 8, 11, 12]
     *
     * 解释:
     * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
     * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
     * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
     * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
     */
    @Test
    void test() {
        NumMatrix(new int[][]{new int[]{3,0,1,4,2}, new int[]{5,6,3,2,1}, new int[]{1,2,0,1,5}, new int[]{4,1,0,1,7}, new int[]{1,0,3,0,5}});
        System.out.println(sumRegion(2, 1, 4, 3));
        System.out.println(sumRegion(1, 1, 2, 2));
        System.out.println(sumRegion(1, 2, 2, 4));
    }
}
