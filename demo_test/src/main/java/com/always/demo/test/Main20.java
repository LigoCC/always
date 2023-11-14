package com.always.demo.test;

import java.util.Scanner;

/**
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * <p>
 * 数据范围：字符串长度：1≤s≤150
 * <p>
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 * <p>
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 * <p>
 * 输入：
 * asdfas
 * werasdfaswer
 * <p>
 * 输出：
 * 6
 */
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            int max = 0;
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = i; j <= s1.length(); j++) {
                    String sub = s1.substring(i, j);
                    if (s2.contains(sub)) {
                        int length = j - i;
                        max = Math.max(max, length);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
