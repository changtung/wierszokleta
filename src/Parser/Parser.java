/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parser;

import Config.Paths;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Grzegorz
 * klasa bedzie parsowac jeden link do strony internetowej i pobierac z niego podlinki
 */
public class Parser {

    private String adres;
    Parser( String adres ){
        this.adres = adres;
    }
    public String parsuj(){
        String parserPath = Paths.htmlparser;
        String exe = parserPath + "linkextractor ";
          BufferedReader input= null;
        for( String link : l){
        try {
       p = Runtime.getRuntime().exec(exe+link);
       input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      while ((line = input.readLine()) != null) {
        res += line +".";
      }
      input.close();
    }
    catch (Exception err) {
      err.printStackTrace();
    }
    }
}
