package com.always.demo.test5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符全排列
 */
public class Main1 {

    static char[] arr;
    static int[] arrmap;

    static Set<String> set = new HashSet<>();

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

            List<String> list = new ArrayList<>(set);
            list.sort(Comparator.naturalOrder());
            list.forEach(t -> {
                System.out.println(t);
            });
        }
    }

    static void dfs(StringBuilder sb) {
        if (sb.length() == arr.length) {
            set.add(sb.toString());
        }
        for (int i = 0; i < arr.length; i++) {
            if (arrmap[i] == 0) {
                arrmap[i] = 1;
                sb.append(arr[i]);
                dfs(sb);
                sb.deleteCharAt(sb.length() - 1);
                arrmap[i] = 0;
            }
        }
    }
}
