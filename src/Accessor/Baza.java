/*
 * Generator Wiersza
 * Poniższy kod źródłowy, udostępniony jest na licencji GNU
 * text licencji: http://gnu.org.pl/text/licencja-gnu.html
 *
 * @author Grzegorz Patynek
 * contact: grzegorz@patynek.pl
 */

package Accessor;

import Config.Translacja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import prolog.util.Gram;
import prolog.util.SlowoGram;

public class Baza {
Connection conn;
/**
 * Łączymy z bazą danych, za pomocą jdbc, ustalamy w kodzie dane do polaczenia
 */
    public void polacz(){
        try {
        		      try {
		          // The newInstance() call is a work around for some
		          // broken Java implementations
		          Class.forName("com.mysql.jdbc.Driver").newInstance();
		      } catch (Exception ex) {
		          // handle the error
		    	  System.out.println(ex);
		      }
         conn = //TODO:change
                                     DriverManager.getConnection("jdbc:mysql://localhost/ispell?" +
			                                 "user=root&password=");
               //  DriverManager.getConnection("jdbc:mysql://localhost/zjn?" +
		//	                                 "user=root&password=");
        }
        catch ( Exception e){
            System.out.println(e);
        }
    }
    /**
     * lematyzacja slowa i zwracamy slowo i identyfikator w bazie
     * @param slowo
     * @return 
     */
    public Slowo executeLematyzuj(String slowo){
                Translacja t = new Translacja();
        String slowobaza = t.javaBaza(slowo);
        String query = "select bezokoliczniki.slowo,bezokoliczniki.id from bezokoliczniki inner join slowa on slowa.idBezokolicznika = bezokoliczniki.id where slowa.slowo = '"+slowobaza+"'";
        int id = 0;
        String sl = "";
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      if(rs.next()){
		          id = rs.getInt("id");
                          sl = rs.getString("slowo");
		      }
 else {
                          return null;
 }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
        Slowo s = new Slowo(t.bazaJava(sl),id);
        return s;
    }
     public String dongramow(){
                Translacja t = new Translacja();
        String query = "select slowo,flaga,numer from slowa group by flaga,numer ORDER BY rand()";
        
        String slowo = "";
        String flaga = "";
        String numer = "";
        String zdanie = "";
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
                      
		      while (rs.next() ){
		          slowo = t.bazaJava(rs.getString("slowo"));
                          flaga = rs.getString("flaga");
                          numer = String.valueOf(rs.getInt("numer"));
                          zdanie += slowo+"{"+flaga+"-"+numer+"} ";
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
        return zdanie;
    }
    /**
     * lematyzujemy slowo i zwracamy wartosc gramatyczna slowa
     * @param slowo slowo do zlematyzowania
     * @return obiekt posiadajacy kolejnosc slowa oraz wartosc flagi oraz bezokolicznik
     */
     public SlowoGram executeLematyzujGram(String slowo){
                Translacja t = new Translacja();
        String slowobaza = t.javaBaza(slowo);
        String query = "select bezokoliczniki.slowo as b,slowa.flaga, slowa.numer, slowa.slowo as s from bezokoliczniki inner join slowa on slowa.idBezokolicznika = bezokoliczniki.id where slowa.slowo = '"+slowobaza+"'";
        String bezok = "";
        String sl = "";
        int numer =0;
        String flaga = "";
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      if(rs.next()){
		          bezok = rs.getString("b");
                          sl = rs.getString("s");
                          numer = rs.getInt("numer");
                          flaga = rs.getString("flaga");
		      }
                       else {
                                  query = "select bezokoliczniki.slowo from bezokoliczniki where bezokoliczniki.slowo = '"+slowobaza+"'";
                                  stmt = conn.createStatement();
		      rs = stmt.executeQuery(query);
		      if(rs.next()){
		          bezok = rs.getString("slowo");
                          sl = bezok;
                          numer = 0;
                          flaga = "MS";
		      }
                       else
                          return null;
 }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
        SlowoGram res = new SlowoGram(t.bazaJava(sl),flaga,numer,t.bazaJava(bezok));
        return res;
    }
     /**
      * zapisuje liste SlowoGram, zlematyzowanych slow, przypisujac identyfikator bezokolicznika danego slowa dla tematu
      * calosc przypisana jest w pewnej tabeli w bazie, gdzie przypisujemy zbiorowi slow odpowiedni temat
      * @param l
      * @param temat 
      */
     public void zapiszBezok(List<SlowoGram> l, String temat){
                         Translacja t = new Translacja();
        String query = "";
        String insertQuery = "";
        String slowobaza = "";
        SlowoGram s = null;
        Iterator it = l.iterator();
        while ( it.hasNext() ){
            s = (SlowoGram)it.next();
            slowobaza = t.javaBaza(s.wartosc);
            query = "select bezokoliczniki.id from bezokoliczniki inner join slowa on slowa.idBezokolicznika = bezokoliczniki.id where slowa.slowo = '"+slowobaza+"'";
            int ids =0;
            try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          ResultSet rs = stmt.executeQuery(query);
                          if(rs.next()){
                              ids = rs.getInt("id");
                          }
                           else {
                          //nie znalazlo tego slowa??
                              System.out.println("error");
                          }
            }
            catch ( Exception e ){
                System.out.println(e);
            }
            insertQuery = "insert into slowatemat(temat,idBezok) values ( '"+temat+"', "+ids+")";
             try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          stmt.executeUpdate(insertQuery);
            }
            catch ( Exception e ){
                System.out.println(e);
            }
        }
         System.out.println("zapisano slowa w bazie");
     }
     /**
      * 
      * @param lista lista odpowiednich gramatyk dla ktorych wczytujemy
      * @return lista slow i gramatyk dla wszystkich form gramatycznych z listy lista i to sa wszystkie slowa z bazy
      */
      public List<SlowoGram> odczytTemat(List<Gram> lista){//TODO:poprawic tak zeby wczytywal faktycznie dana flage i kilka slow z tej flagi ( z kazdej)
          Translacja t = new Translacja();
          List<SlowoGram> res = new ArrayList();
          Iterator it = lista.iterator();
          Gram tmp = null;
          String query = "select slowa.slowo as sl from slowa where slowa.flaga = ";
          SlowoGram sg = null;
          while ( it.hasNext() )
          {
              tmp = (Gram)it.next();
              query = "select slowa.slowo as sl from slowa where slowa.flaga = '"+tmp.getFlaga()+"' and slowa.numer = "+tmp.getKolejnosc();
                                  try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          ResultSet rs = stmt.executeQuery(query);
                          while (rs.next()){
                              String sl = rs.getString("sl");
                              sg = new SlowoGram(t.bazaJava(sl), tmp.getFlaga(), tmp.getKolejnosc(), "");
                              res.add(sg);
                              
                          }
            }
            catch ( Exception e ){
                System.out.println(e);
            }
          }
          return res;

     }
     public List<SlowoGram> odczytTematGineko(List<Gram> lista){
         String tfl = "";
         int tn = 0;
         Gram g = null;
         Translacja t = new Translacja();
        List idy = this.odczytIdowGineko();
        List<SlowoGram> res = new ArrayList();
        int idbez;
        SlowoGram sg = null;
        Iterator it = idy.iterator();
        String query = "select slowa.slowo as sl, slowa.flaga, slowa.numer from slowa where slowa.idBezokolicznika = ";
        String query2 = "";
        String query3 = "";
        while ( it.hasNext() ){
            idbez = (Integer)it.next();
            query2 = query + idbez;
                    try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          ResultSet rs = stmt.executeQuery(query2);
                          while (rs.next()){
                              tfl = rs.getString("flaga");
                              tn = rs.getInt("numer");
                              g = new Gram(tn,tfl);
                              if ( lista.contains(g))
                              {
                                  sg = new SlowoGram(t.bazaJava(rs.getString("sl")), tfl, tn, "");
                                  res.add(sg);
                              }
                          }
            }
            catch ( Exception e ){
                System.out.println(e);
            }
            /*query3 = "select slowo from bezokoliczniki where id = " + idbez;
                                try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          ResultSet rs = stmt.executeQuery(query3);
                          if (rs.next()){
                              sg = new SlowoGram(t.bazaJava(rs.getString("slowo")),"MS",0,"");
                              res.add(sg);
                          }
            }
            catch ( Exception e ){
                System.out.println(e);
            }
            */
         }

        return res;
     }
      /**
       * 
       * @param temat dany temat w bazie
       * @param lista lista gramatyczna, wszystkich mozliwych gramatyk i odmian
       * @return  lista SlowoGram slow o danym temacie
       */
     public List<SlowoGram> odczytTemat(String temat,List<Gram> lista){
         String tfl = "";
         int tn = 0;
         Gram g = null;
         Translacja t = new Translacja();
        List idy = this.odczytIdow(temat);
        Collections.shuffle(idy);
        List<SlowoGram> res = new ArrayList();
        int idbez;
        SlowoGram sg = null;
        Iterator it = idy.iterator();
        String query = "select slowa.slowo as sl, slowa.flaga, slowa.numer from slowa where slowa.idBezokolicznika = ";
        String query2 = "";
        String query3 = "";
        int counter = 0;
        while ( it.hasNext() ){
            counter++;
            if ( counter == 10000 ) 
                break;
            idbez = (Integer)it.next();
            query2 = query + idbez;
                    try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          ResultSet rs = stmt.executeQuery(query2);
                          while (rs.next()){
                              tfl = rs.getString("flaga");
                              tn = rs.getInt("numer");
                              g = new Gram(tn,tfl);
                              if ( lista.contains(g))
                              {
                                  sg = new SlowoGram(t.bazaJava(rs.getString("sl")), tfl, tn, "");
                                  res.add(sg);
                              }
                          }
            }
            catch ( Exception e ){
                System.out.println(e);
            }
            /*query3 = "select slowo from bezokoliczniki where id = " + idbez;
                                try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          ResultSet rs = stmt.executeQuery(query3);
                          if (rs.next()){
                              sg = new SlowoGram(t.bazaJava(rs.getString("slowo")),"MS",0,"");
                              res.add(sg);
                          }
            }
            catch ( Exception e ){
                System.out.println(e);
            }
            */
         }

        return res;
     }
       /**
      * odczytuje idy bezokolicznikow z tabeli slowatemat
      * @param id
      * @return
      */
     public List odczytIdowGineko(){
                 String query1 = "select idBezok from slowatemat where idBezok != 0";
                 System.out.println(query1);
        //select slowa.slowo, slowa.flaga from slowa where slowa.idBezokolicznika in (  )
        int idbezok = 0;
        List bezok = new ArrayList();
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query1);
		      while(rs.next()){
		          idbezok = rs.getInt("idBezok");
                           bezok.add(idbezok);
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
        return bezok;
     }
     /**
      * odczytuje idy bezokolicznikow z tabeli slowatemat
      * @param id
      * @return
      */
     public List odczytIdow(String temat){
                 String query1 = "select idBezok from slowatemat where temat = '"+temat+"'";
                 System.out.println(query1);
        //select slowa.slowo, slowa.flaga from slowa where slowa.idBezokolicznika in (  )
        int idbezok = 0;
        List bezok = new ArrayList();
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query1);
		      while(rs.next()){
		          idbezok = rs.getInt("idBezok");
                           bezok.add(idbezok);
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
        return bezok;
     }
     /**
      * czy temat jest wolny
      * @param temat
      * @return  true jesli nie jest zajety
      */
     public boolean isTematFree(String temat){

             String query = "select count(temat) as c from slowatemat where slowatemat.temat = '"+temat+"'";
       int count = 0;
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      if(rs.next()){
		          count = rs.getInt("c");
		      }

        }
        catch ( Exception e ){
            System.out.println(e);
        }
        if ( count > 0 )
            return false;
        else
            return true;
    }
     public String dajPrzyklad(List<SlowoGram> in){
         String res = "";
         for ( int i = 0 ; i < in.size() ; i++)
             res += this.dajSlowo(in.get(i))+" ";
         return res;
     }
     /**
      * zwraca pierwsze slowo z bazy o podobnej strukturze do parametru
      * @param sg
      * @return 
      */
     private String dajSlowo(SlowoGram sg){
        String query = "select slowo as s from slowa where slowa.flaga = '"+sg.getFlaga()+"' and numer = " + sg.getKolejnosc();
       String slowo = "";
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      if(rs.next()){
		          slowo = rs.getString("s");
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
       return slowo;
     }
     /**
      * zwraca zrymowane slowo 
      * @param inputSlowo slowo do rymu 
      * @param ile ile ostatnich liter sie rymuje
      * @return 
      */
      public String dajRym(String inputSlowo,int ile){
          Translacja t = new Translacja();
          String rym = inputSlowo.substring(inputSlowo.length()-ile,inputSlowo.length());
        String query = "select slowo as s from slowa where slowo LIKE '%"+t.javaBaza(rym)+"' group by rand()";//TODO:rym
       String slowo = "Brak danych";
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      if(rs.next()){
		          slowo = rs.getString("s");
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
       return t.bazaJava(slowo);
     }
     /**
      *wyswietla przykladowe slowa z gramatyki
      *returns : null jak nie ma odmian dla danej flagi i kolejnosci, w przyciwnym wypadku string do wyswietlenia
      */
     public String przykGram(String flaga, int kolejnosc){
         Translacja t = new Translacja();
         //System.out.println("flaga,kolejnosc"+flaga+","+kolejnosc);

       String query = "select slowo as s from slowa where slowa.flaga = '"+flaga+"' and slowa.numer = " + kolejnosc;
       List<String> wszSlowa = new ArrayList();
       String slowo = "";
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      while ( rs.next() ){
		          slowo = rs.getString("s");
                          String slowobaza = t.bazaJava(slowo);
                          wszSlowa.add(slowobaza);
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
       Collections.shuffle(wszSlowa);
       if ( wszSlowa.size() == 0 ) 
           return "";
       /*if ( ( wszSlowa.size() > 8000 ) || ( wszSlowa.size() < 4000 ) )
           return null;
        * 
        */
       String res = "";
       for ( int i = 0 ; i < ( wszSlowa.size() <= 10 ? wszSlowa.size()-1 : 9 ); i++)
            res += wszSlowa.get(i)+",";
       res += wszSlowa.get(( wszSlowa.size() <= 10 ? wszSlowa.size()-1 : 9 ));
       return res;
     }
     //pobira wszystkie wiersze z bazy
     public List<Lyric> pobierzWiersze(){
                 String query = "select * from lyrics";
       Lyric l = null;
       int id = 0;
       String lyric = null;
       String link = null;
       List<Lyric> res = new ArrayList();
        try {
        Statement stmt = conn.createStatement();
                      //System.out.println("dodaj slowo");
		      ResultSet rs = stmt.executeQuery(query);
		      while(rs.next()){
		          id = rs.getInt("id");
                          lyric = rs.getString("lyric");
                          link = rs.getString("link");
                          l = new Lyric(id,lyric,link);
                          res.add(l);
		      }
        }
        catch ( Exception e ){
            System.out.println(e);
        }
       return res;
     }
     public void setLyric(Lyric l){
        String insertQuery = "";
            insertQuery = "update lyrics set lyric = '"+l.getLyric()+"' where id = "+l.getId();
             try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          stmt.executeUpdate(insertQuery);
            }
            catch ( Exception e ){
                System.out.println(e);
            }
        }
}
