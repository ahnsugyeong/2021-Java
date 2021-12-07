package chapter11;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ComboBoxPractice extends JPanel{
	JTextField t;
	JComboBox<String> combo;
	
	ComboBoxPractice(){
		t = new JTextField(20);
		add(t);
		combo = new JComboBox<String>();
		add(combo);
		
		
		t.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					combo.addItem(t.getText());
				
					t.setText("");
					
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}

public class Java11_2 extends JFrame{
	Java11_2(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new ComboBoxPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_2();

	}

}