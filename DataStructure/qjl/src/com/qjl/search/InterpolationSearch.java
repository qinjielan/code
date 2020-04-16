package com.qjl.search;


import java.util.ArrayList;
import java.util.List;

//插值查找 是二分查找的优化（优化mid的值），数组必须是有序的
public class InterpolationSearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000,1000,1234};
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,10};
        List list = interpolationSearch(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    public static List interpolationSearch(int[] arr, int left, int right, int findVal) {
        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return new ArrayList<Integer>();
        }
        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal < midVal) { //向左递归
            return interpolationSearch(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) { //向右递归
            return interpolationSearch(arr, mid + 1, right, findVal);
        } else { //找到了值
		  /*1. 在找到mid 索引值，不要马上返回
		    2. 向mid 索引值的左边扫描，将所有满足的值， 的元素的索引，加入到集合ArrayList
		    3. 向mid 索引值的右边扫描，将所有满足的值， 的元素的索引，加入到集合ArrayList
		    4. 将Arraylist返回*/
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp = mid - 1;//初始化扫描指针
            while (temp >= 0 && arr[temp] == findVal) {//向左扫描
                list.add(temp--);//满足的值就加入list，并且temp向前移动一位
            }
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {//向右扫描
                list.add(temp++);
            }
            return list;
        }
    }
}
