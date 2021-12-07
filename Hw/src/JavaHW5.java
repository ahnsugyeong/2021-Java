import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





class MyBall{
	float x, y, r;
	float vx, vy;
	float ax, ay;
	Color c;
	
	MyBall(){
		x = 100;
		y = 100;
		r = 20;
		c = Color.MAGENTA;
		
		vx = 300;
		vy = 0;
		ax = 0;
		ay = 600.0f;
		
	}
	
	void draw(Graphics g) {
		g.setColor(c);
		g.fillOval((int)(x-r),(int)(y-r),(int)(2*r),(int)(2*r));
	}
	void update(float dt) {
		vx = vx + ax*dt;
		vy = vy + ay*dt;
		x = x + vx*dt;
		y = y + vy*dt;
	}
	void collisionhandling(Dimension d) {
		int w = d.width;
		int h = d.height;
		if(y+r>h) {
			//System.out.println("h ="+h);
			y = h-r;
			vy = -vy;
		}
		if(x+r>w) {
			x = w-r;
			vx = -vx;
		}
		if(x-r<0) {
			x = r;
			vx = -vx;
		}
	}
}

class FallingBallPanel extends JPanel implements Runnable{
	MyBall b;
	FallingBallPanel(){
		b = new MyBall();
		
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		b.draw(g);
	}
	@Override
	public void run() {
		try{
			while(true) {
				b.update(0.033f);
				b.collisionhandling(getSize());
				repaint();
				
				Thread.sleep(30);
			}
		}
		catch(InterruptedException e) {
			return;
		}
	}
}
class GamePanel extends JPanel{
	GamePanel(){
		
		
		FallingBallPanel ball = new FallingBallPanel();
		
		//getsize이용해서 bounds 설정 똑바로 하기
		
		add(ball);
		
	}

}

class FlickeringLabel extends JLabel implements Runnable{
	FlickeringLabel(String str){
		super(str);
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		boolean n = true;
		while(true) {
			if(n) {
				setVisible(false);
				n = false;
			}
			else {
				setVisible(true);
				n = true;
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class MainPanel extends JPanel{
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.BLACK;
        Color color2 = Color.GRAY;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
	
	
	MainPanel(){
		System.out.println(getHeight());
		setLayout(null);
		Font f1 = new Font("나눔고딕", Font.BOLD, 40);
		
		setBackground(Color.DARK_GRAY);
		JLabel l1 = new JLabel("Java Programming");
		l1.setForeground(Color.white);
		l1.setBounds(150, 40, 500, 70);
		l1.setFont(f1);
		add(l1);
		
		
		
		JLabel l2 = new JLabel("Homework #5");
		l2.setForeground(Color.white);
		l2.setBounds(190, 110, 400, 70);
		l2.setFont(f1);
		add(l2);
		
		
		Font f2 = new Font("나눔고딕", Font.BOLD, 60);
		JLabel l3 = new JLabel("Block Breaker");
		l3.setForeground(Color.white);
		l3.setBounds(140, 230, 450, 80);
		l3.setFont(f2);
		add(l3);
	
		
		
		Font f3 = new Font("나눔고딕", Font.PLAIN, 25);
		FlickeringLabel l4 = new FlickeringLabel("Press Spacebar to play");
		l4.setForeground(Color.red);
		l4.setBounds(210, 500, 300, 30);
		l4.setFont(f3);
		add(l4);
	}	
}


public class JavaHW5 extends JFrame{
	JavaHW5(){
		setTitle("Java Homework4");
		setSize(700, 700);
		
		MainPanel main = new MainPanel();
		add(main);
		main.setVisible(true);		
		setFocusable(true);
		requestFocus();
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) { }
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("GAME START");
					main.setVisible(false);
					GamePanel game = new GamePanel();
					add(game);
					game.setVisible(true);
					
				}
			}
			public void keyReleased(KeyEvent e) { }
			
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new JavaHW5();

	}

}
