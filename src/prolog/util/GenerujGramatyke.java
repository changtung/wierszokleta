/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog.util;

import Accessor.Baza;
import Korpus.TematContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import prolog.Reguly;

/**
 *
 * @author Grzegorz
 */
public class GenerujGramatyke {

    /**
     * 
     * @param text
     * @return poszczegolne zdania cale
     */
    public List<String> tokenizujZdania(String text){
        String[] zdania = text.split("[\\.\\,]");
        List<String> l = new ArrayList();
        for ( int i = 0; i < zdania.length ; i++ )
            l.add(zdania[i]);
        return l;
    }
    /**
     *
     * @param zdanie
     * @return lista slowoGram z calym zdaniem, a jak jakiegos slowa brakuje to null
     */
    public List<SlowoGram> lematyzujZdanie(String zdanie,Baza b){
        Lematyzator l = new Lematyzator();
        List slowa = this.tokenizujSlowo(zdanie);
        if ( slowa.size() == 0 )
            return null;
        System.out.println("ok1");
        Iterator it = slowa.iterator();
        String slowo = "";
        SlowoGram sg = null;

        List<SlowoGram> res = new ArrayList();
        while ( it.hasNext() ){
            slowo = (String)it.next();
            sg = l.lematyzuj(slowo, b);
            if ( sg == null )
                ;//return null;
            else
                res.add(sg);
        }
        return res;
    }
    public List<String> tokenizujSlowo(String zdanie){
         Pattern pattern = Pattern.compile( "\\w+" );
    Matcher matcher = pattern.matcher( zdanie );
    String s;
    List<String> l = new ArrayList();
    while ( matcher.find() ) {
        s = matcher.group();
        l.add(s);
    }
    return l;
    }
    /**
     * program generuje tekst dla prologu  i tworzy gramatyke
     * @param args
     */
    public static void main(String[] args){
        Baza b = new Baza();
        b.polacz();
        TematContainer t = new TematContainer();
        String text = t.dajWiersze().getText();
        GenerujGramatyke g = new GenerujGramatyke();
        Reguly r = new Reguly();
        System.out.println( r.genReg(g.poprawneGram(text, b)) );
       /* test tokenizacji
        GenerujGramatyke g = new GenerujGramatyke();
        System.out.println(g.tokenizujZdania("ala i kali maja psy, owce i koty.oni sa."));
        *
        */
    }
    public boolean bledne(List<SlowoGram> s){
        if ( s.size() >= 3 )
        {
            return true;
            //if ( s.get(0).getFlaga().equals(s.get(1).getFlaga()) == true )
              //  return true;
        }
        return false;
    }
    public List<List<SlowoGram>> poprawneGram(String text,Baza b){
                GenerujGramatyke g = new GenerujGramatyke();
        List<String> l = g.tokenizujZdania(text);
        List<List<SlowoGram>> result = new ArrayList();
        SlowoGram sg = null;
        List<SlowoGram> res = new ArrayList();
        Iterator it = l.iterator();
        String zdanie = "";

        Iterator ka;
        int i = 0;
        int h = 0;
        while ( it.hasNext() )
        {
            zdanie = (String)it.next();
            res = g.lematyzujZdanie(zdanie,b);
            if ( res != null )
            {
                if ( bledne(res) == false )
                {result.add(res);
                    h++;
                    System.out.println("gramatyk poprawnych: "+h);
                }
            }
            
        System.out.println("gramatyk: "+i+" / "+l.size());
        i++;
        }
        System.out.println("zlematyzowano poprawnych zdan : " + h + " . Wszystkich zdan: " + i + " z " + l.size() );
        return result;
        }

    }
}
