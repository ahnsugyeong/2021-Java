import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class HelloSWING extends JFrame{
	
	HelloSWING(String title){
			setTitle(title);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(300, 300);
			
			//JButton b = new JButton("suddi Button");	// component class
			//add(b);
			
			// Content pane
			JPanel p = new JPanel();
			p.setBackground(Color.orange);
			//Container c = getContentPane();
			
			p.setLayout(new FlowLayout());

			
			p.add(new JLabel("Input ID:"));
			p.add(new JTextField(20));
			p.add(new JLabel("Password:"));
			p.add(new JPasswordField(20));
			p.add(new JButton("Cancel"));
			p.add(new JButton("Okay"));
			
			add(p);
			
			setVisible(true);
			System.out.println("Frame 생성 완료!");
	}
	
	public static void main(String[] args) {
		HelloSWING f1 = new HelloSWING("Hello Suddiyo World");
		//HelloSwingFrame f2 = new HelloSwingFrame("hello suddiyo world!!!");
		System.out.println("main 종료!");
	}

}
/* 일꾼 -> thread.
 지금까지는 single-thread. 이렇게 여러 개 돌리는 건 multi-thread.
 
*/