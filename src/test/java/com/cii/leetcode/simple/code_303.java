package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_303 {
    //前缀数组 和 差分数组
    /**
     * 给定一个整数数组 nums，处理以下类型的多个查询:
     *
     * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
     * 实现 NumArray 类：
     *
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
     */
//    private int[] nums;
//    public void NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int res = 0;
//        for (int i = left; i <= right; i++) {
//            res += nums[i];
//        }
//        return res;
//    }

    private int [] pres;
    public void NumArray(int[] nums) {
        pres = new int[nums.length + 1];
        for (int i = 1; i < pres.length; i++) {
            pres[i] = pres[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return pres[right+1] - pres[left];
    }


    /**
     * 示例 1：
     *
     * 输入：
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * 输出：
     * [null, 1, -1, -3]
     *
     * 解释：
     * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
     * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
     */

    @Test
    void test() {
        NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(sumRange(0,2));
        System.out.println(sumRange(2,5));
        System.out.println(sumRange(0,5));
    }

}
