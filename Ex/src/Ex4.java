import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCircle{
	int x, y, r;
	boolean selected = false;
	MyCircle(int _x, int _y, int _r){
		x = _x;
		y = _y;
		r = _r;
	}
}

class DrawCircle extends JPanel implements MouseListener, MouseMotionListener{
	ArrayList<MyCircle> circles = null;
	Point start, end;
	int r;
	int dx, dy;
	boolean exist;
	Point prev;
	JLabel label;
	
	
	DrawCircle(){
		circles = new ArrayList<>();
		start = new Point();
		end = new Point();
		prev = new Point();
		addMouseListener(this);
		addMouseMotionListener(this);
		exist = false;
		label = new JLabel("");
		label.setText("");
		add(label);
		
	}
	public void mouseDragged(MouseEvent e) {
		end.x = e.getX();
		end.y = e.getY();
		
		r = (int)Math.sqrt((start.x-end.x)*(start.x-end.x)+(start.y-end.y)*(start.y-end.y));
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		
		exist = false;
		int x = e.getX();
		int y = e.getY();
		prev.x = x;
		prev.y = y;
		
		for(MyCircle c: circles) {
			if(Point.distance((double)x, (double)y, (double)(c.x), (double)(c.y))<=c.r) {
				c.selected = true;
				exist = true;
			}
			else c.selected = false;
			System.out.println(c.selected);
		}
		
		start.x = e.getX();
		start.y = e.getY();

	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("exist="+exist);
		
		if(exist == true) {
			for(int i=0;i<circles.size();i++) {
				MyCircle p = circles.get(i);
				if(p.selected == true) p.selected = false;
			}
		}
		else {
			System.out.println("circle added!!");
			circles.add(new MyCircle(start.x, start.y, r));
		}
		
 
		repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(exist == true) {
			int dx =end.x - prev.x;
			int dy = end.y - prev.y;
			for(int i=0;i<circles.size();i++) {
				MyCircle p = circles.get(i);
				if(p.selected == true) {
					
					System.out.println("dx = "+dx+", dy ="+dy);
					p.x += dx;
					p.y += dy;
					g.setColor(Color.yellow);
					g.fillOval(p.x-p.r, p.y-p.r, p.r*2, p.r*2);
					g.setColor(Color.black);
					g.drawOval(p.x-p.r, p.y-p.r, p.r*2, p.r*2);
				}
				else {
					g.setColor(Color.red);
					g.fillOval(p.x-p.r, p.y-p.r, p.r*2, p.r*2);
					g.setColor(Color.black);
					g.drawOval(p.x-p.r, p.y-p.r, p.r*2, p.r*2);
				}		
			}
			prev.x = end.x;
			prev.y = end.y;
		}
		else {
			for(int i=0;i<circles.size();i++) {
				MyCircle p = circles.get(i);
				g.setColor(Color.red);
				g.fillOval(p.x-p.r, p.y-p.r, p.r*2, p.r*2);
				g.setColor(Color.black);
				g.drawOval(p.x-p.r, p.y-p.r, p.r*2, p.r*2);
			}
			g.setColor(Color.red);
			g.fillOval(start.x-r, start.y-r, 2*r, 2*r);
			g.setColor(Color.black);
			g.drawOval(start.x-r, start.y-r, 2*r, 2*r);
		}
		
		label.setText("Num of Circles: "+circles.size());
		
	}
}

public class Ex4  extends JFrame{
	Ex4(){
		setTitle("Example 4");
		setSize(500, 500);
		add(new DrawCircle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args){
		new Ex4();
	}

}
