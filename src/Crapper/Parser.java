package Crapper;

/**
 * zaimportowanie biblioteki odpowiedzialnej za kontenery i innych. ArrayList oznacza liste.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Parser {
    /**
     * konstruktor domyslny klasy Parser, jako parametr podajemy domene w jakiej prowadzimy eksperyment
     * sprawdzamy czy adres rozpoczyna sie od znanych prefixow i wycinamy te prefiksy
     * @param domena 
     */
    public Parser(String domena){
        if ( domena.startsWith("http://www.") == true )
            this.domena = domena.substring(11);
        else
        if ( domena.startsWith("http://") == true )
            this.domena = domena.substring(7);
        else
            this.domena = domena;
        System.out.println("Parser:Parser -domena:  "+this.domena);
        
    }
    private String domena;
    /**
     * sciezka do biblioteki htmlparser. Jest to biblioteka pozwalajaca na parsowanie odnosnikow na stronie internetowej, dostepna na licencji open source
     * zmienic jesli uzywamy na innym komputerze, sciezka musi prowadzic do katalogu bin/
     */
    private String path = "c:\\htmlparser1_6\\bin\\";
    /**
     * Pobiera wszystkie linki z danego adresu www
     * @param address adres www linkow
     * @return lista linkow
     */
    public ArrayList<String> getLinks(String address){
        ArrayList<String> linki = new ArrayList();
        String tmp;
        try {
      String line;
      /**
       * uruchamiamy linkextractora
       */
      Process p = Runtime.getRuntime().exec(this.path + "linkextractor.cmd "+ address);
      /**
       * przekazujemy wyjscie i standardowy strumien bledu do programu
       */
      BufferedReader bri = new BufferedReader
        (new InputStreamReader(p.getInputStream()));
      BufferedReader bre = new BufferedReader
        (new InputStreamReader(p.getErrorStream()));
      /**
       * sprawdzamy czy mamy link z linkextractora, jesli jest, wyciagamy z niego url, dodajemy url do listy
       */
      while ((line = bri.readLine()) != null) {
        tmp = this.extrLink(line);
          System.out.println("Parser:GetLinks - line "+line);
        if ( tmp != null )
            if ( this.nalezyDoStrony(tmp) == true )
                linki.add(tmp);
      }
      bri.close();
      /**
       * wyswietlenie bledu
       */
      while ((line = bre.readLine()) != null) {
        //System.out.println(line);
      }
      bre.close();
      p.waitFor();
      System.out.println("Parser:GetLinks: Done.");
    }
    catch (Exception err) {
      err.printStackTrace();
    }
        return linki;
    }
    /**
     * wyciaga link z tekstu, jeden. 
     * uzywamy wyrazenia regularnego, uzywamy klas Pattern i Matcher oraz wyrazenia regularnego sprawdzajacego link
     * @param a tekst z linkiem ( jednym ) 
     * @return wartosc linku
     */
    private String extrLink(String a){
        Pattern pattern;
	Matcher matcher;
        String AHREF = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
        pattern = Pattern.compile(AHREF);
        matcher = pattern.matcher(a);
         while(matcher.find()){
             return matcher.group(1);
         }
        return null;
    }
    /**
     * sprawdza czy dany link nalezy do domeny macierzystej ( czy bedzie w grafie ) 
     * @param link adres www strony
     * @return true jesli nalezy, false w p.p.
     */
    public boolean nalezyDoStrony(String link){
        if ( link.contains(this.domena))
            return true;
        return false;
    }
    /**
     * przetwarza strone i buduje z niej graf
     * @param glebokosc - glebokosc na jakiej pobieramy linki np. 2 - linki drugiego stopnia
     * @return Zbudowany graf 
     */
    public Graf algorytm(int glebokosc,String adres,Graf g){        
        if ( glebokosc == 1 ){
        ArrayList linki = new ArrayList();
        linki = this.getLinks(adres);
        for ( int i = 0 ; i < linki.size() ; i++)
            g.dodajKrawedz(adres, (String)linki.get(i));
        return g;
        }
        else { 
            glebokosc--;
            ArrayList linki = new ArrayList();
            linki = this.getLinks(adres);
            for ( int i = 0 ; i < linki.size() ; i++)
            { 
                g.dodajKrawedz(adres, (String)linki.get(i));
                g = algorytm(glebokosc,(String)linki.get(i),g);
            }
            return g;
        }
    }
    /**
     * uruchomienie programu dla przykladowej strony i wyswietlenie danych
     * @param args tablica argumentow, dla ktorej wywolamy program
     */
    public static void main(String[] args){
        int glebokosc =3;
        if ( args.length == 0 ){
        Parser p = new Parser("http://blogbiszopa.blog.onet.pl/");
        Graf g = p.algorytm(glebokosc,"http://blogbiszopa.blog.onet.pl/",new Graf());
        System.out.println(g);
        //System.out.println(g.wyswietlPolaczenia());
        System.out.println(g.wyswietlStopnieWchodzace());
        System.out.println(g.wyswietlStopnieWychodzace());
        }
        else { 
            for ( int i = 0 ; i < args.length ; i++){
                Parser p = new Parser(args[i]);
                Graf g = p.algorytm(glebokosc,"http://www.wykop.pl",new Graf());
                System.out.println(g);
            }
        }
    }
}
