package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class Code_370 {
    //前缀数组 和 差分数组
    /**
     * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
     * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
     * 请你返回 k 次操作后的数组。
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] pre = new int[length + 1];
        for (int i = 0; i < updates.length; i++) {
            pre[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < pre.length) {
                pre[updates[i][1] + 1] -= updates[i][2];
            }
        }
        int[] res = new int[length];
        res[0] = pre[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i-1] + pre[i];
        }
        return res;
    }

    /**
     * 示例:
     *
     * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
     * 输出: [-2,0,3,5,3]
     * 解释:
     *
     * 初始状态:
     * [0,0,0,0,0]
     *
     * 进行了操作 [1,3,2] 后的状态:
     * [0,2,2,2,0]
     *
     * 进行了操作 [2,4,3] 后的状态:
     * [0,2,5,5,3]
     *
     * 进行了操作 [0,2,-2] 后的状态:
     * [-2,0,3,5,3]
     */
    @Test
    void test() {
        System.out.println(Arrays.toString(Arrays.stream(getModifiedArray(5, new int[][]{new int[]{1, 3, 2}, new int[]{2, 4, 3}, new int[]{0, 2, -2}})).toArray()));
    }
}
