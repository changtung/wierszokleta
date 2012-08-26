/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Projekt
 */
public class BazaWP {
    Connection conn;
/**
 * Łączymy z bazą danych, za pomocą jdbc, ustalamy w kodzie dane do polaczenia
 */
    public void polacz(String host,String dbname,String login,String pass){
        System.out.println("aaa");
        try {
        		      try {
		          // The newInstance() call is a work around for some
		          // broken Java implementations
		          Class.forName("com.mysql.jdbc.Driver").newInstance();
		      } catch (Exception ex) {
		          // handle the error
		    	  System.out.println(ex);
		      }
                                                  System.out.println("jdbc:mysql://"+host+"/"+dbname+"?" +"user="+login+"&password="+pass);

         conn = //TODO:change
                                     DriverManager.getConnection("jdbc:mysql://"+host+"/"+dbname+"?" +
			                                 "user="+login+"&password="+pass);
               //  DriverManager.getConnection("jdbc:mysql://localhost/zjn?" +
		//	                                 "user=root&password=");
        }
        catch ( Exception e){
            System.out.println(e);
        }
    }/**
     * 
     * @param prefix wp7
     * @param artykul content
     * @param post_title aaa bbb
     * @param post_name aaa-bbb
     */
    public void dodajArtykul(String prefix,String artykul,String post_title,String post_name){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
            
            String utc2Time = sdf.format(new Date());
            
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String utcTime = sdf.format(new Date());
            
            
            String insertQuery = "insert into "+prefix+"posts(post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count)"+
                    " values (1,'"+utc2Time+"','"+utcTime+"','"+artykul+"','"+post_title+"','','publish','open','open','','"+post_name+"','','','"+utcTime+"','"+utc2Time+"','',0,'',0,'post','',0)";
             try {
                Statement stmt = conn.createStatement();
                System.out.println("updatuje baze");
                 System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
            }
            catch ( Exception e ){
                System.out.println(e);
            }
        }
}
