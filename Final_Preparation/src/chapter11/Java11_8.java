package chapter11;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


class ImagePractice extends JPanel{
	int index = 0;
	Vector<ImageIcon> imgs;
	JLabel curimg;
	JRadioButton left;
	JRadioButton right;
	ImagePractice(){
		imgs = new Vector<>();
		ButtonGroup g = new ButtonGroup();
		left = new JRadioButton("left");
		right = new JRadioButton("right");
		g.add(left); g.add(right);
		add(left); add(right);
		
        File f = new File("images");
        File files[] = f.listFiles();
        
        for(int i=0; i<files.length; i++){
            ImageIcon image = new ImageIcon(files[i].getPath());
            imgs.add(image);
        }
        
        curimg = new JLabel();
        curimg.setPreferredSize(new Dimension(500, 300));
        curimg.setIcon(imgs.get(0));
        add(curimg);
        curimg.addMouseListener(new MouseListener() {
        	public void mouseClicked(MouseEvent e) {
        		if(left.isSelected()) {
        			index--;
        			if(index==-1) index = files.length-1;
        			curimg.setIcon(imgs.get(index));
        		}
        		else if(right.isSelected()) {
        			index++;
        			if(index==files.length) index = 0;
        			curimg.setIcon(imgs.get(index));
        		}
        	}
        	public void mousePressed(MouseEvent e) {}
        	public void mouseReleased(MouseEvent e) {}
        	public void mouseEntered(MouseEvent e) {}
        	public void mouseExited(MouseEvent e) {}
        	
        });
        
        
        
        
        
        
		
		
	}
}

public class Java11_8 extends JFrame{
	Java11_8(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new ImagePractice());
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java11_8();
		
	}

}