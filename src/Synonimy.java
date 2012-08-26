
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witchhunter
 */
public class Synonimy {
    public ArrayList<String> znajdz(String s){
        String address = "http://synonimy.ux.pl/multimatch.php?word="+s;
        String html = getCurl(address);
        String middle = extractUl(html);
        System.out.println(middle);
            return null;
    }
    public String extractUl(String html){
        Pattern pattern = Pattern.compile("<ul class=\"compact\">(.+?)</ul>");
final Matcher matcher = pattern.matcher(html);
matcher.find();
return matcher.group(1); // Prints String I want to extract
    }
    public String getCurl(String a){
        
String exe = Config.Paths.curl + "curl "+a;
        String res = "";
        String line = null;
        Process p = null;
                BufferedReader input= null;
        try {
       p = Runtime.getRuntime().exec(exe);
       input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      while ((line = input.readLine()) != null) {
        res += line;
      }
      input.close();
    }
    catch (Exception err) {
      err.printStackTrace();
    }
        return res;
    }
    public static void main(String[] args){
        Synonimy s = new Synonimy();
        System.out.println(s.znajdz("kobieta"));
    }
}
