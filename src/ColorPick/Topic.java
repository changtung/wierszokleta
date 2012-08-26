/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ColorPick;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Topic {


    /**
     * 
     * @param temat
     * @param begin w tysiacach znakow od ktorego znaku zaczynamy parsing. 
     * @param end
     * @return
     */
    public String parsujTemat(String temat,int ileZnakow){
        Curl c = new Curl();
        c.pobierz(temat);
        Links l = new Links(temat);
        Parser p = new Parser();
        List<String> u = new ArrayList();
        System.out.println(l);
        for ( int i = 15 ; i <= 19 ; i++)
            u.add(l.urls.get(i));
        return p.pobierz(u);
    }
    public static void main(String[] args){
        System.out.println("Temat: ");
        Topic pt = new Topic();
        System.out.println(pt.parsujTemat("patynek", 1000));
    }
}
