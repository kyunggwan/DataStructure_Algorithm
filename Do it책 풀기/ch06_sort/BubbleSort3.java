package ch06_sort;

import java.util.Scanner;

public class BubbleSort3 {
	// 바꾸는 메소드
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	//버블 정렬
	static void bubbleSort(int[] a, int n) {
		//a[k]보다 앞쪽은 정렬을 마친 상태
		int k = 0;
		while (k < n - 1) {
			//마지막으로 요소를 교환한 위치
			int last = n - 1;
			for (int j = n - 1; j > k; j--)
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;		//스왑이 일어난 지점 저장. last = j이다.
									//스왑이 안일어 나면 last는 변동 없음.
									//k = last를 하여, k아래 쪽은 검사안함.
				}
			k = last;
		}

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬(버전 3)");
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
