package com.cii.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class Code_146 {
    /**
     * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
     * 如果不存在，则向缓存中插入该组key-value 。
     * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     */
    class LRUCache {
        class DbLinkedNode {
            private int key;
            private int value;
            private DbLinkedNode prev;
            private DbLinkedNode next;
        }
        // 使用双链表结构加map存储链表节点信息
        private HashMap<Integer, DbLinkedNode> cache;
        private DbLinkedNode head;
        private DbLinkedNode tail;
        private int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<Integer, DbLinkedNode>();
            this.capacity = capacity;
            head = new DbLinkedNode();
            tail = new DbLinkedNode();
            head.prev = null;
            head.next = tail;
            tail.prev = head;
            tail.next = null;
        }

        public int get(int key) {
            // 在map中获取到节点后，将节点移到链表头；
            DbLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            // 如果该 key 值存在，则重新赋值后移动到链表头；
            DbLinkedNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
                return;
            }
            // 不存在则 新建节点并保存在链表头和map里
            DbLinkedNode newNode = new DbLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);
            // 添加新值后，map大小超过容量值，则将链表的最后一位移除并同时在map里移除；
            if (cache.size() > capacity) {
                DbLinkedNode pop = popTail();
                cache.remove(pop.key);
            }

        }

        private void addNode(DbLinkedNode node) {
            // 往头部添加节点
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void remove(DbLinkedNode node) {
            // 移除该节点
            DbLinkedNode prev = node.prev;
            DbLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DbLinkedNode node) {
            // 将该节点移到头部（先移除后重新添加）
            remove(node);
            addNode(node);
        }

        private DbLinkedNode popTail() {
            // 获取链表最后一个节点并移除
            DbLinkedNode res = tail.prev;
            remove(res);
            return res;
        }
    }

    /**
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     */
    @Test
    void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
