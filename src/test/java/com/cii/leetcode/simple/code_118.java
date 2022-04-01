package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class code_118 {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    item.add(1);
                    continue;
                }
                item.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(item);
        }
        return res;
    }

    /**
     * 示例 1:
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * 示例2:
     * 输入: numRows = 1
     * 输出: [[1]]
     */
    @Test
    void test() {
        printList(generate(5));
        printList(generate(1));
    }

    private void printList(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).toString());
        }
        System.out.println();
    }
}
