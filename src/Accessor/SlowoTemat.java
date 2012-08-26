/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Accessor;

import java.util.List;
import prolog.util.Gram;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class SlowoTemat {

    /**
     * zwraca wszystkie slowa o danym temacie
     * @param temat temat z bazy danych
     * @return
     * 
     */
    public List<SlowoGram> dajSlowa(String temat,List<Gram> lista){
                Baza b = new Baza();
        b.polacz();
        List<SlowoGram> res = b.odczytTemat(temat,lista);
        System.out.println("rozmiar"+res.size());
        return res;
    }
     public List<SlowoGram> dajSlowaAll(List<Gram> lista){
                Baza b = new Baza();
        b.polacz();
        List<SlowoGram> res = b.odczytTemat(lista);
        return res;
    }
     public List<SlowoGram> dajSlowaGineko(List<Gram> lista){
                Baza b = new Baza();
        b.polacz();
        List<SlowoGram> res = b.odczytTematGineko(lista);
        return res;
    }
    /**
     * zapisuje wszystkie slowa wybrane do bazy, nie wszystkie tylko bezokoliczniki a pozniej na ich podstawie wygeneruje wszystkie slowa
     * @param l
     * @param id
     */
    public void zapiszWszystkie(List<SlowoGram> l, String temat){
        Baza b = new Baza();
        b.polacz();
        b.zapiszBezok(l, temat);
    }
    public static void main(String[] args ){
        //serializable
        //new slowo tema
    }
}
