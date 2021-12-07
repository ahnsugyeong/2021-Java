package chapter14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Java14_1 extends JFrame{
	Java14_1(){
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu m1 = new JMenu("파일");
		JMenuItem m1_1 = new JMenuItem("열기");
		m1.add(m1_1);
		m1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Images", "jpeg");
				chooser.setFileFilter(filter);
				chooser.addChoosableFileFilter(filter);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int ret = chooser.showOpenDialog(null);
				String pathName = chooser.getSelectedFile().getPath();
				if(ret == JFileChooser.APPROVE_OPTION) {
					//String path
				}
				
			}
			
		});
		JMenu m2 = new JMenu("편집");
		JMenu m3 = new JMenu("보기");
		JMenu m4 = new JMenu("입력");
		
		JMenuItem i1 = new JMenuItem("화면확대");
		JMenuItem i2 = new JMenuItem("쪽윤곽");
		m3.add(i1);
		m3.add(i2);
		
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		menubar.add(m4);
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Java14_1();

	}

}