package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Code_69 {

    /**
     * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     */
    public int mySqrt(int x) {
        long left = 1;
        long right = x;
        while (left<right) {
            long mid = (left + right) / 2;
            if ((long)mid*mid <= x) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return (int)(left*left<=x ? left : left-1);
    }

    /**
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     *
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    @Test
    void test() {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2147483647));
    }
}
