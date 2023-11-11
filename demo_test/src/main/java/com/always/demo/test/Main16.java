package com.always.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，
 * 但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * <p>
 * 数据共2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 * <p>
 * 输入：
 * 6
 * 2 5 1 5 4 5
 * <p>
 * 输出：
 * 3
 */
public class Main16 {
    static int[] arr;   // 存输入信息
    static int length = 0;    // 最大步数
    static int num;
    static Map<Integer, Integer> map = new HashMap<>(); // 字典，key:位置 value:该位置处，后续最大步数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            num = in.nextInt();
            arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = in.nextInt();
            }
            map.put(num - 1, 1);
            for (int j = num - 1; j >= 0; j--) {
                dfs(j);
            }
            System.out.println(length);
        }
    }

    // index:当前求解位置
    static void dfs(int index) {
        int max = 1;
        for (int i = index + 1; i < num; i++) {
            if (arr[index] < arr[i]) {
                int step = map.get(i) + 1;
                if (step > max) {
                    max = step;
                }
            }
        }
        map.put(index, max);
        if (max > length) {
            length = max;
        }
    }
}