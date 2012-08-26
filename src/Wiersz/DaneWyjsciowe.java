/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class DaneWyjsciowe {

     public List<String> wersy;
     List<String> zakazane;

    public List<String> getZakazane() {
        return zakazane;
    }

    public void setZakazane(List<String> zakazane) {
        this.zakazane = zakazane;
    }
    public DaneWyjsciowe(List<String> wersy) {
        this.wersy = wersy;
    }

    public List<String> getWersy() {
        return wersy;
    }

    public void setWersy(List<String> wersy) {
        this.wersy = wersy;
    }


    @Override
    public String toString() {
        return wersy.toString();
    }

}
