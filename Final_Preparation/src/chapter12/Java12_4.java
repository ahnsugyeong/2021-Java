package chapter12;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawCat2 extends JPanel implements MouseMotionListener{
	ImageIcon icon = new ImageIcon("images/cat3.jpeg");
	Image img = icon.getImage();
	int x, y;
	DrawCat2(){
		addMouseMotionListener(this);
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void paintComponent(Graphics g) {
		g.drawImage(img, x, y, 100, 100, null);
	}
}

public class Java12_4 extends JFrame{
	Java12_4(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawCat2());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_4();

	}

}