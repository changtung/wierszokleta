/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gramatyka;

import Accessor.Baza;
import IO.ProlFil;
import Korpus.Temat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import prolog.util.GenerujGramatyke;
import prolog.util.SlowoGram;

/**
 * 19-08-2012
 * generujemy digramy z gramatyk z jezyka polskiego, nastepnie laczymy markowem te digramy w plik gramatyki
 * @author Projekt
 */
public class DiGramy {

    public List<List<SlowoGram>> ekstrakcja(){
              List<String> strony = new ArrayList();
        File f = new File("c:\\linki\\"+"kredyt"+".txt");
        String s = ProlFil.getContents(f);
        String[] linki = s.split(System.getProperty("line.separator"));
        System.out.println("linki size: "+linki.length);
        String url = "";
       /* for ( int i = 1 ; i < 9 ; i++ ){//kredyt od 1623
            strony.add("http://www.dejzy.pl/czytelnia/dlamlodziezy/jeszcze000"+i+".html");
        }*/
        strony.add("http://www.se.pl/");
              Baza b = new Baza();
        b.polacz();        
         Temat tem = new Temat("kredyt",strony);
         String text = tem.getText();
         GenerujGramatyke g = new GenerujGramatyke();
        List<String> l = g.tokenizujZdania(text);
        List<List<SlowoGram>> result = new ArrayList();
        SlowoGram sg = null;
        List<SlowoGram> res = new ArrayList();
        Iterator it = l.iterator();
        String zdanie = "";

        Iterator ka;
        int i = 0;
        int j = 0;
        while ( it.hasNext() )
        {
            j++;
            zdanie = (String)it.next();
            res = g.lematyzujZdanie(zdanie,b);
            if ( res != null )
            {
                if ( res.size() > 1 ){
                result.add(res);
                i++;
                }
            }
            if ( i == 300 )
                break;
            System.out.println("gramatyk: "+i+",wszystkich:"+j+"a calosc: "+l.size());         
        }
        return result;
    }
    
    public static void main(String[] args){
        DiGramy dg = new DiGramy();
        List<List<SlowoGram>> zdania = dg.ekstrakcja();
        SlowoGram sg;
        Iterator it = zdania.iterator();
        Iterator at;
        List<SlowoGram> tmp = null;
        String res = "";
        while ( it.hasNext() ){
            tmp = (List<SlowoGram>)it.next();
            at = tmp.iterator();
            
            while (at.hasNext() ){
                sg = ( SlowoGram )at.next();
                res += sg.wartosc+"{"+sg.flaga+"-"+sg.kolejnosc+"} ";
            }
            res += "\r\n";
        }
        File fi = new File("d:\\bgram\\"+"ngramy2"+".txt");
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
