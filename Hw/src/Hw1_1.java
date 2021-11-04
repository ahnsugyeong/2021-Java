import java.util.Scanner;

public class Hw1_1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int x1, y1, r1, x2, y2, r2;
		System.out.print("첫 번째 원의 중심과 반지름 입력 >> ");
		x1 = input.nextInt();
		y1 = input.nextInt();
		r1 = input.nextInt();
		System.out.print("두 번째 원의 중심과 반지름 입력 >> ");
		x2 = input.nextInt();
		y2 = input.nextInt();
		r2 = input.nextInt();
		
		int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		int minus = (r1 - r2) * (r1 - r2);
		int plus = (r1 + r2) * (r1 + r2);

		if ((d > minus && d < plus) || ((x1 == x2)&&(y1 == y2)&&(r1 == r2)))
			System.out.println("두 원은 서로 겹친다.");
		else
			System.out.println("두 원은 서로 겹치지 않는다.");

	}
}