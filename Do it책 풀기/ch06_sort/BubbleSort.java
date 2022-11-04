package ch06_sort;

import java.util.Scanner;

public class BubbleSort {

	// 변환하는 메소드
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 버블 정렬, 앞에 것이 더 크면 swap메소드 발동해서 앞에 것과 교환
	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++)
			for (int j = n - 1; j > i; j--)
				if (a[j - 1] > a[j])
					swap(a, j - 1, j);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬(버전 1)");
		System.out.print("요소 수 : ");

		// 요소수를 입력 받아 배열을 생성
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		// 배열의 내용 입력
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]:");
			x[i] = stdIn.nextInt();
		}
		// 버블 정렬 실행
		bubbleSort(x, nx);
		// 배열 출력
		System.out.println("오름차순 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print("x[" + i + "] = " + x[i] + "  ");
	}

}
