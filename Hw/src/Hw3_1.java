import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Hw3_1 extends JFrame{

	Hw3_1(){

		setTitle("Ten Color Buttons Frame");
		setSize(1000, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 10));
		
		
		JButton but0 = new JButton("0");
		but0.setBackground(Color.red);
		but0.setOpaque(true); 
		but0.setBorderPainted(false);
		p.add(but0);
		
		JButton but1 = new JButton("1");
		but1.setBackground(Color.orange);
		but1.setOpaque(true); 
		but1.setBorderPainted(false);
		p.add(but1);
		
		JButton but2 = new JButton("2");
		but2.setBackground(Color.yellow);
		but2.setOpaque(true); 
		but2.setBorderPainted(false);
		p.add(but2);
		
		JButton but3 = new JButton("3");
		but3.setBackground(Color.green);
		but3.setOpaque(true); 
		but3.setBorderPainted(false);
		p.add(but3);
		
		JButton but4 = new JButton("4");
		but4.setBackground(Color.CYAN);
		but4.setOpaque(true); 
		but4.setBorderPainted(false);
		p.add(but4);
		
		JButton but5 = new JButton("5");
		but5.setBackground(Color.blue);
		but5.setOpaque(true); 
		but5.setBorderPainted(false);
		p.add(but5);
		
		JButton but6 = new JButton("6");
		but6.setBackground(Color.magenta);
		but6.setOpaque(true); 
		but6.setBorderPainted(false);
		p.add(but6);
		
		JButton but7 = new JButton("7");
		but7.setBackground(Color.gray);
		but7.setOpaque(true); 
		but7.setBorderPainted(false);
		p.add(but7);
		
		JButton but8 = new JButton("8");
		but8.setBackground(Color.pink);
		but8.setOpaque(true); 
		but8.setBorderPainted(false);
		p.add(but8);
		
		JButton but9 = new JButton("9");
		but9.setBackground(Color.LIGHT_GRAY);
		but9.setOpaque(true); 
		but9.setBorderPainted(false);
		p.add(but9);
		add(p);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Hw3_1();
	}

}
