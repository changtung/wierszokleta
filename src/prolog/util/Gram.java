/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog.util;

/**
 *
 * @author Grzegorz
 */
public class Gram {

    public Gram(int kolejnosc, String flaga) {
        this.kolejnosc = kolejnosc;
        this.flaga = flaga;
    }

    private int kolejnosc;
    private String flaga;

    public String getFlaga() {
        return flaga;
    }

    public void setFlaga(String flaga) {
        this.flaga = flaga;
    }

    public int getKolejnosc() {
        return kolejnosc;
    }

    public void setKolejnosc(int kolejnosc) {
        this.kolejnosc = kolejnosc;
    }

    @Override
    public boolean equals(Object obj) {
        Gram g = (Gram)obj;
        if ( ( this.kolejnosc == g.kolejnosc ) && ( this.flaga.equals(g.flaga) == true )){
            return true;
        }
            
        else
            return false;
    }
    public String toString(){
        return this.flaga + "-" + this.kolejnosc;
    }
}
