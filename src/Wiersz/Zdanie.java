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
public class Zdanie {
    private int ilSyl;
    private String rym;
    List<String> zakaz;
    List<String> slowa;

    public Zdanie(int ilSyl, String rym, List<String> zakaz) {
        this.ilSyl = ilSyl;
        this.rym = rym;
        this.zakaz = zakaz;
    }

    public Zdanie(int ilSyl, String rym, List<String> zakaz, List<String> slowa) {
        this.ilSyl = ilSyl;
        this.rym = rym;
        this.zakaz = zakaz;
        this.slowa = slowa;
    }

    public int getIlSyl() {
        return ilSyl;
    }

    public void setIlSyl(int ilSyl) {
        this.ilSyl = ilSyl;
    }

    public String getRym() {
        return rym;
    }

    public void setRym(String rym) {
        this.rym = rym;
    }

    public List<String> getSlowa() {
        return slowa;
    }

    public void setSlowa(List<String> slowa) {
        this.slowa = slowa;
    }

    public List<String> getZakaz() {
        return zakaz;
    }

    public void setZakaz(List<String> zakaz) {
        this.zakaz = zakaz;
    }
    public String toString(){
        return this.slowa.toString();
    }
}
