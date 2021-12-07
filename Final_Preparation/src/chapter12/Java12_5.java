package chapter12;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawCat3 extends JPanel implements KeyListener{
	int per = 100;
	ImageIcon icon = new ImageIcon("images/cat2.jpeg");
	Image img = icon.getImage();
	
	DrawCat3(){
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyChar()+" "+e.getKeyCode()+"pressed!!");
		
		if(e.getKeyCode()==61) {
			per += 10;
			repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_MINUS) {
			per -= 10;
			repaint();
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth()*per/100, getHeight()*per/100, 0, 0, icon.getIconWidth(), icon.getIconHeight(),null);
		
	}
}

public class Java12_5 extends JFrame{
	Java12_5(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawCat3());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_5();

	}

}