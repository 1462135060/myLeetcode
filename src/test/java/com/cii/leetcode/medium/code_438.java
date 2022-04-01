package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class code_438 {

    /**
     * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     */
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        int valid = 0;
        char[] ss = s.toCharArray();
        while (right < ss.length) {
            char c = ss[right++];
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid ++;
                }
            }

            while (right - left >= p.length()) {
                if (need.size() == valid) {
                    res.add(left);
                }
                char d = ss[left++];
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid --;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    /**
     * 示例1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 
     * 示例 2:
     * 输入: s = "", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */
    @Test
    void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc").toString());
        System.out.println(findAnagrams("abab", "ab").toString());
    }
}
