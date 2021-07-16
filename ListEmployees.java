// To list all employee details
import java.sql.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class ListEmployees extends JFrame implements ActionListener{
	JTable j1;
    JButton b1;
    String h[] = {"Emp id", "Name", "Gender", "Address", "Email", "Phone"};
    String d[][] = new String[20][6];  
    int i = 0, j = 0;
    
    ListEmployees(){
        super("Display Employees Details");
        
        setSize(1000,400);
        setLocation(200,200);

        try{
            String qry = "select * from employee";
            connect c1 = new connect();
            ResultSet rs = c1.s.executeQuery(qry);
            while(rs.next()){
                d[i][j++] = rs.getString("id");
                d[i][j++] = rs.getString("name");
                d[i][j++] = rs.getString("gender");
                d[i][j++] = rs.getString("address");
                d[i][j++] = rs.getString("email");
                d[i][j++] = rs.getString("phone");
                i++;
                j = 0;
            }
            
            j1=new JTable(d,h); // row, column - data (2D array), headings (1D array)
        }
        catch(Exception e){}
        
        b1 = new JButton("Print Employee details");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1,"South");
        
        JScrollPane s1 = new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){}
    }
     
    /*public static void main(String s[]){
        new ListEmployees().setVisible(true);
    }*/
    
}
