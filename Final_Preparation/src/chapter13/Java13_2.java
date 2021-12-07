package chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel implements Runnable {
	
	MyPanel(){
		System.out.println("here~");
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		int x = (int)(Math.random()*(this.getWidth()-50));
		int y = (int)(Math.random()*(this.getHeight()-50));
		System.out.println(x+" "+y);
		g.setColor(Color.pink);
		g.drawOval(x, y, 50, 50);
	}
}

public class Java13_2 extends JFrame{
	Java13_2(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyPanel p = new MyPanel();
		
		add(p);
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java13_2();

	}

}