import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 1. 밖으로 빼서 하기
class MyButtonActionListener implements ActionListener{
	int count = 0;
	HelloEventHandlingPanel panel = null;
	
	MyButtonActionListener(HelloEventHandlingPanel in)
	{
		panel = in;
	}
	@Override
	public void actionPerformed(ActionEvent e) {	// callback method
		System.out.println("button button button!!!!!");
		JButton b = (JButton)e.getSource();
		
		count++;
		
		//String str = "Button "+count;
		//b.setText(str);
		
		
		panel.label.setText("# of Count: "+count);
		//if(b.getText().equals("Button1"))b.setText("Pushed!!");
		//else b.setText("Button1");
		
	}
}

class HelloEventHandlingPanel extends JPanel implements ActionListener{
	JLabel label;
	int count = 0;
	
	HelloEventHandlingPanel(){
		setBackground(Color.pink);
		//add(new JButton("Button1"));
		
		JButton but = new JButton("Button1");
		label = new JLabel("# of Click");
		
		// int i=0;  -> anonymous class 안에서 로컬 변수를 쓸 땐 상수로 생각해야함. final int형!!
		
		//2번. anonymous class로 안에다가 하기
		//but.addActionListener(new MyButtonActionListener(this));
		/*ActionListener ac = new ActionListener() {
			int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Anonymous class");
				count++;
				label.setText("# of Count: "+count);
			}
			
		};	//anonymous
		
		//3번. anonymous class로 안에다가 하기 더 간략한 버전
		but.addActionListener(new ActionListener() {
			//int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Anonymous class");
				count++;
				label.setText("# of Count: "+count);
			}
			
		});*/
		/*
		
		//4번. 더 간단하게! 람다식
		but.addActionListener((e)->{
			System.out.println("Lamda Expression");
			count++;
			label.setText("# of Count: "+count);
		});	//람다식!!! lamda expression
		
		*/
		//5번. 패널 자체가 수행하는 것. implements ActionListener 추가	
		//but.addActionListener(this);
		
		
		add(but);
		add(label); 
		but.addActionListener(this);
		JButton but2 = new JButton("Button2");
		but2.addActionListener(this);
		add(but2);
	}
	//5번. 패널 자체가 수행하는 것. implements ActionListener 추가
	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Button1")) {
			System.out.println("Panel Method");
			count++;
			label.setText("# of Count: "+count);
		}
		else {
			System.out.println("Button2!!!!");
		}
		
		
	}
}


public class HelloEventHandling extends JFrame{
	
	HelloEventHandling(){
		setTitle("Hello Event Handling");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		HelloEventHandlingPanel p = new HelloEventHandlingPanel();
		add(p);
		setVisible(true);
	}
	public static void main(String[] args) {
		new HelloEventHandling();

	}

}
