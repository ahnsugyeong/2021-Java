package chapter11;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class JSliderPractice2 extends JPanel{
	JSlider slider;
	int value;
	JTextArea text;
	JSliderPractice2(){
		setLayout(null);
		value = 0;
		text = new JTextArea(500, 300);
		text.setBounds(0, 0, 500, 300);
		add(text);

		
	
		
		
		slider = new JSlider(0, 100);
		slider.setBounds(0, 300, 500, 200);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		slider.setValue(value);
		
		
		text.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				value = text.getText().length();
				if(value>100) {
					text.setText(text.getText().substring(0,99));
					value = 100;
				}
				slider.setValue(value);
				
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
		
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(slider.getValue()<value) {
					System.out.println("remove!!");
					text.setText(text.getText().substring(0, text.getText().length()-1));
					value = slider.getValue();
				}
				
			}
			
		});
		
		add(slider);
	}
}

public class Java11_6 extends JFrame{
	Java11_6(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JSliderPractice2());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_6();

	}

}