package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;

public class Code_70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    // F(N) = F(N-1) + F(N-2)
    // 1 2 2 3 5 8 13
    public int climbStairs(int n) {
        if (n==1 || n==2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = a + temp;
        }
        return b;
    }


    /**
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     *
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    @Test
    void test() {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(7));
    }
}
