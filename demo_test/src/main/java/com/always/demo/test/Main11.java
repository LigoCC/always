package com.always.demo.test;

import java.util.Scanner;

/**
 * 给定一个正整数数组，检查数组中是否存在满足规则X=Y+2Z的数字组合（用例保证最多只有一组解）。
 * 说明：数组元素可重复，但每个元素只能在结果算式中使用一次。如：数组成员为[0,0,1,5],0出现2次是允许的，但结果0=0+2*0虽然满足规则但不匀速，因为算式中使用了3个0.
 * <p>
 * 输入：
 * 第一行是数组长租N，3≤N≤100
 * 第二行是所有数组元素（取值范围为[0,65535]），空格分隔。
 * <p>
 * 输出：
 * 依次输出X Y Z的值，空格分隔。
 * <p>
 * 示例：
 * 输入：
 * 4
 * 2 8 4 0
 * 输出：
 * 8 4 2
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = in.nextInt();
            }

            int x;
            int y;
            int z;

            for (int i = 0; i < count; i++) {
                x = arr[i];
                for (int j = 0; j < count; j++) {
                    if (i != j) {
                        y = arr[j];
                        for (int k = 0; k < count; k++) {
                            if (k != i && k != j) {
                                z = arr[k];
                                if (x == (y + 2 * z)) {
                                    System.out.println(x + " " + y + " " + z);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
