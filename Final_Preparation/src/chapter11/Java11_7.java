package chapter11;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class SliderPractice extends JPanel{
	JLabel label;
	JSlider slider;
	int size;
	
	SliderPractice(){
		size = 20;
		
		setLayout(new BorderLayout());
		slider = new JSlider(1, 100);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTrack(true);
		slider.setValue(size);
		add(slider, BorderLayout.NORTH);
		
		
		label = new JLabel("I Love Java");
		add(label, BorderLayout.CENTER);
		label.setFont(new Font("나눔 고딕", Font.PLAIN, size));
		
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				size = slider.getValue();
				label.setFont(new Font("나눔 고딕", Font.PLAIN, size));
			}
		});
		
		
		
		
	}
}

public class Java11_7 extends JFrame{
	Java11_7(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new SliderPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_7();

	}

}