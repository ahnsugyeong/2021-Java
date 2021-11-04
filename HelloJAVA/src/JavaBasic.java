import java.util.Scanner;

public class JavaBasic {
	
	public static void main(String[] args) {
		System.out.print("이름과 나이와 학점을 입력하시오 : ");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		int age = input.nextInt();
		float score = input.nextFloat();
		System.out.println("당신의 이름은 " + name +"이고, 나이는 " + age + "살이고 학점은 " + score + "입니다.");
	}
}