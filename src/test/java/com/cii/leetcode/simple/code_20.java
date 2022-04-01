package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。。
     */
    public boolean isValid(String s) {
//        char[] chars = s.toCharArray();
//        for (int i = 0, j = chars.length-1; i < chars.length/2; i++, j--) {
//            if ((chars[i] == '(' && chars[j] != ')') || (chars[i] == '{' && chars[j] != '}') || (chars[i] == '[' && chars[j] != ']')) {
//                return false;
//            }
//        }
//        return true;
        for (int i = 0; i < s.length()/2 + 1; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.length() == 0;
    }

    /**
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     */
    @Test
    void test() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
