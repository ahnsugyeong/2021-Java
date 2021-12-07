package chapter12;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DrawCat extends JPanel implements MouseMotionListener{
	int x, y;
	ImageIcon icon = new ImageIcon("images/cat3.jpeg");
	JLabel label = new JLabel(icon);
	DrawCat(){
		setLayout(null);
		label.setBounds(x, y, 100, 100);
		add(label);
		addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		label.setLocation(x, y);
		
	}
	public void mouseMoved(MouseEvent e) {}
}

public class Java12_3 extends JFrame{
	Java12_3(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawCat());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_3();

	}

}