package chapter12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class BlueLabel extends JPanel{
	JLabel label;
	BlueLabel(String in){
		setLayout(null);
		label = new JLabel(in);
		label.setBounds(50, 50, 300, 100);
		label.setFont(new Font("나눔 고딕", Font.ITALIC, 70));
		label.setForeground(Color.red);
		label.setBackground(Color.black);
		add(label);
		repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		label.setOpaque(true);
		label.setBackground(Color.blue);
	}
}

public class Java12_9 extends JFrame{
	Java12_9(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new BlueLabel("Big Hello"));
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java12_9();

	}

}