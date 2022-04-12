package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

@SpringBootTest
public class Code_316 {
    /**
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
     * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() >= s.charAt(i) && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        char[] ans = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
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
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
