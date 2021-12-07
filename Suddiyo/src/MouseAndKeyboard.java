import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Point;
import java.awt.TextField;

class MouseAndKeyboardPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	JLabel text;
	JTextField textField;
	int mouseButton;
	int localvar = 10;
	
	MouseAndKeyboardPanel(){
		this.setLayout(null);
		
		text = new JLabel("Text");
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				text.setText("Enter!");
			}
			@Override
			public void mouseExited(MouseEvent e) { 
				text.setText("Exit!");
			}	
		});
		add(text);
		text.setLocation(10,10);
		text.setSize(100,20);

		textField = new JTextField(20);
		add(textField);
		textField.setLocation(10,100);
		textField.setSize(100,20);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
/*
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				System.out.println("key Pressed!"+text.getText());
				setBackground(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			}
			public void keyReleased(KeyEvent e) {
				System.out.println("key Released!");
			}
		});
*/
		addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		
		
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("click count:" +e.getClickCount());
		if(e.getClickCount() == 2) {
			Color c = new Color((int)(Math.random()*255),
					            (int)(Math.random()*255), 
					            (int)(Math.random()*255));				// R, G, B : [0, 255]
			setBackground(c);
			
		}
	}
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();	
		mouseButton = e.getButton();
		
		if(e.getButton() == MouseEvent.BUTTON1)
			System.out.println("Left Button Pressed at ("+x+","+y+")");
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			text.setLocation(e.getX(), e.getY());
		}		
		
		requestFocus();
	}
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if(e.getButton() == MouseEvent.BUTTON1)
			System.out.println("Left Button Released at ("+x+","+y+")");
	}
	public void mouseEntered(MouseEvent e) { 
		setBackground(Color.red);
	}
	public void mouseExited(MouseEvent e) {	 
		setBackground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(mouseButton == MouseEvent.BUTTON1)
			//System.out.println("Dragged!!!:" + " " + e.getX() + "," + e.getY());
			text.setLocation(e.getX(), e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Moved!!!:" + e.getX() + "," + e.getY());
		
	}
	public void keyTyped(KeyEvent e) {
			
			char c = e.getKeyChar();
			int key = (int)c;
			if(key == KeyEvent.VK_BACK_SPACE) {
				String str = text.getText();
				text.setText(str.substring(0,str.length()-1));			
			}
			else {
				System.out.println("key="+key);
				String str = text.getText();
				str += c;
				text.setText(str);
			}
	}
	public void keyPressed(KeyEvent e) {
		
		System.out.println("key Pressed!"+e.getKeyCode());			// ascii

		Point pt = text.getLocation();
		int x = pt.x;
		int y = pt.y;
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:		
			setBackground(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			break;
		case KeyEvent.VK_LEFT:	x-=10; text.setLocation(x,y);	break;
		case KeyEvent.VK_RIGHT:	x+=10; text.setLocation(x,y);	break;
		case KeyEvent.VK_UP:	y-=10; text.setLocation(x,y);	break;
		case KeyEvent.VK_DOWN:	y+=10; text.setLocation(x,y);	break;

			
		default:												break;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			setBackground(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));

	
	}
	public void keyReleased(KeyEvent e) {
		//System.out.println("key Released!");
	}	
}

public class MouseAndKeyboard extends JFrame{

	MouseAndKeyboard(){
		setTitle("Mouse and Keyboard");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MouseAndKeyboardPanel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseAndKeyboard();
	}

}