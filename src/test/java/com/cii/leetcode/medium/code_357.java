package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_357 {
    /**
     * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
     */
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        int p = 9;
        for (int i = 1; i <= n; i++) {
            res += p;
            p *= (10-i);
        }
        return res;
    }













    /**
     * 示例 1：
     * 输入：n = 2
     * 输出：91
     * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
     * 示例 2：
     * 输入：n = 0
     * 输出：1
     */
    @Test
    void test () {
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(0));
        System.out.println(countNumbersWithUniqueDigits(3)); // 739
        System.out.println(countNumbersWithUniqueDigits(4)); // 5257
    }

}
