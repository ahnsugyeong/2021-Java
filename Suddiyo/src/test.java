import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


class TestPanel extends JPanel{
	String[] name = {"12345678, pro1", "12312322, pro2", "000000, pro3"};
	JTextField id;
	TestPanel(){
		
		Font titlefont = new Font("Klavika Bold", Font.PLAIN, 30);
		setBackground(new Color(238, 230, 216));
		JLabel l = new JLabel("  Check Professors");
		l.setBounds(0, 0, 350, 50);
		l.setOpaque(true);
		l.setBackground(new Color(186, 73, 72));
		l.setFont(titlefont);
		add(l);
		
		setLayout(null);
		
		JList list = new JList(name);
		list.setBounds(20, 70, 300, 300);
		add(list);
		list.setOpaque(false);
		
	
	
		
	}
	
}



public class test extends JFrame{
	Container c;
	test(){
		setTitle("Sejong Online Management Service");
		setSize(350, 250);
		c = getContentPane();
		c.add(new TestPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new test();
		
	}
}
