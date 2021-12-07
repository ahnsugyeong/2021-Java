package chapter11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class CheckBoxPractice extends JPanel{
	
	CheckBoxPractice(){
		
		JRadioButton b1 = new JRadioButton("버튼 비활성화");
		JRadioButton b2 = new JRadioButton("버튼 감추기");
		
		JButton b = new JButton("test button");
		add(b1); add(b2);add(b);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b1.isSelected()) {
					b.setEnabled(false);
				}
				else b.setEnabled(true); 	
			}
		});
		
		
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b2.isSelected()) {
					b.setVisible(false);
				}
				else b.setVisible(true); 	
			}
		});
		
		
	}
}

public class Java11_1 extends JFrame{
	Java11_1(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new CheckBoxPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_1();

	}

}