package com.qjl.sort;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //  int[] arr = new int[]{101, 34, 119, 1, -1, 89, 7};
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 800000);
        }

        LocalDateTime now1 = LocalDateTime.now();
        quickSort(arr1, 0, arr1.length - 1);
        //  System.out.println(Arrays.toString(arr));
        LocalDateTime now2 = LocalDateTime.now();
        long between = ChronoUnit.MILLIS.between(now1, now2);
        System.out.println(between);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = arr[left];
        int l = left, r = right;
        while (l != r) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (arr[r] >= base && l < r) {
                r--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (arr[l] <= base && l < r) {
                l++;
            }

            // 上面的循环结束表示找到了位置 或者 (l>=r)了，交换两个数在数组中的位置
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        arr[left] = arr[l];
        arr[l] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // l的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

}
