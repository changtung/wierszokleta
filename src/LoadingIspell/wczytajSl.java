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
/**
 * Klasa odpowiada za wczytywanie slow ze slownika tekstowego do bazy danych mysql. Dziala poprzez interfejs jdbc i wczytywanie trwa jakis czas.
 * @author Grzegorz Patynek
 */
public class wczytajSl {
        public String dbConnection = "jdbc:mysql://localhost/zjn?user=root&password=";
        boolean duza = false;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private DataInputStream dis; 
	public String fn = "C";//klasa i 23-04-2011
	private String sciezka = "/ispell-pl/";//sciezka do plikow ispella
	private char className;
        public void init(){
            try {
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
			         DriverManager.getConnection(this.dbConnection);
                          Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
                      stmt.executeUpdate("drop table IF EXISTS ispell_czestosci");
                      stmt.executeUpdate("drop table IF EXISTS ogolny_sens");
                      stmt.executeUpdate("drop table IF EXISTS slowa");
                      stmt.executeUpdate("drop table IF EXISTS bezokoliczniki");
                      stmt.executeUpdate("drop table IF EXISTS sensy");
		      stmt.executeUpdate("CREATE TABLE bezokoliczniki(id int not null AUTO_INCREMENT,slowo varchar(100), Primary Key (id) );");
                      stmt.executeUpdate("CREATE TABLE slowa(id int NOT NULL AUTO_INCREMENT,slowo varchar(100),flaga varchar(5),numer int,idBezokolicznika int, Primary Key (id) , foreign key (idBezokolicznika) references bezokoliczniki(id))");
                      stmt.executeUpdate("CREATE TABLE ispell_czestosci(idRdzenia int,czestosc int, Foreign Key (idRdzenia) references bezokoliczniki(id))");
                      System.out.println("updated");
                      stmt.executeUpdate("CREATE TABLE sensy(id int NOT NULL AUTO_INCREMENT, wartosc varchar(100),primary key(id) )");
                      stmt.executeUpdate("CREATE TABLE ogolny_sens(id int NOT NULL AUTO_INCREMENT, idSlowa int, idSensu int, Primary Key (id),Foreign Key (idSlowa) references slowa(id),Foreign Key (idSensu) references sensy(id))");
            }
            catch ( Exception e ){
                System.out.println(e);
            }
        }
	wczytajSl(char g,boolean duza,String path,String flag,String db){
                this.fn = flag;
                this.dbConnection = db;
                this.sciezka = path + this.sciezka;
                this.duza = duza;
		this.className = g;
	}
        wczytajSl(char g,String path,String flag,String db){
            this.fn = flag;
            this.dbConnection = db;
            this.sciezka = path+this.sciezka;
		this.className = g;
	}
	public void wczytujSlowa(){
                System.out.println("this.className:"+this.className);
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
			         DriverManager.getConnection(this.dbConnection);
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
				     //System.out.println(s);
				     tekst += s;
				    	 }
		      linie = podzielNaLinie(tekst);
		      for (int x=0; x<linie.length; x++){
		    	  //System.out.println(linie[x]);
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
        	przetworzBezFlag(result[0]);
        }
        else {//jest flaga i staty
        	przetworzFlageIStaty(result[0],result[1],conn);
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
	private void przetworzBezFlag(String s){
	}
	private void dodajSlowo(String slowo,int liczba,Connection conn) throws SQLException{
			  Translacja t = new Translacja();
		      Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery("SELECT * " +
	          "from bezokoliczniki where slowo = '" + t.javaBaza(slowo) + "'" );
		      int theInt=0;
		      String odmieniony;
		      if(rs.next()){
		          theInt = rs.getInt("id");
		      }
                      else {
                          stmt.executeUpdate("insert into bezokoliczniki(slowo) values('"+ t.javaBaza(slowo) +"')");
                          rs = stmt.executeQuery("SELECT * " +
	          "from bezokoliczniki where slowo = '" + t.javaBaza(slowo) + "'" );
		       theInt=0;
		      if(rs.next()){
		          theInt = rs.getInt("id");
		      }
                      }
		      //tylko dla duzych liter
                      //jak duza to jedno a jak mala to drugie
                      String duzeNazwaPl = String.valueOf(this.className);;
                      if ( duza == true ){
                            duzeNazwaPl.toUpperCase();
                            duzeNazwaPl += ".txt";
                      }
		      //
                      else{
                        duzeNazwaPl += "_.txt";
                        }
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
                 *
                
		wczytajSl w = new wczytajSl('i');
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

		w = new wczytajSl('x');
		w.wczytujSlowa();
		w = new wczytajSl('y');
		w.wczytujSlowa();
		w = new wczytajSl('z');
		w.wczytujSlowa();

                //duze
                w = new wczytajSl('A',true);
		w.wczytujSlowa();
		w = new wczytajSl('B',true);
		w.wczytujSlowa();
		w = new wczytajSl('C',true);
		w.wczytujSlowa();
		w = new wczytajSl('D',true);
		w.wczytujSlowa();
		w = new wczytajSl('E',true);
		w.wczytujSlowa();
		w = new wczytajSl('F',true);
		w.wczytujSlowa();
		w = new wczytajSl('G',true);
		w.wczytujSlowa();
		w = new wczytajSl('H',true);
		w.wczytujSlowa();
		w = new wczytajSl('I',true);
		w.wczytujSlowa();
		w = new wczytajSl('J',true);
		w.wczytujSlowa();
		w = new wczytajSl('K',true);
		w.wczytujSlowa();
		w = new wczytajSl('L',true);
		w.wczytujSlowa();
		w = new wczytajSl('M',true);
		w.wczytujSlowa();
		w = new wczytajSl('N',true);
		w.wczytujSlowa();
		w = new wczytajSl('O',true);
		w.wczytujSlowa();
		w = new wczytajSl('P',true);
		w.wczytujSlowa();
		w = new wczytajSl('Q',true);
		w.wczytujSlowa();
		w = new wczytajSl('R',true);
		w.wczytujSlowa();
		w = new wczytajSl('S',true);
		w.wczytujSlowa();
		w = new wczytajSl('T',true);
		w.wczytujSlowa();
		w = new wczytajSl('U',true);
		w.wczytujSlowa();
		w = new wczytajSl('V',true);
		w.wczytujSlowa();

		w = new wczytajSl('W',true);
		w.wczytujSlowa();
		w = new wczytajSl('X',true);
		w.wczytujSlowa();
		w = new wczytajSl('Y',true);
		w.wczytujSlowa();
		w = new wczytajSl('Z',true);
		w.wczytujSlowa(); */
		//System.out.println( w.dajLiczbe("OTSqK 97") );
		//System.out.println(w.czyJestFlaga("jFBIa	756","F"));
		}
}
