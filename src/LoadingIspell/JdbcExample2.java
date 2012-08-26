package LoadingIspell;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Driver; 

public class JdbcExample2 {

  public static void main(String args[]) {
	  
      try {
          // The newInstance() call is a work around for some
          // broken Java implementations
          Class.forName("com.mysql.jdbc.Driver").newInstance();
      } catch (Exception ex) {
          // handle the error
    	  System.out.println(ex);
      }
//	  DriverManager.registerDriver (new Driver()); 
	  
	  Connection conn = null;
	  try {
	      conn = 
	         DriverManager.getConnection("jdbc:mysql://localhost/test?" + 
	                                     "user=root&password=abcdefgh");
	      Statement stmt = conn.createStatement();
	      //stmt.executeUpdate(
          //"create table test(id int , tekst varchar(30))");
	      //stmt.executeUpdate(
          //"insert into test values(7 ,'aaa')");

	      ResultSet rs = stmt.executeQuery("SELECT * " +
          "from test");
	      while(rs.next()){
	          int theInt= rs.getInt("id");
	          String str = rs.getString("tekst");
	          System.out.println("id= " + theInt
	                               + " tekst = " + str);
	        }//
	      // Do something with the Connection
	  } catch (SQLException ex) {
	      // handle any errors
	      System.out.println("SQLException: " + ex.getMessage());
	      System.out.println("SQLState: " + ex.getSQLState());
	      System.out.println("VendorError: " + ex.getErrorCode());
	  }
  }
}