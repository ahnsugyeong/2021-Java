package chapter10;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class KeyPractice extends JPanel implements KeyListener{
	JLabel label;
	String str;
	
	KeyPractice(){
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
			if(str.equals("Love Java")) str= "avaJ evoL";
			else str = "Love Java";
			label.setText(str);
		}
	}
	public void keyReleased(KeyEvent e) {}
}

public class Java10_3 extends JFrame{
	Java10_3(){
		setTitle("Left 키로 문자열 교체");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new KeyPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_3();

	}

}

