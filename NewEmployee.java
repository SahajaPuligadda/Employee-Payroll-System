// Creating new employee
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class NewEmployee extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    Choice c1;
    
    NewEmployee(){
        super("New Employee");
        
        setSize(500,400);
        setLocation(450,200);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1= new JPanel();
        p1.setBorder(new EmptyBorder(20, 20, 20, 20));
        p1.setBackground(Color.WHITE);
        p1.setLayout(new GridLayout(6,2,20,20)); // row, columns, row spacing, column spacing
        
        l1 = new JLabel("Name");
        t1 = new JTextField(20);
        p1.add(l1);
        p1.add(t1);
       
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("Other");
       
        l2 = new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);
        
        l3 = new JLabel("Address");
        t2 = new JTextField(50);
        p1.add(l3);
        p1.add(t2);
        
        l4 = new JLabel("Email");
        t3 = new JTextField(15);
        p1.add(l4);
        p1.add(t3); 
        
        l5 = new JLabel("Phone number");
        t4 = new JTextField(15);
        p1.add(l5);
        p1.add(t4);
        
        b1 =new JButton("Create");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);
       
        add(p1);
       
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
    	String msg = ae.getActionCommand();
    	
        String a = t1.getText();
        String b = c1.getSelectedItem();
        String c = t2.getText();
        String d = t3.getText();
        String e = t4.getText();
        String qry = "insert into employee values(null,'"+ a +"','"+ b +"','"+ c +"','"+ d +"','"+ e +"')";
       
        try{
        	if(msg.equals("Create")) {
	            connect c1 = new connect();
	            c1.s.executeUpdate(qry);
	            JOptionPane.showMessageDialog(null,"Employee Created Successfully!");
	            this.setVisible(false); 
        	}
        	else if(msg.equals("Cancel")) {
        		this.setVisible(false); 
        	}
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /*public static void main(String s[]){
        new NewEmployee().setVisible(true);
    }*/
    
}
    

