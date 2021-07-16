// Update salary of an employee
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateSalary extends JFrame implements ActionListener, ItemListener{
	JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Choice c2;
    
    UpdateSalary(){
    	super("Update Salary Details");
        setLayout(null);
        
        c2 = new Choice();
        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
       
        JLabel emp = new JLabel("Select Employee ID");
        emp.setBounds(20,20,200,20); // (x,y) coordinates, width, height
        add(emp);
        c2.setBounds(250,20,200,20);
        add(c2);
        
        l1 = new JLabel("HRA");
        t1 = new JTextField(15);
        l1.setBounds(20,60,200,20);
        t1.setBounds(250,60,200,20);
        add(l1);
        add(t1);
       
        l2 = new JLabel("DA");
        t2 = new JTextField(15);
        l2.setBounds(20,100,200,20);
        t2.setBounds(250,100,200,20);
        add(l2);
        add(t2);
       
        l3 = new JLabel("MEDICAL");
        t3 = new JTextField(15);
        l3.setBounds(20,140,200,20);
        t3.setBounds(250,140,200,20);
        add(l3);
        add(t3);
       
        l4 = new JLabel("PF");
        t4 = new JTextField(15);
        l4.setBounds(20,180,200,20);
        t4.setBounds(250,180,200,20);
        add(l4);
        add(t4); 
       
        l5 = new JLabel("BASIC");
        t5 = new JTextField(15);
        l5.setBounds(20,220,200,20);
        t5.setBounds(250,220,200,20);
        add(l5);
        add(t5);
       
        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(20,280,200,40);
        b2.setBounds(250,280,200,40);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        c2.addItemListener(this);
        
        setSize(500,380);
        setLocation(450,200);
        getContentPane().setBackground(Color.WHITE);
    }
    
    // salary update or delete in database
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
        	String id = c2.getSelectedItem();
            String hra = t1.getText();
            String da = t2.getText();
            String med = t3.getText();
            String pf = t4.getText();
            String basic = t5.getText();
      
            String qry = "update salary set hra=" + hra + ",da=" + da + ",med=" + med + ",pf=" + pf + ",basic_salary=" + basic + "  where id=" + id;
       
            try{
                connect c1 = new connect();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Salary Updated Successfully!");
                this.setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(ae.getSource() == b2){
            try{
                connect c1 = new connect();
                c1.s.executeUpdate("delete from salary where id=" + c2.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Salary Deleted Successfully!");
                this.setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    // display previously stored salary details
    public void itemStateChanged(ItemEvent ie){
        try{
           connect c1 = new connect();
            ResultSet rs = c1.s.executeQuery("select * from salary where id=" + c2.getSelectedItem());
            if(rs.next()){
                t1.setText(rs.getString("hra"));
                t2.setText(rs.getString("da"));
                t3.setText(rs.getString("med"));
                t4.setText(rs.getString("pf"));
                t5.setText(rs.getString("basic_salary"));
         
            }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    /*public static void main(String[] args){
        new UpdateSalary().setVisible(true);
    }*/
}
