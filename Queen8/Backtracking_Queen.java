package Queen8;

public class Backtracking_Queen {
	public static void SolveQueen(int[][] d) {
		// 변수 설정, count
		int count = 0;
		int mode = 0;
		int ix = 0, iy = 0;
		// 스택을 만듦
		QueenStack st = new QueenStack(10);
		// 생성자, (ix, iy)는 좌표 주소가 된다.
		Point p = new Point(ix, iy);
		// 시작점 = 1 , count를 증가시키고, 시작점 1을 스택에 푸시한다
		d[ix][iy] = 1;
		count++;
		st.push(p);
		// count는 col 방향 이동하는 거를 센다. count == 각 행에 몇개의 퀸이 있는지 센다.
		//퀸을 모든 행에 배치할 동안
		while (count < d.length) {
			ix++;
			// cy는 행, row이며 내가 이동할 위치 
			int cy = 0;

			while (ix < d.length) {
				cy = NextMove(d, ix, cy);
					
				while (cy < d[0].length) {
					Point px = new Point(ix, iy);

					if (CheckMove(d, ix, iy)) {
						st.push(px);
						count++;
						break;
					}
					cy++;
				}
				if (cy != d[0].length) {
					break;
				} else {
					p = st.pop();
					count--;
					ix = p.getX();
					iy = p.getY();

				}

			}

		}
	}

	// row를 검사함. 왼쪽, 오른쪽을 검사
	public static boolean checkRow(int[][] d, int crow) {

		for (int i = 0; i < d.length; i++) {
			if (d[crow][i] == 1) {
				return false;
			}
		}

		return true;
	}

	// col을 검사. 위, 아래를 검사
	public static boolean checkCol(int[][] d, int ccol) {

		for (int i = 0; i < d[0].length; i++) {
			if (d[i][ccol] == 1) {
				return false;
			}
		}
		return true;
	}

	// 왼쪽 위쪽 대각선을 검사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7

		while (cx >= 0 && cx < d.length && cy >= 0 && cy < d[0].length) {

			if (d[cx][cy] == 1) {
				return false;
			}
			cx--;
			cy--;
		}

		return true;
	}

	// 오른쪽 위쪽 대각선을 검사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--

		while (cx >= 0 && cx <= d.length && cy >= 0 && cy <= d[0].length) {

			if (d[cx][cy] == 1) {
				return false;
			}
			cx--;
			cy++;
		}

		return true;
	}

	// 양옆, 위아래, 대각선에 1이 없으면 True를 반환한다
	public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;

		return false;

	}

	public static Integer NextMove(int[][] d, int row, int col) {// 다음 row에 대하여 이동할 col을 조사
		while (col < d.length) {
			if (CheckMove(d, row, col))
				return col;
			col++;
		}
		return d.length;
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
