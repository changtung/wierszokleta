/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import Accessor.DodajTemat;
import Accessor.SlowoTemat;
import Gramatyka.Gramatyka;
import IO.ProlFil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import prolog.Reguly;
import java.io.*;
/**
 *
 * @author Grzegorz
 */
public class Generator {

    ProlFil pf = new ProlFil();

    public Nauczone dodajTemat(String temat, ArrayList<String> linki){
        DodajTemat d = new DodajTemat();
        Nauczone n = null;
        if ( d.isWolnyTemat(temat))
            n = d.dodajTemat(temat, linki);
        else
            System.out.println("temat zajety");
        return n;
    }
     public Nauczone dodajTemat(String temat, String text){
        DodajTemat d = new DodajTemat();
        Nauczone n = null;
        if ( d.isWolnyTemat(temat))
            n = d.dodajTemat(temat, text);
        else
            System.out.println("temat zajety");
        return n;
    }
    public void generujProgram(String temat){
        //generowanie losowej gramatyki
        Gramatyka g = new Gramatyka();
        ProlFil pf = new ProlFil();
        String res = g.generujLosowoscGram(pf.getPlikGramatyki());
        //wczytanie pliku z gramatyka
        //deprecated res = wczytajGram();
        res += "\r\n";
        //wczytaniu slow
        SlowoTemat instance = new SlowoTemat();
        List expResult = null;
        List result = instance.dajSlowa(temat,null);
        Collections.shuffle(result);
        Reguly r = new Reguly();
        res += r.genSlowa(result);
        res += wczytajProg();

                try {
        pf.setContents(new File(pf.getPlikOutput1()),res );
        }
        catch ( Exception e ){
            System.out.println(e);
        }

    }
    /**
     * ma losowac gramatyki rowniez
     * @return
     */
    private String wczytajGram(){
        String res = pf.getContents(new File(pf.getPlikGramatyki()));
        return res;
    }
    private String wczytajProg() {
        String res = pf.getContents(new File(pf.getPlikProgramu1()));
        return res;
    }





            public static void main(String[] args){


        /*
         * Wierszokleta Teddy - wersja BETA IDE
         */

        /*
         * Dane wejsciowe - temat - nazwa tematu - unikalna.
         */
        String temat = "termy29022012";
        /*
         * ArrayList of links - lista stringow z linkami do stron o ktorych ukladamy wiersz.
         */
        String link2 = "http://strony-www.gci.suchylas.pl/";
        //String link3 = "http://www.photoblog.pl/trance294/25456565/insipiracja.html";
        //String link4 = "http://mirriel.blorg.pl/viewtopic.php?f=5&t=1663&start=390";
      
        ArrayList<String> lista = new ArrayList();
       // lista.add(link1);
        lista.add(link2);
       // lista.add(link3);
//lista.add(link4);
        Generator g = new Generator();
        g.dodajTemat(temat, lista);
        g.generujProgram(temat);//
        /*Prolog p = new Prolog();
        p.test_0();
        //tu chcemy nowy watek
        String [] resCom = p.start();
                System.out.println("Wiersz to. :): ");
        for ( int i = 0 ; i < resCom.length ; i++)
                    System.out.println(p.compoundToString(resCom[i]));
         *
         */

        String komenda = "c:\\wiersz\\start.bat";

       ProcessBuilder builder = new ProcessBuilder(komenda);
        builder.redirectErrorStream(false);
        ProlFil pf = new ProlFil();
        //zerowanie pliku wiersza
        try {
        pf.setContents(new File(pf.plikWiersza1), "");
                }
        catch ( Exception e ){
            System.out.println("exc: "+e);
        }

       String line = "";
                        List<String> rezultat = new ArrayList();
       try {
       Process process = builder.start();
       
     /* BufferedReader input =
        new BufferedReader
          (new InputStreamReader(process.getInputStream()));
      * 
      */
      Thread thisThread = Thread.currentThread();
         /*     PrologRunnable pr = new PrologRunnable(input);
        Thread t = new Thread(pr);
        //Thread t = new Thread(pr);
        t.start();
           System.out.println("preparing to sleep");
          * 
          */
         try
             {
             thisThread.sleep(25000);
         }
         catch (Throwable tt)
             {
             throw new OutOfMemoryError("An Error has occured");
         }
         //rezultat = pr.getRezultat();
      process.destroy();
                               try
             {
             thisThread.sleep(5000);
         }
         catch (Throwable tt)
             {
             throw new OutOfMemoryError("An Error has occured");
         }
                }
              catch ( Exception e){
           System.out.println("exc;"+e);
       }
/*
                               for ( int i = 0 ; i < rezultat.size() ; i++)
                    System.out.println("rez:"+rezultat.get(i));
//dodawanie rezultatu
       if ( ( rezultat == null ) || (rezultat.size() < 4) )
                    System.out.println("Brak wiersza");
       else
       for ( int i = rezultat.size()-1 ; i >= rezultat.size()-4 ; i--)
                    System.out.println(rezultat.get(i));
 * 
 */

                        String res = "";
         try {
             res = pf.getContents(new File(pf.plikWiersza1));
                }
        catch ( Exception e ){
            System.out.println("exc: "+e);
        }
                System.out.println("rezultat pracy: "+res);
    }

    public String view(String tytul){

        /*
         * Wierszokleta Teddy - wersja BETA IDE
         */

        /*
         * Dane wejsciowe - temat - nazwa tematu - unikalna.
         */
         String temat = tytul;
        /*
         * ArrayList of links - lista stringow z linkami do stron o ktorych ukladamy wiersz.
         */
        String link2 = "http://strony-www.gci.suchylas.pl/";
        //String link3 = "http://www.photoblog.pl/trance294/25456565/insipiracja.html";
        //String link4 = "http://mirriel.blorg.pl/viewtopic.php?f=5&t=1663&start=390";

        ArrayList<String> lista = new ArrayList();
       // lista.add(link1);
        lista.add(link2);
       // lista.add(link3);
//lista.add(link4);
        Generator g = new Generator();
        g.dodajTemat(temat, lista);
        g.generujProgram(temat);//
        /*Prolog p = new Prolog();
        p.test_0();
        //tu chcemy nowy watek
        String [] resCom = p.start();
                System.out.println("Wiersz to. :): ");
        for ( int i = 0 ; i < resCom.length ; i++)
                    System.out.println(p.compoundToString(resCom[i]));
         *
         */
        ProlFil pf = new ProlFil();

        String komenda = "c:\\wiersz\\start.bat";
        try {
        //pf.setContents(new File(pf.plikWiersza), "");
                }
        catch ( Exception e ){
            System.out.println("exc: "+e);
        }
       ProcessBuilder builder = new ProcessBuilder(komenda);
        builder.redirectErrorStream(false);
        //zerowanie pliku wiersza


       String line = "";
                        List<String> rezultat = new ArrayList();
       try {
       Process process = builder.start();

     /* BufferedReader input =
        new BufferedReader
          (new InputStreamReader(process.getInputStream()));
      *
      */
      Thread thisThread = Thread.currentThread();
         /*     PrologRunnable pr = new PrologRunnable(input);
        Thread t = new Thread(pr);
        //Thread t = new Thread(pr);
        t.start();
           System.out.println("preparing to sleep");
          *
          */
         try
             {
             thisThread.sleep(15000);
         }
         catch (Throwable tt)
             {
             throw new OutOfMemoryError("An Error has occured");
         }
         //rezultat = pr.getRezultat();
      process.destroy();
                               try
             {
             thisThread.sleep(5000);
         }
         catch (Throwable tt)
             {
             throw new OutOfMemoryError("An Error has occured");
         }
                }
              catch ( Exception e){
           System.out.println("exc;"+e);
       }
/*
                               for ( int i = 0 ; i < rezultat.size() ; i++)
                    System.out.println("rez:"+rezultat.get(i));
//dodawanie rezultatu
       if ( ( rezultat == null ) || (rezultat.size() < 4) )
                    System.out.println("Brak wiersza");
       else
       for ( int i = rezultat.size()-1 ; i >= rezultat.size()-4 ; i--)
                    System.out.println(rezultat.get(i));
 *
 */

                        String res = "";
         try {
             res = pf.getContents(new File(pf.plikWiersza1));
                }
        catch ( Exception e ){
            System.out.println("exc: "+e);
        }
       return "rezultat pracy: "+res;
    }
}
