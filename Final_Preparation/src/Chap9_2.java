import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{
	MyPanel(){
		setLayout(new BorderLayout(5, 7));
		JButton n = new JButton("North");
		add(n, BorderLayout.NORTH);
		JButton s = new JButton("South");
		add(s, BorderLayout.SOUTH);
		JButton w = new JButton("West");
		add(w, BorderLayout.WEST);
		JButton e = new JButton("East");
		add(e, BorderLayout.EAST);
		JButton c = new JButton("Center");
		add(c, BorderLayout.CENTER);
	}
}

public class Chap9_2 extends JFrame{
	Chap9_2(){
		setTitle("BorderLayout Practice");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel());
		setSize(400, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Chap9_2();
	}

}
