package com.always.demo.test;

public class Main1 {
    public static void main(String[] args) {
        char A = 'A';
        char Z = 'Z';
        char a = 'a';
        char z = 'z';

        char zero = '0';
        char one = '1';
        char two = '2';
        char nine = '9';

        // char -> int
        System.out.println((int) A);    // 65
        System.out.println((int) Z);    // 90
        System.out.println((int) a);    // 97
        System.out.println((int) z);    // 122
        System.out.println("----------");
        System.out.println((int) zero);    // 48
        System.out.println((int) one);    // 49
        System.out.println((int) two);    // 50
        System.out.println((int) nine);    // 57
        System.out.println("----------");
        // int -> char
        int x = 65;
        char charx = (char) x;
        System.out.println(charx);      // A
    }
}
