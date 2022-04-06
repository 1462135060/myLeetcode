package com.cii.leetcode.medium;

import com.cii.leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class code_92 {

    /**
     * 给你单链表的头指针 head 和两个整数left 和 right ，
     * 其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     */
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    public ListNode reverseN(ListNode head, int num) {
        if (num == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, num - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 示例 1：
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 
     * 示例 2：
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     */
    @Test
    void test() {
        ListNode.printListNode(reverseBetween(ListNode.getListNode(new int[]{1,2,3,4,5}), 2, 4));
    }
}
