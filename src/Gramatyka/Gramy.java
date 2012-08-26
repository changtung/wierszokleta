/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gramatyka;

import Accessor.Baza;
import IO.ProlFil;
import LoadingIspell.a;
import java.io.File;

/**
 *
 * @author Projekt
 */
public class Gramy {
  public static void main(String[] args){
      Baza b = new Baza();
      b.polacz();
      String res = b.dongramow();
       File fi = new File("c:\\wiersz\\"+"ngramy"+".txt");
        try { 
        if(!fi.exists()){
        fi.createNewFile();
        }
        ProlFil.setContents(fi, res);
        }
        catch ( Exception e)
        {
            System.out.println(e);
        }
  }
}
