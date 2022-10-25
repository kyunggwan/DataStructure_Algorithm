package ch05;
//다른 예제에서 사용하는 파일: RecurX2
public class IntStack {

	private int[] stk;
	private int capacity;
	private int ptr;
	
	// 실행 시 예외 : 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	// 실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
		
	//생성자
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
	
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	
	}// 스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity) //스택이 가득 찰 경우 예외처리
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	//스택에서 데이터를 팝
	public int pop() throws EmptyIntStackException{
		if (ptr <= 0) //스택이 비어 있음. 비면 예외 처리
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	//스택에서 데이터를 피크(꼭대기 부터 봄)
	public int peek() throws EmptyIntStackException{
		if(ptr <= 0) 
				throw new EmptyIntStackException();
		return stk[ptr -1 ];
	}
	
	//스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	//스택에서 x를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int x) {
		for(int i = ptr -1; i>=0; i--)
			if(stk[i] == x)
				return i; 	//검색 성공
			return -1;		//검색 실패
	}
	
	//스택의 용량을 반환
	public int getCapacity() {
		return capacity;
	}

	//스택에 쌓여 있는 데이터 개수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//스택이 가득 찼는가?
	public boolean isFUll() {
		return ptr >= capacity;
	}
	
	//스택 안의 모든 데이터를 바닥 -> 꼭대기 순으로 출력
	public void dump() {
		if (ptr <=0 ) 
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.println(stk[i] + " ");
			System.out.println();
		}
	}
}
