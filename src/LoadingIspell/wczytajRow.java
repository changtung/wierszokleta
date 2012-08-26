package LoadingIspell;

import Config.Translacja;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class wczytajRow {
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private DataInputStream dis; 
	private String fn = "A";
	private String sciezka = "C:\\Documents and Settings\\pacior\\workspace\\dbCon\\ispell-pl\\";
	private char className;
	wczytajRow(){
	}
	public void wczytujSlowa(){
		try {
			file = new File(sciezka + fn);
		    fis = null;
		    bis = null;
		    dis = null;
		      fis = new FileInputStream(file);

		      // Here BufferedInputStream is added for fast reading.
		      bis = new BufferedInputStream(fis);
		      dis = new DataInputStream(bis);

		      // dis.available() returns 0 if the file does not have more lines.
		      String linia;
		      try {
		          // The newInstance() call is a work around for some
		          // broken Java implementations
		          Class.forName("com.mysql.jdbc.Driver").newInstance();
		      } catch (Exception ex) {
		          // handle the error
		    	  System.out.println(ex);
		      }
//			  DriverManager.registerDriver (new Driver()); 
			  
			  Connection conn = null;
			      conn = 
			         DriverManager.getConnection("jdbc:mysql://localhost/lik?" + 
			                                 "user=root&password=abcdefgh");
			      String tekst = "";
			      int i = 0;
			      byte ba[] = new byte[1024];
			      int bytesRead = 0;
			      String s;
			      String[] linie;
		      while (bytesRead != -1) {

		      // this statement reads the line from the file and print it to
		        // the console.
		    	  ba = new byte[1024];
				     bytesRead = dis.read( ba, 0 /* offset in ba */, ba.length /* bytes to read */ );
				     if ( bytesRead == -1)
				    	 break;
				     String encodingName = "ISO-8859-2";
				     s = new String ( ba, encodingName );
				     System.out.println(s);
				     tekst += s;
				    	 }
		      linie = podzielNaLinie(tekst);
		      for (int x=0; x<linie.length; x++){
		    	  System.out.println(linie[x]);
		    	  przetworz(linie[x],conn);
		      }
		      // dispose all the resources after using them.
		      fis.close();
		      bis.close();
		      dis.close();

		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
			  catch (SQLException ex) {
			      // handle any errors
			      System.out.println("SQLException: " + ex.getMessage());
			      System.out.println("SQLState: " + ex.getSQLState());
			      System.out.println("VendorError: " + ex.getErrorCode());
			  }
			  //B
			  try {
					file = new File(sciezka + "B");
				    fis = null;
				    bis = null;
				    dis = null;
				      fis = new FileInputStream(file);

				      // Here BufferedInputStream is added for fast reading.
				      bis = new BufferedInputStream(fis);
				      dis = new DataInputStream(bis);

				      // dis.available() returns 0 if the file does not have more lines.
				      String linia;
				      try {
				          // The newInstance() call is a work around for some
				          // broken Java implementations
				          Class.forName("com.mysql.jdbc.Driver").newInstance();
				      } catch (Exception ex) {
				          // handle the error
				    	  System.out.println(ex);
				      }
//					  DriverManager.registerDriver (new Driver()); 
					  
					  Connection conn = null;
					      conn = 
					         DriverManager.getConnection("jdbc:mysql://localhost/lik?" + 
					                                 "user=root&password=abcdefgh");
					      String tekst = "";
					      int i = 0;
					      byte ba[] = new byte[1024];
					      int bytesRead = 0;
					      String s;
					      String[] linie;
				      while (bytesRead != -1) {

				      // this statement reads the line from the file and print it to
				        // the console.
				    	  ba = new byte[1024];
						     bytesRead = dis.read( ba, 0 /* offset in ba */, ba.length /* bytes to read */ );
						     if ( bytesRead == -1)
						    	 break;
						     String encodingName = "ISO-8859-2";
						     s = new String ( ba, encodingName );
						     System.out.println(s);
						     tekst += s;
						    	 }
				      linie = podzielNaLinie(tekst);
				      for (int x=0; x<linie.length; x++){
				    	  System.out.println(linie[x]);
				    	  przetworz(linie[x],conn);
				      }
				      // dispose all the resources after using them.
				      fis.close();
				      bis.close();
				      dis.close();

				    } catch (FileNotFoundException e) {
				      e.printStackTrace();
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
					  catch (SQLException ex) {
					      // handle any errors
					      System.out.println("SQLException: " + ex.getMessage());
					      System.out.println("SQLState: " + ex.getSQLState());
					      System.out.println("VendorError: " + ex.getErrorCode());
					  }
					  //C
					  try {
							file = new File(sciezka + "C");
						    fis = null;
						    bis = null;
						    dis = null;
						      fis = new FileInputStream(file);

						      // Here BufferedInputStream is added for fast reading.
						      bis = new BufferedInputStream(fis);
						      dis = new DataInputStream(bis);

						      // dis.available() returns 0 if the file does not have more lines.
						      String linia;
						      try {
						          // The newInstance() call is a work around for some
						          // broken Java implementations
						          Class.forName("com.mysql.jdbc.Driver").newInstance();
						      } catch (Exception ex) {
						          // handle the error
						    	  System.out.println(ex);
						      }
//							  DriverManager.registerDriver (new Driver()); 
							  
							  Connection conn = null;
							      conn = 
							         DriverManager.getConnection("jdbc:mysql://localhost/lik?" + 
							                                 "user=root&password=abcdefgh");
							      String tekst = "";
							      int i = 0;
							      byte ba[] = new byte[1024];
							      int bytesRead = 0;
							      String s;
							      String[] linie;
						      while (bytesRead != -1) {

						      // this statement reads the line from the file and print it to
						        // the console.
						    	  ba = new byte[1024];
								     bytesRead = dis.read( ba, 0 /* offset in ba */, ba.length /* bytes to read */ );
								     if ( bytesRead == -1)
								    	 break;
								     String encodingName = "ISO-8859-2";
								     s = new String ( ba, encodingName );
								     System.out.println(s);
								     tekst += s;
								    	 }
						      linie = podzielNaLinie(tekst);
						      for (int x=0; x<linie.length; x++){
						    	  System.out.println(linie[x]);
						    	  przetworz(linie[x],conn);
						      }
						      // dispose all the resources after using them.
						      fis.close();
						      bis.close();
						      dis.close();

						    } catch (FileNotFoundException e) {
						      e.printStackTrace();
						    } catch (IOException e) {
						      e.printStackTrace();
						    }
							  catch (SQLException ex) {
							      // handle any errors
							      System.out.println("SQLException: " + ex.getMessage());
							      System.out.println("SQLState: " + ex.getSQLState());
							      System.out.println("VendorError: " + ex.getErrorCode());
							  }
	}

	private String[] podzielNaLinie(String s){
	     String[] result = s.split("\\n");
	     return result;
	}
	public void przetworz(String linia,Connection conn)throws SQLException{
        Pattern p = Pattern.compile("/");
        // Split input with the pattern
        String[] result = 
                 p.split(linia);
        if ( result.length == 1 )
        	//nie ma flagi i statow
        {
        	przetworzBezFlag(result[0],conn);
        }
        else {//jest flaga i staty
        	//przetworzFlageIStaty(result[0],result[1],conn);
        }
	}
	/**
	 *  robi co trzeba z pobranymi danymi, doda do bazy, podzieli..
	 * @param slowo szukane slowo
	 * @param fs flagi i staty
	 */
	private void przetworzFlageIStaty(String slowo,String fs,Connection conn)throws SQLException{
//		System.out.println("pflageIStety:"+fs);
		boolean b = false;
		for ( int i = 0 ; i < fs.length() ; i++)
			if ( fs.charAt(i) == this.className ) 
				b = true;
		if ( b == true )
		{
			int liczba = dajLiczbe(fs);
			dodajSlowo(slowo,liczba,conn);
		}
	}
	private void przetworzBezFlag(String s,Connection conn)throws SQLException{
        Pattern p = Pattern.compile("\\s");
        // Split input with the pattern
        //zostawienie interesujacych nas liter
        String[] result = 
                 p.split(s);
        int liczba = Integer.parseInt(result[1]);
        String row = result[0];
        //System.out.println("rown.:"+row+"l:"+ liczba);
        dodajRownowaznik(row,liczba,conn);
        
		
	}
	private void dodajRownowaznik(String slowo,int liczba,Connection conn) throws SQLException{
		  Translacja t = new Translacja();
	      Statement stmt = conn.createStatement();
	      stmt.executeUpdate("insert into bezokoliczniki(slowo) values('"+ t.javaBaza(slowo) +"')");
	      /*ResultSet rs = stmt.executeQuery("SELECT * " +
          "from rownowazniki where slowo = '" + t.javaBaza(slowo) + "'" );
	      int theInt=0;
	      String odmieniony;
	      while(rs.next()){
	          theInt = rs.getInt("id");
	      }
	      stmt.executeUpdate(
		          "insert into rown_czestosci values("+theInt+","+liczba+")");*/
	}
	private void dodajSlowo(String slowo,int liczba,Connection conn) throws SQLException{
			  Translacja t = new Translacja();
		      Statement stmt = conn.createStatement();
		      stmt.executeUpdate("insert into bezokoliczniki(slowo) values('"+ t.javaBaza(slowo) +"')");
		      ResultSet rs = stmt.executeQuery("SELECT * " +
	          "from bezokoliczniki where slowo = '" + t.javaBaza(slowo) + "'" );
		      int theInt=0;
		      String odmieniony;
		      while(rs.next()){
		          theInt = rs.getInt("id");
		      }
		      //tylko dla duzych liter
		      String duzeNazwaPl = String.valueOf(this.className);
		      duzeNazwaPl.toUpperCase();
		      duzeNazwaPl += ".txt";
		      DD flaga = new DD(duzeNazwaPl);
		      //
		      stmt.executeUpdate(
			          "insert into ispell_czestosci values("+theInt+","+liczba+")");
		      ArrayList l = flaga.odmienSlowo(slowo);
		      for ( int i = 0 ; i < l.size() ; i++){
		    //	  System.out.println((String)l.get(i));
		      stmt.executeUpdate(
			          "insert into slowa(slowo,flaga,numer,idBezokolicznika) values('"+t.javaBaza( (String)l.get(i) ) +"','" + this.className + "',"+i+","+theInt+")" );
		      }
	}
	/**
	 * daje liczbe czestosci jaka wystepuje
	 * @param slowo flagi i cyfry
	 * @return liczba czestosci
	 */
	private int dajLiczbe(String slowo){
        Pattern p = Pattern.compile("\\s");
        // Split input with the pattern
        //zostawienie interesujacych nas liter
        String[] result = 
                 p.split(slowo);
        return Integer.parseInt(result[1]);
	}
	/**
	 * sprawdza czy dana flaga jest w tekscie
	 * @param tekst pozadany tekst, pozadany jest jako ciag flag(tak powinno byc gdzies indziej w programie)
	 * @param f flaga ktora zostanie poddana sprawdzeniu 
	 * @return true jesli flaga jest false w p.p.
	 */
	public boolean czyJestFlaga(String tekst,String f){
		Pattern patt = Pattern.compile(".*"+f+".*");
		  Matcher m = patt.matcher(tekst);
		  return m.matches();
	}
	public static void main(String[] args){
		
		/*wczytajSl w = new wczytajSl('a');
		w.wczytujSlowa();
		w = new wczytajSl('b');
		w.wczytujSlowa();
		w = new wczytajSl('c');
		w.wczytujSlowa();
		w = new wczytajSl('d');
		w.wczytujSlowa();
		w = new wczytajSl('e');
		w.wczytujSlowa();
		w = new wczytajSl('f');
		w.wczytujSlowa();
		w = new wczytajSl('g');
		w.wczytujSlowa();
		w = new wczytajSl('h');
		w.wczytujSlowa();
		w = new wczytajSl('i');
		w.wczytujSlowa();
		w = new wczytajSl('j');
		w.wczytujSlowa();
		w = new wczytajSl('k');
		w.wczytujSlowa();
		w = new wczytajSl('l');
		w.wczytujSlowa();
		w = new wczytajSl('m');
		w.wczytujSlowa();
		w = new wczytajSl('n');
		w.wczytujSlowa();
		w = new wczytajSl('o');
		w.wczytujSlowa();
		w = new wczytajSl('p');
		w.wczytujSlowa();
		w = new wczytajSl('q');
		w.wczytujSlowa();
		w = new wczytajSl('r');
		w.wczytujSlowa();
		w = new wczytajSl('s');
		w.wczytujSlowa();
		w = new wczytajSl('t');
		w.wczytujSlowa();
		w = new wczytajSl('u');
		w.wczytujSlowa();
		w = new wczytajSl('v');
		w.wczytujSlowa();
		w = new wczytajSl('w');
		w.wczytujSlowa();
		*/
		/*wczytajSl w = new wczytajSl('X');
		w.wczytujSlowa();
		*/
		wczytajRow w = new wczytajRow();
		w.wczytujSlowa();
		
		//System.out.println( w.dajLiczbe("OTSqK 97") );
		//System.out.println(w.czyJestFlaga("jFBIa	756","F"));
		}
}
