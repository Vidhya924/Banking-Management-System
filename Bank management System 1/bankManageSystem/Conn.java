package bankManageSystem;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
public class Conn {
   // crt conn
	java.sql.Connection c;
	Statement s;
	public Conn() {
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);		
			 c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");    
	         s=c.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
