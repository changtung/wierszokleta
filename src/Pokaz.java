
import Accessor.Baza;
import Accessor.DodajTemat;
import Accessor.Slowo;
import CreWriter.Encja;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witchhunter
 */
public class Pokaz {
    HashMap ciag = new HashMap();
    Start s = new Start();
    Baza b = new Baza();
    DodajTemat dt = new DodajTemat();
    public static ArrayList<Slowo> strukturaMorfologiczna(ArrayList<String> v1){
        ArrayList<Slowo> zbior = new ArrayList();
        Pokaz p = new Pokaz();
        String synonim = "";
        Slowo s = null;
        Iterator start = v1.iterator();
        while ( start.hasNext() ){
            synonim = (String)start.next();      
            s = p.b.executeLematyzuj(synonim);
            System.out.println("Pokaz:strukturaMorfologiczna:"+s);
            zbior.add(s);//{budynek|budowla}
            }
        return zbior;
        
    }
    /**
     * 
     * @param zbior tablica alternatyw { budowla | budynek }
     */
    public void regexDodajGrupe(ArrayList<String> zbior,String name){
            ciag.put(name, new Encja(zbior));
    }
    public ArrayList<Encja> ParsujWejscie(String wejscie){
            ArrayList<Encja> res = new ArrayList();
            String atom = "";
            do { 
                atom = parFindFirst(wejscie);
                if ( atom == null )
                    break;
                wejscie = wejscie.substring(atom.length());
                System.out.println("Pokaz:ParsujWejscie - Atom:"+atom+"wejscie:"+wejscie);
                res.add(process(atom));
            } while ( wejscie.length() != 0 );
            System.out.println("Pokaz:ParsujWejscie:"+res);
            return res;
    }
    public String parFindFirst(String wejscie){
        char[] litery = wejscie.toCharArray();
        if ( litery[0] == '{' )//{budowla|budynek}
        {
            int i = 0;
            while ( litery[i] != '}' )
                i++;
            return wejscie.substring(0, i+1);
        }
        int i = 0;

        while ( ( litery[i] != '{' ) && ( i < litery.length ) )
        {   
            i++;
            if ( i == litery.length )
                break;
        }
        if ( i == litery.length )//doszlismy do konca
            return null;
        else
            return wejscie.substring(0, i);
        
        
    }
    public Encja process(String atom){
        String[] zbior = null;
        ArrayList<String> zb = new ArrayList();
        if ( atom.startsWith("{") == true )
        {
            System.out.println("Pokaz:process-starts with");
            zbior = atom.substring(1, atom.length()-1).split("\\|");
            for ( int i = 0 ; i < zbior.length ; i++)
            {
                zb.add(zbior[i]);
                System.out.println("Pokaz:process"+zbior[i]);
            }
            return new Encja(zb);
        }
        else return new Encja(atom);
    }
    public static String wyswietlWejscie(ArrayList<Encja> lista){
        String res = "";
        for ( int i = 0 ; i < lista.size() ; i++)
            res += (Encja)lista.get(i)+" ";
        return res;
    }
    public static void main(String[] args){
        String wejscie = "{budowla|budynek} stoi na {gorze|skarpie}";
        Pokaz p = new Pokaz();
        System.out.println(p.wyswietlWejscie(p.ParsujWejscie(wejscie)));
    }
}
