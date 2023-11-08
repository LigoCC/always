package com.always.demo.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] split1 = in.nextLine().split(" ");
            int m = Integer.valueOf(split1[0]);
            int n = Integer.valueOf(split1[1]);
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                String[] lineArr = in.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    // 数据存入
                    arr[i][j] = Integer.valueOf(lineArr[j]);
                }
            }

            List<List<Node>> list = new ArrayList<>();    // 存所有路径
            List<Node> tmp = new ArrayList<>();
            Node node = new Node(0, 0);
            tmp.add(node);
            list.add(tmp);

            List<List<Node>> result = extracted(m, n, arr, list);

            for (List<Node> nodes : result) {
                for (Node oneNode : nodes) {
                    System.out.println("(" + oneNode.getX() + "," + oneNode.getY() + ")");
                }
            }
        }
    }

    private static List<List<Node>> extracted(int m, int n, int[][] arr, List<List<Node>> list) {
        if (null == list || list.size() == 0) {
            return list;
        }

        List<Node> nodes = list.stream().map(t -> t.get(t.size() - 1)).distinct().collect(Collectors.toList());
        if (nodes.size() == 1 && nodes.get(0).getX() == (m - 1) && nodes.get(0).getY() == (n - 1)) {
            return list;
        }

        List<List<Node>> tmp = new LinkedList<>();

        for (List<Node> lineList : list) {
            Node xy = lineList.get(lineList.size() - 1);    // 最后一个

            Integer x = xy.getX();  // 行
            Integer y = xy.getY();  // 列

            if (x == (m - 1) && y == (n - 1)) {
                List<Node> listNew = new ArrayList<>(lineList);
                tmp.add(listNew);
            } else {
                if (x + 1 < m) {
                    if (arr[x + 1][y] == 0) {
                        List<Node> listNew = new ArrayList<>(lineList);

                        Node newNode = new Node(x + 1, y);
                        listNew.add(newNode);
                        tmp.add(listNew);
                    }
                }
                if (y + 1 < n) {
                    if (arr[x][y + 1] == 0) {
                        List<Node> listNew = new ArrayList<>(lineList);
                        Node newNode = new Node(x, y + 1);
                        listNew.add(newNode);
                        tmp.add(listNew);
                    }
                }
            }
        }
        list = tmp;
        return extracted(m, n, arr, list);
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
