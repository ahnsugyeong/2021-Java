import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPointer extends JPanel implements MouseMotionListener, Runnable{
	int x, y, r;
	int flag = 0;
	MyPointer(){
		x = 0;
		y = 0;
		r = 0;
		addMouseMotionListener(this);
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void paintComponent(Graphics g) {
		g.setColor(new Color(r*3, r*3, r*3));
		g.fillOval(x-r, y-r, r*2, r*2);
	}
	@Override
	public void run() {
		while(true) {
			if(flag == 0) {
				r++;
				if(r == 50) flag = 1;
			}
			else {
				r--;
				if(r == 0) flag = 0;
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Ex9 extends JFrame{
	Ex9(){
		setTitle("Example 9");
		setSize(500, 500);
		
		MyPointer p = new MyPointer();
		add(p);
		Thread t = new Thread(p);
		t.start();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {

		new Ex9();
	}

}
