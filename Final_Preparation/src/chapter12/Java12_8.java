package chapter12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;




class ManyCircle extends JPanel implements MouseListener, MouseMotionListener{
	int x, y, r;
	class MyCircle{
		int x, y, r;
		MyCircle(int _x, int _y, int _r){
			x = _x;
			y = _y;
			r = _r;
		}
	}
	Vector<MyCircle> circles = new Vector<>();
	
	ManyCircle(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		for(int i=0;i<circles.size();i++) {
			MyCircle it = circles.get(i);
			g.drawOval(it.x-it.r, it.y-it.r, it.r*2, it.r*2);
		}
		g.drawOval(x-r, y-r, r*2, r*2);
		
		
	}
	
	public void mouseDragged(MouseEvent e) {
		r = (int) Math.sqrt((x-e.getX())*(x-e.getX())+(y-e.getY())*(y-e.getY()));
		System.out.println(r);
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}


	public void mouseClicked(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		circles.add(new MyCircle(x,y,r));
		repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
public class Java12_8 extends JFrame{
	Java12_8(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new ManyCircle());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_8();

	}

}

