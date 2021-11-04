import java.util.Scanner;

abstract class Shape {
	private Shape next;

	public Shape() { // next 초기화
		next = null;
	}

	public void setNext(Shape obj) { // next에 obj 저장
		next = obj;
	}

	public Shape getNext() { // next 반환
		return next;
	}

	public abstract void draw();
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

public class Hw2_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		int order, what;
		int n = 0;
		Shape head = null;
		Shape sh = null;

		while (true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
			order = input.nextInt();
			if (order == 1) {
				
				Shape whatShape;
				while (true) {
					System.out.print("Line(1), Rect(2), Circle(3) >> ");
					what = input.nextInt();
					if (what == 1) {
						whatShape = new Line();
						break;
					} else if (what == 2) {
						whatShape = new Rect();
						break;
					} else if (what == 3) {
						whatShape = new Circle();
						break;
					} else {
						System.out.println("Error! Try again!");
					}
				}
				if (sh == null) {
					head = whatShape;

				} else {
					sh.setNext(whatShape);
				}
				sh = whatShape;
				n++;
			}
			else if (order == 2) {
				System.out.print("삭제할 도형의 위치 >> ");
				what = input.nextInt();
				Shape p = head;
				if (what > n)
					System.out.println("삭제할 수 없습니다.");

				else {
					if (what == 1)
						head = p.getNext();
					else {
						for (int i = 1; i < what - 1; i++) {
							p = p.getNext();
						}
					}
					if (what == n) {
						sh = p;
					}
					p.setNext(p.getNext().getNext());
					n--;
				}
			} else if (order == 3) {
				Shape p = head;
				while (p != null) {
					p.draw();
					p = p.getNext();

				}
			} else if (order == 4) {
				System.out.println("beuaty을 종료합니다.");
				break;
			}
			else {
				System.out.println("Error! Try again!");
			}
		}
	}
}
