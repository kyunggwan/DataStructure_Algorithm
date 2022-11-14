package Chap6Sort;

public class Chap6_Test_HeapSort {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 정렬 메소드
	static void makeHeap(int[] bx, int position, int value) {
		// position은 키, value는 값
		bx[position] = value;
		// c는 자식값
		int c = 0;
		// root는 부모값
		int root = (c - 1) / 2;

		// 부모 값이 더 클 때까지 반복해서 자리 바꿔준다
		for (int i = position; i > 0; i /= 2) {
			if (bx[i] <= bx[root]) {
				break;
			}
			if (i == 1) {
				break;
			}
			swap(bx, bx[i], bx[root]);
		}

	}

	static void useHeap(int[] bx, int cnt) {
		for (int i = 1; i <= cnt; i++) {
			/// ??
		}

	}

	// --- 힙 정렬 ---//
	static void heapSort(int[] a, int n) {
		// b라는 임시배열 생성
		int[] b = new int[a.length];
		// ix = 0 부터 배열크기까지 증가하면서 makeHeap메소드 실행
		for (int ix = 0; ix < a.length; ix++)
			makeHeap(b, ix + 1, a[ix]);
		// makeHeap = 정렬이 된 상태이다.
		System.out.println();
		System.out.println("makeHeap:");
		// useHeap???
		useHeap();

	}

	public static void main(String[] args) {
		// 배열의 크기
		final int count = 10;
		int[] x = new int[count];
		// 랜덤수 생성
		for (int i = 0; i < count; i++) {
			x[i] = (int) (Math.random() * 30);
		}
		System.out.println("정렬전:");
		for (int i = 0; i < count; i++)
			System.out.print(" " + x[i]);
		heapSort(x, count); // 배열 x를 힙정렬
		System.out.println();
		System.out.println("정렬후: ");
		for (int i = 0; i < count; i++)
			System.out.print(" " + x[i]);
	}
}
