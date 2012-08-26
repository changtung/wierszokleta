
import Accessor.BazaWP;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Projekt
 */
public class AktualizujWP {
    String host;
    String login;
    String haslo;
    String dbName;
    String prefix;
    AktualizujWP(String host,String login,String haslo,String dbName,String prefix){
        this.host = host;
        this.login = login;
        this.haslo = haslo;
        this.dbName = dbName;
        this.prefix = prefix;
    }
    public void dodajArtykul(int ileZnakow,ArrayList frazy){
         Precle p = new Precle();
         String precel = p.precelTematText("seks",frazy, ileZnakow);//nie dziala cos dodawanie znakow
         if ( precel != null ){
         precel = dodajSpacje(precel);
         BazaWP b = new BazaWP();
         b.polacz(this.host, this.dbName, this.login, this.haslo);
         b.dodajArtykul("wp1", precel, (precel.subSequence(0, 30)).toString(), (precel.subSequence(0, 10)).toString().replaceAll(" ", "-"));
         }
    }
    public String dodajSpacje(String a){
                a.replaceAll(".", ".<br/>");
                return a;
    }
    public static void main(String[] args){
        ArrayList sk = new ArrayList();
        sk.add("Sasha Grey");
        sk.add("seks");
        sk.add("seksowna Sasha Grey");
        sk.add("sexi Sasha Grey");

                for ( int i = 0 ; i < 1 ; i++){
        AktualizujWP ap = new AktualizujWP("localhost","root","","ispell","wp1");
        int a = (int)(Math.random()*500);
        ap.dodajArtykul(1000+a, sk);
        }
    }
}
