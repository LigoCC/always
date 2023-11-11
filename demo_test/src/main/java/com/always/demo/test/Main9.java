package com.always.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int anInt = in.nextInt();
            int[] arr = new int[anInt]; // 存数据
            for (int i = 0; i < anInt; i++) {
                arr[i] = in.nextInt();
            }

            List<Node> line = new ArrayList<>();
            line.add(new Node(arr[0], 0));

            for (int i = 1; i < anInt; i++) {

            }

        }
    }
}

class Node {
    int num;
    int index;

    public Node(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int getNum() {
        return this.num;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}