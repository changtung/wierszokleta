/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gramatyka;

import IO.ProlFil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import prolog.UtilityClass;
import prolog.util.Gram;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class GramatykaContainer {
    //generuje gramatyke z pliku gramComp
    public List<Gram> generujZPlikuGram(){
        ProlFil pf = new ProlFil();
        List<Gram> res = new ArrayList();
        List<Gram> g = null;
        List<String> l = pf.getContents2(new File(pf.plikGramatykiComp));
        for ( int i = 0 ; i < l.size() ; i+=2){//w pliku parzyste to gramatyki a nieparzyste to przyklady
            g = this.przetworz(l.get(i));
            res = this.dodajDoListy(g,res);
        }
        return res;
    }
     public List<List<SlowoGram>> generujZPlikuGramKolejnosc(){
        ProlFil pf = new ProlFil();
        List<List<SlowoGram>> res = new ArrayList();
        List<Gram> g = null;
        List<String> l = pf.getContents2(new File(pf.plikGramatykiComp));
        for ( int i = 0 ; i < l.size() ; i+=2){//w pliku parzyste to gramatyki a nieparzyste to przyklady
            g = this.przetworz(l.get(i));
            res = this.dodajDoListyKolejnosc(g,res);
        }
        return res;
    }
    public static void main(String[] args){
        GramatykaContainer gc = new GramatykaContainer();

        System.out.println(gc.generujZPlikuGram());
    }
    public List<Gram> przetworz(String s){
        List<Gram> l = new ArrayList();
        String[] gramy = s.split("\\,");
        for ( int i = 0 ; i < gramy.length ; i++)
            l.add(this.podzielMys(gramy[i]));
        return l;
    }
    public List<Gram> dodajDoListy(List<Gram> skladnik,List<Gram> suma){
        Iterator it = skladnik.iterator();
        Gram g = null;
        while ( it.hasNext() ){
            g = (Gram)it.next();
            if ( suma.contains(g) == false)
                suma.add(g);
        }
        return suma;
    }
    private Gram podzielMys(String s){
         String[] gramy = s.split("\\-");
         String liczba = usunNL(gramy[1]);
        Gram g = new Gram(Integer.parseInt(liczba),gramy[0]);
        return g;
    }
    private String usunNL(String s){
Pattern pattern = Pattern.compile( "\\d+" );
    Matcher matcher = pattern.matcher( s );
    String st;
    matcher.find();
        st = matcher.group();
    return st;
    }
     public List<List<SlowoGram>> dodajDoListyKolejnosc(List<Gram> skladnik,List<List<SlowoGram>> suma){
        Iterator it = skladnik.iterator();
        UtilityClass u = new UtilityClass();
        Gram g = null;
        List<SlowoGram> pos = new ArrayList();
        while ( it.hasNext() ){
            g = (Gram)it.next();
            pos.add(u.GtoSG(g));
        }
        suma.add(pos);
        return suma;
    }
}
