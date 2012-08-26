/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import prolog.util.SlowoGram;

/**
 * zwraca obiekty bazodanowe typu gramatyka czy lista slow, ona najpierw powinna sie ladowac
 * @author Grzegorz
 */
public class Fasada {

    private List<List<SlowoGram>> gramatyka;
    private List<SlowoGram> slowa;
    private HashMap sznak;
    public Fasada(DaneWejsciowe d,ArrayList value) {
        System.out.println("inicjacja fasady");
        this.setGramatyka(d.getGramatyka());
        this.setSlowa(d.getSlowa());
        this.init(value);
    }

    public void init(ArrayList value) {
        //pobierz gramatyke
        //pobeirz slowa
        //utworz hashmape "flaga-numer" - List<String> odmian uwaga, wartosc moze byc pusta

        sznak = this.listToHashMap(value);
    }
    /**
     * przrabia liste zawarta w obiekcie na obikety typu hashmap, klucze to flaga-kolejnosc a wartosci to lista slow
     * @return
     */
    public HashMap listToHashMap(ArrayList value2){
        sznak = new HashMap();

        SlowoGram s = null;
        String key = "";
        List value = new ArrayList();
        Iterator it = slowa.iterator();
        while ( it.hasNext() ){
            s = (SlowoGram)it.next();
            key = s.getFlaga()+"-"+s.getKolejnosc();
            System.out.println("Fasada:"+key);
            if ( sznak.containsKey(key) == true ){
                value = (List<String>)sznak.get(key);
                value.add(s.wartosc);
                sznak.put(key, value);
            }
             else {
                value = new ArrayList();
                value.add(s.wartosc);
                sznak.put(key, value);
             }
            //System.out.println("Fasada:listToHashMap ms-0"+sznak.get("MS-0"));
            sznak.put("MS-0", value2);
        }

        return sznak;
    }
    public HashMap getSznak() {
        return sznak;
    }

    public void setSznak(HashMap sznak) {
        this.sznak = sznak;
    }

    public List<List<SlowoGram>> getGramatyka() {
        return gramatyka;
    }

    public void setGramatyka(List<List<SlowoGram>> gramatyka) {
        this.gramatyka = gramatyka;
    }

    public List<SlowoGram> getSlowa() {
        return slowa;
    }

    public void setSlowa(List<SlowoGram> slowa) {
        this.slowa = slowa;
    }
    /**
     * nie uzywane poki co 
     * @param flaga
     * @param numer
     * @return
     */
    public String dajLosoweSlowo(String flaga, int numer){
        return null;
    }
    /**
     * zwraca liste slow o danej fladze i numerze
     * @param flaga
     * @param numer
     * @return null jak nie ma slowa o tej wartosci, w pp lista slow
     */
    public List<String> dajListe(String flaga,int numer){
        String key = flaga + "-" + numer;
        if ( sznak.containsKey(key) )
            return (List<String>)sznak.get(key);
        else
            return null;
    }

}
