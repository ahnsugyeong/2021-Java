package chapter10;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class KeyFontPractice extends JPanel implements KeyListener{
	JLabel label;
	int size = 30;
	KeyFontPractice(){
		label = new JLabel("Love Java");
		Font f = new Font("나눔 고딕", Font.PLAIN, size);
		label.setFont(f);
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		add(label);
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 61) {
			System.out.println("+++!!");
			size += 5;
			label.setFont(new Font("나눔고딕", Font.PLAIN, size));
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_MINUS) {
			System.out.println("---!!");
			size -= 5;
			label.setFont(new Font("나눔고딕", Font.PLAIN, size));
		}
		
	}
	public void keyReleased(KeyEvent e) {}
}

public class Java10_5 extends JFrame{
	Java10_5(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new KeyFontPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_5();

	}

}
