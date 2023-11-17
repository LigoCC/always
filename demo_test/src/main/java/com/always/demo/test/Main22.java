package com.always.demo.test;

import java.util.Scanner;

/**
 * 最大公约数
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();
            int gdf = gdf(x, y);
            System.out.println(gdf);
        }
    }

    static int gdf(int x, int y) {
        if (x < y) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        if (x % y == 0) {
            return y;
        } else {
            return gdf(y, x % y);
        }
    }
}
