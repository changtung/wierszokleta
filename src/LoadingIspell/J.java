package LoadingIspell;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;

public class J {
	private ArrayList suffixes = new ArrayList();
	private ArrayList zmieniane = new ArrayList();
	private ArrayList zmiany = new ArrayList();
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private DataInputStream dis; 
	private String fn = "J.txt";
	private String sciezka = "C:\\Documents and Settings\\pacior\\workspace\\dbCon\\src\\";
	J(){
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
	      String tekst = "";
	      int i = 0;
	      byte ba[] = new byte[1024];
	      int bytesRead = 0;
	      String s;
	      while (bytesRead != -1) {
			     // -1 means eof.
			     // You don't necessarily get all you ask for in one read.
			     // You get what's immediately available.
	    	  	ba = new byte[1024];
			     bytesRead = dis.read( ba, 0 /* offset in ba */, ba.length /* bytes to read */ );
			     if ( bytesRead == -1)
			    	 break;
			     String encodingName = "ISO-8859-2";
			     s = new String ( ba, encodingName );
			     tekst += s; 
			     
			     i++;
	      }
		     
	      String[] linie = podzielNaLinie(tekst);
	      for (int x=0; x<linie.length; x++)
	    	  przetworzLinie(linie[x],x);

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
	private String[] podzielNaLinie(String s){
		//System.out.println("s:"+s);
	     String[] result = s.split("\\n");
	     return result;


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
        if ( result.length > 0 )
        	return result[0];
        else
        	return "#";
	}
	/**
	 * podaje suffix i zmiany do tablic z nimi
	 * @param linia odczytana z pliku linia ispella
	 */
	public void przetworzLinie(String linia,int count){
		linia = usunKomentarz(linia);
        Pattern p = Pattern.compile(">");
        // Split input with the pattern
        //zostawienie interesujacych nas liter
        String[] result = 
                 p.split(linia);
        if ( result.length >= 2 ){//podzielil wedlug >
        //usun biale znaki
        usunBialeZnaki(result[0],count);
        Pattern p2 = Pattern.compile("[^\\s]+");
        Matcher matcher = 
            p2.matcher(result[1]);
        matcher.find();
        przetworzPrzecinek( matcher.group() ,count);
        }
	}
	private void usunBialeZnaki(String s,int count){
		//usun wszystkie biale znaki
		//dodaj do suffixes
	     String[] result = s.split("\\s");
	     String bb = "";
	     for ( int i = 0 ; i < result.length ; i++ )
	    	 bb+= result[i];
	     suffixes.add(bb);
		//System.out.println(bb+":"+count);
	}
	public void przetworzPrzecinek(String s,int count){
	//dodaj zmieniane 
		//dodaj zmiany
		System.out.println("s:"+s);
		String[] result = s.split(",");
		if ( result.length == 1 )
		{
			//mamy tylko zmiany
			zmieniane.add("");
			zmiany.add(result[0]);
			System.out.println(result[0]);
			return;
		}
		zmiany.add(result[1]);
		String[] result2 = result[0].split("-");
		zmieniane.add(result2[1]);
	}
	/**
	 * sprawdza ile procent odmian spelnia warunki i podaje ilosc prawidlowych odmian w stosunku do blednych
	 * @param slowo sprawdzane slowo
	 * @return zaokroglony procent 
	 */
	public int odmienialnyProcent(String slowo){
		double  a=ileOdmian(slowo);
		double b = suffixes.size();
		return (int)(a/b*100);
	}
	/**
	 * zlicza wszystkie mozliwe odmiany slowa
	 * @return ile roznych odmian
	 */
	public int ileOdmian(String slowo){
		int k = 0;
		for ( int i = 0 ; i < suffixes.size() ; i++ )
			if ( odmienialne(slowo,(String) suffixes.get(i)))
				k++;
		return k;
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
	 * @param suffix napis z tylu do zamiany
	 * @param zmieniony zmiana przedniego na jaki ma byc zmieniony
	 * @return konkatenacja slow, odmienione slowo
	 */
	private String odmien(String rdzen,String suffix,String zmiana,String zmieniony){
		if ( odmienialne(rdzen,suffix) == true )
			//odmien
		{
			String result = rdzen.substring(0, rdzen.length()-zmieniony.length());
			result = result + zmiana;
			return result.toLowerCase();
		}
		return null;
	}
	public boolean odmienialne(String rdzen,String suffix){
		Pattern patt = Pattern.compile(".*"+suffix.toLowerCase());
		  Matcher m = patt.matcher(rdzen.toLowerCase());
		  return m.matches();
	}
	public ArrayList odmienSlowo(String slowo){
		ArrayList result = new ArrayList(); 
		for ( int i = 0 ; i < suffixes.size() ; i++ )
			if ( odmienialne(slowo,(String) suffixes.get(i))){
				result.add( odmien(slowo, (String)suffixes.get(i), (String)zmiany.get(i), (String)zmieniane.get(i)) );
			}
		return result;
	}
	
	public static void main(String[] args ){
		I I = new I();
		I.przetworzPrzecinek("zesz", 1);
		/*System.out.println( G.suffixes );
		System.out.println( G.zmieniane );
		System.out.println( G.zmiany );
		*/
		//F.odmienialne("aslasz�","[^DSZ]�") );
		//for ( int i = 0 ; i < F.suffixes.size() ; i++ )
			//if ( F.odmienialne("splun��",(String) F.suffixes.get(i)))
		//System.out.println( F.odmien("splun��", (String)F.suffixes.get(i), (String)F.zmiany.get(i), (String) F.zmieniane.get(i)) );
		//System.out.println(a.odmienSlowo("slowo")[0].toString().toLowerCase());
		//System.out.println( F.ileOdmian("ow�adn��"));
		//System.out.println( F.odmienSlowo("ow�adn��"));
		
	}
}
