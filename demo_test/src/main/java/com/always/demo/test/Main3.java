package com.always.demo.test;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // 人数
            int num = Integer.valueOf(in.nextLine());
            // 排序规则
            int order = Integer.valueOf(in.nextLine());
            // map，存储score + names
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < num; i++) {
                String line = in.nextLine();
                String[] split = line.split(" ");
                String name = split[0];
                int score = Integer.valueOf(split[1]);

                if (map.containsKey(score)) {
                    List<String> list = map.get(score);
                    ArrayList<String> nameListNew = new ArrayList<>(list);
                    nameListNew.add(name);
                    map.put(score, nameListNew);
                } else {
                    List<String> list = Arrays.asList(name);
                    map.put(score, list);
                }
            }
            // 成绩
            Set<Integer> set = map.keySet();
            ArrayList<Integer> arrayList = new ArrayList<>(set);
            if (order <= 0) {
                arrayList.sort(new Comparator<Integer>() {
                    public int compare(Integer i1, Integer i2) {
                        return i2 - i1;
                    }
                });
            } else {
                arrayList.sort(new Comparator<Integer>() {
                    public int compare(Integer i1, Integer i2) {
                        return i1 - i2;
                    }
                });
            }
            for (Integer score : arrayList) {
                List<String> names = map.get(score);
                for (String name : names) {
                    System.out.println(name + " " + score);
                }

            }
        }
    }
}
