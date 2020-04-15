package com.qjl.sort;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{101, 34, 119, 1, -1, 89, 7};
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 800000);
        }

        LocalDateTime now1 = LocalDateTime.now();
        shellSort(arr1);
        //   System.out.println(Arrays.toString(arr));
        LocalDateTime now2 = LocalDateTime.now();
        long between = ChronoUnit.MILLIS.between(now1, now2);
        System.out.println(between);

    }

    public static void shellSort(int[] arr) {
        int current = 0;
        int preIndex = 0;
        for (int gap = arr.length >> 1; gap > 0; gap >>= 1) { //gap为分组的步长
            for (int i = gap; i < arr.length; i++) {
                preIndex = i - gap; //待插入数的前gap数的索引
                current = arr[i]; //当前待插入的数
                while (preIndex >= 0 && current < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // 当退出while循环时，说明插入的位置找到, preIndex + gap
                // 判断是否需要赋值，如果待插入值的索引等于preIndex + gap，就说明current是有序表里最大的，则不需要赋值
                if (preIndex + gap != i) {
                    arr[preIndex + gap] = current;
                }
            }

        }
    }
}
