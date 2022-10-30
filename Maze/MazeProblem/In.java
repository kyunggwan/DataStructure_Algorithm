package MazeProblem;

public class In {
	private static int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1 }, // 1
			{ 1, 0, 1, 1, 0, 1, 1, 1 }, // 2
			{ 1, 0, 0, 1, 0, 1, 1, 1 }, // 3
			{ 1, 1, 0, 0, 0, 1, 1, 1 }, // 4
			{ 1, 1, 1, 0, 0, 0, 1, 1 }, // 5
			{ 1, 0, 0, 0, 1, 1, 1, 1 }, // 6
			{ 1, 1, 0, 1, 0, 0, 0, 1 }, // 7
			{ 1, 0, 0, 0, 0, 1, 0, 0 }, // 8
			{ 1, 1, 1, 1, 1, 1, 1, 1 } // 9
	};
	private int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북 동 남 서
	private int m = maze.length - 2;
	private int n = maze[0].length - 1;

	public void MazePath() { // 알고리즘대로 프로그램 작성
		int mark[][] = new int[maze.length][maze[0].length];

		Stack st = new Stack(100);
		Stack st1 = new Stack(100); // 올바른 경로 삽입할 스택

		st.push(new Item(1, 1, 1)); // 초기출발위치? 방향 설정

		while (st.isEmpty() != true) {
			Item temp = (Item) st.pop(); // 지나온 경로를 pop함

			while (temp.dir <= 3) {
				int nextI = temp.x + move[temp.dir][0]; // 갈려고하는 방향으로 x+
				int nextJ = temp.y + move[temp.dir][1]; // 갈려고하는 방향으로 y+

				if (nextI == m && nextJ == n) { // 미로경로 발견
					System.out.println("경로를 발견했습니다");

					st.push(new Item(temp.x, temp.y, temp.dir)); // 마지막 경로 지정
					st.push(new Item(nextI, nextJ, 0)); // 마지막 지점 지정

					while (st.isEmpty() != true) {
						st1.push((Item) st.pop());
					}

					while (st1.isEmpty() != true) {
						temp = (Item) st1.pop(); // 올바른 경로 출력
						System.out.println(temp);
						maze[temp.x][temp.y] = 2;
					}
					displayMaze(); // 경로 확인 완료후 출력
					return;
				}

				if (maze[nextI][nextJ] == 0 && mark[nextI][nextJ] == 0) {// 이동가능&시도해보지 않은위치
					mark[nextI][nextJ] = 1;
					st.push(new Item(temp.x, temp.y, temp.dir)); // 지나온경로를 스택에 push

//temp = new Item(nextI,nextJ,0); //새로운 위치와 방향 설정 방향은 초기화
					temp.x = nextI;
					temp.y = nextJ;
					temp.dir = 0;
				} else {
					temp.dir++;
				}
			}
		}
		System.out.println("경로를 발견하지 못했습니다");

	}

	public void displayMaze() {
		String[] str = { "□", "■", "☞" };
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(str[(maze[i][j])]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		MazePath();
	}
}