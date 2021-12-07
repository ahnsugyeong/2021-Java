package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyGame extends JPanel{
	ImageIcon icon = new ImageIcon("images/cat3.jpeg");
	Image img = icon.getImage();
	Red red;
	Cat cat;
	int w, h;
	
	class Red implements Runnable, KeyListener{
		Cat cat;
		Red(){
			setFocusable(true);
			requestFocus();
			addKeyListener(this);
		}
		boolean isSuccess() {
			if((red_y>=0 && red_y<=50 )||( red_y+20>=0&&red_y+20<=50)) {
				if((cat.img_x>=225&&cat.img_x<=275) || (cat.img_x+50>=225&&cat.img_x+50<=275)) {
					return true;
				}
			}
			return false;
		}
		int red_y = h-70;
		public void run() {
			while(true) {
				try {
					if(isSuccess()) {
						cat.img_x = 0;
						red_y = h-70;
						return;
						
					}
					
					red_y-=5;
					Thread.sleep(20);
					if(red_y+20<=0) {
						red_y = h-70;
						return;
						
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				red_y = h-70;
				Thread th = new Thread(this);
				th.start();
			}
		}
		public void keyReleased(KeyEvent e) {}
	}
	
	class Cat implements Runnable{
		Cat(){
			Thread th = new Thread(this);
			th.start();
		}
		Red red;
		int img_x = 0;
		public void run() {
			while(true) {
				try {
					img_x += 5;
					Thread.sleep(20);
					if(img_x==w) img_x = 0;
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	MyGame(){
		cat = new Cat();
		red = new Red();
		cat.red = red;
		red.cat = cat;
		
		
	}
	
	public void paintComponent(Graphics g) {
		w = getWidth();
		h = getHeight();
		g.setColor(Color.black);
		g.fillRect(225, h-50, 50, 50);
		g.setColor(Color.red);
		System.out.println(red.red_y);
		g.fillRect(240, red.red_y, 20, 20);
		g.drawImage(img, cat.img_x, 0, 70, 70, null);
	}
	
	
	
}

public class Java13_5 extends JFrame{
	Java13_5(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyGame());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java13_5();

	}

}