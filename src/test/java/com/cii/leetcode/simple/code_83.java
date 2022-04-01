package com.cii.leetcode.simple;

import com.cii.leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
public class code_83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        ListNode cur = res;
        HashSet<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                ListNode temp = new ListNode(head.val);
                cur.next = temp;
                cur = temp;
            }
            head = head.next;
        }
        return res.next;
    }

    /**
     * 快慢指针
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    /**
     * 示例 1：
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     *
     * 示例 2：
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     */
     @Test
    void test() {
         ListNode.printListNode(deleteDuplicates1(ListNode.getListNode(new int[]{1,1,2})));
         ListNode.printListNode(deleteDuplicates1(ListNode.getListNode(new int[]{1,1,2,3,3})));
     }

}
