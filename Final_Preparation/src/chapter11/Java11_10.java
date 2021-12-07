package chapter11;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ClickLabel extends JPanel implements MouseListener{
	int index = 0;
	JLabel []label;
	int x, y;
	
	void makeLabel() {
		for(int i=0;i<10;i++) {
			index = 0;
			x = (int) (Math.random()*480);
			y = (int) (Math.random()*480);
			label[i].setBounds(x, y, 20, 20);
			label[i].setVisible(true);
			
		}
	}
	
	ClickLabel(){
		setLayout(null);
		label = new JLabel[10];
		for(int i=0;i<10;i++) {
			x = (int) (Math.random()*480);
			y = (int) (Math.random()*480);
			label[i]= new JLabel(""+i);
			label[i].setBounds(x, y, 20, 20);
			label[i].setForeground(Color.blue);
			label[i].addMouseListener(this);
			add(label[i]);
			
		}
		
		
	}
	public void mouseClicked(MouseEvent e) {
		JLabel l = (JLabel)e.getSource();
		if(l.getText().equals(""+index)) {
			l.setVisible(false);
			index++;
			if(index == 10) {
				
				makeLabel();
			}
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

public class Java11_10 extends JFrame{
	Java11_10(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new ClickLabel());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_10();
		
	}

}