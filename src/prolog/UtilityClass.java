/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prolog;

import Crapper.Graf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import prolog.util.Gram;
import prolog.util.SlowoGram;
import prolog.util.SlowoGramExt;

public class UtilityClass {

        public HashMap hm = new HashMap();
    public Set ListToSet(List<SlowoGram> slowa){
        
        Set s = new HashSet();
        int count = 0;
        for (int i=0;    i <  slowa.size(); i++)
        {
            if ( s.add(slowa.get((i))) == false )
                hm.put(slowa.get(i),(Integer)hm.get(slowa.get(i)) + 1 );
            else 
                hm.put(slowa.get(i),1);
            count++;
        }
        System.out.println("UtilityClass:ListToSet");
        System.out.println("Set size: "+s.size() + " List slowa size: "+ count);
        System.out.println("wyswietlenie powtorzen: ");

        return s;
    }
    public void wyswietleniePowtorzen(){
        Crapper.Graf g = new Graf();
        
                hm = g.sortHashMapByValuesD(hm);
                Iterator it = hm.keySet().iterator();
                
        String tmp;
        while ( it.hasNext() )
        {
            tmp = (String)it.next();
            System.out.println(tmp + " " + hm.get(tmp));
        }
    }
    public List<SlowoGram> duplicate(List<SlowoGram> slowa){

        List<SlowoGramExt> res = new ArrayList();
        
        ArrayList duplikaty = new ArrayList();

        List<SlowoGramExt> lista = new ArrayList();
            for (int i=0;    i <  slowa.size(); i++)
               lista.add(this.SGtoSGG(slowa.get((i))));

        HashMap map = new HashMap();
        int value = 0;
        String key = "";
        Set s = new HashSet();
        
        for (int i=0;    i <  lista.size(); i++)
            if ( lista.contains((SlowoGramExt)lista.get(i)) ){
               /* System.out.println("duplicate found");
                key = lista.get(i).bezok;
                if ( map.get(key) != null )
                    value = (Integer)map.get(key);
                else
                    value = 0;
                map.put(key, ++value);
                *
                */
                if ( !res.contains((SlowoGramExt)lista.get(i)))
                    res.add((SlowoGramExt)lista.get(i));
            }
        //res -> res2
        List<SlowoGram> res2 = new ArrayList();
        Iterator it = res.iterator();
        while ( it.hasNext() )
            res2.add(this.SGGtoSG((SlowoGramExt)it.next()));
        return res2;
    }
    public SlowoGramExt SGtoSGG(SlowoGram sg){
        SlowoGramExt res = new SlowoGramExt(sg.getWartosc(), sg.getFlaga(), sg.getKolejnosc(), sg.getBezok());
        return res;
    }
    public SlowoGram SGGtoSG(SlowoGramExt sg){
        SlowoGram res = new SlowoGram(sg.wartosc, sg.getFlaga(), sg.getKolejnosc(), sg.getBezok());
        return res;
    }
    public String SGtoString(SlowoGram sg){
        return sg.bezok +"-"+sg.wartosc;//TODO:bezokolicznik
    }
    public SlowoGram GtoSG(Gram g){
        SlowoGram s = new SlowoGram("",g.getFlaga(),g.getKolejnosc(),"");
        return s;
    }
}