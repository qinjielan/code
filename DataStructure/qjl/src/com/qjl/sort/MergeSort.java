package com.qjl.sort;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{101, 34, 119, 1, -1, 89, 7};
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 800000);
        }
        int[] temp = new int[arr1.length];
        LocalDateTime now1 = LocalDateTime.now();
        mergeSort(arr1, 0, arr1.length - 1, temp);
        //System.out.println(Arrays.toString(arr));
        LocalDateTime now2 = LocalDateTime.now();
        long between = ChronoUnit.MILLIS.between(now1, now2);
        System.out.println(between);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1; //中间索引
            mergeSort(arr, left, mid, temp); //向左递归进行分解
            mergeSort(arr, mid + 1, right, temp); //向右递归进行分解
            merge(arr, left, mid, right, temp); //合并
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化i, 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int t = 0; //temp的初始索引

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        //对比左右两个数组并将较小的数先放到辅助数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //左边的有序序列还有剩余的元素，就全部填充到temp
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //右边的有序序列还有剩余的元素，就全部填充到temp
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //把辅助数组复制到原数组
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }


    }
}
