// after login - payroll system main page
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class payrollpage extends JFrame implements ActionListener {
	
	payrollpage(){
		 super("Main - payroll system");
	     setSize(800,600);
	     setLocation(300,100);
	     getContentPane().setBackground(Color.DARK_GRAY); // background color - dark gray
	     
	     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payroll main page.jpg"));
	     Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
	     ImageIcon i3 = new ImageIcon(i2);
	     JLabel l1 = new JLabel(i3);
	     add(l1);
	 
	     JMenuBar mb = new JMenuBar();
	     setJMenuBar(mb);
	     
	     JMenu m1 = new JMenu("File");
	     m1.setForeground(Color.RED);
	 
	     JMenuItem f1 = new JMenuItem("New Employee");
	     f1.setForeground(Color.RED);
	     f1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     f1.setMnemonic('N'); // shortcut key - ctrl + N
	     f1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	     f1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/new emp.png")));
	
	     JMenuItem f2 = new JMenuItem("Salary");
	     f2.setForeground(Color.RED);
	     f2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     f2.setMnemonic('S');
	     f2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/salary.png")));
	     f2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	 
	     JMenuItem f3 = new JMenuItem("List Employees");
	     f3.setForeground(Color.RED);
	     f3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     f3.setMnemonic('L');
	     f3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/list emp.png")));
	     f3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
	     
	     m1.add(f1);
	     m1.add(f2);
	     m1.add(f3);
	     mb.add(m1);
	 
	     f1.addActionListener(this);
	     f2.addActionListener(this);
	     f3.addActionListener(this);
	     
	     JMenu edit = new JMenu("Update");
	     edit.setForeground(Color.RED);
	     mb.add(edit);
	     
	     JMenuItem u1 = new JMenuItem("Update Employee");
	     u1.setForeground(Color.RED);
	     u1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     u1.setMnemonic('E');
	     u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/update emp.png")));
	     u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	     edit.add(u1);
	     
	     JMenuItem u2 = new JMenuItem("Update Salary");
	     u2.setForeground(Color.RED);
	     u2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     u2.setMnemonic('U');
	     u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/update sal.png")));
	     u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
	     edit.add(u2);	     
	     
	     JMenuItem u3 = new JMenuItem("Take Attendance");
	     u3.setForeground(Color.RED);
	     u3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     u3.setMnemonic('T');
	     u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/attendance.PNG")));
	     u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
	     edit.add(u3);
	     
	     u1.addActionListener(this);
	     u2.addActionListener(this);
	     u3.addActionListener(this);
	     
	     JMenu rep = new JMenu("Reports");
	     rep.setForeground(Color.RED);
	     mb.add(rep);
	     
	     JMenuItem r1 = new JMenuItem("Generate PaySlip");
	     r1.setForeground(Color.RED);
	     r1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     r1.setMnemonic('G');
	     r1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/payslip.png")));
	     r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
	     rep.add(r1);
	     
	     JMenuItem r2 = new JMenuItem("Show Attendance");
	     r2.setForeground(Color.RED);
	     r2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     r2.setMnemonic('A');
	     r2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/show attendance.png")));
	     r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
	     rep.add(r2);
	     
	     r1.addActionListener(this);
	     r2.addActionListener(this);
	
	     JMenu util = new JMenu("Utilities");
	     util.setForeground(Color.RED);
	     mb.add(util);
	     
	     JMenuItem t1 = new JMenuItem("Notepad");
	     t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png")));
	     t1.setForeground(Color.RED);
	     t1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     t1.setMnemonic('O');
	     t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	     util.add(t1);
	     
	     JMenuItem t2 = new JMenuItem("Calculator");
	     t2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/calculator.png")));
	     t2.setForeground(Color.RED);
	     t2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     t2.setMnemonic('C');
	     t2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	     util.add(t2);
	     
	     JMenuItem t3 = new JMenuItem("Web Browser");
	     t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/browser.png")));
	     t3.setForeground(Color.RED);
	     t3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     t3.setMnemonic('W');
	     t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
	     util.add(t3);
	
	     t1.addActionListener(this);
	     t2.addActionListener(this);
	     t3.addActionListener(this);
	
	     JMenu m8 = new JMenu("Exit");
	     m8.setForeground(Color.RED);
	     mb.add(m8);
	     
	     JMenuItem e1 = new JMenuItem("Exit");
	     m8.add(e1);
	     e1.setForeground(Color.RED);
	     e1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
	     e1.setMnemonic('X');
	     e1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/exit.png")));
	     e1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
	     e1.addActionListener(this);

	}
 
	public void actionPerformed(ActionEvent ae){
	     String msg = ae.getActionCommand();
	   
	     if(msg.equals("New Employee"))
	         new NewEmployee().setVisible(true);
	     
	     else if(msg.equals("Salary"))
	         new salary().setVisible(true);
	     
	     else if(msg.equals("List Employees"))
	         new ListEmployees().setVisible(true);
	     
	     else if(msg.equals("Update Employee"))
	         new UpdateEmployee().setVisible(true);
	     
	     else if(msg.equals("Update Salary"))
	         new UpdateSalary().setVisible(true);
	     
	     else if(msg.equals("Take Attendance"))
	         new TakeAttendance().setVisible(true);
	     
	     else if(msg.equals("Generate PaySlip"))
	         new PaySlip().setVisible(true);
	     
	     else if(msg.equals("Show Attendance"))
	         new DisplayAttendance().setVisible(true);
	     
	     else if(msg.equals("Notepad")){
	         try{
	            Runtime.getRuntime().exec("notepad.exe");
	         }catch(Exception e){ }
	     }
	     
	     else if(msg.equals("Calculator")){
	         try{
	            Runtime.getRuntime().exec("calc.exe");
	         }catch(Exception e){ }
	     }
	     
	     else if(msg.equals("Web Browser")){
	         try{
	            Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	         }catch(Exception e){ }
	     }
	     
	     else if(msg.equals("Exit"))
	         System.exit(0);
	     
	     else
	    	 System.exit(0);
 	}
 
 	/*public static void main(String[] args){
 		new payrollpage().setVisible(true);
 	}*/
 
}
