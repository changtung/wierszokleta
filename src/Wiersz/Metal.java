/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *nazwa od metal slug - nie wiedzialem co do tych operacji by sei dobrze nadawalo:)
 * @author Grzegorz
 */
public class Metal {
    private Sylaby s = new Sylaby();
    /**
     * wszystkie slowa ktore maja okreslony rym
     * @param slowa
     * @param rym
     * @return
     */
    public List<String> zgodRym(List<String> slowa,String rym){
        //TODO:
        List<String> res = new ArrayList();
        Iterator it = slowa.iterator();
        String slowo = "";
        while ( it.hasNext() ){
            slowo = (String)it.next();
            if ( this.maRym(slowo, rym) == true )//TODO:dodaj usun rym
                res.add(slowo);
        }
        return res;
    }
    private boolean maRym(String slowo,String rym){
        
        return true;//TODO:wlacz/wylacz rymy
        /*if ( slowo.length() < 2 )
            return false;
        if ( slowo.substring(slowo.length()-1, slowo.length()).equals(rym) == true )
        {
            //System.out.println("rym:"+slowo+","+rym);
            return true;
        }
        return false;//rym wylacz wlacz
        * //wlacz wylacz
        */
    }
    /**
     * usuwa zlowa z listy zakaz z calej listy k
     * @param k
     * @param zakaz
     * @return nowa lista k
     */
    public List<List<String>> usunZakaz(List<List<String>> k, List<String> zakaz){
//TODO:
        //System.out.println("zakaz2:"+zakaz);
        if ( zakaz == null )
            return k;
        for ( int i = 0 ; i < k.size() ; i++)
            for ( int j = 0 ; j < k.get(i).size() ; j++)
                if ( zakaz.contains(k.get(i).get(j)) == true ){

                    //System.out.println("contains: k.get(i");
                    //System.out.println("usunieto:");
                    k.get(i).remove(j);
                    j--;
                }
        return k;
    }
    /**
     * glowny algorytm ukladajacy zdanie, narazie polega na losowaosci a nie brute-force
     * @param k
     * @param syl
     * @return
     */
    public List<String> uz(List<List<String>> k, int syl){
        int c = 0;
        boolean jump = false;
        List<String> S = new ArrayList();
        do {
            S = new ArrayList();//TODO:tutaj wiecej zdan dodac
            for ( int i = 0 ; i < k.size() ; i++ ){
                if ( k.get(i).isEmpty() == true )//pusty ciag slow
                    jump = true;
                else
                {
                    jump = false;
                    List<String> sd = k.get(i);
                    //System.out.println("Metal:uz():k.get(i):"+sd);
                    S.add(this.getRandom(sd));
                }
                //System.out.println(k.size());
            }
            if ( ( jump == true ) && ( c < 10 ) )
            {
                c++;
                continue;
            }
            //System.out.println("Metal:uz:while:c="+c);
            c++;
            //System.out.println(c);
        //}while (!( (this.s.liczSylaby(S) == syl ) || (this.s.liczSylaby(S) == syl+2 ) || (this.s.liczSylaby(S) == syl -2 ) || (this.s.liczSylaby(S) == syl -4 ) || (this.s.liczSylaby(S) == syl + 4 ) || (this.s.liczSylaby(S) == syl - 6  ) || (this.s.liczSylaby(S) == syl + 6 ) || ( c == 10 )));
        }while (!( ( c == 1 )));

        if ( ( S.size() == k.size() ) ){//TODO:        if ( ( this.s.liczSylaby(S) == syl ) && ( S.size() == k.size() ) ){
            return S;
        }
        else
            return null;
    }
    public String getRandom(List<String> l ){
        Random rand = new Random(System.currentTimeMillis());
        //System.out.println("Metal:getRandom:"+l.get(rand.nextInt(l.size())));
        return l.get(rand.nextInt(l.size()));
        
    }
}
