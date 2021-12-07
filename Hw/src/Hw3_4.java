import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hw3_4 extends JFrame{
	JLabel l = new JLabel("C");
	
	Hw3_4(){
		setTitle("클릭 연습용 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);
		l.setSize(20, 20);
		l.setLocation(100, 100);
		l.addMouseListener(new MyMouseListener());
		
		c.add(l);
		
		setSize(300, 300);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int x = (int) (Math.random() * 250);
			int y = (int) (Math.random() * 250);
			l.setLocation(x, y);
		}
	}
	public static void main(String[] args) {
		new Hw3_4();

	}

}
