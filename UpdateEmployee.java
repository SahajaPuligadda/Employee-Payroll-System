// Update employee details
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener,ItemListener{
	JLabel l1,l2,l3,l4,l5,emp;
    JTextField t1,t3,t4,t5;
    JButton b1,b2;
    Choice c1,c2;
    
    UpdateEmployee(){
        super("Update Employee");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        c2 = new Choice();
        c2.setBounds(250,20,200,20);
       
        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from employee");
      
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
       
        emp = new JLabel("Select Employee ID");
        emp.setBounds(20,20,200,20);
        add(emp);
        add(c2);
        
        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        l1.setBounds(20,60,200,20);
        t1.setBounds(250,60,200,20);
        add(l1);
        add(t1);
       
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("Other");
        l2 = new JLabel("Gender");
        l2.setBounds(20,100,200,20);
        c1.setBounds(250,100,200,20);
        add(l2);
        add(c1);
        
        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        l3.setBounds(20,140,200,20);
        t3.setBounds(250,140,200,20);
        add(l3);
        add(t3);
        
        l4 = new JLabel("Email");
        t4 = new JTextField(15);
        l4.setBounds(20,180,200,20);
        t4.setBounds(250,180,200,20);
        add(l4);
        add(t4); 
        
        l5 = new JLabel("Phone");
        t5 = new JTextField(15);
        l5.setBounds(20,220,200,20);
        t5.setBounds(250,220,200,20);
        add(l5);
        add(t5);
        
        b1 = new JButton("Update");
        b2 = new JButton("Delete");
        
        b1.setBounds(20,270,200,40);
        b2.setBounds(250,270,200,40);
        add(b1);
        add(b2);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        c2.addItemListener(this);
        
        setSize(500,380);
        setLocation(450,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String n = t1.getText();
            String g = c1.getSelectedItem();
            String a = t3.getText();
            String e = t4.getText();
            String p = t5.getText();
            String qry = "update employee set name='" + n + "',gender='" + g + "',address='" + a + "',email='" + e + "',phone='" + p + "' where id=" + c2.getSelectedItem();
       
            try{
                connect c1 = new connect();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Employee Updated Successfully!");
                this.setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(ae.getSource() == b2){
            try{
                connect c1 = new connect();
                c1.s.executeUpdate("delete from employee where id=" + c2.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
                this.setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
            connect c1 = new connect();
            ResultSet rs = c1.s.executeQuery("select * from employee where id=" + c2.getSelectedItem());
            
            if(rs.next()){
                t1.setText(rs.getString("name"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("email"));
                t5.setText(rs.getString("phone"));
            }
        }catch(Exception ex){
           ex.printStackTrace();
        }
    }
    
    /*public static void main(String[] args){
        new UpdateEmployee().setVisible(true);
    }*/
}
