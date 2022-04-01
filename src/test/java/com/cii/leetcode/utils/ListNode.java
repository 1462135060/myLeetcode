package com.cii.leetcode.utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode getListNode(int [] ints) {
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

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(" " + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
}

