// Enter salary of an employee
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class salary extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Choice c2;
    
    salary(){
        super("Enter Salary of Employee");
       
        setLayout(new GridLayout(7,2,20,20));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));
        
        c2 = new Choice();
       
        try{
        	connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from employee");
      
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
            
        }catch(Exception e){ }
       
        add(new JLabel("Select Employee ID"));
        add(c2);
        
        l1 = new JLabel("HRA");
        t1 = new JTextField(15);
        add(l1);
        add(t1);
       
        l2 = new JLabel("DA");
        t2 = new JTextField(15);
        add(l2);
        add(t2);
        
        l3 = new JLabel("MEDICAL");
        t3 = new JTextField(15);
        add(l3);
        add(t3); 
       
        l4 = new JLabel("PF");
        t4 = new JTextField(15);
        add(l4);
        add(t4);
        
        l5 = new JLabel("BASIC");
        t5 = new JTextField(15);
        add(l5);
        add(t5);
       
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(500,400);
        setLocation(450,200);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
    	String msg = ae.getActionCommand();
    	
        String id = c2.getSelectedItem();
        String hra = t1.getText();
        String da = t2.getText();
        String med = t3.getText();
        String pf = t4.getText();
        String basic = t5.getText();
        String qry = "insert into salary values("+ id +","+ hra +","+ da +","+ med +","+ pf +","+ basic +")";
       
        try{
        	
        	if(msg.equals("Submit")) {
	            connect c1 = new connect();
	            c1.s.executeUpdate(qry);
	            JOptionPane.showMessageDialog(null,"Salary entered successfully!");
	            this.setVisible(false);
        	}
            else if(msg.equals("Cancel")) {
        		this.setVisible(false); 
        	}
        	
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /*public static void main(String[] args){
        new salary().setVisible(true);
    }*/
}
