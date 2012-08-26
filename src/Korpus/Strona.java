/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Korpus;

import Config.Paths;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Grzegorz
 */
public class Strona {
    String adres;
    String text;
    String parserPath = Paths.htmlparser;
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Strona(String adres) {
        this.adres = adres;
    }
    public void pobierzText(){
        String exe = parserPath + "stringextractor.cmd "+this.adres;
        String res = "";
        try {
      String line;
      Process p = Runtime.getRuntime().exec
        (exe);
      BufferedReader input =
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
        //res = res.replace(".C:\\Users\\Grzegorz\\Documents\\NetBeansProjects\\wiersz>C:\\Windows\\System32\\java.exe -classpath \"C:\\Users\\Grzegorz\\Documents\\generatorWiersza\\projekt\\htmlparser1_6_20060610\\htmlparser1_6\\lib\\htmlparser.jar\" org.htmlparser.parserapplications.StringExtractor\"", "");
        this.setText(res);
        System.out.println("parsed "+this.adres+"succesfully");
    }
    public static void main(String[] args){
        Strona s = new Strona("http://grzegorz.patynek.pl");
        s.pobierzText();
        System.out.println(s.getText());

    }
}
