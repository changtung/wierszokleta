/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import Accessor.Baza;
import java.util.ArrayList;

/**
 *
 * @author Grzegorz
 */
public class Nauka {

    public boolean wolnyTemat(String temat){
        Baza b = new Baza();
        b.polacz();
        return b.isTematFree(temat);
    }
    public Nauczone ucz(String[] adresy, String temat){
           ArrayList<String> lista = new ArrayList();
       // lista.add(link1);
           for ( int i = 0 ; i < adresy.length ; i++)
                lista.add(adresy[i]);
       // lista.add(link3);
//lista.add(link4);
        Generator g = new Generator();
        Nauczone n = g.dodajTemat(temat, lista);
        return n;
    }
     public Nauczone ucz(String text, String temat){
         System.out.println("text:"+text);
                 Generator g = new Generator();

        Nauczone n = g.dodajTemat(temat, text);
        return n;
    }

    public static void main(String[] args){
        String temat = "nka";
        String[] adresy = new String[10];

        //dobieranie adresow automatycznie
        int s = 0;
       for ( int i = 10 ; i < 11 ; i++ )
           adresy[i-10] = "http://grzegorz.patynek.pl";


        Nauka n = new Nauka();
        //czy temat nie jest zajety
        Nauczone na = null;
        if ( n.wolnyTemat(temat) ){
            na = n.ucz(adresy, temat);
        }
 else
            System.out.println("Temat zajety, wybierz inna nazwe tematu");
        
        System.out.println("wyniki nauki: " + na);

    }
}
