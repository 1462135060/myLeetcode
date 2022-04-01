package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class code_34 {
    // 二分查找
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        // 找最左的下标
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            res[0] = -1;
        } else {
            res[0] = left;
        }
        // 找最右的下标
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            res[1] = -1;
        } else {
            res[1] = right;
        }
        return res;
    }


    /**
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 
     * 示例2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    @Test
    void test() {
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
//        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 3)));
    }
}
