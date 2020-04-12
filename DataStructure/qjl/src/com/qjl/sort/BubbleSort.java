package com.qjl.sort;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // int[] arr1 = new int[]{3, 5, 1, 6, 3, 7, 9, 8, 1};
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 800000);
        }

        LocalDateTime now1 = LocalDateTime.now();
        bubbleSort(arr1);
        LocalDateTime now2 = LocalDateTime.now();
        long between = ChronoUnit.MILLIS.between(now1, now2);
        System.out.println(between);
    }

    public static void bubbleSort(int[] arr) {
        // 冒泡排序的时间复杂度 O(n^2)
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) { //false表示在一趟排序中，一次交换都没有发生
                break;
            } else {
                flag = false; //注意：重置flag，进行下次判断
            }
        }
    }

}
