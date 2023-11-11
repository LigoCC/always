package com.always.demo.test;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
public class Main15 {
    static int[] arr;   // 存高度
    static int length = 0;    // 步数
    static int num;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            num = in.nextInt();
            arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = in.nextInt();
            }

            for (int loc = 0; loc < num; loc++) { // 起始位置
                List<Integer> list = new ArrayList<>();
                list.add(arr[loc]);
                dfs(list, loc + 1);
            }

            System.out.println(length);
        }
    }

    static void dfs(List<Integer> list, int index) {
        if (index == num) {
            if (list.size() > length) {
                length = list.size();
            }
            return;
        }

        for (int i = index; i < num; i++) {
            List<Integer> newList = new ArrayList<>(list);
            if (newList.get(newList.size() - 1) < arr[i]) {
                newList.add(arr[i]);
            }
            dfs(newList, i + 1);
        }
    }
}