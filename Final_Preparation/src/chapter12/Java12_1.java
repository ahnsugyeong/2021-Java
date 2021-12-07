package chapter12;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class DrawImage extends JPanel{
	int flag = 1;
	DrawImage(){
		JButton but = new JButton("Hide/Show");
		but.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(flag == 0) {
					flag = 1;
				}
				else flag = 0;
				repaint();
			}
		});
		add(but);
		
	}
	public void paintComponent(Graphics g) {
		if(flag == 1) {
			ImageIcon icon= new ImageIcon("images/cat3.jpeg");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		}
		
	}
}

public class Java12_1 extends JFrame{
	Java12_1(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawImage());
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_1();

	}

}