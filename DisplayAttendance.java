// Display attendance of employees
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayAttendance extends JFrame implements ActionListener{
	JTable j1;
    JButton b1;
    String h[] = {"Employee ID","Date-Time","First Half","Second Half"};
    String d[][] = new String[15][4];  
    int i=0,j=0;
    
    DisplayAttendance(){
        super("Display Employees Attendance");
        setSize(700,300);
        setLocation(350,250);

        try{
            String q = "select * from attendence";
            connect c1 = new connect();
            ResultSet rs = c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++] = rs.getString("id");
                d[i][j++] = rs.getString("time");
                d[i][j++] = rs.getString("fir_half");
                d[i][j++] = rs.getString("sec_half");
                i++;
                j=0;
            }
            j1=new JTable(d,h);
        }catch(Exception e){}
        
        b1=new JButton("Print Attendance");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1,"South");
        
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    /*public static void main(String[] args){
        new DisplayAttendance().setVisible(true);
    }*/
}
