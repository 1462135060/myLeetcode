package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class code_875 {
    // 二分查找
    /**
     * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
     * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     */
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];
        int sum = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            sum = 0;
            for (int pile : piles) {
                sum += pile%mid==0 ? pile/mid : pile/mid+1;
            }
            if (sum < h) {
                right = mid - 1;
            } else if (sum > h) {
                left = mid + 1;
            } else if (sum == h) {
                right = mid - 1;
            }
        }
//        if (right <= 0 || sum != h) {
//            return -1;
//        } else {
//            return right;
//        }
        return left;
    }

    /**
     * 示例 1：
     * 输入: piles = [3,6,7,11], H = 8
     * 输出: 4
     * 
     * 示例2：
     * 输入: piles = [30,11,23,4,20], H = 5
     * 输出: 30
     * 
     * 示例3：
     * 输入: piles = [30,11,23,4,20], H = 6
     * 输出: 23
     */
    @Test
    void test() {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println(minEatingSpeed(new int[]{312884470},312884469));
        System.out.println(minEatingSpeed(new int[]{1,1,1,999999999},10));
    }
}
