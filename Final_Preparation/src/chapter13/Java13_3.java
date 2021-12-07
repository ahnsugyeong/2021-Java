package chapter13;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class CurrentClock extends JPanel implements Runnable{
	JLabel label;
	CurrentClock(){
		label = new JLabel();
		add(label);
		label.setFont(new Font("나눔 고딕", Font.BOLD, 70));
		Thread t = new Thread(this);
		t.start();
		
		
	}
	public void run() {
		while(true) {
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			label.setText(clockText);
			
		}
	}
}

public class Java13_3 extends JFrame{
	Java13_3(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new CurrentClock());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java13_3();

	}

}