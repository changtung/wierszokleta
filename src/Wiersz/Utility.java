/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Utility {
    /**
     * wysiwelta wszystkie slowa, przydatne przy ukladaniu gramatyki
     * @param d
     */
    public void wyswietlSlowa(DaneWejsciowe d){
                Fasada f = new Fasada(d);

        Iterator it = f.getSznak().keySet().iterator();
        String key = "";
        while ( it.hasNext() )
        {
            key =(String) it.next();
            System.out.print(key+":");
            System.out.println(((List<String>)f.getSznak().get(key)).toString());
        }
    }
}
