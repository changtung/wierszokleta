/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Accessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 * jakies odmienione formy slowa
 */
public class Funk {
/**
 * slowo
 * @param wartosc - slowo
 * @return obiekt slowo, ktory zawiera podstawowe slowo
 */
    public Slowo lematyzuj(String wartosc, Baza b){
        return b.executeLematyzuj(wartosc);
}
    public SlowoGram lematyzujg(String wartosc, Baza b){
        return b.executeLematyzujGram(wartosc);
}
    /**
     * zwraca ztokenizowany ciag wyrazow, dzielimy tekst na slowa, czyli wartosci atomowe
     * @param text
     * @return
     */
    public List<String> tokenizuj(String text){
            Pattern pattern = Pattern.compile( "\\w+" );
    Matcher matcher = pattern.matcher( text );
    String s;
    List<String> l = new ArrayList();
    while ( matcher.find() ) {
        s = matcher.group();
        l.add(s);
    }
    return l;
    }
    public static void main(String[] args){
        /**
         * tokenizacja
         */
        /*String text = "ala ma kota. Rybki i akwarium, las tez byly";
        Funk s = new Funk();
        s.tokenizuj(text);
         * 
         */
        /* lematyzacja */
         Funk s = new Funk();
       //  System.out.println(s.lematyzuj("biecnad"));
    }
}
