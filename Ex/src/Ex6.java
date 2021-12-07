import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class MyTypingPanel extends JPanel{
	JTextField text;
	JTextArea textarea;
	
	JLabel label = new JLabel("Type At the Above TextField");
	
	MyTypingPanel(){
		setLayout(new BorderLayout());
		text = new JTextField();
		setFocusable(true);
		requestFocus(true);
		text.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textarea.append(text.getText());
					textarea.append("\n");
					text.setText("");
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		add(text, BorderLayout.NORTH);
		
		textarea = new JTextArea();
		add(textarea, BorderLayout.CENTER);
		
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setSize(500, 20);
		add(label, BorderLayout.SOUTH);
	}
}

public class Ex6 extends JFrame{
	Ex6(){
		setTitle("Example 6");
		setSize(500, 500);
		
		add(new MyTypingPanel());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex6();

	}

}
