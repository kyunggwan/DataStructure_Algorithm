package Maze;
//이 c++문제를 보고 자바로 바꾸기
public class MazingProblemCPP {

//struct items {
//int x, y, dir;
//};
//
//ostream& operator<<(ostream& os, items& item)
//{
//return os << item.x << "," << item.y << "," << item.dir;
//}
//
//struct offsets {
//int a, b;
//};
//
	//자바의 enumeration 공부하기
//enum directions { N, NE, E, SE, S, SW, W, NW };
//offsets moves[8];

//int maze[100][100];
//int mark[100][100]; 내가 지나온 길
//

	public static void main(String[] args) {
		int[][] maze = new int[100][100];
		int[][] mark = new int[100][100];

//void path(int m, int p)  m,p는 출구 좌표
////Output a path (if any) in the maze; rows is m, cols is p;
//{
//	//start at (1,1) 시작점
//	mark[1][1] = 1;
//	Stack<items> stack(m * p);
//	items temp;
//	temp.x = 1; temp.y = 1; temp.dir = E; E대신에 숫자 쓸거임. 동쪽부터 간다, d는 방향
//	stack.Push(temp);
//
//	while (!stack.IsEmpty()) // stack not empty
//	{
//		temp = stack.Pop(); // unstack 막히면 뒤로가기 = pop
//		int i = temp.x; int j = temp.y; int d = temp.dir; d는 방향
//		while (d < 8) // moves forward
//		{
//			//outFile << i << " " << j << " " << d << endl;
//			int g = i + moves[d].a;  moves는 배열, a, b는 xy좌표
//			int h = j + moves[d].b;		g,h는 다음 이동방향
//			if ((g == m) && (h == p)) { // reached exit
//										// output path  m , p 는 출구 좌표
//				cout << stack;
//
//				cout << "the term near the exit: " << i << " " << j << endl;
//				cout << "exit: " << m << " " << p << endl;
//				return;
//			}
//			if ((!maze[g][h]) && (!mark[g][h])) { // new position
//				mark[g][h] = 1; //자바는 enumeration 안되니까 숫자로 방향 넣을거임.
//				//push the old temp to the stack, but the direction changes.
//				//Because the neighbor in the direction of d has been checked.
//				temp.x = i;  temp.y = j; temp.dir = d + 1;
//				stack.Push(temp); // stack it
//				i = g; j = h; d = N; // moves to (g,h)
//			}
//			else d++; // try next direction
//		}
//	}
//	cout << "no path in maze " << endl;
//}
///*
//maze[][], mark[][]를 class의 private data member로 선언
//main()에서는 class의 public function의 호출로 미로 찾기
//*/
//void main() {

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);
		moves[0].a = -1;		//a는 x값, b는 y값   1북동쪽, 2 동쪽 01234567 방향 0북쪽부터 시계방향
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

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;
			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}
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
