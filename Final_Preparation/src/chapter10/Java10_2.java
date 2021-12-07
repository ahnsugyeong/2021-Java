package chapter10;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MouseColorPractice extends JPanel{
	MouseColorPractice(){
		setBackground(Color.GREEN);
		addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) {
				setBackground(Color.yellow);
			}
			public void mouseMoved(MouseEvent e) {}
		});
		
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
				setBackground(Color.GREEN);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
	}
}

public class Java10_2 extends JFrame{
	Java10_2(){
		setTitle("드래깅동안 YELLOW");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MouseColorPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java10_2();

	}

}