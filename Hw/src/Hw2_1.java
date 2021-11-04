import java.util.Scanner;

class Concert {
	String[][] seat = new String[3][10];

	void printSeat(int type) {
		if (type == 1) {
			System.out.print("S >> ");
		} else if (type == 2) {
			System.out.print("A >> ");
		} else if (type == 3) {
			System.out.print("B >> ");
		}

		for (int i = 0; i < 10; i++) {
			if (seat[type - 1][i] == null)
				System.out.print("---");
			else
				System.out.print(seat[type - 1][i]);
			System.out.print(" ");
		}

		System.out.println();
	}

	void reserveSeat(int type, String name, int num) {
		seat[type - 1][num - 1] = name;

	}

	void showSeat() {
		printSeat(1);
		printSeat(2);
		printSeat(3);
		System.out.println("<<< 조회를 완료하였습니다. >>>");
	}

	void cancelSeat(int type, String name) {
		for (int i = 0; i < 10; i++) {
			if (name.equals(seat[type - 1][i]))
				seat[type - 1][i] = null;
		}
	}

	boolean findName(int type, String name) {
		boolean flag;
		for (int i = 0; i < 10; i++) {
			if (name.equals(seat[type - 1][i])) {
				return true;
			}
		}
		System.out.println("Error! Try again!");
		return false;
	}

	boolean findNum(int num) {
		if (num < 1 || num > 10) {
			System.out.println("Error! Try again!");
			return false;
		} else
			return true;
	}

	boolean findType(int type) {
		if (type < 1 || type > 3) {
			System.out.println("Error! Try again!");
			return false;
		} else
			return true;
	}

	boolean isEmpty(int type) {
		for (int i = 0; i < 10; i++) {
			if (seat[type - 1][i] != null) 
				return false;
		}
		System.out.println("Error! Try again!");
		return true;
	}
}

public class Hw2_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("명품콘서트홀 예약 시스템입니다.");

		int order;
		int type;
		String name;
		int num;
		Concert concert = new Concert();
		while (true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
			order = input.nextInt();
			if (order == 1) {
				while (true) {
					System.out.print("좌석구분 S(1), A(2), B(3) >> ");
					type = input.nextInt();
					if (concert.findType(type))
						break;
				}
				concert.printSeat(type);
				System.out.print("이름 >> ");
				name = input.next();
				while (true) {
					System.out.print("번호 >> ");
					num = input.nextInt();
					if (concert.findNum(num))
						break;
				}
				concert.reserveSeat(type, name, num);
			} else if (order == 2) {
				concert.showSeat();
			} else if (order == 3) {
				while (true) {
					System.out.print("좌석 S:1, A:2, B:3 >> ");
					type = input.nextInt();
					if (concert.findType(type)) {
						if(!concert.isEmpty(type))
							break;
					}
						
				}
				concert.printSeat(type);
				while (true) {
					System.out.print("이름 >> ");
					name = input.next();
					if (concert.findName(type, name))
						break;
				}
				concert.cancelSeat(type, name);
			} else if (order == 4) {
				break;
			} else {
				System.out.println("Error! Try again!");
			}
		}
	}
}
