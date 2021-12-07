package chapter13;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class VibratingLabel extends JPanel implements Runnable{
	JLabel label;
	int x, y;
	VibratingLabel(){
		
		x = 100;
		y = 100;
		setLayout(null);
		label = new JLabel("진동 레이블");
		label.setFont(new Font("굴림", Font.PLAIN, 70));
		label.setBounds(x, y, 400, 100);
		add(label);
		Thread t = new Thread(this);
		t.start();
		
	}
	public void run() {
		while(true) {
			label.setBounds(x+10, y+10, 400, 100);
			label.setBounds(x-10, y+10, 400, 100);
			label.setBounds(x-10, y-10, 400, 100);
			label.setBounds(x+10, y-10, 400, 100);
			
		}
	}
}

public class Java13_4 extends JFrame implements Runnable{
	int cnt = 100;
	Java13_4(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Thread th = new Thread(this);
		th.start();
		
		add(new VibratingLabel());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java13_4();

	}
	public void run() {
		while(cnt>0) {
			cnt--;
			this.setLocation(this.getX()-10, this.getY()+10);
			this.setLocation(this.getX()+10, this.getY()-10);
			this.setLocation(this.getX()-10, this.getY()+10);
			this.setLocation(this.getX()+10, this.getY()-10);
		}
	}

}