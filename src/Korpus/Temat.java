/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Korpus;

import Crapper.Parser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Temat {

    public Temat(String temat, List<String> strony) {
        this.temat = temat;
        this.strony = strony;
    }
    
    public String temat;
    public List<String> strony;
    public String getText(){
        Iterator it = strony.iterator();
        String res = "";
        Strona s = null;
        String base = "";
        ArrayList<String> linki = new ArrayList();
        while ( it.hasNext() )
        {
            System.out.println("ite-next");
            base = (String) it.next();
            Parser p = new Parser(base);
            linki = p.getLinks(base);
            System.out.println("Temat:GetText Linki wychodzace.size: "+linki.size());
            s = new Strona(base);
            s.pobierzText();
            res += s.getText();
            for ( int i = 0 ; i < linki.size() ; i++ )
            {
                s = new Strona((String)linki.get(i));
                s.pobierzText();
                res += s.getText();
            }
        }
        return res;
    }
}
