package chapter13;

import java.util.Scanner;

class Hey implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=10;i++) System.out.print(i+" ");
		
	}	
}

public class Java13_1{
	
	public static void main(String[] args) {
	
		System.out.print("아무 키나 입력>> ");
		Scanner input = new Scanner(System.in);
		String n = input.next();
		Thread t = new Thread(new Hey());
		t.start();
	}


}
