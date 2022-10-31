package MazeProblem;

//좌표를 저장하는 Offsets
class Offsets {
	public int a;
	public int b;

	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Offsets [a=" + a + ", b=" + b + "]";
	}

}

public class MazingProblem {

	static void path(int[][] maze, int[][] mark, int x, int y) {
		// 스택을 불러옴
		Stack st = new Stack(100);
		// moves[]라는 8개짜리 배열 하나 만듦
		Offsets moves[] = new Offsets[8];
		// moves배열 안에 Offsets객체를 만듦. moves는 위에서 설정한 대로 8개까지 가능
		for (int i = 0; i < 8; i++)
			moves[i] = new Offsets(0, 0);

		moves[0].a = -1; // 서쪽
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;

		// 시작점 1,1
		mark[1][1] = 1;

		// Item은 임시좌표 저장소, temp라고 명명
		Item temp = new Item(0, 0, 0);
		// 초기값으로 (1,1,1)로 시작
		temp.setX(1);
		temp.setY(1);
		temp.setDir(2);
		st.push(temp);
		System.out.println("초기:: " + temp.toString());

		while (!st.isEmpty()) // stack not empty, 스택이 공백이 될때까지 반복
		{
			// temp = 지나온 경로를 pop해라
			temp = st.pop();
			// ix, iy는 좌표 저장 주소
			int ix = temp.getX();
			int iy = temp.getY();
			int dir = temp.getDir();

			while (dir < 8) // moves forward, d는 방향, 8방위를 조사
			{
//				System.out.println(ix + " " + iy + " " + dir); // output path
				// 가려고 하는 방향으로 x+, y+
				int nextX = ix + moves[dir].a; // x - 1
				int nextY = iy + moves[dir].b; // y

				if ((nextX == 15) && (nextY == 12)) { // reached exit, 출구 발견시에
					// output path, 마지막 경로 지점을 푸시
					st.push(new Item(ix, iy, dir));
					// 마지막 지점까지 지정
					st.push(new Item(nextX, nextY, dir));

//					System.out.println("the term near the exit: " + ix + " " + iy);
					System.out.println("exit: " + 12 + " " + 15);
					return;
				}
				if ((maze[nextX][nextY] == 0) && (mark[nextX][nextY] == 0)) { // new position 시도해보지 않은 위치, 이동가능 위치
					// 다음 위치 발견하면 기존 위치를 mark에 1로 저장
					mark[ix][iy] = 1;
					// 매번 객체를 만들어서 저장
					Item tmp = new Item(ix, iy, dir + 1);
					// 그 좌표를 스택에 push
					st.push(tmp);
					// 다음 좌표로 전환
					ix = nextX;
					iy = nextY;
					// dir을 초기화 해줘야 방향을 처음부터 다시 검사함.
					dir = 0;

				} else
					dir++; // try next direction
			}
		}
		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {
		// maze, mark를 만듦.
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };

		// 미로의 테두리에 1의 벽을 침.
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				// maze출구인 경우
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;

			}
		}
		// 미로 출력
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}
		// 지나가는 길 출력
		path(maze, mark, 12, 15);
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
