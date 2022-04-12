package com.cii.leetcode.difficult;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
public class Code_76 {
    // 滑动窗口
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小子串的其实位置以及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        char[] ss = s.toCharArray();
        while (right < ss.length) {
            // 获取该字符并将窗口右移
            char c = ss[right++];
            // 判断是否为need所要字符, 是则将字符加入window个数加1
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断window中该字符的个数是否满足need中该字符的个数
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid ++;
                }
            }

            // 判断所有条件是否以满足，满足则尝试缩短左窗口
            while (need.size() == valid) {
                // 记录当前位置和长度
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                // 尝试将最左边的字符移出
                char d = ss[left++];
                if (need.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid --;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

    /**
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     *
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     *
     * 示例 3:
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     */
    @Test
    void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

}
