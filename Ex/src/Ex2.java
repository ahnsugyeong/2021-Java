import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class DrawLine extends JPanel implements MouseMotionListener, MouseListener{
	
	int w, h;
	JLabel label;
	
	ArrayList<MyCurve> curves;
	
	
	class MyPoint {
		float x, y;
		MyPoint(float _x, float _y){
			x = _x;
			y = _y;
		}
	}
	class MyCurve{
		ArrayList<MyPoint> points = null;
		
		MyCurve(){
			points = new ArrayList<>();
		}
		MyCurve(Float x, Float y){
			points = new ArrayList<>();
			new MyPoint(x, y);
		}
	}
	
	DrawLine(){
		curves = new ArrayList<>();
		addMouseMotionListener(this);
		label = new JLabel("");
		add(label);
		addMouseListener(this);
	}

	public void mouseDragged(MouseEvent e) {
		curves.get(curves.size()-1).points.add(new MyPoint((float)e.getX()/w, (float)e.getY()/h));
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	
	public void paintComponent(Graphics g) {
		w = getSize().width;
		h = getSize().height;
		
		
		for(int i=0;i<curves.size();i++) {
			MyCurve p = curves.get(i);
			for(int j=0;j<p.points.size()-1;j++) {	
				g.drawLine((int)(p.points.get(j).x*w), (int)(p.points.get(j).y*h), (int)(p.points.get(j+1).x*w), (int)(p.points.get(j+1).y*h));
			}
		}
		
		
		label.setText("num of curves: " + curves.size());
		
	}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		curves.add(new MyCurve((float)e.getX()/w, (float)e.getY()/h));

	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

public class Ex2 extends JFrame{
	Ex2(){
		setTitle("Example 2");
		setSize(500, 500);
		add(new DrawLine());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex2();

	}

}
