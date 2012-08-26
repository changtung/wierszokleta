
import Accessor.SlowoTemat;
import Gramatyka.GramatykaContainer;
import IO.ProlFil;
import java.util.List;
import prolog.util.Gram;
import prolog.util.SlowoGram;
import user.Generator;
import user.Nauka;
import Wiersz.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witchhunter
 */
public class Start {
    String wiersz,aa,bb,cc = null;
    Generator g = null;
    String text = "";
    SlowoTemat instance = null;
    GramatykaContainer gc = null;
    List<List<SlowoGram>> list = null;
    List<Gram> slowa = null;
    List sl = null;
    String tekst= null;
    ArrayList s = null;
    String tmp = null;
    Ukladacz ukl = null;
    DaneWejsciowe d = null;
    public Start(String temat){
        g = new Generator();
        text = "";
        System.out.println("New SlowoTenat");
        instance = new SlowoTemat();
        gc = new GramatykaContainer();
        list = gc.generujZPlikuGramKolejnosc();
        slowa = gc.generujZPlikuGram();
        //String temat = "znanyinformatyk";//"termy29021986";
        //Nauka n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
          //  System.out.println("777"+slowa);
            sl = instance.dajSlowa(temat,slowa);
            tekst = "";
            s = new ArrayList();
            tmp = "";
            
            
            d = new DaneWejsciowe(list,sl);
            ukl = new Ukladacz(d,s);
            
    }
    public String get(){
        for ( int i = 0 ; i < 2 ; i++){

                try {
                    //System.out.println("1");
                        tmp += ukl.ulozS(null)+"<br/>";
                        //System.out.println("2");
                    }
                catch ( Exception e ){
                    System.out.println(e);
                }
            }
        return tmp;
    }
    String w1,w2,w3,w4;
    public static void main(String[] args){
        Start st = new Start(null);
        String wiersz,aa,bb,cc = null;
           Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        String temat = "GOCLEVER";//"termy29021986";
        Nauka n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
            System.out.println("777"+slowa);
            String topic = "http://www.xopowiadania.pl/";
            //String topic = "http://zyczenia.sennik.biz/zyczenia-dla-zakochanych";
            List sl = instance.dajSlowa(topic,slowa);
            System.out.println("slowa:"+sl);
            System.out.println("slowa size:"+sl.size());

            String tekst = "";
            ArrayList s = new ArrayList();
            String tmp = "";
            Ukladacz ukl = null;
            
            
            DaneWejsciowe d = new DaneWejsciowe(list,sl);
            ukl = new Ukladacz(d,s);
            
            String[] wersy3 = new String[2];
            for ( int i = 0 ; i < 2 ; i++){

                try {
                    System.out.println("1");
                        tmp = ukl.ulozS(null);
                        System.out.println("2");
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+tmp+i);
                        wersy3 = tmp.split("xxx");
                        if ( i == 0 ){
                        st.w1 = wersy3[0];
                        st.w3 = wersy3[1];
                        }
                        if ( i == 1 ){
                        st.w2 = wersy3[0];
                        st.w4 = wersy3[1];
                        }
                    }
                catch ( Exception e ){
                    System.out.println(e);
                }
            }
                //prezentacja
                Demo demo = new Demo();
                String res = "<div class=\"w\" style=\"margin:0 auto\">";
                res += "<h2>"+demo.gradient(st.w1)+"</h2>";
                res += "<h2>"+demo.gradient(st.w2)+"</h2>";
                res += "<h2>"+demo.gradient(st.w3)+"</h2>";
                res += "<h2>"+demo.gradient(st.w4)+"</h2>";
                res += "</div>";
                tmp += st.w1+st.w2+st.w3+st.w4;
                System.out.println("wiersz:"+Start.wersy(tmp));
                try { 
                ProlFil.setContents(new File("/home/witchhunter/seks.html"), ProlFil.getContents(new File("/home/witchhunter/seks.html"))+res);
                }
                catch ( Exception e ){
                    System.out.println(e);
                }
            
        
        //Start s = new Start();
        //System.out.println(s.get());
    }
    public String drukuj(String topic){
                String wiersz,aa,bb,cc = null;
           Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        String temat = "GOCLEVER";//"termy29021986";
        Nauka n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
            System.out.println("777"+slowa);
            List sl = instance.dajSlowa(topic,slowa);
            System.out.println("slowa:"+sl);
            System.out.println("slowa size:"+sl.size());

            String tekst = "";
            ArrayList s = new ArrayList();
            String tmp = "";
            Ukladacz ukl = null;
            
            
            DaneWejsciowe d = new DaneWejsciowe(list,sl);
            ukl = new Ukladacz(d,s);
            for ( int i = 0 ; i < 2 ; i++){

                try {
                    System.out.println("1");
                        tmp += ukl.ulozS(null);
                        System.out.println("2");
                    }
                catch ( Exception e ){
                    System.out.println(e);
                }
                System.out.println("wiersz:"+Start.wersy(tmp));
                try { 
                ProlFil.setContents(new File("/home/witchhunter/1.html"), Start.wersy(tmp));
                }
                catch ( Exception e ){
                    System.out.println(e);
                }
            }
                            return Start.wersy(tmp);

    }
    public static String wersy(String s){
        String[] tab = s.split("xxx");
        String tmp;
        for ( int i = 1 ; i < tab.length ; i+=2 ){
            tmp = tab[i-1];
            tab[i-1] = tab[i];
            tab[i] = tmp;
        }
        String res = "";
                for ( int i = 0 ; i < tab.length ; i++ ){
            res += tab[i]+"\r\n";
        }
                return res;
    }
    public static ArrayList process(ArrayList s){
        ArrayList c = new ArrayList();
        Iterator it = s.iterator();
        String tmp;
        while ( it.hasNext() )
        {
            tmp = (String)it.next();
            c.add(odwroc(tmp));
        }
        Collections.sort(c);
        return c;
    }
    public static String piszListe(Start sl,ArrayList a){
        Iterator it = a.iterator();
        String z1 = "";
        String z2 = "";
        String z3 = "";
        ArrayList k = new ArrayList();
        while ( it.hasNext() )
        {
            z1 = sl.odwroc((String)it.next());
            z2 = sl.odwroc((String)it.next());
            z3 = sl.odwroc((String)it.next());
            k.add(piszInter(z1,z2,z3));
        }
        it = k.iterator();
        String res = "";
        while ( it.hasNext() )
            res += (String)it.next() + "\r\n";
        return res;
    }
    public static String piszInter(String z1,String z2, String z3){
        z1 = z1.replace(".", "");
        z2 = z2.replace(".", "");
        z3 = z3.replace(".", "");
        double a = (Double)(Math.random() * 2);
        int r = (int)a;
        if ( r == 0 )
                        return z1 +".";
        if ( r == 1)
                        return z1 +", "+z2+".";
        if ( r == 2 )
            return z1+", "+z2+", "+z3+".";
        return z1 +", "+z2+".";
    }
    public static String odwroc(String a){
	
		int length = a.length();
		StringBuilder reverse = new StringBuilder();
		for(int i = length; i > 0; --i) {
			char result = a.charAt(i-1);
			reverse.append(result);
		}
		return reverse.toString();
	
    }
}
