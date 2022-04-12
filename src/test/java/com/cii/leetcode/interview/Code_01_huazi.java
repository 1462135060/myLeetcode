package com.cii.leetcode.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

@SpringBootTest
public class Code_01_huazi {
    /**
     * 给出 M 篇新闻稿，每篇新闻稿包含两行字符串，第一行字符串是标题，第二行字符串是正文；
     * 统计 M 篇新闻稿中所有单词出现的频率，某个单词若在新闻的标题中出现则频率 + 3，在正文中出现则频率 + 1，
     * 求出现频率最高的 N 个单词。
     * 若单词的出现频率相等，则在标题出现频率高的优先输出，
     * 若在标题出现的频率也相等，则标题顺序靠前的单词优先输出，
     * 若标题顺序也一样，则正文顺序靠前的单词优先输出。
     * 输入：N、M、2 * M 行字符串
     * 输出：出现频率最高的 N 个单词
     */
    @Data
    @AllArgsConstructor
    class Dto {
        private char c;
        private int total;
        private int title;
        private int titleAsc;
        private int bodyAsc;
    }
    private char[] frequency(String[][] press, int n) {
        HashMap<Character, int[]> map = new HashMap<>();
        // 标记位，标记出现的顺序
        int flag = 1;
        for (String[] p : press) {
            // 标题
            for (int i = 0; i < p[0].length(); i++) {
                char c = p[0].charAt(i);
                // map，key为char， value为数组
                // item[0]: 频率总数， item[1]: 标题个数， item[2]: 标题顺序， item[3]：正文顺序
                int[] item = map.getOrDefault(c, new int[]{0, 0, 0, 0});
                item[0] += 3;
                item[1] += 1;
                if (item[2] == 0) {
                    item[2] = flag++;
                }
                map.put(c, item);
            }
            // 正文
            for (int i = 0; i < p[1].length(); i++) {
                char c = p[1].charAt(i);
                int[] item = map.getOrDefault(c, new int[]{0, 0, 0, 0});
                item[0] += 1;
                if (item[3] == 0) {
                    item[3] = flag++;
                }
                map.put(c, item);
            }
        }
        // 创建优先队列
        PriorityQueue<Dto> queue = new PriorityQueue<>(map.size(), (o1, o2) -> {
            if (o1.getTotal() != o2.getTotal())
                return o2.getTotal() > o1.getTotal() ? 1 : -1;
            if (o1.getTitle() != o2.getTitle())
                return o2.getTitle() > o1.getTitle() ? 1 : -1;
            if (o1.getTitleAsc() != o2.getTitleAsc())
                return o1.getTitleAsc() > o2.getTitleAsc() ? 1 : -1;
            return o1.getBodyAsc() > o2.getBodyAsc() ? 1 : -1;
        });
        // 将map插入队列
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            queue.offer(new Dto(entry.getKey(), entry.getValue()[0], entry.getValue()[1], entry.getValue()[2], entry.getValue()[3]));
        }
        // 从队列中获取
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Objects.requireNonNull(queue.poll()).getC();
        }
        return ans;
    }

    @Test
    void test() {
//        System.out.println(frequency(new String[][]{new String[]{"assdd", "ghjeaaashhhzsww"}, new String[]{"asdfghjk", "asdafgawegbnbvczxcv"}}, 3));
        System.out.println(frequency(new String[][]{new String[]{"asaass", "gg"}, new String[]{"ddd", "asfffghj"}}, 7));
    }
}
