import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MoveRect extends JPanel implements KeyListener, Runnable{
	int x, y;
	int h, w;
	int dx, dy;
	MoveRect(){
		x = 0;
		y = 0;
		dx = 0;
		dy = 0;
		setFocusable(true);
		requestFocus(true);
		h = 70;
		w = 70;
		addKeyListener(this);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT) {
			dx = -20;
			dy = 0;
		}
		else if(e.getKeyCode()==e.VK_RIGHT) {
			dx = 20;
			dy = 0;
		}
		else if(e.getKeyCode()==e.VK_UP) {
			dx = 0;
			dy = -20;
		}
		else if(e.getKeyCode()==e.VK_DOWN) {
			dx = 0;
			dy = 20;
		}
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(x, y, w, h);
	}

	@Override
	public void run() {
		while(true) {
			if(x+w>this.getSize().width || x < 0) dx = -dx;
			else if(y+h>this.getSize().height || y < 0) dy = -dy;
			x+= dx;
			y+= dy;
		
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

public class Ex11 extends JFrame{
	
	
	Ex11(){
		setTitle("Example 11");
		setSize(700, 400);
		MoveRect m = new MoveRect();
		Thread t = new Thread(m);
		t.start();
		add(m);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex11();

	}

}
