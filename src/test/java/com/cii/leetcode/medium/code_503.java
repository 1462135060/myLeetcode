package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Stack;

@SpringBootTest
public class code_503 {
    /**
     * 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），返回nums中每个元素的 下一个更大元素 。
     * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = 2*nums.length-1; i>0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%nums.length]) {
                stack.pop();
            }
            ans[i%nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%nums.length]);
        }
        return ans;











    }

    /**
     * 示例 1:
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * 示例 2:
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     */
    @Test
    void test() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }
}
