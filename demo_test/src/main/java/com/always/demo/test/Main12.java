package com.always.demo.test;

import java.util.Scanner;

/**
 * 给定一个表面数字 N，该数字是在如下机制下产生的：从1到N，遇到任意数
 * 字位置为数宇 4就直接跳过（比如 23会变成 25， 39 会变成 50，399 会变成 500），请计算表面数字 N 的真实值应该是多少。
 * <p>
 * 输入：
 * 数字 N，表示表面值。
 * <p>
 * 输出：
 * 数字，表示真实值。
 * <p>
 * 示例：
 * 输入：
 * 18
 * 输出：
 * 16
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int jumpNum = 0;
            for (int i = 1; i < num; i++) {
                String valueOf = String.valueOf(i);
                if (valueOf.contains("4")) {
                    jumpNum++;
                }
                if (jumpNum + i == num) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
