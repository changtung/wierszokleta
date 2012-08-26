/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog.util;

import java.util.Random;

/**
 *
 * @author Grzegorz
 */
public class Skladnia {

    public String flagaNaTerm(String flaga){
        return "t"+flaga;
    }
    /*
     * MS -> mst(0,Y)
     */
    public String kawalZdania(SlowoGram s){
        String tytul = this.flagaNaTerm(s.getFlaga());
        tytul += "(";
        tytul += s.getKolejnosc();
       // tytul += ",";
        tytul += ")";
        return tytul;
    }
     public String kawalZdaniaFile(SlowoGram s){
        String tytul = s.getFlaga();
        tytul += "-";
        tytul += s.getKolejnosc();
       // tytul += ",";
        return tytul;
    }
    public String atom(SlowoGram s){
        String atom = this.flagaNaTerm(s.getFlaga());
        atom += "(";
        atom += s.getKolejnosc();
       //atom += ",";
       // atom += key;
        atom += ") --> [";
        atom += s.getWartosc();
        atom += "].";
        return atom;
    }
    public String keyGen(){
        Random random = new Random();
        int length = 10;
        int a = 0;
        char[] symbole = new char[length];
        for ( int i = 0 ; i < length ; i++ )
        {
            a = random.nextInt(24);
            a += 97;
            symbole[i] = (char)a;
        }
        return new String(symbole);

    }
    public static void main(String[] args){
        Skladnia s = new Skladnia();
        for ( int i = 0 ; i < 10 ; i++)
            System.out.println(s.keyGen());
    }

}
