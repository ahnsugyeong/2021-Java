import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class MyGameObject extends JPanel{
	MyGameObject(){
	}
	
	abstract void draw(Graphics g);
	abstract void update(float dtime);
	abstract void collisionResolution(MyGameObject in);
	abstract boolean isDead();
}


class MySphere extends MyGameObject{
	float x, y;
	float prev_x, prev_y;
	float vx, vy;

	float r;
	Color color;
	
	
	
	MySphere(float _x, float _y, float angle){
		x = _x;
		y = _y;
		
		float speed = 200;
		
		
		vx = (float) (speed*Math.cos(angle));
		vy = (float) (speed*Math.sin(angle));
		r = 3;
		prev_x = x;
		prev_y = y;
		color = Color.red;
		
	}
	
	
	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(x-r), (int)(y-r),(int) (2*r), (int)(2*r));
	}
	@Override
	void update(float dtime) {
		prev_x = x;
		prev_y = y;
		x = x + vx*dtime;
		y = y + vy*dtime;
		
	}
	@Override
	void collisionResolution(MyGameObject in) {
		MyRectBlock wall = (MyRectBlock) in;
		if(wall.isCollide(this)==false) return;
		
		if(prev_y + r < wall.y ) {y = wall.y-r; vy = -vy;};
		if(prev_y - r > wall.y + wall.h) {y = wall.y+ wall.h + r; vy = -vy;};
		if(prev_x + r <wall.x) { x = wall.x - r; vx = -vx;}
		if(prev_x -r >wall.x + wall.w) { x= wall.x +wall.w +r; vx=-vx;}
		
	}
	
	boolean isDead() {
		if(y + r > 500 ) {		
			return true;
		}
		return false;
	}
}
//flag가 0이면 벽 1이면 블럭 2면 특수 블럭 3이면 바

class MyRectBlock extends MyGameObject {
	MySphere myball;
	int x;
	int y;
	int w;
	int h;
	Color color;
	Color color2;
	int flag;
	boolean collide;
	MyRectBlock(int _x, int _y, int _w, int _h, Color c, Color c2, int f){
		
		collide = false;
		x = _x;
		y = _y;
		w = _w;
		h = _h;
		color = c;
		color2 = c2;
		flag = f;
	}
	
	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x,  y,  w,  h);
		g.setColor(color2);
		g.drawRect(x, y, w, h);
		
	}

	@Override
	void update(float dtime) {
		return;
		
	}

	@Override
	void collisionResolution(MyGameObject in) {
		
	}	
	
	boolean isCollide(MyGameObject o) {
		MySphere b = (MySphere) o;
		if(b.y+b.r >= y && b.y-b.r <= y+h &&
		   b.x+b.r >= x && b.x-b.r <=x+w) {
			collide = true;
			myball = b;
			return true;
		}
		return false;		
	}
	boolean isDead() {
		return collide;
	}
}

class Homework5PracticePanel extends JPanel implements Runnable{
	boolean left, right;
	int n = 3;
	int rect_cnt = 0;
	int ball_cnt = 0;
	MyRectBlock my;
	Thread t;
	float dtime = 1/30.0f;
	
	int []special_x;
	int []special_y;
	int special_cnt = 0;
	LinkedList<MyGameObject> objs = new LinkedList<MyGameObject>();	
	Clip clip = null;
	public boolean isExist(int a, int b) {
		
		for(int i=0;i<special_cnt;i++) {
			if(special_x[i] == a && special_y[i] == b) {
				return true;
				
			}
		}
		return false;
	}
	Homework5PracticePanel(int in) {
		n = in;
		ball_cnt++;
		objs.add(new MySphere(250, 400, 30f));
		
		
		special_cnt = (int)(Math.random()*(n*n/2));
		System.out.println(special_cnt);
		
		special_x = new int[special_cnt];
		special_y = new int[special_cnt];
		
		for(int i=0;i<special_cnt;i++) {
			special_x[i] = (int)(Math.random()*n);
			special_y[i] = (int)(Math.random()*n);
			System.out.println(special_x[i]+" "+special_y[i]);
			System.out.println("/////////////");
		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isExist(i, j)) objs.add(new MyRectBlock(i*440/n+30,j*300/n+30,440/n,300/n, Color.yellow, Color.pink, 2));
				else objs.add(new MyRectBlock(i*440/n+30,j*300/n+30,440/n,300/n, Color.black, Color.pink, 1));
				
				rect_cnt++;
			}
		}
		
		
		objs.add(new MyRectBlock(0,0,500,30, Color.white, Color.white, 0));
		objs.add(new MyRectBlock(0,30,30,500, Color.white, Color.white, 0));
		objs.add(new MyRectBlock(470,30,30,500, Color.white, Color.white, 0));
			
		
		my = new MyRectBlock(200, 450, 150, 20, Color.pink, Color.white, 4);
		objs.add(my);
		if(t == null) {
			t = new Thread(this);
		}
		t.start();
		

		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(MyGameObject o : objs)
			o.draw(g);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				
				for(MyGameObject o : objs)
					o.update(dtime);
				
				for(MyGameObject o1: objs)
				{
					if(o1 instanceof MySphere) {
						for(MyGameObject o2: objs) {
							if(o1==o2) continue;
							if(o2 instanceof MyRectBlock)
								o1.collisionResolution(o2);
						}
					}
				}
				
				var it = objs.iterator();
				int add = 0;
				int addx = 0, addy = 0;
				while(it.hasNext()) {
					MyGameObject o = it.next();
					if(o.isDead()) {
						if(o instanceof MyRectBlock) {
							MyRectBlock b = (MyRectBlock)o;
							if(b.flag == 1 || b.flag == 2) {
								it.remove();
								rect_cnt--;
							}
							if(b.flag == 2) {
								try {
									clip = AudioSystem.getClip();
									URL url = getClass().getResource("coin.wav");
									AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
									clip.open(audioStream);
									
								} catch (LineUnavailableException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (UnsupportedAudioFileException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								clip.start();
								add = 1;
								addx = (int)b.myball.x;
								addy = (int)b.myball.y;
							}
							
						}
						else {
							ball_cnt--;
							it.remove();
						}
					}
				}
				if(add == 1) {
					objs.add(new MySphere(addx, addy, 90f));
					objs.add(new MySphere(addx, addy, 120f));
					ball_cnt += 2;
				}
				repaint();
				
	
				
				Thread.sleep((int)(dtime*1000));
			}
		}
		catch(InterruptedException e) {
			
		}
	}
	
}


class FlickeringLabel extends JLabel implements Runnable{
	FlickeringLabel(String str){
		super(str);
		
	}
	@Override
	public void run() {
		boolean n = true;
		while(true) {
			try {
				if(n) {
					setVisible(false);
					n = false;
				}
				else {
					setVisible(true);
					n = true;
				}
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class MainPanel extends JPanel{
	Thread t;
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
		
		setLayout(null);
		Font f1 = new Font("나눔고딕", Font.BOLD, 40);
		
		setBackground(Color.DARK_GRAY);
		JLabel l1 = new JLabel("Java Programming");
		l1.setForeground(Color.white);
		l1.setBounds(70, 40, 500, 70);
		l1.setFont(f1);
		add(l1);
		
		
		
		JLabel l2 = new JLabel("Homework #5");
		l2.setForeground(Color.white);
		l2.setBounds(110, 110, 400, 70);
		l2.setFont(f1);
		add(l2);
		
		
		Font f2 = new Font("나눔고딕", Font.BOLD, 60);
		JLabel l3 = new JLabel("Block Breaker");
		l3.setForeground(Color.white);
		l3.setBounds(50, 230, 450, 80);
		l3.setFont(f2);
		add(l3);
	
		
		
		Font f3 = new Font("나눔고딕", Font.PLAIN, 25);
		FlickeringLabel l4 = new FlickeringLabel("Press Spacebar to play");
		if(t==null) t = new Thread(l4);
		t.start();
		l4.setForeground(Color.red);
		l4.setBounds(110, 380, 300, 30);
		l4.setFont(f3);
		add(l4);
	}	
}

class GameOverPanel extends JPanel{
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        Color color1 = Color.BLACK;
        Color color2 = Color.GRAY;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, 500, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, 500, 500);
    }
	
	
	GameOverPanel(){
		
		setLayout(null);
		Font f1 = new Font("나눔고딕", Font.BOLD, 40);
		
		setBackground(Color.DARK_GRAY);
		FlickeringLabel l1 = new FlickeringLabel("GAME OVER");

		l1.setForeground(Color.pink);
		l1.setBounds(110, 50, 500, 70);
		l1.setFont(new Font("나눔 고딕", Font.BOLD, 40));
		add(l1);
		
		
		Font f3 = new Font("나눔고딕", Font.PLAIN, 25);
		FlickeringLabel l4 = new FlickeringLabel("Press Spacebar to start");
		Thread t2 = new Thread(l4);
		t2.start();
		
		l4.setForeground(Color.red);
		l4.setBounds(110, 380, 300, 30);
		l4.setFont(f3);
		add(l4);
		
	}	
}

public class Homework5 extends JFrame implements Runnable{
	Clip clip = null;
	
	int i = 1;
	Homework5 home;
	KeyListener mykey;
	Homework5PracticePanel game;
	MainPanel main;
	GameOverPanel over;
	Homework5(){
		try {
			clip = AudioSystem.getClip();
			URL url = getClass().getResource("start.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
			clip.open(audioStream);
			
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clip.start();
		
		home= this;
		setSize(500,500);
		setTitle("Homework5 Practice");
		main = new MainPanel();
		add(main);
		main.setVisible(true);		
		setFocusable(true);
		requestFocus();
		Thread t = new Thread(this);
		t.start();
		mykey = new KeyListener() {
			public void keyTyped(KeyEvent e) { }
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					if(over == null) {
						clip.stop();
						main.setVisible(false);
						main.removeAll();
						main = null;
						game = new Homework5PracticePanel(3);
						i++;
						
						add(game);
						game.setVisible(true);
					}
					else {
						
						over.setVisible(false);
						over.removeAll();
						main = new MainPanel();
						add(main);
						main.setVisible(true);
						
						
						over = null;
					}
					
				}

				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					if(game != null)
					game.left = true;
					
					
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					if(game != null)
					game.right = true;
					
				}
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					    
				}
			
			}
			public void keyReleased(KeyEvent e) { 
				if(game != null) {
					game.left = false;
					game.right = false;
					
				}
			}
			
		};
		this.addKeyListener(mykey);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Homework5();

	}
	public void run() {
		while(true) {
			if(game != null) {
				if(game.left == true) {
					game.my.x -= 30;
					if(game.my.x<=30) game.my.x = 30;
					game.left = false;
					game.my.repaint();
				}
				if(game.right == true) {
					game.my.x+=30;
					if(game.my.x+game.my.w>=480) game.my.x = 470-game.my.w;
					game.right = false;
					game.my.repaint();
				}
				if(game.rect_cnt == 0) {
					try {
						clip = AudioSystem.getClip();
						URL url = getClass().getResource("next.wav");
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
						clip.open(audioStream);
						
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					clip.start();
					
					System.out.println("clear~");
					getContentPane().remove(game);
					game = new Homework5PracticePanel(3*i);
					add(game);
					game.removeAll();
					invalidate();
					validate();
					i++;
					
				}
				if(game.ball_cnt==0) {
					try {
						clip = AudioSystem.getClip();
						URL url = getClass().getResource("over.wav");
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
						clip.open(audioStream);
						
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					clip.start();
					
					game.setVisible(false);
					game.removeAll();
					over = new GameOverPanel();
					add(over);
					over.setVisible(true);
					game = null;
				}
				
				
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}