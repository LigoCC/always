package com.always.demo.test;

import java.util.Scanner;

/**
 * 1~n的最小公倍数
 */
public class Main26 {

    static int[] arr;   // 记录前n个数的最小公倍数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int i = in.nextInt();
            arr = new int[i + 1];
            arr[1] = 1; // 存前i个数的最小公倍数
            for (int j = 2; j <= i; j++) {
                gbs(j, arr[j - 1]);
            }
            System.out.println(arr[i]);
        }
    }

    // 2数最小公倍数
    public static void gbs(int a, int b) {
        arr[a] = (a * b) / gys(a, b);
    }

    // 2数最大公约数
    public static int gys(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0) {
            return b;
        } else {
            return gys(b, a % b);
        }
    }
}
