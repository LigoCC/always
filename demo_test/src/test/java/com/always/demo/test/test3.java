package com.always.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@Slf4j
@SpringBootTest(classes = test3.class)
public class test3 {

    int p; // 终点x坐标
    int q;  // 终点y坐标
    int min = 99999999;

    int[][] arr = new int[100][100];    // 存地图,1表示空地,2表示障碍物
    int[][] load = new int[100][100];   // 记录访问,0表示未访问,1表示访问

    @Test
    public void demo1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            // 数据存入
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                    load[i][j] = 0;
                }
            }
            // 起始位置、终点位置
            load[0][0] = 1;
            dfs(0, 0, 0);
            System.out.println(min);
        }
    }

    void dfs(int x, int y, int step) {
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
