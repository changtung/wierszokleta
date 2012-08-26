/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Nauczone {

    private int ileSlow;
    private int ileRozpoznal;
    List<String> slowa;

    public int getIleRozpoznal() {
        return ileRozpoznal;
    }

    public void setIleRozpoznal(int ileRozpoznal) {
        this.ileRozpoznal = ileRozpoznal;
    }

    public int getIleSlow() {
        return ileSlow;
    }

    public void setIleSlow(int ileSlow) {
        this.ileSlow = ileSlow;
    }

    public List<String> getSlowa() {
        return slowa;
    }

    public void setSlowa(List<String> slowa) {
        this.slowa = slowa;
    }

    @Override
    public String toString() {
        String res = "Wyniki nauki: <br>";
        res += "Wszystkich słów: "+this.getIleSlow() +"<br>";
        res += "Rozpoznanych słów: "+this.getIleRozpoznal()+"<br>";
        res += "Rozpoznano nastepujace powtarzajace sie slowa: <br>";
        res += "<ul>";
        String exclude = "";
        for ( int i = 0 ; i < this.getSlowa().size() ; i++)
        {
            exclude = this.getSlowa().get(i);
            if ( ( exclude != "plik-pliku") && ( exclude != "projekt-projekt") && ( exclude != "jar-jar") )//te slowa ktore sa w parserze
            res += "<li>"+this.getSlowa().get(i)+"</li>";
        }
        res += "</ul>";
        return res;
    }

}
