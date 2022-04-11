package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class code_347 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(map.size(), (o1, o2) -> {
            return o2[1] - o1[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = Objects.requireNonNull(queue.poll())[0];
        }
        return ans;
    }

    /**
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    @Test
    void test() {
//        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
//        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(topKFrequent(new int[]{-1, -1}, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }
}
