/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Korpus;

import Accessor.Baza;
import Accessor.Funk;
import Accessor.Slowo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class TematContainer {
    public List<Slowo> dajSlowa(Temat temat){
        Baza b = new Baza();
        b.polacz();

        System.out.println("lematyzuj");
                String text = temat.getText();
                Funk instance = new Funk();

                List result = instance.tokenizuj(text);
        Iterator it = result.iterator();
        List<Slowo> s = new ArrayList();

        int i = 0;
        while ( it.hasNext() ){
            i++;
            s.add(instance.lematyzuj((String)it.next(),b));
            System.out.println("zlematyzowano: " + i + " / " + result.size() + " slow" );
        }

        it = s.iterator();
        List dobreSlowa = new ArrayList();
        Slowo prz = null;
        while ( it.hasNext() ){
            prz = (Slowo)it.next();
            if ( prz != null )
                dobreSlowa.add(prz);
        }
        System.out.println("Ogółem ztokenizowano " + result.size() + " slow, a zlematyzowano: " + dobreSlowa.size() + "Slow, co daje "+(dobreSlowa.size()/result.size())*100 + " procent lematyzacji");
        return dobreSlowa;

    }
    public Temat dajTestTemat(){

        List<String> strony = new ArrayList();
        String prefix = "http://";
        strony.add(prefix+"pl.wikipedia.org/wiki/Wielkanoc");
        strony.add(prefix+"www.klamerka.pl/5-1-wielkanocne.html");
        strony.add(prefix+"wielkanoc.lagata.pl");
        strony.add(prefix+"www.wielkanoc.waw.pl");
        strony.add(prefix+"www.wielkanoc.tm.pl");
        strony.add(prefix+"www.wielkanoc.org.pl");
        strony.add(prefix+"www.wielkanoc.swieta.biz");
        strony.add(prefix+"www.e-zyczenia.pl/zyczenia/wielkanocne/");
        strony.add(prefix+"www.wielkanoc.gsm.pl");
        strony.add(prefix+"halloween.friko.net/wielkanoc.html");
         
        
        return new Temat("Wielkanoc",strony);
    }

        public Temat dajPoryRoku(){

        List<String> strony = new ArrayList();
        String prefix = "http://";
        strony.add(prefix+"pl.wikipedia.org/wiki/Pora_roku");
        strony.add(prefix+"www.ga.com.pl/pory.htm");
        strony.add(prefix+"program4poryroku.pl");


        return new Temat("pory",strony);
    }
                public Temat dajProjekt(){

        List<String> strony = new ArrayList();
        String prefix = "http://";
        strony.add(prefix+"siup.amu.edu.pl");
        strony.add(prefix+"siup.amu.edu.pl/index.php?id=1");

        return new Temat("pory",strony);
    }
        public Temat dajMilosc(){

        List<String> strony = new ArrayList();
        String prefix = "http://";
        strony.add(prefix+"pl.wikipedia.org/wiki/Miłość");
                strony.add(prefix+"adonai.pl/milosc/");
        strony.add(prefix+"www.klamerka.pl/54-1-milosc.html");
        strony.add(prefix+"milosc.info");
        strony.add(prefix+"www.cytaty.info/temat/milosc/1");
        strony.add(prefix+"pl.wikiquote.org/wiki/Miłość");
        strony.add(prefix+"kobieta.gazeta.pl");
        strony.add(prefix+"cytaty.eu");
        strony.add(prefix+"prawdziwa-milosc.pl");
        strony.add(prefix+"www.verwa.com/");
        strony.add(prefix+"www.milosne.biz.pl/");


        return new Temat("Milosc",strony);
    }
        public Temat dajFortepian(){

        List<String> strony = new ArrayList();
        String prefix = "http://";
        strony.add(prefix+"pl.wikipedia.org/wiki/Fortepian");
                strony.add(prefix+"piano.com.pl/");


        return new Temat("Milosc",strony);
    }
        public Temat dajEtno() {
            List<String> strony = new ArrayList();
        String prefix = "http://";
        strony.add(prefix+"etno.pl");
        return new Temat("Etno",strony);
        }
    public Temat dajLalke(){

                List<String> strony = new ArrayList();
        //String prefix = "http://";
                for ( int i = 10 ; i <= 37 ; i++ )
                    strony.add("http://literat.ug.edu.pl/lalka/00"+i+".htm");
        return new Temat("Lalka",strony);
    }
        public Temat dajWiersze(){

                List<String> strony = new ArrayList();
        //String prefix = "http://";
                for ( int i = 10 ; i <= 85 ; i++ )
                    strony.add("http://literat.ug.edu.pl/amwiersz/00"+i+".htm");
        return new Temat("Mickiewicz",strony);
    }
        public static void main(String[] args){
                    TematContainer t = new TematContainer();
        t.dajSlowa(t.dajTestTemat());
        }
}
