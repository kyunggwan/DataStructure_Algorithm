package chap04stack;

public class IntQueue {
	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;

	// 실행시 예외 : 큐가 비어있음.
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// 실행시 예외 : 큐가 가득참.
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// 생성자
	public IntQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[capacity]; // 큐 본체용 배열 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// que에서 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= capacity)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return x;
	}

	// que 에서 데이터를 deque
	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == capacity)
			front = 0;
		return x;
	}

	// 큐에서 데이터를 피크
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	// 큐를 비움
	public void clear() {
		num = front = rear = 0;
	}

	// 큐에서 x를 검색하여 인덱스(찾지 못하면 -1 반환)
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity; // 입력된 x가 front
			if (que[idx] == x)
				return idx;
		}
		return -1;
	}

	// 큐의 용량을 반환
	public int getCapacity() {
		return capacity;
	}

	// 큐에 쌓여있는 데이터의 개수
	public int size() {
		return num;
	}

	// 큐가 비어 잇는지
	public boolean isEmpty() {
		return num <= 0;
	}

	// 큐가 가득 찼는지
	public boolean isFull() {
		return num >= capacity;
	}

	// 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.println(que[(i + front) % capacity] + " ");
			System.out.println();
		}
	}
}