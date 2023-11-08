package com.always.demo.test;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main10 {
    public static void print(Point p) {
        if (p != null) {
            print(p.father);
            System.out.println("(" + p.px + "," + p.py + ")");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] grid = new int[row][col];
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Queue<Point> que = new LinkedList<Point>();
            que.offer(new Point(0, 0, null));
            grid[0][0] = 1;
            Point pos = null;
            while (true) {
                pos = que.poll();
                int px = pos.px;
                int py = pos.py;
                if (px == row - 1 && py == col - 1) {
                    break;
                } else {
                    if (px + 1 < row && grid[px + 1][py] == 0) {
                        grid[px + 1][py] = 1;
                        que.offer(new Point(px + 1, py, pos));
                    }
                    if (py - 1 >= 0 && grid[px][py - 1] == 0) {
                        grid[px][py - 1] = 1;
                        que.offer(new Point(px, py - 1, pos));
                    }
                    if (px - 1 >= 0 && grid[px - 1][py] == 0) {
                        grid[px - 1][py] = 1;
                        que.offer(new Point(px - 1, py, pos));
                    }
                    if (py + 1 < col && grid[px][py + 1] == 0) {
                        grid[px][py + 1] = 1;
                        que.offer(new Point(px, py + 1, pos));
                    }
                }
            }
            print(pos);
        }
    }
}

class Point {
    int px;
    int py;
    Point father;

    Point(int px, int py, Point father) {
        this.px = px;
        this.py = py;
        this.father = father;
    }

    Point() {
    }
}