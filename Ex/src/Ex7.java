import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class MyClock extends JPanel implements Runnable{
	int h, m, s;
	String s_h, s_m, s_s;
	JButton hour, min, sec;
	JLabel time = new JLabel("00:00:00");
	MyClock(){
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
		add(hour); add(min); add(sec);
		time.setFont(f);
		add(time);
		
		
	}
	@Override
	public void run() {
		while(true) {
			s++;
			try {
				Thread.sleep(1000);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

public class Ex7 extends JFrame{
	Ex7(){
		setTitle("Example 7");
		setSize(500, 500);
		MyClock c = new MyClock();
		add(c);
		Thread t = new Thread(c);
		t.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex7();

	}

}
