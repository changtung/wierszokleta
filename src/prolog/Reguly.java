/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog;

import Gramatyka.Przyklady;
import IO.ProlFil;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import prolog.util.Skladnia;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class Reguly {
    public String genReg(List<List<SlowoGram>> l){
        String s = "";
        Iterator it = l.iterator();
        while ( it.hasNext() )
            s += this.genPojReg((List<SlowoGram>)it.next());
        return s;

    }
     public void genRegFile(List<List<SlowoGram>> l){
        String s = "";
        Iterator it = l.iterator();
        List<SlowoGram> tmp = null;
        Przyklady p = new Przyklady();
        while ( it.hasNext() ){
            tmp = (List<SlowoGram>)it.next();
            s += this.genPojRegFile(tmp);
            s += p.generujPrzyklad(tmp)+"\r\n";
         }
        ProlFil pf = new ProlFil();
        try {
        pf.setContents(new File(pf.plikGramatykiComp), s);
         }
        catch ( Exception e){
            System.out.println(e);
        }
    }
    public String genSlowa(List<SlowoGram> l ){
                String res = "";
        Skladnia s = new Skladnia();

        Iterator it = l.iterator();
        while ( it.hasNext() )
            res += s.atom((SlowoGram)it.next())+"\r\n";
        return res;
    }
    public String genSlowaS(Set<SlowoGram> l ){
                String res = "";
        Skladnia s = new Skladnia();

        Iterator it = l.iterator();
        while ( it.hasNext() )
            res += s.atom((SlowoGram)it.next())+"\r\n";
        return res;
    }
    public String genPojReg(List<SlowoGram> l){
        String res = "";
        Skladnia s = new Skladnia();
        String key = s.keyGen();
        Iterator it = l.iterator();
        res += "zdanie(Y) --> ";
        it = l.iterator();
        SlowoGram sg = null;

        int k = 0;
        while ( it.hasNext() ){
            k++;
            sg = (SlowoGram)it.next();
            if ( k == 1 )
                res += s.kawalZdania(sg);
            else
                res += ", "+s.kawalZdania(sg);


        }
        res += ".\r\n";
        return res;
    }
    public String genPojRegFile(List<SlowoGram> l){
        String res = "";
        Skladnia s = new Skladnia();
        String key = s.keyGen();
        Iterator it = l.iterator();
        //res += "zdanie(Y) --> ";
        it = l.iterator();
        SlowoGram sg = null;

        int k = 0;
        while ( it.hasNext() ){
            k++;
            sg = (SlowoGram)it.next();
            if ( k == 1 )
                res += s.kawalZdaniaFile(sg);
            else
                res += ","+s.kawalZdaniaFile(sg);


        }
        res += "\r\n";
        return res;
    }
    public String genAtom(SlowoGram sg){
            Skladnia s = new Skladnia();
            String res = s.atom(sg)+"\r\n";
            return res;
    }
    public static void main(String[] args ){

    }
}
