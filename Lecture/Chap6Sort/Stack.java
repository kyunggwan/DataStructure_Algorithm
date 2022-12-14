package Chap6Sort;

class Point {
	public int x;
	public int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

public class Stack {
	private Point[] stk;
	private int capacity;
	private int ptr;

	// 실행 시 예외 : 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// 실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	public Stack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new Point[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// 스택에 x를 푸시
	public Point push(Point pt) throws OverflowIntStackException {
		if (ptr >= capacity) // 스택이 가득 찰 경우 예외처리
			throw new OverflowIntStackException();
		return stk[ptr++] = pt;
	}

	// 스택에서 데이터를 팝
	public Point pop() throws EmptyIntStackException {
		if (ptr <= 0) // 스택이 비어 있음. 비면 예외 처리
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// 스택에서 데이터를 피크(꼭대기 부터 봄)
	public Point peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// 스택을 비움
	public void clear() {
		ptr = 0;
	}

	// 스택의 용량을 반환
	public int getCapacity() {
		return capacity;
	}

	// 스택에 쌓여 있는 데이터 개수를 반환
	public int size() {
		return ptr;
	}

	// 스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// 스택이 가득 찼는가?
	public boolean isFull() {
		return ptr >= capacity;
	}

	// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순으로 출력
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.printf("(%d, %d) ", stk[i].getX(), stk[i].getY());
			System.out.println();
		}
	}
}
