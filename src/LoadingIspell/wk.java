package LoadingIspell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class wk {
public static void main(String[] args){
	try {
        // The newInstance() call is a work around for some
        // broken Java implementations
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	  DriverManager.registerDriver (new Driver()); 
	  
	  Connection conn = null;
	      conn = 
	         DriverManager.getConnection("jdbc:mysql://localhost/lik?" + 
	                                 "user=root&password=abcdefgh");
	      Statement stmt = conn.createStatement();
//	      stmt.executeUpdate("insert into bezokoliczniki(slowo) values('"+ slowo +"')");
	     
	      ResultSet rs = stmt.executeQuery("SELECT * " +
          "from slowa where slowo = 'z��k�ego'" );
	      int theInt=0;
	      String odmieniony = "";
	      while(rs.next()){
	          odmieniony = rs.getString("slowo");
	      }
	      System.out.println(odmieniony);
	}
	  catch (SQLException ex) {
	      // handle any errors
	      System.out.println("SQLException: " + ex.getMessage());
	      System.out.println("SQLState: " + ex.getSQLState());
	      System.out.println("VendorError: " + ex.getErrorCode());
	  }
}
}
