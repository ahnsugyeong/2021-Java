package chapter10;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MousePractice extends JPanel{
	JLabel label;
	MousePractice(){
		 label = new JLabel("Love Java");
		 label.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				label.setText("사랑해");
			}
			public void mouseExited(MouseEvent e) {
				label.setText("Love Java");
			}
		 });
		 add(label);
				 
	}
}

public class Java10_1 extends JFrame{
	Java10_1(){
		setTitle("마우스 올리기 내리기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MousePractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_1();

	}

}
