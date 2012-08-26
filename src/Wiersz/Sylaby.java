/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Sylaby {
    String[] samogloski = { "a","e","y","u","i","o","ó","ę","ą"};
    List<String> samoList = null;
    public Sylaby() {
        samoList = new ArrayList();
        for ( int i = 0 ; i < samogloski.length ; i++)
            samoList.add(samogloski[i]);
    }

    public int liczSylaby(List<String> s){
        String m = "";
        for ( int i = 0 ; i < s.size() ; i++ )
            m += s.get(i);
        return liczSylaby(m);
    }
    public int liczSylaby(String s){
        char[] litery = s.toCharArray();
        int k = 0;
        for ( int i = 0 ; i < litery.length ; i++ )
            if ( samoList.contains(Character.toString(litery[i])) == true )
                k++;
        return k;
    }
    public static void main(String[] args){
        Sylaby s = new Sylaby();
        System.out.println(s.liczSylaby("ala ma kota"));
        System.out.println(s.liczSylaby("abecadlo"));
    }
}
