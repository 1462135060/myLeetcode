package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class code_1109 {
    //前缀数组 和 差分数组
    /**
     * 这里有n个航班，它们分别从 1 到 n 进行编号。
     *
     * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
     *
     * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] pre = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            pre[bookings[i][0]-1] += bookings[i][2];
            if (bookings[i][1] < pre.length) {
                pre[bookings[i][1]] -= bookings[i][2];
            }
        }
        int[] res = new int[n];
        res[0] = pre[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i-1] + pre[i];
        }
        return res;
    }

    /**
     * 示例 1：
     *
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     * 
     * 示例 2：
     *
     * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
     * 输出：[10,25]
     * 解释：
     * 航班编号        1   2
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       15
     * 总座位数：      10  25
     * 因此，answer = [10,25]
     */
    @Test
    void test() {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{new int[]{1, 2, 10}, new int[]{2, 3, 20}, new int[]{2, 5, 25}}, 5)));
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{new int[]{1, 2, 10}, new int[]{2,2,15}}, 2)));
    }
}
