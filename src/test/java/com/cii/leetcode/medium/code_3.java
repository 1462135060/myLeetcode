package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class code_3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        char[] ss = s.toCharArray();
        while (right < ss.length) {
            char c = ss[right++];
            window.put(c , window.getOrDefault(c, 0) + 1);
            // 记录最长子串的长度
            if (window.get(c) == 1 && window.size() > res) {
                res = window.size();
            }
            // 出现重复字符，开始缩短子串
            while (window.get(c) > 1) {
                char d = ss[left++];
                if (window.get(d) == 1) {
                    window.remove(d);
                } else {
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    /**
     * 示例1:
     * 输入: s = "abcabcbb"
     * 输出: 3 
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     */
    @Test
    void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
