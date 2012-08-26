/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.List;
import prolog.util.Gram;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class DaneWejsciowe {
private List<List<SlowoGram>> gramatyka;
private List<SlowoGram> slowa;
private int ilSyl = 13;
    public DaneWejsciowe(List<List<SlowoGram>> gramatyka, List<SlowoGram> slowa, int ilSyl) {
        this.gramatyka = gramatyka;
        this.slowa = slowa;
        this.ilSyl = ilSyl;
    }

    public int getIlSyl() {
        return ilSyl;
    }

    public void setIlSyl(int ilSyl) {
        this.ilSyl = ilSyl;
    }

    public DaneWejsciowe(List<List<SlowoGram>> gramatyka, List<SlowoGram> slowa) {
        this.gramatyka = gramatyka;
        this.slowa = slowa;
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

}
