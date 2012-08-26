package Crapper;


/**
 * importujemy HashMape, czyli zbior par klucz-wartosc. 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;


public class Graf {
    /**
     * kluczem bedzie para dwoch wierzcholkow a wartoscia waga krawedzi
     */
    HashMap hm = new HashMap();
    
    /**
     * konstruktor klasy Graf, nic sie nie dzieje.
     */ 
    public Graf(){
        
    }
    /**
     * dodaje krawedz do grafu skierowanego z wagami. Kazdy wierzcholek jest jednoznacznie okreslony
     * przez adres internetowy. Jest to zbior V adresow internetowych. waga krawedzi miedzy wierzcholkami
     * oraz skierowanie, wyznaczaja ilosc linkow z danej strony do drugiej i kierunek linka
     * @param adres1 wierzcholek grafu o wartosci adres1, jesli nie istnieje, zostaje utworzony
     * @param adres2 wierzcholek grafu o wartosci adres2, jesli nie istnieje zostaje utworzony
     */
    public void dodajKrawedz(String adres1,String adres2){
        System.out.println("dodaje krawedz pomiedzy "+adres1+" a "+ adres2);
        Para nowy = new Para(adres1,adres2);
        if ( hm.containsKey(nowy) )//jest juz krawedz pomiedzy wierzcholkami
            hm.put(nowy, ((Integer)hm.get(nowy)+1) );
        else
            hm.put(nowy, 1 );//dodajemy nowa krawedz
    }
    /**
     * przeciazona metoda toString klasy Object. Tutaj wyswietla informacje o grafie ktory stworzylismy
     * @return 
     */
    public String toString(){
        Iterator it = hm.keySet().iterator();
        Para tmp;
        String res = "";
        while ( it.hasNext() ){
            tmp = (Para)it.next();
            res += "Z wierzcholka "+tmp.a + " do wierzcholka "+tmp.b + " jest "+ hm.get(tmp) + " wartosci\r\n";
        }
        return res;
    }
    /**
     * wyswietla wszystkie polaczenia w grafie, czyli pary (a,b) i przypisane im wartosci. 
     * a,b - adresy stron (a,b) - para adresow, f((a,b)) -> n, n - liczba naturalna
     * @return opis tekstowy polaczen w grafie
     */
    public String wyswietlPolaczenia(){
        return this.toString();
    }
    /**
     * wyswietla stopien wierzcholka ze wzgledu na wchodzace polaczenia( czyli ile linkow linkuje do tej strony ) 
     * @return opis tekstowy
     */
    public String wyswietlStopnieWchodzace(){
        HashMap wchodzace = new HashMap();
        Iterator it = hm.keySet().iterator();
        Para tmp;
        String res = "";
        while ( it.hasNext() ){
            tmp = (Para)it.next();
            if ( wchodzace.containsKey(tmp.b) )//wierzcholek do ktorego wchodzi link
                wchodzace.put(tmp.b, ((Integer)wchodzace.get(tmp.b)+1) );
            else
                wchodzace.put(tmp.b, 1 );//dodajemy nowy link wchodzacy
        }
        /**
         * sortowanie
         */
        wchodzace = this.sortHashMapByValuesD(wchodzace);
        /**
         * wyswietlenie wszystkiego
         */
        it = wchodzace.keySet().iterator();
        String w="";
        while ( it.hasNext() ){
            w = (String)it.next();
            res += "wierzcholek "+w+" ma "+(Integer)wchodzace.get(w)+" linkow wchodzacych\r\n";
        }
        return res;
    }
    /**
     * kod zaciagniety z internetu i przetestowany.
     * sortuje hashmape wedlug jej wartosci i nie usuwa duplikatow
     * @param passedMap hasmapa do posortowania
     * @return posortowana hashmapa
     */
public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
    List mapKeys = new ArrayList(passedMap.keySet());
    List mapValues = new ArrayList(passedMap.values());
    Collections.sort(mapValues);
    Collections.sort(mapKeys);
        
    LinkedHashMap sortedMap = 
        new LinkedHashMap();
    
    Iterator valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
        Object val = valueIt.next();
        Iterator keyIt = mapKeys.iterator();
        
        while (keyIt.hasNext()) {
            Object key = keyIt.next();
            String comp1 = passedMap.get(key).toString();
            String comp2 = val.toString();
            
            if (comp1.equals(comp2)){
                passedMap.remove(key);
                mapKeys.remove(key);
                sortedMap.put((String)key, (Integer)val);
                break;
            }

        }

    }
    return sortedMap;
}
    /**
     * wyswietla stopnie wierzcholka ze wzgledu na wychodzace polaczenia ( kierunek na zewnatrz, czyli ile mamy linkow na danym adresie ) 
 *   * metoda podobna do wyswietlStopnieWchodzace(), tylko wierzcholek na krawedzi jest zamieniony
     * @return 
     */
    public String wyswietlStopnieWychodzace(){
        HashMap wchodzace = new HashMap();
        Iterator it = hm.keySet().iterator();
        Para tmp;
        String res = "";
        while ( it.hasNext() ){
            tmp = (Para)it.next();
            if ( wchodzace.containsKey(tmp.a) )//wierzcholek do ktorego wchodzi link
                wchodzace.put(tmp.a, ((Integer)wchodzace.get(tmp.a)+1) );
            else
                wchodzace.put(tmp.a, 1 );//dodajemy nowy link wchodzacy
        }
        wchodzace = this.sortHashMapByValuesD(wchodzace);
        it = wchodzace.keySet().iterator();
        String w="";
        while ( it.hasNext() ){
            w = (String)it.next();
            res += "wierzcholek "+w+" ma "+(Integer)wchodzace.get(w)+" linkow wychodzacych\r\n";
        }
        return res;
    }
}
