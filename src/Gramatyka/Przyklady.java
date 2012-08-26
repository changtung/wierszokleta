/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gramatyka;

import Accessor.Baza;
import java.util.List;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class Przyklady {

    public String generujPrzyklad(List<SlowoGram> in){
        Baza b = new Baza();
        b.polacz();
        return b.dajPrzyklad(in);
    }
    //generuje plik gramatyki z pliku Comp.txt
}
