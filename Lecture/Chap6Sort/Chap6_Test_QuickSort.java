package Chap6Sort;

public class Chap6_Test_QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		Stack st = new Stack(a.length);
		Point pt = new Point(left, right);
		st.push(pt);

		// 스택이 비어있지 않으면 비워내고, 좌표
		while (st.isEmpty() != true) {
			// rt에서 팝한다
			Point rt = st.pop();
			// pl, pr은 팝한 x,y값이고, 다음 좌표로 설정
			int pl = rt.getX();
			int pr = rt.getY();
			int nextPl = pl;
			int nextPr = pr;
			// pv은 기준점 피봇
			int pivot = a[(pr + pl) / 2];

			do {
				while (a[pl] < pivot)
					pl++;
				while (a[pr] > pivot)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			}
			// 만약 pl <= pr이면
			while (pl <= pr);
			if (nextPl < pr) {
				Point pt2 = new Point(nextPl, pr);
				st.push(pt2);
			}
			if (pl < nextPr) {
				Point pt3 = new Point(pl, nextPr);
				st.push(pt3);
			}
		}
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
