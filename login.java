// login page - after main
import java.awt.*;
import java.awt.event.*; // event listener
import javax.swing.*;
import java.sql.*; // to check if name, password match in DB

public class login extends JFrame implements ActionListener{
    JLabel l1, l2; // name, password text
    JTextField t1; // entry for name
    JPasswordField t2; // entry for password
    JButton b1, b2; // login, cancel buttons
    
    login(){ // constructor
        super("Login Page"); // heading
        setLayout(new BorderLayout());
        
        t2 = new JPasswordField(15);
        t1 = new JTextField(15);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons\\login.jpg"));
	    // gets the image from disk
		Image im1 = ic1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		// adjusting the dimensions
		ImageIcon ic2 = new ImageIcon(im1); 
		// image cannot be directly added to frame, only imageicon is valid
		JLabel l = new JLabel(ic2);
        
        b1 = new JButton("Login");
        b2 = new JButton("Cancel");
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel p1, p2, p3, p4;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();

        add(l,BorderLayout.WEST);

        p2.add(new JLabel("Enter User Name:  "));
        p2.add(t1);
        p2.add(new JLabel("Enter Password: "));
        p2.add(t2);
        add(p2,BorderLayout.CENTER);

        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);

        setSize(500,300);
        setLocation(450,250);	
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    	String msg = ae.getActionCommand();
    	
        try{
        	if(msg.equals("Login")) {
	            connect c1 = new connect(); // connect class
	            String u = t1.getText(); // username
				String v = t2.getText(); // password
	            
	            String que = "select * from login where username ='" + u + "' and password ='" + v + "'";
	            
	            ResultSet rs = c1.s.executeQuery(que); // executes a query and stores the result
	            // s - statement, in connect class
	            
	            if(rs.next()){
	                new payrollpage().setVisible(true);
	                setVisible(false);
	            }
	            else{
	                JOptionPane.showMessageDialog(null, "Invalid login");
	                setVisible(false);
	            }
        	}
        	else if(msg.equals("Cancel")) {
        		this.setVisible(false); 
        	}
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /*public static void main(String[] args){
        new login();
    } */
    
}

