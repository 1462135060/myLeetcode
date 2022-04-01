package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.PriorityQueue;

@SpringBootTest
public class code_870 {

    /**
     * 给定两个大小相等的数组A和B，A 相对于 B 的优势可以用满足A[i] > B[i]的索引 i的数目来描述。
     *
     * 返回A的任意排列，使其相对于 B的优势最大化
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 将数组 nums1 排序
        Arrays.sort(nums1);
        // 将数组 nums2 放入优先队列排序 保存索引值
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] pair1, int[] pair2) -> {return pair2[1] - pair1[1];});
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }
        // 遍历两个有序数组, 返回一个新的数组
        int left = 0;
        int right = nums1.length - 1;
        int[] res = new int[nums1.length];
        while (left <= right) {
            int[] poll = queue.poll();
            if (nums1[right] > poll[1]) {
                res[poll[0]] = nums1[right--];
            } else {
                res[poll[0]] = nums1[left++];
            }
        }
        return res;
    }

    /**
     * 示例 1：
     * 输入：A = [2,7,11,15], B = [1,10,4,11]
     * 输出：[2,11,7,15]
     * 
     * 示例 2：
     * 输入：A = [12,24,8,32], B = [13,25,32,11]
     * 输出：[24,32,8,12]
     */
    @Test
    void test() {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }
}
