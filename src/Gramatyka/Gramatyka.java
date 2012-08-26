/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gramatyka;

import Accessor.Baza;
import IO.ProlFil;
import Korpus.Temat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import prolog.Reguly;
import prolog.util.GenerujGramatyke;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class Gramatyka {
    ProlFil pf = new ProlFil();

    public String wyciagnijGramatyke(Temat temat){
        Baza b = new Baza();
        b.polacz();
        String text = temat.getText();
        GenerujGramatyke g = new GenerujGramatyke();
        Reguly r = new Reguly();
        List<List<SlowoGram>> l = g.poprawneGram(text, b);
        r.genRegFile(l);
        return r.genReg(l);
    }
        public String generujLosowoscGram(String filepath){
        List contents = pf.getContents2(new File(filepath));
        String res = "";
        String pom = "";
        for ( int i = 0 ; i <= 1 ; i++ )
        {
            System.out.println("shuffled");
            Collections.shuffle(contents);
            for ( int k = 0 ; k < contents.size(); k++ )
            {
                pom =(String) contents.get(k);
                pom = pom.replace("zdanie(Y)", "zdanie"+i+"(Y)");
                res += pom + "\r\n";
            }
        }
        return res;
    }
        public void generujGram1(){
                            List<String> strony = new ArrayList();
        //String prefix = "http://";
                for ( int i = 10 ; i <=15 ; i++ )//85
                    ;//strony.add("http://literat.ug.edu.pl/amwiersz/00"+i+".htm");
        
                                            for ( int i = 10 ; i <= 12 ; i++ )
                    strony.add("http://literat.ug.edu.pl/lalka/00"+i+".htm");
                            
         Temat tem = new Temat("teksty1",strony);
            System.out.println(this.wyciagnijGramatyke(tem));
        }
        public void generujGram2(){
                                        List<String> strony = new ArrayList();
                            for ( int i = 10 ; i <= 10 ; i++ )
                    strony.add("http://literat.ug.edu.pl/lalka/00"+i+".htm");

         Temat tem = new Temat("teksty",strony);
            System.out.println(this.wyciagnijGramatyke(tem));
        }
        public static void main(String[] args){
            //generuje grmatyke do pliku Comp.txt
            Gramatyka g = new Gramatyka();
            g.generujGram1();
        }
}
