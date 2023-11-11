package com.always.demo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 课本的长宽都是整数，分别记为L，W。如果课本X的长和宽都比课本Y的长和宽大，则可以将Y叠放在X 上面。给定一组课本，叠放时不可旋转，请计算最多可叠放的课本数。
 * <p>
 * 输入：
 * 二维数组形式的字符串，中间无空格。
 * <p>
 * 输出：
 * 一个整数，表示最大可叠放课本数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * 5
 * 13 12
 * 4 3
 * 6 7
 * 2 3
 * 23 21
 * <p>
 * 输出：
 * 4
 */
public class Main13 {
    static int num; // 书本总数
    static int max = 1; // 最大堆叠数
    static List<Book> list = new ArrayList<>(); // 书籍信息
    static Map<Integer, Integer> map = new HashMap<>();  // 记录 key:书位置 value:该书之下最大可堆叠数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            num = in.nextInt();
            // 存入信息
            for (int i = 0; i < num; i++) {
                list.add(new Book(in.nextInt(), in.nextInt()));
            }
            // 先长度方向排序
            list.sort(Comparator.comparingInt(Book::getLength));
            // 宽度方向组合，找到最大值(采用字典记录的倒排方式，正向暴力排序重复计算多、内存开销过大)
            map.put(num - 1, 1);
            for (int j = num - 1; j >= 0; j--) {
                dfs(j);
            }
            System.out.println(max);
        }
    }

    static void dfs(int index) {
        Book book = list.get(index);    // 该书本信息
        int thisBookMax = 1;
        for (int i = index + 1; i < num; i++) {
            Book bookI = list.get(i);
            if (book.getWidth() < bookI.getWidth()) {
                int thisNum = map.get(i) + 1;
                if (thisNum > thisBookMax) {
                    thisBookMax = thisNum;
                }
            }
        }
        if (thisBookMax > max) {
            max = thisBookMax;
        }
        map.put(index, thisBookMax);
    }

    static class Book {
        int length;
        int width;

        public Book() {
        }

        public Book(int length, int weigth) {
            this.length = length;
            this.width = weigth;
        }

        public int getLength() {
            return this.length;
        }

        public int getWidth() {
            return this.width;
        }
    }
}
