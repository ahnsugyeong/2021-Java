package chapter12;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class drawSome extends JPanel implements MouseListener{
	int []x = new int[10];
	int []y = new int[10];
	int x_index =0;
	int y_index = 0;
	drawSome(){
		addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		x[x_index] = e.getX();
		y[y_index] = e.getY();
		x_index++;
		y_index++;
		repaint();
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void paintComponent(Graphics g) {
		g.drawPolyline(x, y, x_index);
	}
	
}

public class Java12_7 extends JFrame{
	Java12_7(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new drawSome());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_7();

	}

}
