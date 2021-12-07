import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



class MyHelloCircle{
	int x, y, r;
	MyHelloCircle(int _x, int _y, int _r){
		x = _x;
		y = _y;
		r = _r;
	}
}
class MyLeftPanel extends JPanel implements ListSelectionListener{
	MyRightPanel rightPanel;
	JList list;
	JButton del;
	DefaultListModel listModel;
	MyLeftPanel(){
		listModel = new DefaultListModel();
		list = new JList(listModel);
		del = new JButton("delete");
		add(del);
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rightPanel.removeSelected();
				
			}
			
		});
		list.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);	
		list.setPreferredSize(new Dimension(200,400));
		add(list);
	}
	
	public void updateList() {
		listModel.clear();
		
		int i=0;
		for(MyHelloCircle p: rightPanel.circles)
		{
			String str = new String();
			str = i+": center("+p.x+","+p.y+")";
			listModel.addElement(str);
			i++;
		}		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int index = list.getSelectedIndex();
		rightPanel.selected = index;
		rightPanel.repaint();
		
	}
}
class MyRightPanel extends JPanel implements MouseListener{
	MyLeftPanel leftPanel;
	int selected = -1;
	
	Vector<MyHelloCircle> circles = new Vector<>();
	MyRightPanel(){
		setBackground(Color.orange);
		addMouseListener(this);
	}
	public void removeSelected() {
		if(selected<0) return;
		ListIterator it = circles.listIterator();
		int i=-1;
		while(it.hasNext()) {
			it.next();
			i++;
			if(i == selected) {
				it.remove();
				break;
			}
		}
		leftPanel.updateList();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for(MyHelloCircle c: circles) {
			if(selected>=0 && c == circles.get(selected)) {
				g.setColor(Color.red);
			}
			else g.setColor(Color.black);
			g.drawOval(c.x-c.r, c.y-c.r, c.r*2, c.r*2);
			
		}
		
	}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		circles.add(new MyHelloCircle(e.getX(), e.getY(), 50));
		leftPanel.updateList();
		repaint();
	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	
}

public class Ex5 {

	public static void main(String[] args) {
		
	JFrame f = new JFrame();
	f.setSize(800,500);
	f.setTitle("Example 5");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	MyLeftPanel p1 = new MyLeftPanel();
	p1.setPreferredSize(new Dimension(200,500));
	f.add(p1, BorderLayout.WEST);
	MyRightPanel p2 = new MyRightPanel();
	f.add(p2, BorderLayout.CENTER);
	
	p1.rightPanel = p2;
	p2.leftPanel = p1;
	
	f.setVisible(true);
		
	}
}
