package ch06_sort;

import java.util.Scanner;

public class SelectionSort {
	// 바꾸는 메소드
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {

		for (int i = 0; i < n - 1; i++) {
			//정렬 되지 않은 부분의 가장 작은 요소의 인덱스 min을 저장.
			int min = i;
			for (int j = i + 1; i < n; j++)
				if (a[j] < a[min])	//요소 값들을 비교해서 j가 min보다 작다면
					min = j;		//min에다가 j를 넣는다.
			swap(a, i, min);		//요소도 a[min]에 a[j]값으로 바꾼다.
		}

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
