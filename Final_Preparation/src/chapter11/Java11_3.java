package chapter11;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class MoneyPractice extends JPanel{
	int []result = new int[8];
	JLabel []label = new JLabel[8];
	JLabel []r_label = new JLabel[8];
	int money;
	
	void calc() {
		if(money / 50000 > 0) {
			result[0] = money / 50000;
			money %= 50000;
		}
		if(money / 10000 > 0) {
			result[1] = money / 10000;
			money %= 10000;
		}
		if(money / 1000 > 0) {
			result[2] = money / 1000;
			money %= 1000;
		}
		if(money / 500 > 0) {
			result[3] = money / 500;
			money %= 500;
		}
		if(money / 100 > 0) {
			result[4] = money / 100;
			money %= 100;
		}
		if(money / 50 > 0) {
			result[5] = money / 50;
			money %= 50;
		}
		if(money / 10 > 0) {
			result[6] = money / 10;
			money %= 10;
		}
		result[7] = money;
		
	}
	
	MoneyPractice(){
		setBackground(Color.pink);
		setLayout(null);
		
		JLabel l1 = new JLabel("금액");
		l1.setBounds(30, 30, 40, 20);
		add(l1);
		JTextField f1 = new JTextField(10);
		f1.setBounds(70, 30, 100, 20);
		add(f1);
		JButton but = new JButton("계산");
		but.setBounds(190, 30, 40, 20);
		add(but);
		String []name = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
		
		
		for(int i=0;i<8;i++) {
			result[i] = 0;
			label[i] = new JLabel(name[i]);
		}
		
		for(int i=0;i<8;i++) {
			r_label[i] = new JLabel("        ");
		}
		for(int i=0;i<8;i++) {
			label[i].setBounds(30, (i+1)*30+70, 60, 20);
			add(label[i]);
			r_label[i].setBounds(100, (i+1)*30+70, 100, 20);
			r_label[i].setOpaque(true);
			r_label[i].setBackground(Color.white);
			add(r_label[i]);
		}
		
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				money = Integer.parseInt(f1.getText());
				calc();
				for(int i=0;i<8;i++) {
					r_label[i].setText("           "+result[i]);
				}
			}
		});
		
		
		
	
		
		
		
	}
}

public class Java11_3 extends JFrame{
	Java11_3(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MoneyPractice());
		setSize(300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_3();

	}

}