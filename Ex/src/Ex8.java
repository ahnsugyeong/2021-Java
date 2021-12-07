import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class MyRoundClock extends JPanel implements Runnable{
	MyClock2 clock;
	JButton hour, min, sec, round;
	MyRoundClock(){
		setBackground(Color.orange);
		Font f = new Font("나눔 고딕", Font.BOLD, 70);
		hour = new JButton("Hour");
		hour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clock.h++;
				repaint();
				
			}
			
		});
		min = new JButton("Min");
		min.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clock.m++;
				repaint();
			}
			
		});
		sec = new JButton("Sec");
		sec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.s++;
				repaint();
			}
			
		});
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g) {
		
	}
	
}


class MyClock2 extends JPanel implements Runnable{
	MyClock2 here;
	int h, m, s;
	String s_h, s_m, s_s;
	JButton hour, min, sec, round;
	JLabel time = new JLabel("00:00:00");
	MyClock2(){
		here = this;
		h = 0;
		m = 0;
		s = 0;
		Font f = new Font("나눔 고딕", Font.BOLD, 70);
		hour = new JButton("Hour");
		hour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				h++;
				repaint();
				
			}
			
		});
		min = new JButton("Min");
		min.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m++;
				repaint();
			}
			
		});
		sec = new JButton("Sec");
		sec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s++;
				repaint();
			}
			
		});
		round = new JButton("Round Clock");
		round.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyRoundClock c2 = new MyRoundClock();
				c2.clock = here;
				
			}
			
		});
		
		
		add(hour); add(min); add(sec); add(round);
		time.setFont(f);
		add(time);
		
		
	}
	@Override
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(1000);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s++;
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(h==0) s_h = "00";
		else if(h<10) s_h = "0"+h;
		else s_h = ""+h;
		
		if(m==0) s_m = "00";
		else if(m<10) s_m = "0"+m;
		else s_m = ""+m;
		
		if(s==0) s_s = "00";
		else if(s<10) s_s = "0"+s;
		else s_s = ""+s;
		
		if(s==60) {
			s = 0;
			m++;
		}
		if(m == 60) {
			m = 0;
			h++;
		}
		if(h == 24) {
			h = 0;
		}
		
		
		
		time.setText(s_h+":"+s_m+":"+s_s);
		
		
	}
}

public class Ex8 extends JFrame{
	Ex8(){
		setTitle("Example 7");
		setSize(500, 500);
		MyClock2 c = new MyClock2();
		
		add(c);
		
		Thread t = new Thread(c);
		t.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex8();

	}

}
