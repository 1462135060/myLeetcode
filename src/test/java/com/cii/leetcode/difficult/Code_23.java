package com.cii.leetcode.difficult;

import com.cii.leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.PriorityQueue;

@SpringBootTest
public class Code_23 {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return res.next;


    }

    /**
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     */
    @Test
    void test() {
        ListNode.printListNode(mergeKLists(new ListNode[]{ListNode.getListNode(new int[]{1,4,5}), ListNode.getListNode(new int[]{1,3,4}), ListNode.getListNode(new int[]{2,6})}));
        ListNode.printListNode(mergeKLists(new ListNode[]{}));
        ListNode.printListNode(mergeKLists(new ListNode[]{ListNode.getListNode(new int[]{})}));
    }

}
