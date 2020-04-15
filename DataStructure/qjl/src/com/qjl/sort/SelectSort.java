package com.qjl.sort;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{101, 34, 119, 1};
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 800000);
        }

        LocalDateTime now1 = LocalDateTime.now();
        selectionSort(arr1);

        //  System.out.println(Arrays.toString(arr));
        LocalDateTime now2 = LocalDateTime.now();
        long between = ChronoUnit.MILLIS.between(now1, now2);
        System.out.println(between);
    }

    public static void selectionSort(int[] arr) {
        int minIndex = 0;
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { //说明假定的最小值，并不是最小的
                    min = arr[j]; //重置最小值（min）
                    minIndex = j; //重置最小值索引（minIndex）
                }
            }
            // 如果当前的值是最小值，就不进行交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
    }
}
