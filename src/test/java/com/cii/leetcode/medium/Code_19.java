package com.cii.leetcode.medium;

import com.cii.leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Code_19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
    
    
    /**
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     */
    @Test
    void test() {
        ListNode.printListNode(removeNthFromEnd(ListNode.getListNode(new int[]{1,2,3,4,5}), 2));
        ListNode.printListNode(removeNthFromEnd(ListNode.getListNode(new int[]{1}), 1));
        ListNode.printListNode(removeNthFromEnd(ListNode.getListNode(new int[]{1,2}), 1));
    }
}
