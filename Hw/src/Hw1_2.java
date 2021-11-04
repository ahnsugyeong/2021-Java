import java.util.Scanner;

public class Hw1_2 {

	public static void main(String[] args) {
		System.out.print("연산 >> ");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		String o = input.next();
		int b = input.nextInt();
		if (o.equals("/") && b == 0)
			System.out.println("0으로 나눌 수 없습니다");
		else {
			switch (o) {
			case "+":
				System.out.println(a + "+" + b + "의 계산 결과는 " + (a + b));
				break;

			case "-":
				System.out.println(a + "-" + b + "의 계산 결과는 " + (a - b));
				break;

			case "*":
				System.out.println(a + "*" + b + "의 계산 결과는 " + (a * b));
				break;

			case "/":
				System.out.println(a + "/" + b + "의 계산 결과는 " + (a / b));
				break;

			}
		}
	}
}
