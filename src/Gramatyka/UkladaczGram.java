/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gramatyka;

import IO.ProlFil;
import java.io.File;
import java.util.List;
import prolog.Reguly;
import prolog.util.SlowoGram;

/**
 * uklada gramatyke dal prologu z gramatyki zdefiniowanej roboczo
 * @author Grzegorz
 */
public class UkladaczGram {
    public void uloz(){
        ProlFil pf = new ProlFil();
        GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();
        Reguly r = new Reguly();
        String tekst = r.genReg(list);
        try {
                pf.setContents(new File(pf.getPlikGramatyki()), tekst);
                }
        catch ( Exception e ){
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        UkladaczGram u = new UkladaczGram();
        u.uloz();
    }

}
