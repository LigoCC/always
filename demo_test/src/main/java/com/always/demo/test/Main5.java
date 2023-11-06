package com.always.demo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Integer num = Integer.valueOf(in.nextLine());
            Map<Integer, List<Integer>> map1 = new HashMap<>(); // 机器1
            Map<Integer, List<Integer>> map2 = new HashMap<>(); // 机器2
            Map<Integer, List<Integer>> map3 = new HashMap<>(); // 机器3
            Map<Integer, List<Integer>> map4 = new HashMap<>(); // 机器4
            Map<Integer, List<Integer>> map5 = new HashMap<>(); // 机器5
            int order = 1;  // 存入序列
            for (int i = 0; i < num; i++) {
                String line = in.nextLine();
                if (line.startsWith("IN")) {
                    String[] takeIn = line.split(" ");
                    int channelNum = Integer.valueOf(takeIn[1]); // 机器编号
                    int level = Integer.valueOf(takeIn[2]);  // 优先级
                    if (channelNum == 1) {
                        order = getOrder(map1, order, level);
                    } else if (channelNum == 2) {
                        order = getOrder(map2, order, level);
                    } else if (channelNum == 3) {
                        order = getOrder(map3, order, level);
                    } else if (channelNum == 4) {
                        order = getOrder(map4, order, level);
                    } else if (channelNum == 5) {
                        order = getOrder(map5, order, level);
                    }
                } else if (line.startsWith("OUT")) {
                    String[] takeOut = line.split(" ");
                    int channelNum = Integer.valueOf(takeOut[1]);   // 机器编号
                    if (channelNum == 1) {
                        extracted(map1);
                    } else if (channelNum == 2) {
                        extracted(map2);
                    } else if (channelNum == 3) {
                        extracted(map3);
                    } else if (channelNum == 4) {
                        extracted(map4);
                    } else if (channelNum == 5) {
                        extracted(map5);
                    }
                }
            }
        }
    }

    private static int getOrder(Map<Integer, List<Integer>> map, int order, int level) {
        if (map.containsKey(level)) {
            List<Integer> list = new ArrayList<>();
            list.addAll(map.get(level));
            list.add(order);
            map.put(level, list);
            order++;
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(order);
            map.put(level, list);
            order++;
        }
        return order;
    }

    private static void extracted(Map<Integer, List<Integer>> map) {
        if (map.isEmpty() || map.size() == 0) {
            System.out.println("Null");
        } else {
            // 获取最高优先级
            Set<Integer> keySet = map.keySet();
            List<Integer> keyArray = new ArrayList<>(keySet);
            keyArray.sort(new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return i2 - i1;
                }
            });
            Integer index = keyArray.get(0);    // 优先级最高的key

            List<Integer> values = map.get(index);
            Integer out = values.get(0);
            System.out.println(out);
            if (values.size() > 1) {
                ArrayList<Integer> newValues = new ArrayList<>(values);
                newValues.remove(0);
                map.put(index, newValues);
            } else {
                map.remove(index);
            }
        }
    }
}
