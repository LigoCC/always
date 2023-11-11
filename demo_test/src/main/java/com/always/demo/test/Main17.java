package com.always.demo.test;

import java.util.Scanner;

/**
 * 现有一个编号系统。每一个编号由小写英文字母(a-z)和数字(0-9)组成，比如’aads000’, ‘dd001’。编号不能全为字母或数字，允许数字部分有前导0或全为0。
 * 给定至少需要的编号个数 M 和编号中字母长度 N，请计算编号中数字的最短长度。其
 * 中，0<M <=2^50-1,0<N<=5。
 * <p>
 * 输入：
 * 两个非负整数M,N，用空格分隔。
 * <p>
 * 输出：
 * 正整数，表示数字部分的最短长短
 * <p>
 * 示例：
 * 输入：
 * 2599 1
 * 输出：
 * 2
 */
public class Main17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long m = in.nextLong();
            long n = in.nextLong();
            int length = 1;
            while (true) {
                double max = Math.pow(25, n) * Math.pow(10, length) + Math.pow(10, length) - 1;
                if (max >= m) {
                    System.out.println(length);
                    return;
                }
                length++;
            }
        }
    }
}
