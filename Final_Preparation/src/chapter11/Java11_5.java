package chapter11;

import java.awt.Color;
import java.util.Dictionary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class JSliderPractice extends JPanel{
	JSlider slider;
	JLabel value;
	JSliderPractice(){
		slider = new JSlider(100, 200);
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		
		value = new JLabel(""+slider.getValue());
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				value.setText(""+slider.getValue());
				
			}
			
		});
		value.setOpaque(true);
		value.setBackground(Color.green);
		add(slider); add(value);
	}
}

public class Java11_5 extends JFrame{
	Java11_5(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JSliderPractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_5();

	}

}