package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class code_560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     */
//    private int[] preSum;
//    public int subarraySum(int[] nums, int k) {
//        preSum = new int[nums.length+1];
//        for (int i = 1; i < preSum.length; i++) {
//            preSum[i] = nums[i-1] + preSum[i-1];
//        }
//        int res = 0;
//        for (int i = 1; i < preSum.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (preSum[i] - preSum[j] == k) {
//                    res ++;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * preSum[j] == preSum[i] - k
     */

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum_i = 0;
        int res = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum_i += nums[i];
            int sum_j = sum_i - k;
            if (map.containsKey(sum_j)) {
                res += map.get(sum_j);
            }
            map.put(sum_i, map.getOrDefault(sum_i, 0) + 1);
        }
        return res;
    }

    /**
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     *
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     */
    @Test
    void test() {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }
}
