package com.always.demo.test;

public class Main1 {
    public static void main(String[] args) {
        char A = 'A';
        char Z = 'Z';
        char a = 'a';
        char z = 'z';

        // char -> int
        System.out.println((int) A);    // 65
        System.out.println((int) Z);    // 90
        System.out.println((int) a);    // 97
        System.out.println((int) z);    // 122

        // int -> char
        int x = 65;
        char charx = (char) x;
        System.out.println(charx);      // A
    }
}
