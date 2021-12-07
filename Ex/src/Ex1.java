import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class DrawAndRemoveDot extends JPanel implements MouseListener, MouseMotionListener{
	ArrayList<Point> points = null;
	Point start = null;
	Point end = null;
	JLabel label = null;
	boolean rightbutton = false;

	DrawAndRemoveDot(){
		points = new ArrayList<>();
		start = new Point(0, 0);
		end = new Point(0, 0);
		label = new JLabel("");
		add(label);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void mouseDragged(MouseEvent e) {
		if(e.getButton()==1) {
			Point p = new Point();
			p.x = e.getX();
			p.y = e.getY();
			points.add(p);
		}
		if(e.getButton()==3) {
			end.x = e.getX();
			end.y = e.getY();
			rightbutton = true;
		}
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==3) {
			start.x = e.getX();
			start.y = e.getY();
			rightbutton = true;
		}
	}
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==3) {
			end.x = e.getX();
			end.y = e.getY();
			
			int x = start.x;
			int y = start.y;
			
			int w = end.x-start.x;
			if(w<0) {
				x = end.x;
				w = -w;
			}
			int h = end.y-start.y;
			if(h<0) {
				y = end.y;
				h = -h;
			}
			Rectangle2D rect = new Rectangle2D.Float(x, y, w, h);
			ListIterator<Point> it = points.listIterator();
				while(it.hasNext()) {
					Point p = it.next();
					if(rect.contains(p)) it.remove();
				}
			
			repaint();
			
		}
		rightbutton = false;
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		for(int i=0;i<points.size();i++) {
			g.fillOval(points.get(i).x,points.get(i).y,5, 5); 
		}
		
		//remove

		g.setColor(Color.RED);
		
		int x = start.x;
		int y = start.y;
		
		int w = end.x-start.x;
		if(w<0) {
			x = end.x;
			w = -w;
		}
		int h = end.y-start.y;
		if(h<0) {
			y = end.y;
			h = -h;
		}
		if(rightbutton) g.drawRect(x, y, w,h);
		
		label.setText("Num Of Points: "+points.size());
		
			
	}
	
}


public class Ex1 extends JFrame{
	Ex1(){
		setTitle("Example 1");
		setSize(500, 500);
		add(new DrawAndRemoveDot());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex1();

	}

}
