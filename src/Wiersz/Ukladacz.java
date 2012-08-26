/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import prolog.util.SlowoGram;

/**
 *
 * @author Grzegorz
 */
public class Ukladacz {
    private DaneWejsciowe d;
    private Fasada f ;
    private ArrayList value;
    public List<String> spalone = new ArrayList();
    public Ukladacz(DaneWejsciowe d,ArrayList value) {
        this.d = d;
        this.f = new Fasada(d,value);
        this.value = value;
    }
    
        public String ulozS(List<String> zakazane){
        //Fasada f = new Fasada(this.d,this.value);
        Rym r = new Rym();
        List<String> rymy = r.getRymy();
        Collections.shuffle(rymy);
        String res = "";
        Iterator it = rymy.iterator();
        String rym = "";
        Zdanie z = null;
        Zdanie z2 = null;
        Zdanie z3 = null;
        Zdanie z4 = null;
        List<String> aa = null;
        while ( it.hasNext() ){
            rym = (String)it.next();
            try { 
            z = zdanie(d.getIlSyl(),rym,this.spalone);
            }
            catch ( Exception e){
                System.out.println("wyjaaatek!!!");
            }
            //System.out.println("z:"+z);
            if ( z != null ){
                //System.out.println("zakazane lokalnie: "+z.getSlowa());
                /*if ( zakazane == null )
                    zakazane = new ArrayList();
                 */
                spalone.addAll(z.getSlowa());
                //System.out.println("spalone:"+spalone);
                try { 
                z2 = zdanie(d.getIlSyl(),rym,spalone);
                }
                catch ( Exception e)
                {
                    System.out.println("Wyjatek2!!!");
                }
                   if ( z2 != null ){
                spalone.addAll(z2.getSlowa());        
res = this.tworzWersyS(z);
res += this.tworzWersyS(z2);
                   }
//z.getSlowa().addAll(z2.getSlowa());
//res.setZakazane(z.getSlowa());
return res;
//                }
                       /* aa = this.scal(z.getSlowa(),z2.getSlowa());
                        z3 = zdanie(d.getIlSyl(),rym,aa);
                        if ( z3 != null ){
                            aa = this.scal(aa,z3.getSlowa());
                            z4 = zdanie(d.getIlSyl()-2,rym,aa);
                            if ( z4 != null ){
                                
                             }
                        * 
                        */
            }
        }
        return null;
    }
    public DaneWyjsciowe uloz(List<String> zakazane){
        Fasada f = new Fasada(this.d,this.value);
        Rym r = new Rym();
        List<String> rymy = r.getRymy();
        Collections.shuffle(rymy);

        Iterator it = rymy.iterator();
        String rym = "";
        Zdanie z = null;
        Zdanie z2 = null;
        Zdanie z3 = null;
        Zdanie z4 = null;
        List<String> aa = null;
        while ( it.hasNext() ){
            rym = (String)it.next();
            z = zdanie(d.getIlSyl(),rym,zakazane);
            //System.out.println("z:"+z);
            if ( z != null ){
                //System.out.println("zakazane lokalnie: "+z.getSlowa());
                if ( zakazane == null )
                    zakazane = new ArrayList();
                zakazane.addAll(z.getSlowa());
       //         z2 = zdanie(d.getIlSyl(),rym,zakazane);
         //          if ( z2 != null ){
                        
DaneWyjsciowe res = new DaneWyjsciowe(this.tworzWersy(z));
//z.getSlowa().addAll(z2.getSlowa());
//res.setZakazane(z.getSlowa());
return res;
//                }
                       /* aa = this.scal(z.getSlowa(),z2.getSlowa());
                        z3 = zdanie(d.getIlSyl(),rym,aa);
                        if ( z3 != null ){
                            aa = this.scal(aa,z3.getSlowa());
                            z4 = zdanie(d.getIlSyl()-2,rym,aa);
                            if ( z4 != null ){
                                
                             }
                        * 
                        */
            }
        }

        return null;
    }
    public List<String> scal(List<String> a , List<String> b){
        a.addAll(b);
        return a;
    }
    public Zdanie zdanie(int ilSyl,String rym, List<String> zakaz){
        Collections.shuffle(this.d.getGramatyka());
        Iterator git = this.d.getGramatyka().iterator();
        List<String> s = new ArrayList();
        while ( git.hasNext() ){
            //System.out.println("Ukladacz:zdanie1/2");
            s = ulozZdanie(ilSyl,rym,zakaz,(List<SlowoGram>)git.next());
            //System.out.println("Ukladacz:zdanie2/2");
            if ( s != null ){
                return new Zdanie(ilSyl,rym,zakaz,s);
            }
        }
        return null;
    }
    /**
     * widok
     * @param z1
     * @param z2
     * @return
     */
    private List<String> tworzWersy(Zdanie z1, Zdanie z2){
                    List<String> wersy = new ArrayList();
                    wersy.add(this.formatujWers(z1.getSlowa()));
                    wersy.add(this.formatujWers(z2.getSlowa()));
                    return wersy;
    }
     private List<String> tworzWersy(Zdanie z1){
                    List<String> wersy = new ArrayList();
                    wersy.add(this.formatujWers(z1.getSlowa()));
                    return wersy;
    }
          private String tworzWersyS(Zdanie z1){
                    return this.formatujWers(z1.getSlowa());
    }
        private List<String> tworzWersy(Zdanie z1, Zdanie z2,Zdanie z3,Zdanie z4){
                    List<String> wersy = new ArrayList();
                    wersy.add(this.formatujWers(z1.getSlowa()));
                    wersy.add(this.formatujWers(z2.getSlowa()));
                    wersy.add(this.formatujWers(z3.getSlowa()));
                    wersy.add(this.formatujWers(z4.getSlowa()));
                    return wersy;
    }
    private String formatujWers(List<String> wers){
        Iterator it = wers.iterator();
        String res = "";
        for ( int i = 0 ; i < wers.size() -1 ; i++)
            res += (String)wers.get(i)+" ";
        res += (String)wers.get(wers.size() -1)+"";
        return res+"xxx";
    }
    public List<String> ulozZdanie(int ilSyl,String rym,List<String> zakaz, List<SlowoGram> g){
        //System.out.println("Ukladacz:uluzZdanie:g"+g);
        List<List<String>> k = new ArrayList();
        Iterator it = g.iterator();
        SlowoGram sg = null;
        String key = null;
        List<String> jedngr = null;
        while ( it.hasNext() )
        {
            sg = (SlowoGram)it.next();
            key = sg.getFlaga()+"-"+sg.getKolejnosc();
            jedngr = (List<String>)this.f.getSznak().get(key);
            if ( key.equals("MS-0") == true )//7-maja-2012 dodajemy slowa  kluczowe
            {
                //System.out.println("TEST:MS-0");
                //jedngr.addAll(this.getKeywords()); dwa zbiory slow dopelniajace sie lub czesciowo matma....teria zbiorow
                jedngr = this.getKeywords();
            }
            //System.out.println("Ukladacz:ulozZdanie:while"+sg);
            if ( jedngr == null ){
                //System.out.println("546");
                return null;
            }
            k.add(jedngr);
        //    System.out.println("Ukladacz:uluzZdanie "+jedngr);
        }
        //mamy k
        /*for ( int i = 0 ; i < k.size() ; i++)
            System.out.println(k.get(i));
        return null;
         * 
         */
        Metal engine = new Metal();
        List<String> sfg = engine.zgodRym(k.get(k.size()-1), rym);
        if ( sfg.isEmpty() == true )
            return null;

        
        k.set(k.size()-1, sfg);
        k = engine.usunZakaz(k, zakaz);
        //System.out.println("Ukladacz:ulozZdanie");
        return engine.uz(k, ilSyl);
    }
    //slowa kluczowe
    public List<String> getKeywords(){
        return slowa;
    }
        //slowa kluczowe
    public void setKeywords(List<String> slowa){
        this.slowa = slowa;
    }
    List<String> slowa = new ArrayList();
}
