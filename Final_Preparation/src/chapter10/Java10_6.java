package chapter10;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ClickPractice extends JPanel implements MouseListener{
	JLabel label;
	int x, y;
	int w, h;
	ClickPractice(){
		setLayout(null);
		x = 100;
		y = 100;
		label = new JLabel("C");
		add(label);
		label.setBounds(100, 100, 20, 20);
		label.addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e) {
		w = getWidth();
		h = getHeight();
		x = (int) (Math.random()* w-label.getWidth());
		y = (int) (Math.random()* h-label.getHeight());
		label.setLocation(x, y);
		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

public class Java10_6 extends JFrame{
	Java10_6(){
		setTitle("클릭 연습 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new ClickPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_6();

	}

}