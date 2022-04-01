package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_67 {

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     */
    public String addBinary(String a, String b) {
            int res = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
            return  Integer.toBinaryString(res);
    }

    /**
     * 示例1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * 示例2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    @Test
    void test() {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
