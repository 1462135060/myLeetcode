package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_1094 {

    /**
     * 假设你是一位顺风车司机，车上最初有capacity个空座位可以用来载客。由于道路的限制，车只能向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
     *
     * 这儿有一份乘客行程计划表trips[][]，其中trips[i] = [num_passengers, start_location, end_location]包含了第 i 组乘客的行程信息：
     *
     * 必须接送的乘客数量；
     * 乘客的上车地点；
     * 以及乘客的下车地点。
     * 这些给出的地点位置是从你的初始出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
     *
     * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false）。
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pre = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][1] < pre.length) {
                pre[trips[i][1]] += trips[i][0];
            }
            if (trips[i][2] < pre.length) {
                pre[trips[i][2]] -= trips[i][0];
            }
        }
        int[] res = new int[pre.length - 1];
        res[0] = pre[0];
        if (res[0] > capacity) {
            return false;
        }
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i-1] + pre[i];
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    /**
     * 示例 1：
     *
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
     * 输出：false
     * 示例 2：
     *
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     * 示例 3：
     *
     * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
     * 输出：true
     * 示例 4：
     *
     * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
     * 输出：true
     */
    @Test
    void test() {
//        System.out.println(carPooling(new int[][]{new int[]{2,1,5}, new int[]{3,3,7}}, 4));
//        System.out.println(carPooling(new int[][]{new int[]{2,1,5}, new int[]{3,3,7}}, 5));
//        System.out.println(carPooling(new int[][]{new int[]{2,1,5}, new int[]{3,5,7}}, 3));
//        System.out.println(carPooling(new int[][]{new int[]{3,2,7}, new int[]{3,7,9}, new int[]{8,3,9}}, 11));
        System.out.println(carPooling(new int[][]{new int[]{9, 0, 1}, new int[]{3,3,7}}, 4));
    }
}
