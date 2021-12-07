import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class Hw3_3 extends JFrame{
	String str = "Love Java";
	JLabel l = new JLabel(str);
	
	Hw3_3(){
		setTitle("Left 키로 문자열 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(l);
		l.addKeyListener(new MyKeyListener());

		setSize(300, 100);
		setVisible(true);

		l.setFocusable(true);
		l.requestFocus();
	}
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				str = str.substring(1,str.length()) + str.substring(0, 1);
				l.setText(str);
			}
		}
	}
	public static void main(String[] args) {
		new Hw3_3();

	}

}
