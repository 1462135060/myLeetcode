package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class Code_66 {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] ++;
        for (int i = digits.length-1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i-1] ++;
            }
        }
        if (digits[0] == 10) {
            digits[0] = 0;
            List<Integer> list = Arrays.stream(digits).boxed().collect(Collectors.toList());
            list.add(0, 1);
            digits = list.stream().mapToInt(Integer::valueOf).toArray();
        }
        return digits;
    }

    /**
     * 示例1：
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     *
     * 示例2：
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     *
     * 示例 3：
     * 输入：digits = [0]
     * 输出：[1]
     */
    @Test
    void test() {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }

}
