package com.always.demo.test;

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
 * 输入：
 * [[13,12],[4,3],[6,7],[2,3],[23,21]] .
 * 输出：
 * 4
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int[][] arr = new int[num][2];
            // 数组存入
            for (int i = 0; i < num; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }


        }
    }
}
