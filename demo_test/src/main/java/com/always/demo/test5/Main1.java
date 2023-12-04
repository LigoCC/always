package com.always.demo.test5;

import java.util.Scanner;
import java.util.Set;

public class Main1 {

    static char[] arr;
    static int[] arrmap;
    static Set<String> set;

    public static void main(String[] args) {
        // String str = "abcde";
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String str = in.nextLine();
            arr = new char[str.length()];
            arrmap = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            }

            for (int j = 0; j < str.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[j]);
                arrmap[j] = 1;
                dfs(sb);
                arrmap[j] = 0;
            }
        }
    }

    static void dfs(StringBuilder str) {
        for (int i = 0; i < arr.length; i++) {
            if (arrmap[i] == 0) {

            }
        }
    }
}
