package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;

public class Code_796 {

    /**
     * 给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。
     * s的 旋转操作 就是将s 最左边的字符移动到最右边。
     * 例如, 若s = 'abcde'，在旋转一次之后结果就是'bcdea'。
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    /**
     * 示例 1:
     * 输入: s = "abcde", goal = "cdeab"
     * 输出: true
     * 示例 2:
     * 输入: s = "abcde", goal = "abced"
     * 输出: false
     */
    @Test
    void test() {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }
}
