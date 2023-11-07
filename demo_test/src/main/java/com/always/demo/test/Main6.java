package com.always.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line1 = in.nextLine();
            String[] line1Split = line1.split(" ");
            Integer count = Integer.valueOf(line1Split[0]); // 数组长度
            Integer yuNum = Integer.valueOf(line1Split[1]); // 优雅阈值
            if (yuNum > count) {
                System.out.println(0);
            } else {
                String line2 = in.nextLine();
                String[] line2Split = line2.split(" ");
                List<Integer> list = new ArrayList<>(); // 总数组
                for (int i = 0; i < count; i++) {
                    list.add(Integer.valueOf(line2Split[i]));
                }

                for (int startIndex = 0; startIndex < count - yuNum; startIndex++) {    // 子数组startIndex
                    for (int endIndex = startIndex + yuNum; endIndex < count; endIndex++) { // 子数组endIndex
//                        list.subList()
                    }
                }
            }
        }
    }
}
