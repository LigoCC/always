package com.always.demo.test;

import java.util.Scanner;

/**
 * 假设一个大小为 MxN的方格迷宫(O<M,N<=1000)，每个方格可以用(x,y)描述。
 * 入口在(0,0)，出口在(M-1,N-1)。用例保证挑战者可以从入口走到出口。
 * 迷宫中有K个墙壁(O<=K<M*N)，且挑战者只能向右或向下前进，
 * 因此在迷宫中存在一些挑战者不可达的位置，记为 P，
 * 也存在一些挑战者一旦到达就无法走到出口的位置，记为Q。
 * 给定迷宫大小和墙壁位置，请计算P和Q分别有多少个。
 * <p>
 * 输入：
 * 第一行是M N,空格分隔
 * 第二行是K
 * 之后K行是墙壁坐标，每行坐标均以空格分隔
 * <p>
 * 输出：
 * 两个整数，空格分隔，结尾不带回车换行
 * <p>
 * 示例：
 * 输入：
 * 6 4
 * 4
 * 0 2
 * 1 2
 * 4 1
 * 5 1
 * 输出：
 * 2 2
 */
public class Main19 {


    static int m;
    static int n;

    static int[][] arr; // 记录地形
    static int[][] mapArr;  // 记录路径
    static int[][] arriveArr;   // 记录可达
    static int[][] successArr;   // 记录可达且成功

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        arr = new int[m][n];
        mapArr = new int[m][n];
        arriveArr = new int[m][n];
        successArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
                mapArr[i][j] = 0;
                arriveArr[i][j] = 0;
                successArr[i][j] = 0;
            }
        }
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int kx = in.nextInt();
            int ky = in.nextInt();
            arr[kx][ky] = 1;
            arriveArr[kx][ky] = 1;  // 墙位置视为可达
            successArr[kx][ky] = 1;  // 墙位置视为可达
        }

        mapArr[0][0] = 1;
        arriveArr[0][0] = 1;
        successArr[0][0] = 1;
        dfs(0, 0);

        // 不可达
        int p = 0;
        // 死角
        int q = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arriveArr[i][j] == 0) {
                    p++;
                }
                if (arriveArr[i][j] != successArr[i][j]) {
                    q++;
                }
            }
        }
        System.out.println(p + " " + q);
    }

    static void dfs(int x, int y) {
        if (x == (m - 1) && y == (n - 1)) { // 到达终点
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mapArr[i][j] == 1) {
                        // System.out.println(i + " " + j);
                        successArr[i][j] = 1;
                    }
                }
            }
            // System.out.println("----------");
            return;
        }
        // you
        if (y + 1 < n && arr[x][y + 1] == 0) {
            mapArr[x][y + 1] = 1;
            arriveArr[x][y + 1] = 1;
            dfs(x, y + 1);
            mapArr[x][y + 1] = 0;
        }
        // xia
        if (x + 1 < m && arr[x + 1][y] == 0) {
            mapArr[x + 1][y] = 1;
            arriveArr[x + 1][y] = 1;
            dfs(x + 1, y);
            mapArr[x + 1][y] = 0;
        }
        // 死角
        return;
    }
}
