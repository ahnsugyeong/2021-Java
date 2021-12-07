import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;


class MyRect{

	int x, y, w, h;
	Color color;
	MyRect(int _x, int _y, int _w, int _h, Color c){
		color = c;
		x = _x;
		y = _y;
		w = _w;
		h = _h;
	}
}

class drawRect extends JPanel implements MouseMotionListener, MouseListener{
	ArrayList<MyRect> rects= null;
	JLabel label = null;
	
	Point start = null, end = null;
	Color c = Color.red;
	
	drawRect(){
		label = new JLabel("");
		add(label);
		rects= new ArrayList<>();
		start = new Point();
		end = new Point();
		addMouseMotionListener(this);
		addMouseListener(this);
		ButtonGroup buttons = new ButtonGroup();
		
		
		JRadioButtonMenuItem r = new JRadioButtonMenuItem("red");
	
		JRadioButtonMenuItem g = new JRadioButtonMenuItem("green");
		JRadioButtonMenuItem b = new JRadioButtonMenuItem("blue");
		add(r); add(g); add(b);
		buttons.add(r); buttons.add(g); buttons.add(b);
		r.setSelected(true);
		
		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = Color.red;
			}
		});
		g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = Color.green;
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = Color.blue;
			}
		});
		
	}

	
	public void mouseDragged(MouseEvent e) {
		end.x = e.getX();
		end.y = e.getY();
		
		repaint();
	}
	
	public void mouseMoved(MouseEvent e) {		}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		start.x = e.getX();
		start.y = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		int x, y, w, h;
		x = start.x;
		y = start.y;
		w = end.x-start.x;
		h = end.y-start.y;
		if(w<0) {
			x = end.x;
			w = -w;
		}
		if(h<0) {
			y = end.y;
			h = -h;
		}

		rects.add(new MyRect(x, y, w, h, c));
		repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void paintComponent(Graphics g) {
		int x, y, w, h;
		x = start.x;
		y = start.y;
		w = end.x-start.x;
		h = end.y-start.y;
		if(w<0) {
			x = end.x;
			w = -w;
		}
		if(h<0) {
			y = end.y;
			h = -h;
		}
		for(int i=0;i<rects.size();i++) {
			MyRect p = rects.get(i);
			g.setColor(p.color);
			g.fillRect(p.x, p.y, p.w, p.h);
			g.setColor(Color.black);
			g.drawRect(p.x, p.y, p.w, p.h);
		}
		g.setColor(c);
		g.fillRect(x,  y,  w,  h);
		g.setColor(Color.black);
		g.drawRect(x,  y,  w,  h);
		label.setText("num of rects: "+ rects.size());
	}
}

public class Ex3 extends JFrame{
	Ex3(){
		setTitle("Example 3");
		setSize(500, 500);
		add(new drawRect());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex3();
	}
}


/*
addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
 */
