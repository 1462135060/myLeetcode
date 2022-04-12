package com.cii.leetcode.difficult;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedHashSet;

@SpringBootTest
public class Code_460 {

    /**
     * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
     * 实现 LFUCache 类：
     * LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
     * int get(int key)- 如果键key 存在于缓存中，则获取键的值，否则返回 -1 。
     * void put(int key, int value)- 如果键key 已存在，则变更其值；
     * 如果键不存在，请插入键值对。当缓存达到其容量capacity 时，则应该在插入新项之前，移除最不经常使用的项。
     * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
     * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
     * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     */
    class LFUCache {
        // 三个map， 分别存储 key和value、 key和访问次数、 访问次数和key列表；
        private HashMap<Integer, Integer> keyToValue;
        private HashMap<Integer, Integer> keyToFreq;
        private HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
        private int capacity;
        private int minFreq;

        public LFUCache(int capacity) {
            keyToValue = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKey = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 0;
        }

        public int get(int key) {
            // 在key和value map中寻找是否存在key值，存在则 key 访问次数+1；
            if (!keyToValue.containsKey(key)) {
                return -1;
            }
            increaseFreq(key);
            return keyToValue.get(key);
        }

        public void put(int key, int value) {
            if (this.capacity == 0) {
                return;
            }
            // 如果在 key和value map中存在， 则替换新值， key 访问次数+1；
            if (keyToValue.containsKey(key)) {
                keyToValue.put(key, value);
                increaseFreq(key);
                return;
            }
            // 不存在则 将插入新 key和value 入各个map；
            keyToValue.put(key, value);
            keyToFreq.put(key, 1);
            freqToKey.putIfAbsent(1, new LinkedHashSet<>());
            freqToKey.get(1).add(key);
            // 新加入值后， 如果map 的大小超过容量，则移除访问次数最少且访问隔间最久的key值；
            if (keyToValue.size() > this.capacity) {
                removeMinFreqKey();
            }
            // 加入新值后，最小访问量为 1；
            this.minFreq = 1;
        }

        private void increaseFreq(int key) {
            // 获取访问次数且+1后重新赋值；
            Integer freq = keyToFreq.get(key);
            keyToFreq.put(key, freq+1);
            // 在访问次数和key列表中， 将key往 访问次数+1 挪；
            freqToKey.putIfAbsent(freq+1, new LinkedHashSet<>());
            freqToKey.get(freq+1).add(key);
            freqToKey.get(freq).remove(key);
            // 挪完后， 如果原访问次数的 列表 为空时，在map里删除freq；
            if (freqToKey.get(freq).size() == 0) {
                freqToKey.remove(freq);
                // 如果 原访问次数 为最小访问次数， 则最小访问次数+1；
                if (minFreq == freq) {
                    minFreq++;
                }
            }
        }

        private void removeMinFreqKey() {
            // 根据 LinkedHashSet 存在顺序，使用遍历器获取最小访问次数中的第一个，则是 最小访问次数且访问时间最长的 key；
            Integer minFreqKey = freqToKey.get(this.minFreq).iterator().next();
            keyToFreq.remove(minFreqKey);
            keyToValue.remove(minFreqKey);
            freqToKey.get(this.minFreq).remove(minFreqKey);
            // 如果最小访问次数列表 移除key值后为空；则移除之，此时的 最小访问次数不必更新，因为其马上就会被置为1；
            if (freqToKey.get(this.minFreq).size() == 0) {
                freqToKey.remove(this.minFreq);
            }
        }
    }
    
    /**
     * 输入：
     * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
     * 输出：
     * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
     */
    @Test
    void test() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
