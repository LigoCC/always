package com.always.demo.test;

import java.util.Scanner;

public class Main24 {
    static int[] arr;
    static int[] beforeMap;    // 记录i位置之前最长序列（包含本人）
    static int[] afterMap;    // 记录i位置之后最长序列（包含本人）

    static int num; // 总人数
    static int length = 0;  // 队伍最长人数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            num = in.nextInt();
            arr = new int[num];
            afterMap = new int[num];
            beforeMap = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = in.nextInt();
            }
            beforeMap[0] = 1;
            for (int i = 1; i < num; i++) {
                beforeDfs(i);
            }
            afterMap[num - 1] = 1;
            for (int j = num - 1; j >= 0; j--) {
                afterDfs(j);
            }
        }

        int maxLength = 0;
        for (int k = 1; k < num - 1; k++) {
            int i = beforeMap[k] + afterMap[k] - 1;
            if (maxLength < i) {
                maxLength = i;
            }
        }
        System.out.println(num - maxLength);
    }

    static void beforeDfs(int k) {
        int max = 1;
        for (int i = 0; i < k; i++) {
            if (arr[k] > arr[i]) {
                if (max < beforeMap[i] + 1) {
                    max = beforeMap[i] + 1;
                }
            }
        }
        beforeMap[k] = max;
    }

    static void afterDfs(int k) {
        int max = 1;
        for (int i = k + 1; i < num; i++) {
            if (arr[k] > arr[i]) {
                if (max < afterMap[i] + 1) {
                    max = afterMap[i] + 1;
                }
            }
        }
        afterMap[k] = max;
    }
}
