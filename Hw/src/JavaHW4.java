import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Hw4Frame extends JFrame implements MouseListener{
	int max = 0;
	int flag = 0;
	int ans = 0;
	long tmp = 0;
	String text_tmp = "";
	JLabel Hw4Label;
	
	Hw4Frame(){
		setTitle("JavaHW4");
		setSize(340, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout(20, 20));
		
		// AnsPanel
		JPanel Hw4AnsPanel = new JPanel();
		Hw4AnsPanel.setLayout(new BorderLayout(20, 20));	
		
		Hw4Label = new JLabel(""+ans);
		Hw4Label.setSize(100, 80);
		Hw4Label.setFont(new Font("맑은 고딕", 0, 40));
		
		Hw4AnsPanel.add(Hw4Label, BorderLayout.EAST);
		add(Hw4AnsPanel, BorderLayout.NORTH);
		
		//ButtonPanel
		JPanel Hw4ButtonPanel = new JPanel();
		String []name = {"7", "8", "9", "C", "4", "5", "6", "+", "1", "2", "3", "-", "0", "", "", "="};
		Hw4ButtonPanel.setLayout(new GridLayout(4, 4));
		JButton []Hw4Button = new JButton[16];
		
		for(int i=0;i<16;i++) {
			Hw4Button[i] = new JButton(name[i]);
			Hw4Button[i].setSize(60, 60);
			Hw4Button[i].addMouseListener(this);
			Hw4ButtonPanel.add(Hw4Button[i]);
			if(name[i]=="C") Hw4Button[i].setBackground(Color.RED);
			
		}
		add(Hw4ButtonPanel, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		String text = ((JButton)e.getSource()).getText();
		System.out.println(text+" Clicked!!!");
		switch(text) {
		case "" : break;
		case "+" : 
			if(flag != 0) {
				if(text_tmp.equals("")) tmp = Integer.parseInt(Hw4Label.getText());
				else if(text_tmp.equals("+")) tmp += Integer.parseInt(Hw4Label.getText());
				else if(text_tmp.equals("-")) tmp -= Integer.parseInt(Hw4Label.getText());
	
				Hw4Label.setText(""+tmp);
				flag = 0;
				text_tmp = "+";
				max = 0;
			}
			break;
			
		case "-" : 
			
			if(flag != 0) {
				if(text_tmp.equals("")) tmp = Integer.parseInt(Hw4Label.getText());
				else if(text_tmp.equals("+")) tmp += Integer.parseInt(Hw4Label.getText());
				else if(text_tmp.equals("-")||text_tmp.equals("")) tmp -= Integer.parseInt(Hw4Label.getText());
				
				Hw4Label.setText(""+tmp);
				flag = 0;
				max = 0;
				text_tmp = "-";
			}
			break;
		
		case "C" : 
			Hw4Label.setText("0");
			tmp = 0;
			ans = 0;
			flag = 0;
			text_tmp = "";
			max = 0;
			break;
		
		case "=" :
			if(text_tmp.equals("+")) tmp += Integer.parseInt(Hw4Label.getText());
			else if(text_tmp.equals("-")) tmp -= Integer.parseInt(Hw4Label.getText());	
			Hw4Label.setText(""+tmp);
			text_tmp = "";
			flag = 2;
			max = 0;
			break;
			
		default :
			if(max == 0) {
				ans = Integer.parseInt(text);
				String newstr;
				if(Hw4Label.getText().equals("0")) newstr = ""+ ans;
				else newstr = Hw4Label.getText()+ans;
				if(flag == 0||flag == 2) {
					newstr = ""+ans;
					flag = 1;
				}
				Hw4Label.setText(newstr);
				if(Integer.parseInt(newstr)>100000000) max = 1;
			}
			break;
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}


public class JavaHW4 {
	
	public static void main(String[] args) {
		new Hw4Frame();

	}

}

// 111+123-5-6=
