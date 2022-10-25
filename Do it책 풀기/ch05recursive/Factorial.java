package ch05;

//팩토리얼 값을 재귀적으로 구함.
import java.util.Scanner;

public class Factorial {
	static int factorial(int n) {
		if (n > 0)
			return n * factorial(n - 1);
		else
			return 1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int x;
		System.out.print("정수 입력하세요 : ");
		while ((x = stdIn.nextInt()) != 0) {
			System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
			System.out.print("정수 입력하세요(종료는 0) : ");
		}
		 System.out.println("종료합니다");
	}
}
