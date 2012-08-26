/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog.util;

import Accessor.Baza;

/**
 *
 * @author Grzegorz
 */
public class Lematyzator {

    /**
     * 
     * @param wartosc
     * @return null jak nie zlematyzowal, w przeciwnym przypadku Slowogram
     */
    SlowoGram lematyzuj(String wartosc, Baza b){
            return b.executeLematyzujGram(wartosc);
    }
}
