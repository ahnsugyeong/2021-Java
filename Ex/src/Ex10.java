import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyImage extends JPanel implements MouseMotionListener{
	BufferedImage img;
	int x, y, size;
	MyImage(){
		x = 0;
		y = 0;
		size = 100;
		
		addMouseMotionListener(this);
		
		try {
			img = ImageIO.read(new File("lena.jpg"));
		} catch (IOException e) {
			System.out.println("file not found!!");
			e.printStackTrace();
		}
		
		addMouseWheelListener(new MouseWheelListener()
		{
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				int rot = e.getWheelRotation();
				size += rot*5;
				if(size <10 ) size = 10;
				if(x+size>img.getWidth()) {
					x = img.getWidth()-size;
				}
				if(y+size>img.getHeight()) {
					y = img.getHeight()-size;
				}
				if(size>=img.getWidth()&&size>img.getHeight()) {
					x = 0;
					y = 0;
					size = img.getWidth();
				}
				repaint();
				
			}
		});
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.drawImage(img, 0, 0, null);
		g2.drawImage(img, img.getWidth(), 0, (img.getWidth()+300), 300, x, y, x+size, y+size, null);
		g2.setColor(Color.red);

		
		g2.drawRect(x, y, size, size);
		
		
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX()-size/2;
		y = e.getY()-size/2;
		if(x+size>img.getWidth()) x = img.getWidth()-size;
		if(x<0) x = 0;
		if(y+size>img.getHeight()) y = img.getHeight()-size;
		if(y<0) y = 0;
		
		repaint();
	}
	public void mouseMoved(MouseEvent e) {
		x = e.getX()-size/2;
		y = e.getY()-size/2;
		if(x+size>img.getWidth()) x = img.getWidth()-size;
		if(x<0) x = 0;
		if(y+size>img.getHeight()) y = img.getHeight()-size;
		if(y<0) y = 0;
		repaint();
	}
}

public class Ex10 extends JFrame{
	
	
	Ex10(){
		setTitle("Example 10");
		setSize(900, 700);
		
		MyImage i = new MyImage();
		add(i);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex10();

	}

}
