import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;



/*
 * 클릭 후 드래그해서 원 그리기, 그린 원을 드래그해서 움직이기, 버튼을 연동해서 그려던 원들을 삭제하기, 버튼을 눌러서 원들을 부드러운 애니메이션으로 크기에 따라서 정렬하기.
 */

class RightPanel extends JPanel implements MouseListener, MouseMotionListener{
	LeftPanel left;
	int x, y, r;
	class MyCircle{
		int x, y, r;
		MyCircle(int _x, int _y, int _r){
			x = _x;
			y = _y;
			r = _r;
		}
	}
	ArrayList<MyCircle> circles = new ArrayList<>();
	
	RightPanel(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g) {
		g.drawOval(x-r, y-r, r*2, r*2);
		for(int i=0;i<circles.size();i++) {
			MyCircle tmp = circles.get(i);
			g.drawOval(tmp.x-tmp.r, tmp.y-tmp.r, tmp.r*2, tmp.r*2);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		r = (int)(Math.sqrt((x - e.getX())*(x - e.getX())+(y - e.getY())*(y - e.getY())));
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		circles.add(new MyCircle(x, y, r));
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


class LeftPanel extends JPanel{
	RightPanel right;
	
	LeftPanel(){
		JList list = new JList();
		JListItem item = new JListItem();
		setBackground(Color.DARK_GRAY);
	}
}

public class test extends JFrame{
	test(){
		setTitle("test");
		setSize(500, 500);
		setLayout(null);
		
		LeftPanel left = new LeftPanel();
		left.setBounds(0,0, (int)(getWidth()*0.3), getHeight());
		left.setLocation(0,  0);
		add(left);
		
		RightPanel right = new RightPanel();
		right.setBounds((int)(getWidth()*0.3), 0, (int)(getWidth()*0.7), getHeight());
		add(right);
		
		left.right = right;
		right.left = left;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new test();

	}

}
