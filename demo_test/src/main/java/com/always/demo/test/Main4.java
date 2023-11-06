package com.always.demo.test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main4 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//        StringBuffer bff = new StringBuffer();
//        String ip = "255.255.255";
//        String[] split = ip.split("\\.");
//        for (int i = 0; i < split.length; i++) {
//            String str = split[i];
//            String binaryString = Integer.toBinaryString(Integer.valueOf(str));
//            bff.append(binaryString);
//        }
//        int anInt = Integer.parseInt(bff.toString(), 2);
//        System.out.println(anInt);
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));  // 1111111.11111111.11111111.11111111

        int anInt = Integer.parseInt("1111111", 2);
        System.out.println(anInt);

        double pow1 = Math.pow(2, 24);
        long l1 = 127 * (long) pow1;
        double pow2 = Math.pow(2, 16);
        long l2 = 255 * (long) pow2;
        double pow3 = Math.pow(2, 8);
        System.out.println("pow3" + ":" + pow3);
        long l3 = 255 * (long) pow3;

        long l = l1 + l2 + l3 + 255;
        System.out.println(l);

        System.out.println(Integer.MAX_VALUE);
    }
}