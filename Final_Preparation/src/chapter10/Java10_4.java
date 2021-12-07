package chapter10;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class KeyMovePractice extends JPanel implements KeyListener{
	JLabel label;
	String str;
	
	KeyMovePractice(){
		str = "Love Java";
		label = new JLabel(str);
		add(label);
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			char tmp = str.charAt(0);
			str = str.substring(1, str.length())+tmp;
			System.out.println(str);
			label.setText(str);
		}
	}
	public void keyReleased(KeyEvent e) {}
}

public class Java10_4 extends JFrame{
	Java10_4(){
		setTitle("Left 키로 문자열 이동");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new KeyMovePractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_4();

	}

}

