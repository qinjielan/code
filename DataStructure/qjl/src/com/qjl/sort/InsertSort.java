package com.qjl.sort;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
      //  int[] arr = new int[]{101, 34, 119, 1, -1, 89};
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 800000);
        }

        LocalDateTime now1 = LocalDateTime.now();
        insertSort(arr1);
     //   System.out.println(Arrays.toString(arr));
        LocalDateTime now2 = LocalDateTime.now();
        long between = ChronoUnit.MILLIS.between(now1, now2);
        System.out.println(between);
    }

    public static void insertSort(int[] arr) {
        int current = 0;
        int preIndex = 0;
        for (int i = 1; i < arr.length; i++) {

            preIndex = i-1; //待插入数的前一个数的索引
            current = arr[i]; //定义当前待插入的数
            // 拿当前的数与之前已排序序列逐一往前比较，
            // 如果比较的数据比当前的大，就把该数往后移一步
            // 说明
            // 1. preIndex >= 0 保证在给current 找插入位置，不越界
            // 2. current < arr[preIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[preIndex] 后移
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, preIndex + 1
            // 判断是否需要赋值，如果待插入值的索引等于preIndex + 1，就说明current是有序表里最大的，则不需要赋值
            if (preIndex + 1 != i) {
                arr[preIndex + 1] = current;
            }
        }
    }
}
