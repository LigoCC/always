package com.always.demo.test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int a = Integer.valueOf(in.nextLine());
            String b = in.nextLine();

            int x = 1;  // 窗口起始位置
            int y = a >= 4 ? 4 : a;  // 窗口结束位置
            int k = 1;  // 光标位置

            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c == 'U') {
                    // k = (k - 1) >= 1 ? (k - 1) : a;
                    if ((k - 1) >= 1) {
                        k = k - 1;
                        if (k < x) {
                            x--;
                            y--;
                        }
                    } else {
                        k = a;
                        y = a;
                        x = (a - 3) >= 1 ? (a - 3) : 1;
                    }
                } else if (c == 'D') {
                    // k = (k + 1) <= a ? (k + 1) : 1;
                    if ((k + 1) <= a) {
                        k = k + 1;
                        if (k > y) {
                            x++;
                            y++;
                        }
                    } else {
                        k = 1;
                        x = 1;
                        y = a > 4 ? 4 : a;
                    }

                }

            }
            StringBuffer bff = new StringBuffer();
            for (int i = 0; i <= y - x; i++) {
                bff.append(x + i);
                bff.append(" ");
            }
            System.out.println(bff);
            System.out.println(k);
        }
    }
}
