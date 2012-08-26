/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Accessor;

import Korpus.Temat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import prolog.Reguly;
import prolog.UtilityClass;
import prolog.util.GenerujGramatyke;
import prolog.util.SlowoGram;
import user.Nauczone;

/**
 *
 * @author Grzegorz
 */
public class DodajTemat {

    /**
     * czy zajety temat
     * @param temat
     * @return true jesli temat jest wolny, false jesli temat jest zajety
     */
    public boolean isWolnyTemat(String temat){
        Baza b = new Baza();
        b.polacz();
        return b.isTematFree(temat);
    }
    /**
     * Dodaje temat do bazy tematow, nastepnie mozemy sobie pobrac wszystkie slowa z danego tematu juz z bazy po nazwie tematu, przed wywolaniem sprawdzmy metode czy zajety
     * @param temat nazwa tematu
     * @param linki lista stringow zawierajacych linki do strony, minimum jeden link
     */
    public Nauczone dodajTemat(String temat,List<String> linki){
        Nauczone nau = new Nauczone();
System.out.println("Kitty: DOdajTemat:dodajTemat");
         Baza b = new Baza();
        b.polacz();
        Temat tem = new Temat(temat,linki);
        String text = tem.getText();
        GenerujGramatyke g = new GenerujGramatyke();
        Reguly r = new Reguly();

        //* funktest
                    /* nawiazanie jednokrotnego polaczenia z baza danych */

        System.out.println("lematyzuj");
                Funk instance = new Funk();
System.out.println("tokenizuj");
                List result = instance.tokenizuj(text);
                System.out.println("ztokenizowano");
        Iterator it = result.iterator();
        List<SlowoGram> s = new ArrayList();

        System.out.println("pzred while lematyzacja, result.size:"+result.size());
        System.out.println(result);
        int i = 0;
        while ( it.hasNext() ){
            i++;
            s.add(instance.lematyzujg((String)it.next(),b));
            System.out.println("zlematyzowano: " + i + " / " + result.size() + " slow" );
        }

        it = s.iterator();
        List dobreSlowa = new ArrayList();
        SlowoGram prz = null;
        while ( it.hasNext() ){
            prz = (SlowoGram)it.next();
            if ( prz != null )
                dobreSlowa.add(prz);
        }
        System.out.println("Ogółem ztokenizowano " + result.size() + " slow, a zlematyzowano: " + dobreSlowa.size() + "Slow, co daje "+(dobreSlowa.size()/result.size())*100 + " procent lematyzacji");

        nau.setIleRozpoznal(dobreSlowa.size());
        nau.setIleSlow(result.size());


        /** end funk test
         *
         */
        UtilityClass u = new UtilityClass();
        Set a = u.ListToSet(dobreSlowa);
        //System.out.println(r.genSlowaS(a));
        List<SlowoGram> h = dobreSlowa;//u.duplicate(dobreSlowa); za malo duplikatow

        /* wyswietl duplikaty */
        Collections.shuffle(h);
        //System.out.println(r.genSlowa(h));
        List<SlowoGram> l = h;
                //dodanie slow do listy
        List<String> lista = new ArrayList();
        it = l.iterator();
        while ( it.hasNext() ){
            lista.add(u.SGtoString((SlowoGram)it.next()));
        }
        nau.setSlowa(lista);

        SlowoTemat instance2 = new SlowoTemat();
        instance2.zapiszWszystkie(l, temat);
        return nau;
    }
  /**
     * Dodaje temat do bazy tematow, nastepnie mozemy sobie pobrac wszystkie slowa z danego tematu juz z bazy po nazwie tematu, przed wywolaniem sprawdzmy metode czy zajety
     * @param temat nazwa tematu
     * @param linki lista stringow zawierajacych linki do strony, minimum jeden link
     */
    public Nauczone dodajTematSleep(String temat,List<String> linki,long ile){
        Nauczone nau = new Nauczone();
System.out.println("Kitty: DOdajTemat:dodajTemat");
         Baza b = new Baza();
        b.polacz();
        Temat tem = new Temat(temat,linki);
        String text = tem.getText();
        GenerujGramatyke g = new GenerujGramatyke();
        Reguly r = new Reguly();

        //* funktest
                    /* nawiazanie jednokrotnego polaczenia z baza danych */

        System.out.println("lematyzuj");
                Funk instance = new Funk();
System.out.println("tokenizuj");
                List result = instance.tokenizuj(text);
                System.out.println("ztokenizowano");
        Iterator it = result.iterator();
        List<SlowoGram> s = new ArrayList();

        System.out.println("pzred while lematyzacja, result.size:"+result.size());
        System.out.println(result);
        int i = 0;
        while ( it.hasNext() ){
            i++;
            s.add(instance.lematyzujg((String)it.next(),b));
            System.out.println("zlematyzowano: " + i + " / " + result.size() + " slow" );
            if ( i >= 15000 )
                break;
            try { 
                //Thread.sleep(ile);
            }
            catch ( Exception e){
                
            }
        }

        it = s.iterator();
        List dobreSlowa = new ArrayList();
        SlowoGram prz = null;
        while ( it.hasNext() ){
            prz = (SlowoGram)it.next();
            if ( prz != null )
                dobreSlowa.add(prz);
        }
        System.out.println("Ogółem ztokenizowano " + result.size() + " slow, a zlematyzowano: " + dobreSlowa.size() + "Slow, co daje "+(dobreSlowa.size()/result.size())*100 + " procent lematyzacji");

        nau.setIleRozpoznal(dobreSlowa.size());
        nau.setIleSlow(result.size());


        /** end funk test
         *
         */
        UtilityClass u = new UtilityClass();
        Set a = u.ListToSet(dobreSlowa);
        //System.out.println(r.genSlowaS(a));
        List<SlowoGram> h = dobreSlowa;//u.duplicate(dobreSlowa); za malo duplikatow

        /* wyswietl duplikaty */
        Collections.shuffle(h);
        //System.out.println(r.genSlowa(h));
        List<SlowoGram> l = h;
                //dodanie slow do listy
        List<String> lista = new ArrayList();
        it = l.iterator();
        while ( it.hasNext() ){
            lista.add(u.SGtoString((SlowoGram)it.next()));
        }
        nau.setSlowa(lista);

        SlowoTemat instance2 = new SlowoTemat();
        instance2.zapiszWszystkie(l, temat);
        return nau;
    }

       public Nauczone dodajTemat(String temat,String text){
        Nauczone nau = new Nauczone();
System.out.println("dodajTemat");
         Baza b = new Baza();
        b.polacz();
        GenerujGramatyke g = new GenerujGramatyke();
        Reguly r = new Reguly();

        //* funktest
                    /* nawiazanie jednokrotnego polaczenia z baza danych */

        System.out.println("lematyzuj");
                Funk instance = new Funk();
System.out.println("tokenizuj");
                List result = instance.tokenizuj(text);
                System.out.println("ztokenizowano");
        Iterator it = result.iterator();
        List<SlowoGram> s = new ArrayList();

        System.out.println("pzred while lematyzacja, result.size:"+result.size());
        System.out.println(result);
        int i = 0;
        while ( it.hasNext() ){
            i++;
            s.add(instance.lematyzujg((String)it.next(),b));
            System.out.println("zlematyzowano: " + i + " / " + result.size() + " slow" );
        }

        it = s.iterator();
        List dobreSlowa = new ArrayList();
        SlowoGram prz = null;
        while ( it.hasNext() ){
            prz = (SlowoGram)it.next();
            if ( prz != null )
                dobreSlowa.add(prz);
        }
        System.out.println("Ogółem ztokenizowano " + result.size() + " slow, a zlematyzowano: " + dobreSlowa.size() + "Slow, co daje "+(dobreSlowa.size()/result.size())*100 + " procent lematyzacji");

        nau.setIleRozpoznal(dobreSlowa.size());
        nau.setIleSlow(result.size());


        /** end funk test
         *
         */
        UtilityClass u = new UtilityClass();
        Set a = u.ListToSet(dobreSlowa);
        //System.out.println(r.genSlowaS(a));
        List<SlowoGram> h = dobreSlowa;//u.duplicate(dobreSlowa); za malo duplikatow

        /* wyswietl duplikaty */
        Collections.shuffle(h);
        //System.out.println(r.genSlowa(h));
        List<SlowoGram> l = h;
                //dodanie slow do listy
        List<String> lista = new ArrayList();
        it = l.iterator();
        while ( it.hasNext() ){
            lista.add(u.SGtoString((SlowoGram)it.next()));
        }
        nau.setSlowa(lista);

        SlowoTemat instance2 = new SlowoTemat();
        instance2.zapiszWszystkie(l, temat);
        return nau;
    }
    public static void main(String[] args){
/*
        String temat = "termy29021986";
        String link1 = "http://www.cocodive.pl";
        String link2 = "http://www.cnoctopus.pl";
        String link3 = "http://www.orcadive.pl";
        String link4 = "http://gpcn.pl";
        String link5 = "http://www.akwanauta.com.pl";
        String link6 = "http://www.cocoblog.p";
        String link7 = "http://www.diveclub.pl";
        */
         String temat = "http://www.xopowiadania.pl/";
        
        List<String> lista = new ArrayList();
        
        lista.add(temat);
        /*lista.add("www.jezus.com.pl");
        
        lista.add("http://www.jezushistoryczny.pl");
        lista.add("http://www.mt1033.pl");
        lista.add("http://www.jezuufamtobie.pl");
        lista.add("http://jezus.waw.pl");
        lista.add("http://www.filmjezus.org.pl");
        lista.add("http://www.przystanekjezus.pl");
        lista.add("http://jezus.ownlog.com");
        lista.add("http://www.dlaczegojezus.pl");
        lista.add("http://www.karmelitanki.pl");
        lista.add("http://szpital-clo.med.pl");
        lista.add("http://pl.wikiquote.org/wiki/Jezus_Chrystus");
        lista.add("http://www.intronizacja.pl");
        lista.add("http://adonai.pl/jezus");
        lista.add("http://www.dzieciatko-jezus.pl");
        lista.add("http://pl.wiktionary.org/wiki/Jezus");
        lista.add("http://www.sw.tereska.pl");*/
        /*
        lista.add("http://portalwiedzy.onet.pl/31501,,,,jezus,haslo.html");
        lista.add("http://www.goszen.pl");
        lista.add("http://madeinheaven.pl");
        lista.add("http://tylkojezus.net");
        lista.add("http://www.jezus-czarna.pl");
        lista.add("http://pl-pl.facebook.com/PrzystanekJezus");
        lista.add("http://www.jezus-zyje.e-odnowa.pl");
        lista.add("http://marylki.pl");
        lista.add("http://www.milosierdzieboze.pl");
         * 
         
        lista.add("http://szukajacboga.jesus.net");
        lista.add("http://www.planetaislam.com/jezus/jezus.html");
        lista.add("http://www.jjp.org.pl");
        
        lista.add("http://wiadomosci.wp.pl/query,jezus,szukaj.html");
        lista.add("http://www.teresasiedlce.pl");
        lista.add("http://www.swteresa.konin.pl");
        lista.add("http://przedszkole-barnabici.edu.pl");
        lista.add("http://mtrojnar.rzeszow.opoka.org.pl/nowenna_do_dzieciatka");
        lista.add("http://www.jezusmi.republika.pl");
        lista.add("http://www.gotquestions.org/Polski/Jezus-Bogiem.html");
        lista.add("http://grzegorz.patynek.pl/");
        */
        //lista.add("http://www.sciaga.pl");
        //lista.add("http://www.wolnosc.elblag.pl/");
       /* lista.add("http://43dom.interia.pl/");
        lista.add("http://www.kapitalizm.org/");
        lista.add("http://pl.wiktionary.org/wiki/wolność");
        lista.add("http://www.wid.org.pl/");
        lista.add("http://www.ruchwig.pl/");
        lista.add("http://www.cytaty.info/temat/wolnosc.htm");
         * 
         */
        /*
        lista.add("http://jezusprzegrywaflejmy.tumblr.com");
        lista.add("http://jezuszyje.odnowa.org");
        lista.add("http://opoka.tv/filmy/15-film-jezus-po-polsku.html");
        lista.add("http://www.swietateresa.pl");
        lista.add("http://slowopana.com/jezus-chodzi");
        lista.add("http://www.joemonster.org/filmy/25156/Jezus_i_Judasz");
        lista.add("http://www.brewiarz.katolik.pl/czytelnia/swieci/01-03b.php3");
        lista.add("http://www.biblia-bog.pl");
        lista.add("http://www.eioba.pl/t/jezus");
        lista.add("http://chrzescijanin.republika.pl/");
        lista.add("http://sanctus.pl/index.php?grupa=45&podgrupa=46");
        lista.add("http://wolnelektury.pl/katalog/lektura/jezus-malusienki");
        lista.add("http://dzieckonmp.wordpress.com/category/jezus-krol-polski");
        lista.add("http://jakjezus.net");
        lista.add("http://www.marypages.com/InfantJesusPraguePolish.htm");
        lista.add("http://www.whoisjesus-really.com/polish/default.htm");
        lista.add("http://www.jezus.zapraszamy.pl");
        lista.add("http://kchjz.info.pl");
        lista.add("http://dzieciatka-jezus.prv.pl");
        lista.add("http://kalisz.koinoniagb.pl");
        lista.add("http://dzieciatko-jezus.blogspot.com");
        lista.add("http://bandzone.cz/jezuscrust");
        lista.add("http://e-sancti.net/forum");
        lista.add("http://panemjezus.pl");
        lista.add("http://www.ichtis.info/index.php/przystanek-jezus");
        lista.add("http://www.antytrynitarianie.pl/panjezus.html");
        lista.add("http://ekai.pl/wydarzenia/x53860/musimy-pokazywac-ze-jezus-jest-z-nami");
        lista.add("http://mateusz.pl/ksiazki/ja-cd/ja-cd-310.htm");
        lista.add("http://www.wiez.pl/index.php?s=karta&id=181");
        lista.add("http://gosc.pl/doc/1126418.Kurs-Alfa-Dlaczego-Jezus-umarl");
        lista.add("http://www.objawienia.pl/argasinska/arga-spis.html");
        lista.add("http://gajdaw.pl/koledy/jezus-malusienki.html");
        lista.add("http://www.kaszubski.filmjezus.org.pl");
        lista.add("http://www.nspjgdynia.pl");
        lista.add("http://www.zbawienie.com/yahushua.htm");
        lista.add("http://www.focus.pl/szukaj/tresc/0/wedlug/2/frazy/Jezus");
        lista.add("http://www.polonia-jezus.eu");
        lista.add("http://jezus80.pl");
        lista.add("http://www.swteresa.pl");
        */
        
        DodajTemat d = new DodajTemat();
        //if ( d.isWolnyTemat(temat))
            System.out.println(d.dodajTematSleep(temat, lista,10));
    }
}
