package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * com.test
 * Created by ForMe
 * 2019/4/10
 * 10:05
 */
public class Test {

    public static void merge(List<Integer> numbers,int p,int q,int r){ //把数组进型分组，q为第一组的末尾
        int n1 = q - p + 1;
        int n2 = r - q;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < n1; i++)
            list1.add(numbers.get(p + i -1));
        for(int j = 0; j < n2; j++)
            list2.add(numbers.get(q + j));
        list1.add(Integer.MAX_VALUE); //哨兵
        list2.add(Integer.MAX_VALUE);
        int i = 0, j =0;
        for(int k = p-1; k < r; k++)
            if(list1.get(i) <= list2.get(j)) {
                numbers.set(k, list1.get(i));
                i++;
            }else {
                numbers.set(k,list2.get(j));
                j++;
            }
    }

    public static void sort(List<Integer> numbers, int p, int r){ //两路合并排序算法
        if(p < r) {
            int q = (r + p) / 2;
            sort(numbers, p, q);
            sort(numbers, q + 1, r);
            merge(numbers, p, q, r);
        }
    }

    public static void fastSort(List<Integer> arrs,int left,int right) { //快排
        if (left >= right) {
            return;
        } else {
            int temp = arrs.get(left);
            int i = left, j = right;
            while (i < j) {
                while (i < j && arrs.get(j) >= temp) {
                    j--;
                }
                if (i < j) {
                    int num = arrs.get(i);
                    arrs.set(i,arrs.get(j));
                    arrs.set(j,num);
                    i++;
                }
                while (i < j && arrs.get(i) <= temp) {
                    i++;
                }
                if (i < j) {
                    int num = arrs.get(j);
                    arrs.set(j,arrs.get(i));
                    arrs.set(i,num);
                    j--;
                }
            }
            fastSort(arrs, left, i - 1);
            fastSort(arrs, i + 1, right);
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 10000; i++) {
            int a = i + new Random().nextInt(10000);
            list.add(a);
            list1.add(a);
        }
        System.out.println("原数组：");
        for (int aa : list)
            System.out.print(aa + " ");
        System.out.println();
        long l1 = System.currentTimeMillis();
        sort(list,1,list.size());
        long l2 = System.currentTimeMillis();
        System.out.println("两路合并排序后的数组：");
        for (int a : list)
            System.out.print(a + " ");
        System.out.println();
        System.out.println("两路合并所用时为：" + (l2 - l1) + "ms");
        System.out.println();
        System.out.println("原数组：");
        for (int aa : list1)
            System.out.print(aa + " ");
        System.out.println();
        long l3 = System.currentTimeMillis();
        fastSort(list1,0,list.size() - 1);
        long l4 = System.currentTimeMillis();
        System.out.println("快速排序后的数组：");
        for (int a : list1)
            System.out.print(a + " ");
        System.out.println();
        System.out.println("快速排序所用时为：" + (l4 - l3) + "ms");
    }
}
