import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class Panel1 extends JPanel{
	test frame;
	
	Panel1(test parent){
		frame = parent;
		
		setBackground(Color.orange);
		JButton but = new JButton("button1");
		but.addActionListener((e)->{
			if(this.getBackground()==Color.orange) {
				setBackground(Color.MAGENTA);
				frame.changePanel(this);
				
			}
			else setBackground(Color.orange);
		});
		add(but);
	}
}

class Panel2 extends JPanel{
	test frame;
	JLabel label = null;
	
	Panel2(test parent){
		frame = parent;
		label = new JLabel("hello!");
		
		add(label);
		
		
		setBackground(Color.blue);
		JButton but = new JButton("button2");
		but.addActionListener((e)->{
			if(this.getBackground()==Color.blue) {
				setBackground(Color.green);

				frame.changePanel(this);
				
			}
			else setBackground(Color.blue);
		});
		add(but);
	}
}

class PanelControl{
	
	
}
public class test extends JFrame{
	
	
	Panel1 p1 = new Panel1(this);
	Panel2 p2 = new Panel2(this);
	
	void changePanel(JPanel p) {
		System.out.println(p.getClass().getName());
		if(p.getClass().getName().equals( "Panel1")) {
			removeAll();
			add(new Panel2(this));
			revalidate();
			repaint();
		}
		else {
			System.out.println("hey");
			removeAll();
			add(new Panel1(this));
			revalidate();
			repaint();
		}
	}
	test(){
		
		
		setTitle("Hello World");
		setSize(500,500);
		
		add(p1);
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
	}
	

}