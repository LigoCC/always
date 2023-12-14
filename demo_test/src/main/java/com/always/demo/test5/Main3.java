package com.always.demo.test5;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();  // 最大信道阶数
        int[] N = new int[20];  // 每阶信道通道数量
        for (int i = 0; i <= R; i++) {
            N[i] = scanner.nextInt();
        }
        int D = scanner.nextInt();  // 每人所需
        System.out.println(func1(R, N, D));
    }

    public static int func1(int R, int[] N, int D) {
        int[] subtrahend = new int[50];
        int subtrahendSize = 0;  // 位数
        while (D > 0) { // 没人所需，十进制转二进制
            subtrahend[subtrahendSize++] = D % 2;
            D /= 2;
        }
        int count = 0;
        for (int i = R; i >= subtrahendSize; i--) {  // 单个信道大于所需的数量
            count += N[i];
        }
        int[] minuend = new int[subtrahendSize];
        for (int i = 0; i < subtrahendSize; i++) {  // 低位存入minuend
            minuend[i] = N[i];
        }
        while (func2(minuend, subtrahend, subtrahendSize)) {
            count++;
        }
        return count;
    }

    public static boolean func2(int[] minuend, int[] subtrahend, int size) {
        for (int i = size - 1; i >= 0; i--) {
            if (minuend[i] >= subtrahend[i]) {  // 本位够用，从本位减
                minuend[i] -= subtrahend[i];
            } else {  // 本位不够
                if (func3(minuend, i + 1) < func3(subtrahend, i + 1)) { // 从高位借
                    int j = i + 1;
                    while (j < size) {
                        if (minuend[j] > 0) {
                            minuend[j] -= 1;
                            return true;
                        } else {
                            j += 1;
                        }
                    }
                    return false;
                } else {  // 高位不够，从低位借
                    minuend[i] -= subtrahend[i];
                    minuend[i - 1] += minuend[i] << 1;
                    minuend[i] = 0;
                }
            }
        }
        return true;
    }

    public static int func3(int[] bin, int binSize) {
        int ans = 0;
        for (int i = 0; i < binSize; i++) {
            ans += bin[i] * (1 << i);
        }
        return ans;
    }
}