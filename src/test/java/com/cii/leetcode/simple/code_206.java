package com.cii.leetcode.simple;

import com.cii.leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_206 {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     *
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     */
    @Test
    void test() {
        ListNode.printListNode(reverseList(ListNode.getListNode(new int[]{1,2,3,4,5})));
    }
}
