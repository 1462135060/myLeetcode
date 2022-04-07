package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

@SpringBootTest
public class code_1081 {

    /**
     * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
     */
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() >= c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        char[] ans = new char[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.get(i);
        }
        return new String(ans);
    }

    /**
     * 示例 1：
     * 输入：s = "bcabc"
     * 输出："abc"
     *
     * 示例 2：
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     */
    @Test
    void test() {
        System.out.println(smallestSubsequence("bcabc"));
        System.out.println(smallestSubsequence("cbacdcbc"));
    }

}
