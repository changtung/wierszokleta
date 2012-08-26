package LoadingIspell;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class przykladKodowania {
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private DataInputStream dis; 
	private String fn = "F.txt";
	private String sciezka = "C:\\Documents and Settings\\pacior\\workspace\\dbCon\\src\\";
	
	public void laduj(){
		file = new File(sciezka + fn);
	    fis = null;
	    bis = null;
	    dis = null;
		try {
		      fis = new FileInputStream(file);

		      // Here BufferedInputStream is added for fast reading.
		      bis = new BufferedInputStream(fis);
		      dis = new DataInputStream(bis);

		      // dis.available() returns 0 if the file does not have more lines.
		      String linia;
		      int i = 0;
		      while (dis.available() != 0) {

		      // this statement reads the line from the file and print it to
		        // the console.
		    	
		        //linia = dis.readLine();

		        //System.out.println(s);
		        i++;
		      }

		      // dispose all the resources after using them.
		      fis.close();
		      bis.close();
		      dis.close();

		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	public static void main(String[] args){
		przykladKodowania p = new przykladKodowania();
		p.laduj();
		System.out.println(java.nio.charset.Charset.availableCharsets());
	}
}
