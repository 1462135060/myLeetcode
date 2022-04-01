package com.cii.leetcode.simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class code_21 {
    /**
     * Definition for singly-linked list.
     * */
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }
        return res.next;
    }


    /**
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     */
    @Test
    void test() {
        printListNode(mergeTwoLists(getListNode(new int[]{1,2,4}), getListNode(new int[]{1,3,4})));
        printListNode(mergeTwoLists(getListNode(new int[]{}), getListNode(new int[]{})));
        printListNode(mergeTwoLists(getListNode(new int[]{}), getListNode(new int[]{0})));
    }

    private ListNode getListNode(int [] ints) {
        if (ints.length == 0) {
            return new ListNode();
        }
        ListNode res = new ListNode();
        ListNode cur = res;
        for (int i = 0; i < ints.length; i++) {
            ListNode temp = new ListNode(ints[i]);
            cur.next = temp;
            cur = temp;
        }
        return res.next;
    }

    private void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(" " + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
}
