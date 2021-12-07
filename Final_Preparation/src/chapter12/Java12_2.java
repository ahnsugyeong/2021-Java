package chapter12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


class DrawCircle extends JPanel implements MouseMotionListener{
	int x, y;
	
	DrawCircle(){
		x = 50;
		y = 50;
		addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	ImageIcon icon = new ImageIcon("images/cat3.jpeg");
	Image img = icon.getImage();
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.green);
		g.fillOval(x, y, 40, 40);
	}
	
}

public class Java12_2 extends JFrame{
	Java12_2(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawCircle());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_2();

	}

}
