package chapter10;

import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MouseWheelPractice extends JPanel implements MouseWheelListener{
	JLabel label;
	int size = 20;
	MouseWheelPractice(){
		label = new JLabel("Love Java");
		add(label);
		Font f = new Font("나눔 고딕", Font.PLAIN, size);
		label.setFont(f);
		addMouseWheelListener(this);
	}

	
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation()<0) {
			size -=5;
		}
		else if(e.getWheelRotation()>0) {
			size +=5;
		}
		
		if(size<5) size = 5;
		label.setFont(new Font("나눔 고딕", Font.PLAIN, size));
		
	}
}

public class Java10_7 extends JFrame{
	Java10_7(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MouseWheelPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_7();

	}

}