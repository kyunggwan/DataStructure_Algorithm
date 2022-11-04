package Chap6_Sorting;

//퀵 정렬

import java.util.Scanner;

class QuickSort {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 퀵 정렬 ---//
 static void quickSort(int[] a, int left, int right) {
     int pl = left;                   // 왼쪽 커서
     int pr = right;                  // 오른쪽 커서
     int x = a[(pl + pr) / 2];        // 피벗(가운데 요소)

     do {
         while (a[pl] < x) pl++;
         while (a[pr] > x) pr--;
         if (pl <= pr)
             swap(a, pl++, pr--);
     } while (pl <= pr);

     if (left < pr)  quickSort(a, left, pr);
     if (pl < right) quickSort(a, pl, right);
 }

 public static void main(String[] args) {
//     Scanner stdIn = new Scanner(System.in);
     int nx = 10;
     int[] x = new int[10];
     for (int ix = 0; ix < 10; ix++) {
    	    double d = Math.random();
    	    x[ix] = (int) (d* 20);
     }
     System.out.println("quick 정렬전");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
     System.out.println();

     quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬

     System.out.println("quick 정렬후:");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
