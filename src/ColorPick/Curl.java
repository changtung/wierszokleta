/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ColorPick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/**
 *
 * @author Grzegorz
 */
public class Curl {
public String pobierz(String temat){

String exe = Config.Paths.curl + "curl "+"https://www.google.com/search?hl=pl&q="+temat;
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
        res += line +".";
      }
      input.close();
    }
    catch (Exception err) {
      err.printStackTrace();
    }
        //res = res.replace(".C:\\Users\\Grzegorz\\Documents\\NetBeansProjects\\wiersz>C:\\Windows\\System32\\java.exe -classpath \"C:\\Users\\Grzegorz\\Documents\\generatorWiersza\\projekt\\htmlparser1_6_20060610\\htmlparser1_6\\lib\\htmlparser.jar\" org.htmlparser.parserapplications.StringExtractor\"", "");
        this.setText(res);
        System.out.println("queried ok");

        String html = Config.Paths.curl+temat + ".html";
      try {

      File f=new File(html);
      if(!f.exists()){
      f.createNewFile();
      System.out.println("New file \"myfile.txt\" has been ");
    }
      Thread.sleep(2000);
        this.setContents(f, res);
    }
      catch (Exception e){
          System.out.println(e);
      }
      return html;
}
private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    static public void setContents(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }

    //use buffering
    Writer output = new BufferedWriter(new FileWriter(aFile));
    try {
      //FileWriter always assumes default encoding is OK!
      output.write( aContents );
    }
    finally {
      output.close();
    }
  }
    public static void main(String[] args){
        Curl c = new Curl();
        System.out.println(c.pobierz("jan nowak"));
    }
}
