package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Stack;

@SpringBootTest
public class code_739 {

    /**
     * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
     * 其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return ans;

//89,62,70,58,47,47,46,76,100,70






    }

    /**
     * 示例 1:
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出:[1,1,4,2,1,1,0,0]
     * 示例 2:
     * 输入: temperatures = [30,40,50,60]
     * 输出:[1,1,1,0]
     * 示例 3:
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     */
    @Test
    void test() {
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})));
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})));
    }
}
