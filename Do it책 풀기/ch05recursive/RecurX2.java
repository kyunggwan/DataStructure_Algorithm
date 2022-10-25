package ch05;

public class RecurX2 {
	// 재귀를 제거
	static void recur(int n) {
		IntStack s = new IntStack(n);

		while (true) {
			if (n > 0) { 			// n 값을 푸시한다. 스택에 저장
				s.push(n); 			// ex) n=4라고 하면 4 3 2 1을 푸시하고, n = 0돼서 아래 if문으로 간다
				n = n - 1;
				continue;
			}
			if (s.isEmpty() != true) { 	// 스택이 비어있지 않으면
				n = s.pop(); 			// 저장하고 있떤 스택값을 팝해서 뺌.
				System.out.println(n);
				n = n - 2; 				// n 값 변화 : 0 -1 0 1  
				continue;				// pop 값들 : 1 2 3 1푸시... 
			}							//결국 stack 비어지고 break;
			break;
		}
	}
}
