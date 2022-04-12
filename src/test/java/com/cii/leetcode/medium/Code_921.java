package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Code_921 {

    /**
     * 只有满足下面几点之一，括号字符串才是有效的：
     *
     * 它是一个空字符串，或者
     * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
     * 它可以被写作(A)，其中A是有效字符串。
     * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
     *
     * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
     * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
     */
    public int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int need = 0;
        for (char c : chars) {
            if (c == '(') {
                need ++;
            } else {
                need--;
                if (need == -1) {
                    res++;
                    need++;
                }
            }
        }
        return res + need;
    }

    /**
     * 示例 1：
     * 输入：s = "())"
     * 输出：1
     * 
     * 示例 2：
     * 输入：s = "((("
     * 输出：3
     */
    @Test
    void test() {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
    }
}
