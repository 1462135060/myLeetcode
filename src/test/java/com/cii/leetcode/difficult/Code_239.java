package com.cii.leetcode.difficult;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@SpringBootTest
public class Code_239 {

    /**
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     */
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        private void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        private void pop(int n) {
            if (q.getFirst() == n) {
                q.pollFirst();
            }
        }

        private int max() {
            return q.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i<k-1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res.add(queue.max());
                queue.pop(nums[i-k+1]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }


    /**
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *  
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     */
    @Test
    void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
