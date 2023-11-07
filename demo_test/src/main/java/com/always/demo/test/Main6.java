package com.always.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line1 = in.nextLine();
            String line2 = in.nextLine();
            String[] line1Split = line1.split(" ");
            String[] line2Split = line2.split(" ");
            Integer yuNum = Integer.valueOf(line1Split[1]); // 优雅阈值
            List<String> list = Arrays.asList(line2Split);  // 总数组
            if (yuNum > list.size()) {
                System.out.println(0);
            } else {
                int count = 0;  // 优雅子数组数量
                for (int startIndex = 0; startIndex < list.size() - yuNum; startIndex++) {    // 子数组startIndex
                    for (int endIndex = startIndex + yuNum; endIndex < list.size(); endIndex++) { // 子数组endIndex
                        int max = 0;    // 最大优雅值
                        List<String> subbed = list.subList(startIndex, endIndex);   // 子数组
                        while (subbed.size() > 0) {
                            int sizeStart = subbed.size();
                            List<String> removedList = new ArrayList<>();
                            removedList.add(subbed.get(0));
                            subbed.remove(removedList);
                            int sizeEnd = subbed.size();
                            max = (sizeStart - sizeEnd) > max ? (sizeStart - sizeEnd) : max;
                            if (max >= yuNum) {
                                subbed = new ArrayList<>();
                                count++;
                            }
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
}
