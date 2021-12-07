package chapter12;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


class drawImg extends JPanel{
	int w, h;
	ImageIcon icon = new ImageIcon("images/cat4.jpeg");
	Image img = icon.getImage();
	drawImg(){
		
	}
	public void paintComponent(Graphics g) {
		w = this.getWidth();
		h = this.getHeight();
		g.drawImage(img, 0, 0, w/2-5, h/2-5, 0, 0, w/2, h/2, null);
		g.drawImage(img, w/2+5, 0, w, h/2-5, w/2, 0, w, h/2, null);
		g.drawImage(img, 0, h/2+5, w/2-5, h, 0, h/2, w/2, h, null);
		g.drawImage(img, w/2+5, h/2+5, w, h, w/2, h/2, w, h, null);
		
	}
}

public class Java12_10 extends JFrame{
	Java12_10(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new drawImg());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_10();

	}

}