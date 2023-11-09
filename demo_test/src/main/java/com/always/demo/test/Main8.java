package com.always.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] split1 = in.nextLine().split(" ");
            int m = Integer.valueOf(split1[0]);
            int n = Integer.valueOf(split1[1]);
            int[][] arr = new int[m][n];    // 记录坐标0，1
            int[][] ars = new int[m][n];    // 记录坐标0，1
            for (int i = 0; i < m; i++) {
                String[] lineArr = in.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    // 数据存入
                    arr[i][j] = Integer.valueOf(lineArr[j]);
                    // 初始化
                    ars[i][j] = 0;
                }
            }

            List<Node[]> list = new ArrayList<>();    // 存所有路径
            Node[] firstArr = new Node[m * n];
            firstArr[0] = new Node(0, 0);
            ars[0][0] = 1;
            list.add(firstArr);

            int index = 0;
            boolean key = true;
            Node[] result = null;
            while (key) {
                List<Node[]> tmp = new ArrayList<>();
                for (Node[] node : list) {
                    int x = node[index].getX();
                    int y = node[index].getY();

                    if (x == (m - 1) && y == (n - 1)) {
                        key = false;
                        result = node;
                        break;
                    }

                    if (x + 1 < m) {
                        if (arr[x + 1][y] == 0 && ars[x + 1][y] == 0) {
                            Node[] clone = node.clone();
                            clone[index + 1] = new Node(x + 1, y);
                            ars[x + 1][y] = 1;
                            tmp.add(clone);
                        }
                    }
                    if (x - 1 >= 0) {
                        if (arr[x - 1][y] == 0 && ars[x - 1][y] == 0) {
                            Node[] clone = node.clone();
                            clone[index + 1] = new Node(x - 1, y);
                            ars[x - 1][y] = 1;
                            tmp.add(clone);
                        }
                    }
                    if (y + 1 < n) {
                        if (arr[x][y + 1] == 0 && ars[x][y + 1] == 0) {
                            Node[] clone = node.clone();
                            clone[index + 1] = new Node(x, y + 1);
                            ars[x][y + 1] = 1;
                            tmp.add(clone);
                        }
                    }
                    if (y - 1 >= 0) {
                        if (arr[x][y - 1] == 0 && ars[x][y - 1] == 0) {
                            Node[] clone = node.clone();
                            clone[index + 1] = new Node(x, y - 1);
                            ars[x][y - 1] = 1;
                            tmp.add(clone);
                        }
                    }
                }
                index++;
                list = tmp;
            }

            if (null != result) {
                for (int i = 0; i < index; i++) {
                    System.out.println("(" + result[i].getX() + "," + result[i].getY() + ")");
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
