package ch06_sort;

import java.util.Scanner;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 배열을 나눔
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서, 시작점
		int pr = right; // 오른쪽 커서, 끝점
		int x = a[(pl + pr) / 2];// 피벗(가운데 요소)

		do {
			while (a[pl] < x)
				pl++;
			while (a[pr] > x)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		//왼쪽 커서가 끝점을 안 벗어낫으면 정렬
		if (left < pr)
			quickSort(a, left, pr);
		//오른쪽 커서가 시작점 밑으로 안내려갔으면 정렬
		if (pl < right)
			quickSort(a, pl, right);

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("배열을 나눕니다.");
		System.out.print("요솟 수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		quickSort(x, 0, nx - 1); // 배열 x를 단순 삽입 정렬
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]: " + x[i]);

	}
}
