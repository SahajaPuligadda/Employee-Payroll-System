// connect java and mysql
import java.sql.*;

public class connect {
	public Connection c; // creates a session between java application and database
	public Statement s; // executes the queries
	
	public connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///payroll","root","");
			// DB name = payroll, user name = root, password
            s = c.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
