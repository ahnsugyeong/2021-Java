import java.util.Scanner;

public class Hw1_3 {

	public static void main(String[] args) {
		System.out.print("정수 몇개? ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] x = new int[n];
		int tmp;
		for (int i = 0; i < n; i++) {
			while (true) {
				tmp = (int) (Math.random() * 99 + 1);
				boolean flag = false;
				for (int j : x) {
					if (j == tmp) {
						flag = true;
					}
				}
				if (flag == false)
					break;
			}
			x[i] = tmp;
		}
		int cnt = 0;
		for (int i : x) {
			System.out.print(i + " ");
			cnt++;
			if (cnt % 10 == 0)
				System.out.println();
		}
	}
}