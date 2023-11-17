package com.always.demo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * input:
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 * <p>
 * output:
 * 2200
 */
public class Main21 {
    static int money;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            money = in.nextInt();
            int num = in.nextInt();
            arr = new int[num][3];
            for (int i = 0; i < num; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2] = in.nextInt();
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < num; j++) {
                if (arr[j][2] != 0) {







                }
            }


        }
    }
}
