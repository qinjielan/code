package com.qjl.recursion;


public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(factorial(3));

    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
