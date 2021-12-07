package chapter12;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawLine extends JPanel{
	int w, h;
	public void paintComponent(Graphics g) {
		w = this.getWidth();
		h = this.getHeight();
		
		for(int i=0;i<9;i++) {
			g.drawLine((i+1)*(w/10), 0, (i+1)*(w/10), h);
			g.drawLine(0, (i+1)*(h/10), w, (i+1)*(h/10));
		}
		
	}
}

class DrawLine2 extends JPanel{
	int w, h;
	public void paintComponent(Graphics g) {
		w = this.getWidth();
		h = this.getHeight();
		for(int i=0;i<10;i++) {
			
			g.drawLine(w/2, i*10, i*10, h/2);
			g.drawLine(w/2, i*10, w-i*10, h/2);
			g.drawLine(w/2, h-i*10, i*10, h/2);
			g.drawLine(w/2, h-i*10, w-i*10, h/2);
			
		}
		
	}
}

public class Java12_6 extends JFrame{
	Java12_6(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawLine2());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_6();

	}

}
