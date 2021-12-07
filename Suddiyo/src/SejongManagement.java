import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class HomeButton extends JButton{
	
	HomeButton(){
		super("HOME");
	}
}

class ProfessorRegisterPanel extends JPanel implements ActionListener{
	JTextField id;
	JTextField max;
	Professor pro;
	ProfessorRegisterPanel(Professor in, SejongManagement home){
		pro = in;
		Font titlefont = new Font("Klavika Bold", Font.PLAIN, 30);
		setBackground(new Color(238, 230, 216));
		JLabel l = new JLabel("  Professor Register");
		l.setBounds(0, 0, 300, 50);
		l.setOpaque(true);
		l.setBackground(new Color(186, 73, 72));
		l.setFont(titlefont);
		add(l);
		
		setLayout(null);
		Font f = new Font("Mulish", Font.PLAIN, 15);
		
		JLabel l1 = new JLabel("Course ID: ");
		l1.setBounds(30, 70, 100, 30);
		l1.setFont(f);
		add(l1);
		
		JLabel l2 = new JLabel("Max: ");
		l2.setBounds(30, 110, 100, 30);
		l2.setFont(f);
		add(l2);
		
		id = new JTextField(8);
		id.setBounds(130, 70, 120, 30);
		id.setFont(f);
		add(id);
		
		max = new JTextField(2);
		max.setBounds(130, 110, 30, 30);
		max.setFont(f);
		add(max);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		
		JButton b1 = new JButton("REGISTER");
		b1.setFont(f);
		buttonPanel.add(b1);

		JButton b2 = new JButton("CANCEL");
		b2.setFont(f);
		buttonPanel.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		buttonPanel.setBounds(30, 150, 240, 50);
		add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("REGISTER")) {
			JOptionPane.showMessageDialog(null, "Register Success!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
			pro.course.add(new Course(id.getText(), Integer.parseInt(max.getText()), pro));
			id.setText("");
			max.setText("");
		}
		else if(e.getActionCommand().equals("CANCEL")) {
			id.setText("");
		}
	}	
}
class ProfessorRegisterFrame extends JFrame{
	Container c;
	ProfessorRegisterFrame(Professor pro, SejongManagement home){
		setTitle("Professor management service");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		ProfessorRegisterPanel rp = new ProfessorRegisterPanel(pro,home);
		c.add(rp);
		setSize(300, 250);
		setVisible(true);
		
	}

}
class ProfessorMenuPanel extends JPanel{
int flag = 0;
	
	ProfessorMenuPanel(Professor pro, SejongManagement home){
		
		setBackground(new Color(238, 230, 216));
		
		setLayout(null);
		
		Font titlefont = new Font("Klavika Bold", Font.PLAIN, 30);
		JLabel l = new JLabel("  MENU");
		l.setBounds(0, 0, 500, 50);
		l.setOpaque(true);
		l.setBackground(new Color(186, 73, 72));
		l.setFont(titlefont);
		add(l);
		Font f = new Font("Mulish", Font.BOLD, 15);
		JButton []menu = new JButton[3];
		String []name = {"adding the course", "deleting the course", "grading students"};
		for(int i=0;i<3;i++) {
			menu[i] = new JButton(name[i]);
			menu[i].setBounds(0, 60+(i*50), 500, 50);
			menu[i].setFont(f);
			add(menu[i]);
		}
		
		menu[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorRegisterFrame r = new ProfessorRegisterFrame(pro, home);
				setVisible(false);
			}
		});
		menu[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
}
class ProfessorFrame extends JFrame{
	Container c;
	
	ProfessorFrame(Professor pro, SejongManagement home){
		setTitle("Student management service");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		ProfessorMenuPanel p = new ProfessorMenuPanel(pro, home);
		c.add(p);
		setSize(500, 400);
		setVisible(true);
	}
}

class StudentRegisterPanel extends JPanel implements ActionListener{
	JTextField id;
	Student stu;
	ArrayList<Course> course;
	int flag = 0;
	
	StudentRegisterPanel(Student in, ArrayList<Course> all, SejongManagement home){
		flag = 0;
		stu = in;
		course = all;
		Font titlefont = new Font("Klavika Bold", Font.PLAIN, 30);
		setBackground(new Color(238, 230, 216));
		JLabel l = new JLabel("  Student Register");
		l.setBounds(0, 0, 300, 50);
		l.setOpaque(true);
		l.setBackground(new Color(186, 73, 72));
		l.setFont(titlefont);
		add(l);
		
		setLayout(null);
		Font f = new Font("Mulish", Font.PLAIN, 15);
		
		JLabel l1 = new JLabel("Course ID: ");
		l1.setBounds(30, 70, 100, 30);
		l1.setFont(f);
		add(l1);
		
		id = new JTextField(8);
		id.setBounds(130, 70, 120, 30);
		id.setFont(f);
		add(id);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		
		JButton b1 = new JButton("REGISTER");
		b1.setFont(f);
		buttonPanel.add(b1);

		JButton b2 = new JButton("CANCEL");
		b2.setFont(f);
		buttonPanel.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		buttonPanel.setBounds(30, 120, 240, 50);
		add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("REGISTER")) {
			for(int i=0;i<course.size();i++) {
				if(course.get(i).courseid.equals(id.getText())) {
					if(course.get(i).max == course.get(i).num) JOptionPane.showMessageDialog(null, "Full People!", "ERROR", JOptionPane.ERROR_MESSAGE);
					else {
						JOptionPane.showMessageDialog(null, "Register Success!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
						course.get(i).num += 1;
					}
					flag = 1;
					break;
				}
			}
			if(flag == 0) JOptionPane.showMessageDialog(null, "Course not found!", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			id.setText("");
			
		}
		else if(e.getActionCommand().equals("CANCEL")) {
			id.setText("");
		}
	}	
}
class StudentRegisterFrame extends JFrame{
	Container c;
	StudentRegisterFrame(Student stu, ArrayList<Course> all, SejongManagement home){
		setTitle("Student management service");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		StudentRegisterPanel rp = new StudentRegisterPanel(stu, all, home);
		c.add(rp);
		setSize(300, 250);
		setVisible(true);
		
	}
}

class StudentMenuPanel extends JPanel{
	int flag = 0;
	JPanel current;
	SejongManagement h;
	StudentMenuPanel(Student stu, ArrayList<Course> all, SejongManagement home){
		h = home;
		current = this;
		
		
		
		setBackground(new Color(238, 230, 216));
		
		setLayout(null);
		
		Font titlefont = new Font("Klavika Bold", Font.PLAIN, 30);
		JLabel l = new JLabel("  MENU");
		l.setBounds(0, 0, 450, 50);
		l.setOpaque(true);
		l.setBackground(new Color(186, 73, 72));
		l.setFont(titlefont);
		add(l);
		
		HomeButton b = new HomeButton();
		b.setBounds(450, 0, 50, 50);
		add(b);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current.setVisible(false);
				h.setVisible(true);
			}
		});
		
		
		Font f = new Font("Mulish", Font.BOLD, 15);
		JButton []menu = new JButton[6];
		String []name = {"registering for course", "withdrawing the course", "checking a timetable", "taking a test", "taking a lecture", "checking grades"};
		for(int i=0;i<6;i++) {
			menu[i] = new JButton(name[i]);
			menu[i].setBounds(0, 60+(i*50), 500, 50);
			menu[i].setFont(f);
			add(menu[i]);
		}
		
		menu[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentRegisterFrame r = new StudentRegisterFrame(stu, all, home);
				setVisible(false);
			}
		});
		menu[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	
}

class StudentFrame extends JFrame{
	Container c;
	StudentFrame(Student stu, ArrayList<Course> all, SejongManagement home){
		setTitle("Student management service");
		c = getContentPane();
		StudentMenuPanel p = new StudentMenuPanel(stu, all, home);
		c.add(p);
		
		
		setSize(500, 400);
		setVisible(true);
	}
	
	
}

class Professor{
	String name;
	ArrayList<Course> course = new ArrayList<Course>();
	
	Professor(String in, ArrayList<Course> c_in){
		name = in;
		course = c_in;
	}
}
class Student{
	String name;
	ArrayList<Course> course = new ArrayList<Course>();
	
	Student(String in, ArrayList<Course> c_in){
		name = in;
		course = c_in;
	}
}

class Course{
	String courseid;
	Professor p;
	ArrayList<StudentFrame> s = new ArrayList<StudentFrame>();
	int num = 0;
	int max = 0;
	
	Course(String id, int n, Professor in){
		courseid = id;
		max = n;
		p = in;
	}
}

class LoginPanel extends JPanel{
	JTextField id;
	JPasswordField password;
	int flag = 1;
	HashMap<String, String> stu_inform = new HashMap<String, String>();
	HashMap<String, String> pro_inform = new HashMap<String, String>();
	HashMap<String, String> man_inform = new HashMap<String, String>();
	ArrayList<Course> all;
	
	ArrayList<Professor> professor = new ArrayList<Professor>();
	ArrayList<Student> student = new ArrayList<Student>();
	
	LoginPanel(SejongManagement home){
		all = new ArrayList<Course>();
		setBackground(new Color(238, 230, 216));
		setLayout(null);
		Font titlefont = new Font("Klavika Bold", Font.PLAIN, 20);
		JLabel l = new JLabel("  LOGIN PAGE");
		l.setBounds(0, 0, 350, 50);
		l.setOpaque(true);
		l.setBackground(new Color(186, 73, 72));
		l.setFont(titlefont);
		add(l);
		
		
		Font f1 = new Font("Mulish", Font.PLAIN, 14);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		ButtonGroup buttons = new ButtonGroup();
		JRadioButton but_student = new JRadioButton("student");
		but_student.setFont(f1);
		JRadioButton but_professor = new JRadioButton("professor");
		but_professor.setFont(f1);
		JRadioButton but_manager = new JRadioButton("manager");
		but_manager.setFont(f1);
		
		buttons.add(but_student);
		buttons.add(but_professor);
		buttons.add(but_manager);
		but_student.setSelected(true);
		
		
		
		but_student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Student selected!!");
				flag = 1;
			}
		});
		
		but_professor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Professor selected!!");
				flag = 2;
			}
		});
		
		but_manager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("manager selected!!");
				flag = 3;
			}
		});
		
		
		buttonPanel.add(but_student); buttonPanel.add(but_professor); buttonPanel.add(but_manager);
		buttonPanel.setBounds(20, 60, 300, 30);
		add(buttonPanel);
		buttonPanel.setOpaque(false);
		
		Font f2 = new Font("Mulish", Font.PLAIN, 14);
		
		JLabel l1 = new JLabel("ID: ");
		l1.setFont(f2);
		id = new JTextField(8);
		id.setFont(f2);
		
		JLabel l2 = new JLabel("PASSWORD: ");
		l2.setFont(f2);
		password = new JPasswordField(10);
		password.setFont(f2);
		
		Font f3 = new Font("Mulish", Font.BOLD, 11);
		JButton b1 = new JButton("LOGIN");
		b1.setFont(f3);

		JButton b2 = new JButton("CANCEL");
		b2.setFont(f3);
		
		JButton b3 = new JButton("REGISTER");
		b3.setFont(f3);
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//login
				if(flag == 1) {
					if(stu_inform.containsKey(id.getText())) {
						if(stu_inform.get(id.getText()).equals(password.getText())) {
							JOptionPane.showMessageDialog(null, "Login Success!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
							
							for(int i=0;i<student.size();i++) {
								if(student.get(i).name.equals(id.getText())) {
									StudentFrame p = new StudentFrame(student.get(i), all, home);
									setVisible(false);
								}
							}
						}
						else {
							password.setText("");
							JOptionPane.showMessageDialog(null, "Password error!\nTry again!", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						id.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(null, "The account doesn't exist!\nTry again!", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				else if(flag == 2) {
					if(pro_inform.containsKey(id.getText())) {
						if(pro_inform.get(id.getText()).equals(password.getText())) {
							JOptionPane.showMessageDialog(null, "Login Success!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
							for(int i=0;i<professor.size();i++) {
								if(professor.get(i).name.equals(id.getText())) {
									ProfessorFrame p = new ProfessorFrame(professor.get(i), home);
									setVisible(false);
								}
							}
							
						}
						else {
							password.setText("");
							JOptionPane.showMessageDialog(null, "Password error!\nTry again!", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						id.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(null, "The account doesn't exist!\nTry again!", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(flag == 3) {	
					if(man_inform.containsKey(id.getText())) {
						if(man_inform.get(id.getText()).equals(password.getText())) {
							JOptionPane.showMessageDialog(null, "Login Success!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
							//new ManagerFrame();
							setVisible(false);
						}
						else {
							password.setText("");
							JOptionPane.showMessageDialog(null, "Password error!\nTry again!", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						id.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(null, "The account doesn't exist!\nTry again!", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				password.setText("");
			}
			
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag == 1) {
					stu_inform.put(id.getText(), password.getText());
					JOptionPane.showMessageDialog(null, "Register Success!\nPlease Login!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
					ArrayList<Course> stu_course = new ArrayList<Course>();
					Student s = new Student(id.getText(), stu_course);
					student.add(s);
					id.setText("");
					password.setText("");
					
				}
				else if(flag == 2) {
					pro_inform.put(id.getText(), password.getText());
					JOptionPane.showMessageDialog(null, "Register Success!\nPlease Login!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
					ArrayList<Course> pro_course = new ArrayList<Course>();
					Professor p = new Professor(id.getText(), pro_course);
					professor.add(p);
					id.setText("");
					password.setText("");
				}
				else if(flag == 3) {
					man_inform.put(id.getText(), password.getText());
					JOptionPane.showMessageDialog(null, "Register Success!\nPlease Login!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
					
					id.setText("");
					password.setText("");
				}
			}
			
		});
		
		l1.setBounds(50, 100, 70, 30);
		id.setBounds(130, 100, 120, 30);
		add(l1); add(id);
		
		l2.setBounds(20, 140, 100, 30);
		password.setBounds(130, 140, 120, 30);
		add(l2); add(password);
		
		b1.setBounds(30, 180, 80, 30);
		b2.setBounds(120, 180, 80, 30);
		b3.setBounds(210, 180, 90, 30);
		
		add(b1); add(b2); add(b3);
		
	}

}

public class SejongManagement extends JFrame{
	Container c;
	SejongManagement(){
		setTitle("Sejong Online lecture management service");
		setSize(350, 250);
		c = getContentPane();
		c.add(new LoginPanel(this));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SejongManagement();
		
	}
}
