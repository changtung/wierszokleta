package LoadingIspell;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.*;

public class d{
	private String[] suffixes = new String[1];
	private String[] zmieniane = new String[1];
	private String[] zmiany = new String[1];
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private DataInputStream dis; 
	private String fn = "d_.txt";
	private String sciezka = "C:\\Documents and Settings\\pacior\\workspace\\dbCon\\src\\";
	d(){
		file = new File(sciezka + fn);
	    fis = null;
	    bis = null;
	    dis = null;
	    ladujOdmiany();
	}
	/**
	 * inizjalizacja odmian - otwarcie pliku z odmianami i przeczytanie wszystkich danych do tablic
	 */
	public void ladujOdmiany(){
	    try {
	      fis = new FileInputStream(file);

	      // Here BufferedInputStream is added for fast reading.
	      bis = new BufferedInputStream(fis);
	      dis = new DataInputStream(bis);

	      // dis.available() returns 0 if the file does not have more lines.
	      String linia;
	      while (dis.available() != 0) {

	      // this statement reads the line from the file and print it to
	        // the console.
	        linia = dis.readLine();
	        przetworzLinie(linia);
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
	/**
	 * usuwa wszystkie zdania ze stringu, ktore poprzedzone sa znakiem #
	 * @param linia string wejsciowy
	 */
	private String usunKomentarz(String linia){
        Pattern p = Pattern.compile("#");
        // Split input with the pattern
        String[] result = 
                 p.split(linia);
        return result[0];
	}
	/**
	 * podaje suffix i zmiany do tablic z nimi
	 * @param linia odczytana z pliku linia ispella
	 */
	private void przetworzLinie(String linia){
		linia = usunKomentarz(linia);
        Pattern p = Pattern.compile(">");
        // Split input with the pattern
        //zostawienie interesujacych nas liter
        String[] result = 
                 p.split(linia);
        
        Pattern p2 = Pattern.compile("[^\\s]+");
        // first string from array
        Matcher matcher = 
            p2.matcher(result[0]);
        matcher.find();
        suffixes[0] = matcher.group();
        
        matcher = 
            p2.matcher(result[1]);
        matcher.find();
        zmiany[0] = matcher.group();
	}
	/**
	 * sprawdza ile procent odmian spelnia warunki i podaje ilosc prawidlowych odmian w stosunku do blednych
	 * @param slowo sprawdzane slowo
	 * @return zaokroglony procent 
	 */
	public int odmienialnyProcent(String slowo){
		return 100;
	}
	/**
	 * zlicza wszystkie mozliwe odmiany slowa
	 * @return ile roznych odmian
	 */
	public int ileOdmian(){
		return 1;
	}
	/**
	 * zwraca rdzen slowa
	 * @param slowo slowo ktorego rdzen uzyskujemy
	 * @return uzyskany rdzen
	 */
	public String dajRdzen(String slowo){
		return slowo;
	}
	/**
	 * Odmienia prawidlowo kazde pasujace do flagi slowo
	 * @param rdzen rdzen slowa
	 * @param prefix napis z przodu do zamiany
	 * @param zmieniony zmiana przedniego na jaki ma byc zmieniony
	 * @return konkatenacja slow, odmienione slowo
	 */
	private String odmien(String rdzen,String prefix,String zmieniony){
		if ( prefix.equals(".") == true)//pusty prefix
			return zmieniony + rdzen;
		else return null;
	}
	public String[] odmienSlowo(String slowo){
		String[] result = new String[1];
		result[0] = odmien(dajRdzen(slowo),suffixes[0],zmiany[0]);
		return result;
	}
	public static void main(String[] args ){
		d d = new d();
		//System.out.println(a.odmienSlowo("slowo")[0].toString().toLowerCase());
	}
}
