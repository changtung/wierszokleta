/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Grzegorz
 */
public class ProlFil {
    public String plikGramatyki = "/home/booyak/wiersz/bazaGram.txt";
    protected String plikProgramu1 = "/home/booyak/wiersz/program1.txt";
    protected String plikProgramu2 = "/home/booyak/wiersz/program2.txt";
    protected String plikOutput1 = "/home/booyak/wiersz/wiersz1.pl";
    protected String plikOutput2 = "/home/booyak/wiersz/wiersz2.pl";

    public String plikWiersza1 = "/home/booyak/wiersz/output1.txt";
    public String plikWiersza2 = "/home/booyak/wiersz/output2.txt";
    public String plikPrzykladow = "/home/booyak/wiersz/przyklady.txt";
    public String plikGramatykiComp = "c:\\wiersz\\gramComp.txt";


  /*          public String plikGramatyki = "C:\\wiersz\\bazaGram.txt";
    protected String plikProgramu1 = "C:\\wiersz\\program1.txt";
    protected String plikProgramu2 = "C:\\wiersz\\program2.txt";
    protected String plikOutput1 = "C:\\wiersz\\wiersz1.pl";
    protected String plikOutput2 = "C:\\wiersz\\wiersz2.pl";

    public String plikWiersza1 = "C:\\wiersz\\output1.txt";
    public String plikWiersza2 = "C:\\wiersz\\output2.txt";
    public String plikPrzykladow = "C:\\wiersz\\przyklady.txt";
    public String plikGramatykiComp = "C:\\wiersz\\gramComp.txt";
   * 
   */
    public String getPlikGramatyki() {
        return plikGramatyki;
    }

    public String getPlikProgramu1() {
        return plikProgramu1;
    }
    public String getPlikProgramu2() {
        return plikProgramu2;
    }

    public String getPlikOutput1() {
        return plikOutput1;
    }

    public void setPlikOutput1(String plikOutput1) {
        this.plikOutput1 = plikOutput1;
    }

    public String getPlikOutput2() {
        return plikOutput2;
    }

    public void setPlikOutput2(String plikOutput2) {
        this.plikOutput2 = plikOutput2;
    }

    public void setPlikGramatyki(String plikGramatyki) {
        this.plikGramatyki = plikGramatyki;
    }
    static public void setContents(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
        aFile.createNewFile();
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
      output.append( aContents );
    }
    finally {
      output.close();
    }
  }
    /**
     * zamienia wiersze na liste stringow
     * @param aFile
     * @return
     */
         public  static List getContents2(File aFile) {
    //...checks on aFile are elided
    ArrayList contents = new ArrayList();

    try {
      //use buffering, reading one line at a time
      //FileReader always assumes default encoding is OK!
      BufferedReader input =  new BufferedReader(new FileReader(aFile));
      try {
        String line = null; //not declared within while loop
        /*
        * readLine is a bit quirky :
        * it returns the content of a line MINUS the newline.
        * it returns null only for the END of the stream.
        * it returns an empty String if two newlines appear in a row.
        */
        while (( line = input.readLine()) != null){
          contents.add(line+System.getProperty("line.separator"));
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    //Collections.shuffle(contents);
    return contents;
  }
             public static String getContents(File aFile) {
    //...checks on aFile are elided
    ArrayList contents = new ArrayList();

    try {
      //use buffering, reading one line at a time
      //FileReader always assumes default encoding is OK!
      BufferedReader input =  new BufferedReader(new FileReader(aFile));
      try {
        String line = null; //not declared within while loop
        /*
        * readLine is a bit quirky :
        * it returns the content of a line MINUS the newline.
        * it returns null only for the END of the stream.
        * it returns an empty String if two newlines appear in a row.
        */
        while (( line = input.readLine()) != null){
          contents.add(line+System.getProperty("line.separator"));
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    //Collections.shuffle(contents);
    Iterator it = contents.iterator();
    String gram = "";
    while ( it.hasNext() )
        gram += (String)it.next();
    return gram;
  }
}
