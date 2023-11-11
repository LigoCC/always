package com.always.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * <p>
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，
 * 不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 * <p>
 * 输入描述：输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，
 * 其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * <p>
 * 输出描述：左上角到右下角的最短路径，格式如样例所示。
 * <p>
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * <p>
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 */
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
