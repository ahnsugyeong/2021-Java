import java.awt.*;
import javax.swing.*;

class North extends JPanel{
	public North() {
		this.setBackground(Color.LIGHT_GRAY);
		add(new JLabel("수식 입력 "));
		add(new JTextField(20));
		this.setLayout(new FlowLayout());
	}
}
class Center extends JPanel{
	public Center() {
		setLayout(new GridLayout(4, 4, 2, 2));
		add(new JButton("0"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
		add(new JButton("7"));
		add(new JButton("8"));
		add(new JButton("9"));
		add(new JButton("CE"));
		add(new JButton("계산"));
		
		JButton plus = new JButton("+");
		plus.setBackground(Color.blue);
		plus.setOpaque(true); 
		plus.setBorderPainted(false);
		add(plus);

		
		JButton minus = new JButton("-");
		minus.setBackground(Color.blue);
		minus.setOpaque(true); 
		minus.setBorderPainted(false);
		add(minus);
		
		JButton mul = new JButton("x");
		mul.setBackground(Color.blue);
		mul.setOpaque(true); 
		mul.setBorderPainted(false);
		add(mul);
		
		JButton div = new JButton("/");
		div.setBackground(Color.blue);
		div.setOpaque(true); 
		div.setBorderPainted(false);
		add(div);
	}
}
class South extends JPanel{
	public South() {
		this.setBackground(Color.yellow);
		add(new JLabel("계산 결과 "));
		add(new JTextField(20));
		this.setLayout(new FlowLayout());
	}
}
public class Hw3_2 extends JFrame{

	Hw3_2(){
		setTitle("계산기 프레임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Container c = getContentPane();
		
		c.add(new North(), BorderLayout.NORTH);
		c.add(new Center(), BorderLayout.CENTER);
		c.add(new South(), BorderLayout.SOUTH);
		
		setSize(400, 400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Hw3_2();
		
	}

}
