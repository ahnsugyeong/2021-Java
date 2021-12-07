import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyBall{
	float x;
	float y = 30;
	float vx, vy;
	float ax, ay;
	float r;
	
	float start_time;
	
	MyBall(float _x, float _y, float _s){
		
		x = _x;
		y = _y;
		start_time = _s;
		
		
		vx = 0;
		vy = 0;
		ax = 0;
		ay = 1.0f;
		r = 15;
		
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)x-15, (int)y-15, 30, 30);
		g.setColor(Color.BLACK);
		g.drawOval((int)x-15, (int)y-15, 30, 30);
	}

	void update(float dt) {
		start_time -= 1;
		if(start_time>0) return;
		
		vx = vx  + ax*dt;					// numerical integration
		vy = vy + ay*dt;
		x = x + vx*dt;
		y = y + vy*dt;
	}
	void collisionHandling(Dimension d) {
		
		int w= d.width;
		int h = d.height;
		if(y-r<0)  {y = r; vy = -vy*0.9f;}
		if(y+r>h) {y = h-r; vy = -vy*0.9f;}
		if(x+r>w) {x = w-r; vx = -vx*0.9f;}
		if(x-r<0) {x = r;  vx = -vx*0.9f;}
		
		
	}
}

class ThrowBall extends JPanel implements Runnable, KeyListener{

	ArrayList<MyBall> balls = new ArrayList<>();
	ThrowBall(){
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		Thread t = new Thread(this);
		t.start();
		
		
		
	}
	

	
	public void run() {
		while(true) {
			
			try {
				for(MyBall p : balls) {
					p.update(1);
					p.collisionHandling(getSize());
				}
				Thread.sleep(30);
				repaint();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	

	public void keyTyped(KeyEvent e) {
		
	} 

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_SPACE) {
			

			int count = balls.size();
			balls.clear();
			count ++;
			
			Dimension d = getSize();
			for(int i = 0; i<count; i++)
			{
				int start_time = i*5;
				int x = (int)(d.width/(float)(count+1)*(i+1));
				MyBall b = new MyBall(x, 100, start_time);
				balls.add(b);
			}
			
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(MyBall p: balls) {
			p.draw(g);
		}
		
	}
	
}

public class Ex12 extends JFrame{
	
	
	Ex12(){
		setTitle("Example 12");
		setSize(500, 500);
		add(new ThrowBall());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex12();

	}

}
