// Generate payslip of any employee
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class PaySlip extends JFrame implements ActionListener{
	Choice c1;
    JTextArea t1;
    JButton b1;

    PaySlip(){
        super("PaySlip of Employee");
        setSize(800,650);
        setLocation(300,50);
        
        c1 = new Choice();
        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c1.add(rs.getString("id"));
            }
        }catch(Exception e) { }
    
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        p1.add(new JLabel("Select Id"));
        p1.add(c1);
        add(p1,"North");
    
        t1 = new JTextArea(30,80);
        JScrollPane jsp = new JScrollPane(t1);
     
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        t1.setFont(f1);
        
        b1 = new JButton("Generate Pay Slip");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1,"South");
        add(jsp,"Center");
        b1.addActionListener(this);
    }
   
    public void actionPerformed(ActionEvent e) {
        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from employee where id=" + c1.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();
         
            rs = c.s.executeQuery("select * from salary where id=" + c1.getSelectedItem());
            double gross=0;
            double net=0;
 
            java.util.Date d1 = new java.util.Date();
            int month = d1.getMonth();
            t1.setText("         --------------------  PAY SLIP FOR THE MONTH OF " + month + ", 2021  --------------------         ");
            t1.append("\n");
  
            if(rs.next()){
                t1.append("\n            Employee ID         : " + rs.getString("id"));
                t1.append("\n            Employee Name   : " + name);
                t1.append("\n         ---------------------------------------------------------------------         ");

                double hra = rs.getDouble("hra");
                t1.append("\n            HRA                      : " + hra);
                double da  = rs.getDouble("da");
                t1.append("\n            DA                        : " + da);
                double med  = rs.getDouble("med");
                t1.append("\n            MEDICAL              : " + med);
                double pf  = rs.getDouble("pf");
                t1.append("\n            PF                         : " + pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra + da + med + pf + basic;
                net = gross - pf;
                t1.append("\n            BASIC SALARY     : " + basic);
                t1.append("\n         ---------------------------------------------------------------------         ");
 
                t1.append("\n            GROSS SALARY   : " + gross + "\n            NET SALARY        : " + net);
                t1.append("\n            Tax (5%)            : "+ (gross*5/100)); 
                t1.append("\n         ---------------------------------------------------------------------         ");
                t1.append("\n");
                t1.append("\n");    
                t1.append("\n");
                t1.append("            (  Signature  )   ");
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /*public static void main(String[] args){
        new PaySlip().setVisible(true);
    }*/
}
