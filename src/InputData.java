
import Accessor.Baza;
import Accessor.DodajTemat;
import Accessor.SlowoTemat;
import Gramatyka.GramatykaContainer;
import java.util.ArrayList;
import java.util.List;
import prolog.util.Gram;
import prolog.util.SlowoGram;
import user.Generator;
import user.Nauka;
import Wiersz.*;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witchhunter
 */
public class InputData {
    /**
     * uklada n zdan ze slow z danej strony internetowej zawierajacych k slow kluczowych i calosc jest podana w postaci jednego zdania lub zdania z przecinkami. 
     * @param keywords
     * @param website
     * @param ile
     * @param interpunkcja
     * @return 
     */
    public String zdanie(ArrayList keywords, String website,int ile){
        //max 100
        //if interpunkcja, dodaj 2 lub 3 przecinki
        //generuje lyric generator
         String temat = website;
        String link1 = website;
        
        List<String> lista = new ArrayList();
        
        lista.add(link1);
        DodajTemat d = new DodajTemat();
        if ( d.isWolnyTemat(temat))
            d.dodajTemat(temat, lista);
        //dodano temat
        String wiersz,aa,bb,cc = null;
        Generator g = new Generator();
        String text = "";
        SlowoTemat instance = new SlowoTemat();
        GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        Nauka n = new Nauka();
        List sl = instance.dajSlowa(temat,slowa);
        String tekst = "";
        ArrayList s = new ArrayList();
        for ( int i = 0 ; i < ile*3 ; i++){
                DaneWejsciowe dane = new DaneWejsciowe(list,sl);
                Ukladacz ukl = new Ukladacz(dane,keywords);
                try {
                        DaneWyjsciowe expResult = ukl.uloz(null);
                        s.add(expResult.getWersy().get(0));
                    }
                catch ( Exception e ){
                    System.out.println(e);
                }
            }
            Start fg = new Start();
            return fg.piszListe(fg,fg.process(s));
    }
     public String zdanieAll(ArrayList keywords, String website,int ile){
        //max 100
        //if interpunkcja, dodaj 2 lub 3 przecinki
        //generuje lyric generator
         String temat = website;
        String link1 = website;
        
        List<String> lista = new ArrayList();
        
        lista.add(link1);
        DodajTemat d = new DodajTemat();
        if ( d.isWolnyTemat(temat))
            d.dodajTemat(temat, lista);
        //dodano temat
        String wiersz,aa,bb,cc = null;
        Generator g = new Generator();
        String text = "";
        SlowoTemat instance = new SlowoTemat();
        GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        Nauka n = new Nauka();
        List sl = instance.dajSlowaAll(slowa);
        String tekst = "";
        ArrayList s = new ArrayList();
        for ( int i = 0 ; i < ile*3 ; i++){
                DaneWejsciowe dane = new DaneWejsciowe(list,sl);
                Ukladacz ukl = new Ukladacz(dane,keywords);
                try {
                        DaneWyjsciowe expResult = ukl.uloz(null);
                        s.add(expResult.getWersy().get(0));
                    }
                catch ( Exception e ){
                    System.out.println(e);
                }
            }
            Start fg = new Start();
            return fg.piszListe(fg,fg.process(s));
    }
    /**
     * uklada wyrazenie z danego wzoru powtarzajac niektore slowa
     * @param wzor
     * @return 
     */
    public String wyrazenie(String wzor){
        String wejscie = wzor;
        Pokaz p = new Pokaz();
        return p.wyswietlWejscie(p.ParsujWejscie(wejscie));
    }
    /**
     * podaje forme slowa w jezyku polskim np. czasownik,rzeczonik meskoosobowy etc.
     * @param slowo
     * @return 
     */
    public String lematyzator(String slowo){
        Baza b = new Baza();
        b.polacz();
        SlowoGram sg = b.executeLematyzujGram(slowo);
        String bezok = sg.getBezok();
        String flaga = sg.getFlaga();
        String gramatyka = "";
        char fl = flaga.charAt(0);
        switch ( fl ) {
            case 'O' : gramatyka = "rzeczownik, liczba pojedyncza, osobowy";
                        break;
            case 'o' : gramatyka = "rzeczownik, liczba mnoga, mianownik, osobowy";
                        break;
            case 'D' : gramatyka = "rzeczownik, liczba mnoga, dopelniacz, osobowy";
                        break;
            case 'Q' : gramatyka = "rzeczownik, liczba pojedyncza, osobowy";
                        break;
            case 'q' : gramatyka = "rzeczownik, liczba mnoga, mianownik, osobowy";
                        break;
            case 'T' : gramatyka = "rzeczownik, liczba mnoga, dopelniacz, osobowy";
                        break;
            case 'S' : gramatyka = "rzeczownik, liczba mnoga, celownik, osobowy";
                        break;
            case 's' : gramatyka = "rzeczownik,liczba mnoga, mianownik, nieosobowy";
                        break;
            case 'P' : gramatyka = "rzeczownik, liczba pojedyncza, osobowy";
                        break;
            case 'w' : gramatyka = "rzeczownik,liczba mnoga, mianownik,osobowy";
                        break;
            case 'R' : gramatyka = "rzeczownik, liczba pojedyncza, osobowy";
                        break;
            case 't' : gramatyka = "rzeczownik,liczba mnoga, mianownik,osobowy";
                        break;
            case 'Z' : gramatyka = "rzeczownik,liczba mnoga,dopelniacz, osobowy";
                        break;                                
            case 'z' : gramatyka = "rzeczownik, liczba mnoga, mianownik, nieosobowy";
                        break;
            case 'p' : gramatyka = "rzeczownik, liczba pojedyncza, miekkokoncowkowy";
                        break;
            case 'u' : gramatyka = "rzeczownik,liczba mnoga,miekkokoncowkowy";
                        break;
            case 'r' : gramatyka = "rzeczownik,liczba pojedyncza";
                        break;
            case 'K' : gramatyka = "generacja odmian zenskich do meskich";
                        break;
            case 'L' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba pojedyncza";
                        break;
            case 'M' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba pojedyncza";
                        break;
            case 'A' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba mnoga,mianownik";
                        break;
            case 'm' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba mnoga,dopelniacz";
                        break;
            case 'n' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba mnoga,dopelniacz";
                        break;
            case 'C' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba mnoga,dopelniacz";
                        break;
            case 'N' : gramatyka = "rzeczownik,rodzaj zenski lub meski ale odmieniany jak zenski, liczba mnoga,celownik";
                        break;
            case 'U' : gramatyka = "rzeczownik,rodzaj nijaki,liczba pojedyncza";
                        break;
            case 'V' : gramatyka = "rzeczownik, rodzaj nijaki, liczba mnoga, mianownik";
                        break;
            case 'l' : gramatyka = "rzeczownik bez liczby pojedynczej,dopelniacz,liczba mnoga";
                        break;                
            case 'f' : gramatyka = "rzeczownik bez liczby pojedynczej,dopelniacz,liczba mnoga";
                                    break;
            case 'v' : gramatyka = "rzeczownik bez liczby pojedynczej,dopelniacz,liczba mnoga";
                                    break;
            case 'W' : gramatyka = "rzeczownik bez liczby pojedynczej, celownik, liczba mnoga";
                                    break;
            case 'H' : gramatyka = "czasownik,czas przeszly i tryb przypuszczajacy";
                                    break;
            case 'F' : gramatyka = "czasownik, czas przeszly i tryb przypuszczajacy,dokonany";
                                    break;
            case 'I' : gramatyka = "czasownik, czas terazniejszy lub przyszly";
                                    break;
            case 'J' : gramatyka = "czasownik, czas terazniejszy lub przyszly";
                                    break;
            case 'h' : gramatyka = "czasownik, czas terazniejszy lub przyszly";
                                    break;
                
            case 'B' : gramatyka = "czasownik, tryb rozkazujacy";
                                    break;
                                
            case 'k' : gramatyka = "czasownik,tryb rozkazujacy";
                                    break;
                                
            case 'G' : gramatyka = "imieslow przymiotnikowy przeszly";
                                    break;
                                
            case 'i' : gramatyka = "rzeczownik odslowny i forma bezosobowa";
                                    break;
                                
            case 'j' : gramatyka = "rzeczownik odslowny i forma bezosobowa";
                                    break;
            case 'x' : gramatyka = "przymiotnik";
                                    break;
                                
            case 'X' : gramatyka = "przymiotnik";
                                    break;
                                
            case 'Y' : gramatyka = "przymiotnik";
                                    break;
                                
            case 'y' : gramatyka = "przyslowek";
                                    break;
            default : gramatyka = "brak danych";
        }
        return "\""+slowo+"\""+" -: "+"\""+bezok+"\""+" - "+gramatyka;
    }
    /**\
     * znajduje rym do danego slowa, 
     * @param slowo slowo 
     * @param ileLiter ile ostatnich liter sie rymuje
     * @param zasob zasob czyli albo cala baza albo dana strona www
     * @return 
     */
    public String rym(String slowo,int ileLiter,String strona){
        return "";
    }
    public String rymPewny(String slowo,int ileLiter){
        Baza b = new Baza();
        b.polacz();
        return b.dajRym(slowo, ileLiter);
    }
    public static void main(String[] args){

        long i = System.currentTimeMillis();
        InputData id = new InputData();
        ArrayList keywords = new ArrayList();
        String tekst = id.zdanieAll(keywords, "http://wp.pl", 500);
        System.out.println("Wygenerowany tekst: \r\n");
        System.out.println("<poczatek>");
        System.out.println(tekst);
        System.out.println("</koniec>");
        long j = System.currentTimeMillis();
        System.out.println("Total processing time = "+(j-i)+" milliseconds.");     
         
        /*
        String wyrazenie = "co ja {wiceminiszcze|zegarmiszcze|wicemiszcze|magiszcze}";
        InputData id = new InputData();
        System.out.println("Wyrazenie:\r\n");
        String res = "";
        for ( int i = 0 ; i < 20 ; i++)
            res += id.wyrazenie(wyrazenie) + "\r\n";
        System.out.println(res);
        */
       /*
       InputData id = new InputData();
        System.out.println(id.lematyzator("kefir"));
        
       long i = System.currentTimeMillis();
        id = new InputData();
        
        String slowo = "kefiru";
        System.out.println("input:"+slowo);
        System.out.println("output:\r\n");
        for ( int k = 0 ; k < 20 ; k++ ) 
            System.out.println(id.rymPewny(slowo, 2));

        long j = System.currentTimeMillis();
        System.out.println("Total processing time = "+(j-i)+" milliseconds.");
    
         */
      /*
      
        String w1 = "{wieczorem|wieczorową porą|pod koniec dnia|w porze wieczoru} {palę|parzę|płonę|dymię|fajcze|jaram|kurwie z bonia|kurzę|opierdalam|pykam|smolę|wypalam|puszczam z dymem} {zioło|zioło}";
        String w2 = "się {obśmiało|przyśniło|sfilmowało|oziębnęło|kupowało|marszczyło|popadywało|zerkało|odchrzaniło|mściło|wszczepiło|pudrowało|powybrzydzało|posyłało|oklapło|bluzgnęło|upiększało|zlało|zleciało|buchnęło}"+" ty {jebana|głupia|pojebana|pochlastana} "+"{jemioło|gryzmoło|stodoło|pszczoło|szkoło}";
       
        String r1 = "lubie macać cyce";
        String s1 = "{skubie|dybie|dłubie|podzióbie} {bacówce|postułce|facetece|wojowniczce|pioseneczce|pierwszoklasitce|siłaczce}";
        String r2 = "lubie miętosić cytrynki";
        String s2 = "{rozlokujcie|użądliłyście|powieźcie|pokpiłybyście|zaprzyjaźnijcie|zgładźcie|sprzeciwiajcie}"+"{szklanki|berlinki|kuzynki|owsianki|rodzynki|krakowianki|amerykanki|magazynki|boginki|łazanki|teatromanki|blondynki|zapinki|porcelanki|układanki}";
        String r3 = "lubie smyrać donice";
        String s3 = "zagrać {pasierbice|macice|chłodnice|tortownice|lisice|męczennice|niewolnice|zazdrośnice|ulicznice}";
        
       
        //w1,w2,r1,s1,w1,w2,r2,s2,w1,w2,r3,s3
      
        String piosenka = "";
        InputData id = new InputData();
        ArrayList lista = new ArrayList();
        for ( int i = 0 ; i < 50 ; i++){
            piosenka = "";
            piosenka += id.wyrazenie(w1) + "<br>";
            piosenka += id.wyrazenie(w2) + "<br>";
            piosenka += r1 + "<br>";
            piosenka += id.wyrazenie(s1) + "<br>";
            piosenka += id.wyrazenie(w1) + "<br>";
            piosenka += id.wyrazenie(w2) + "<br>";
            piosenka += r2 + "<br>";
            piosenka += id.wyrazenie(s2) + "<br>";
            piosenka += id.wyrazenie(w1) + "<br>";
            piosenka += id.wyrazenie(w2) + "<br>";
            piosenka += r3 + "<br>";
            piosenka += id.wyrazenie(s3)+"<br><br>";
            lista.add(piosenka);
        }
        Iterator it = lista.iterator();
        while ( it.hasNext() ){
            System.out.println((String)it.next());
        }
          
         */
    }
}
