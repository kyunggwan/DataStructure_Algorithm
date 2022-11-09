package ch06_sort;

import java.util.Scanner;

public class InsertionSort {
//단순 삽입 정렬
	// 값을 받은 뒤, 배열 앞에서 부터 insertionSort해서 작은 것은 위치를 바꾼다.
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			//a[i]값을 tmp로 저장해두고
			int tmp = a[i];
			//a[j]와 a[j-1]을 비교해서 a[j-1]이 더 크면 교환한다
			for (j = i; j > 0 && a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순 삽입 정렬");
		System.out.print("요솟 수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		insertionSort(x, nx); // 배열 x를 단순 삽입 정렬

		System.out.println("오름차순으로 정렬햇습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
