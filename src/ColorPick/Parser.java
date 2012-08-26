/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ColorPick;

import Config.Paths;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Parser {
        String parserPath = Paths.htmlparser;
public String pobierz(List<String> l){

String exe = parserPath + "stringextractor ";
        String res = "";
        String line = null;
        Process p = null;
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
        //res = res.replace(".C:\\Users\\Grzegorz\\Documents\\NetBeansProjects\\wiersz>C:\\Windows\\System32\\java.exe -classpath \"C:\\Users\\Grzegorz\\Documents\\generatorWiersza\\projekt\\htmlparser1_6_20060610\\htmlparser1_6\\lib\\htmlparser.jar\" org.htmlparser.parserapplications.StringExtractor\"", "");
       // System.out.println("res:"+res);
        if ( (this.getText()+res).length() > 100000 )
            break;
        this.setText(this.getText()+res);
        System.out.println("parsed "+link+"succesfully");
    }
    return this.getText();
}
private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
