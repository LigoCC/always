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

            List<Node> list = new ArrayList<>();    // 存所有路径
            Node first = new Node(0, 0, null);
            ars[0][0] = 1;
            list.add(first);

            boolean key = true;
            while (key) {
                List<Node> tmp = new ArrayList<>();
                for (Node node : list) {
                    int x = node.getX();
                    int y = node.getY();

                    if (x == (m - 1) && y == (n - 1)) {
                        key = false;
                        break;
                    }

                    if (x + 1 < m) {
                        if (arr[x + 1][y] == 0 && ars[x + 1][y] == 0) {
                            Node newNode = new Node(x + 1, y, node);
                            ars[x + 1][y] = 1;
                            tmp.add(newNode);
                        }
                    }
                    if (x - 1 >= 0) {
                        if (arr[x - 1][y] == 0 && ars[x - 1][y] == 0) {
                            Node newNode = new Node(x - 1, y, node);
                            ars[x - 1][y] = 1;
                            tmp.add(newNode);
                        }
                    }
                    if (y + 1 < n) {
                        if (arr[x][y + 1] == 0 && ars[x][y + 1] == 0) {
                            Node newNode = new Node(x, y + 1, node);
                            ars[x][y + 1] = 1;
                            tmp.add(newNode);
                        }
                    }
                    if (y - 1 >= 0) {
                        if (arr[x][y - 1] == 0 && ars[x][y - 1] == 0) {
                            Node newNode = new Node(x, y - 1, node);
                            ars[x][y - 1] = 1;
                            tmp.add(newNode);
                        }
                    }
                }
                list = tmp;
            }

            for (Node node : list) {
                System.out.println(node.getX() + " " + node.getY());
            }
        }
    }

    static class Node {
        int x;
        int y;
        Node father;

        public Node(int x, int y, Node father) {
            this.x = x;
            this.y = y;
            this.father = father;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public Node getFather() {
            return this.father;
        }
    }
}
