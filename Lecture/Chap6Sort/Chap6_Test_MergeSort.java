package Chap6Sort;

import java.util.Scanner;

public class Chap6_Test_MergeSort {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(int[] a, int lefta, int righta, int leftb, int rightb) {
		int[] t = new int[a.length]; // 작업용 배열
		int p = lefta; // p는 배열1의 시작 인덱스
		int q = leftb; // q는 배열2의 시작 인덱스

		int ix = 0;
		// 배열1의 첫값과 배열2의 첫값을 비교해서 작은 값을 t[]에 넣음
		while (p <= righta && q <= rightb) {
			if (a[p] <= a[q]) {
				t[ix++] = a[p++];
			} else {
				t[ix++] = a[q++];
			}
		}
		// 모자란 부분 채워넣기
		while (p <= righta) {
			t[ix++] = a[p++];
		}
		while (q <= rightb) {
			t[ix++] = a[q++];
		}
		// 원래배열 a에 다시 넣는다.
		p = lefta;
		for (int idx = 0; idx < ix; idx++) {
			a[p++] = t[idx];
		}
	}

	// --- 퀵 정렬(비재귀 버전) 이용---//
	static void MergeSort(int[] a, int left, int right) {

		if (left < right) {
			int middle = (left + right) / 2;
			// 왼쪽으로 배열1 만들고, 정렬
			MergeSort(a, left, middle);
			// 오른쪽으로 배열2 만들고, 정렬
			MergeSort(a, middle + 1, right);
			// merge메소드(배열, 배열1의 시작점과 끝점, 배열2의 시작점과 끝점)
			merge(a, left, middle, (middle + 1), right);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nx;
		System.out.println("[mergeSort를 이용한 정렬 프로그램입니다]");
		System.out.print("[정렬할 난수 갯수를 입력하세요(0은 종료)]  ");
		while ((nx = sc.nextInt()) != 0) {
			int[] x = new int[nx];
			for (int ix = 0; ix < nx; ix++) {
				double d = Math.random();
				x[ix] = (int) (d * 50);
			}
			for (int i = 0; i < nx; i++)
				System.out.print(" " + x[i]);
			System.out.println();
			MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬

			System.out.println("오름차순으로 정렬했습니다.");
			for (int i = 0; i < nx; i++)
				System.out.print(" " + x[i]);
			System.out.println("");
			System.out.println("");
			System.out.print("[정렬할 난수 갯수를 입력하세요(0은 종료)]  ");
		}
		System.out.println("[종료합니다]");
	}
}
