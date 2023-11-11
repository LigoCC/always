package com.always.demo.test;

import java.util.Scanner;

/**
 * 迷宫由n行m列单元格组成(n,m都小于等于50)
 * 每个单元格要么是空地，要么是障碍物。
 * 找到一条从起点到终点的最短路径长度。
 * <p>
 * &    1     2     3     4
 * 1  --0-- --0-- --1-- --0--
 * 2  --0-- --0-- --0-- --0--
 * 3  --0-- --0-- --1-- --0--
 * 4  --0-- --1-- --0-- --0--
 * 5  --0-- --0-- --0-- --1--
 */
public class Main14 {
    static int p; // 终点x坐标
    static int q;  // 终点y坐标
    static int min = 99999999;

    static int[][] arr = new int[100][100];    // 存地图,1表示空地,2表示障碍物
    static int[][] load = new int[100][100];   // 记录访问,0表示未访问,1表示访问

    public static void main(String[] args) {
        p = 4;
        q = 3;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            // 数据存入
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = in.nextInt();
                    load[i][j] = 0;
                }
            }
            // 起始位置、终点位置
            load[1][1] = 1;
            dfs(1, 1, 0);
            System.out.println(min);
        }
    }

    static void dfs(int x, int y, int step) {
        if (x == p && y == q) { // 到达终点
            if (step < min) {
                min = step;
            }
            return; // 回溯
        }
        // 右
        if (arr[x][y + 1] == 1 && load[x][y + 1] == 0) {
            load[x][y + 1] = 1;
            dfs(x, y + 1, step + 1);
            load[x][y + 1] = 0;
        }
        // 下
        if (arr[x + 1][y] == 1 && load[x + 1][y] == 0) {
            load[x + 1][y] = 1;
            dfs(x + 1, y, step + 1);
            load[x + 1][y] = 0;
        }
        // 左
        if (arr[x][y - 1] == 1 && load[x][y - 1] == 0) {
            load[x][y - 1] = 1;
            dfs(x, y - 1, step + 1);
            load[x][y - 1] = 0;
        }
        // 上
        if (arr[x - 1][y] == 1 && load[x - 1][y] == 0) {
            load[x - 1][y] = 1;
            dfs(x - 1, y, step + 1);
            load[x - 1][y] = 0;
        }
        return;
    }
}
