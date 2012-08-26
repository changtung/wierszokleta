
import Accessor.DodajTemat;
import Accessor.SlowoTemat;
import Gramatyka.GramatykaContainer;
import IO.ProlFil;
import Wiersz.DaneWejsciowe;
import Wiersz.Ukladacz;
import java.io.File;
import java.net.URL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.htmlparser.jericho.CharacterReference;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import prolog.util.Gram;
import prolog.util.SlowoGram;
import user.Generator;
import user.Nauczone;
import user.Nauka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Grzegorz Patynek
 */
public class Precle {
    Precle() { 
        this.polacz();
    }
    Connection conn;

    /**
     * dodaje do bazy slowa kluczowe z adresem strony, dodaje temat o wartosci url
     * @param url 
     */
    public void ucz(String url){
         String temat = url;
        
        List<String> lista = new ArrayList();
        
        lista.add(temat);
        
        DodajTemat d = new DodajTemat();
        //if ( d.isWolnyTemat(temat))
        Nauczone n = d.dodajTematSleep(temat, lista,10);
        Iterator it = n.getSlowa().iterator();
        while ( it.hasNext() )
            dodajKeywordDoBazy((String)it.next(),url);
    }
     private void polacz(){
        try {
        		      try {
		          // The newInstance() call is a work around for some
		          // broken Java implementations
		          Class.forName("com.mysql.jdbc.Driver").newInstance();
		      } catch (Exception ex) {
		          // handle the error
		    	  System.out.println(ex);
		      }
         conn = //TODO:change
                                     DriverManager.getConnection("jdbc:mysql://localhost/ispell?useUnicode=true&characterEncoding=utf-8&" +
			                                 "user=root&password=");
               //  DriverManager.getConnection("jdbc:mysql://localhost/zjn?" +
		//	                                 "user=root&password=");
        }
        catch ( Exception e){
            System.out.println(e);
        }
    }
    private void dodajKeywordDoBazy(String slowo,String url){
        String insertQuery = "insert into a_keywords(keyword,url) values ( '"+this.processSlowo(slowo)+"', '"+url+"')";
             try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          stmt.executeUpdate(insertQuery);
            }
            catch ( Exception e ){
                System.out.println(e);
            }
             System.out.println("slowo"+slowo+" inserted");
    }
     private void dodajInfoDoBazy(String url,String lyric,String title,String keywords,String description,String category){
        String insertQuery = "insert into a_lyrics(url,lyric,title,keywords,description,category) values ( '"+url+"', '"+lyric+"','"+title+"', '"+keywords+"', '"+description+"' ,'"+category+"')";
             try {
            Statement stmt = conn.createStatement();
                          //System.out.println("dodaj slowo");
                          stmt.executeUpdate(insertQuery);
            }
            catch ( Exception e ){
                System.out.println(e);
            }
             System.out.println("slowo"+url+" inserted with lyric");
    }
    /**
     * 
     * @param slowo macica-macicy
     * @return macica
     */
    private String processSlowo(String slowo){
        int k = slowo.indexOf("-");
        return slowo.substring(0, k);
    }
    /**
     * generuje wiersz o stronie i tytul i dodaje do bazy
     * @param url 
     */
    public void precel(ArrayList slowa,int znaki){
        Source source = null;
        this.getLyric2(slowa,znaki);
        
    }
    public void getLyric2(ArrayList words,int ile){
         Start st = new Start(null);
        String wiersz,aa,bb,cc = null;
           Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        String temat = "GOCLEVER";//"termy29021986";
        Nauka n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
            System.out.println("777"+slowa);
            String topic = null;
            //String topic = "http://zyczenia.sennik.biz/zyczenia-dla-zakochanych";
//            List sl = instance.dajSlowaAll(slowa);//high
            List sl = instance.dajSlowaGineko(slowa);//high

            //List sl = instance.dajSlowa("alkohol", slowa);//high
//            System.out.println("slowa:"+sl);
  //          System.out.println("slowa size:"+sl.size());

            String tekst = "";
            ArrayList s = new ArrayList();
            String tmp = "";
            Ukladacz ukl = null;
            
            
            DaneWejsciowe d = new DaneWejsciowe(list,sl);//high?
            ukl = new Ukladacz(d,s);//high
            
            String res = "";
            String[] wersy3 = new String[2];
            File fi = null;
            String word = "";
            Iterator it = words.iterator();
            ArrayList tmp2 = null;
            
            while ( it.hasNext() ) {
            
            word = (String)it.next();
            tmp2 = new ArrayList();
            tmp2.add(word);
            ukl.setKeywords(tmp2);
            ukl.spalone = new ArrayList();
            res = "";
            while ( res.length() < ile ) {
                System.out.println("progres: "+word+"::"+res.length()+"/"+ile);
                wersy3 = new String[2];
                for ( int i = 0 ; i < 2 ; i++){

                    try {
                            tmp = ukl.ulozS(null);
                            if ( tmp == null )
                                continue;
                            wersy3 = tmp.split("xxx");
                            if ( i == 0 ){
                            st.w1 = wersy3[0];
                            st.w3 = wersy3[1];
                            }
                            if ( i == 1 ){
                            st.w2 = wersy3[0];
                            st.w4 = wersy3[1];
                            }
                        }
                    catch ( Exception e ){
                        System.out.println(e);
                    }
                }



                    res += st.w1+".";
                    res += st.w2+".";
                    res += st.w3+".";
                    res += st.w4+".";
                
            }
            fi = new File("c:\\wiersz\\"+word+".txt");
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
     public String precelText(ArrayList slowa,int znaki){
        Source source = null;
        return this.getLyric2Text(slowa,znaki);
        
    }
     public String precelTematText(String temat,ArrayList slowa,int znaki){
        Source source = null;
        return this.getLyricTematText(temat,slowa,znaki);
        
    }
    public String getLyric2Text(ArrayList words,int ile){
         Start st = new Start(null);
        String wiersz,aa,bb,cc = null;
           Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        String temat = "GOCLEVER";//"termy29021986";
        Nauka n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
            System.out.println("777"+slowa);
            String topic = null;
            //String topic = "http://zyczenia.sennik.biz/zyczenia-dla-zakochanych";
//            List sl = instance.dajSlowaAll(slowa);//high
            List sl = instance.dajSlowaGineko(slowa);//high

            //List sl = instance.dajSlowa("alkohol", slowa);//high
//            System.out.println("slowa:"+sl);
  //          System.out.println("slowa size:"+sl.size());

            String tekst = "";
            ArrayList s = new ArrayList();
            String tmp = "";
            Ukladacz ukl = null;
            
            
            DaneWejsciowe d = new DaneWejsciowe(list,sl);//high?
            ukl = new Ukladacz(d,s);//high
            
            String res = "";
            String[] wersy3 = new String[2];
            File fi = null;
            String word = "";
            Iterator it = words.iterator();
            ArrayList tmp2 = null;
            
            while ( it.hasNext() ) {
            
            word = (String)it.next();
            tmp2 = new ArrayList();
            tmp2.add(word);
            ukl.setKeywords(tmp2);
            ukl.spalone = new ArrayList();
            res = "";
            while ( res.length() < ile ) {
                System.out.println("progres: "+word+"::"+res.length()+"/"+ile);
                wersy3 = new String[2];
                for ( int i = 0 ; i < 2 ; i++){

                    try {
                            tmp = ukl.ulozS(null);
                            wersy3 = tmp.split("xxx");
                            if ( i == 0 ){
                            st.w1 = wersy3[0];
                            st.w3 = wersy3[1];
                            }
                            if ( i == 1 ){
                            st.w2 = wersy3[0];
                            st.w4 = wersy3[1];
                            }
                        }
                    catch ( Exception e ){
                        System.out.println(e);
                    }
                }



                    res += st.w1+".";
                    res += st.w2+".";
                    res += st.w3+".";
                    res += st.w4+".";
                
            }
            /*fi = new File("c:\\wiersz\\"+word+".txt");
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
        * 
        */
            }
            return res;
           
    }
      public String getLyricTematText(String temat,ArrayList words,int ile){
         Start st = new Start(null);
        String wiersz,aa,bb,cc = null;
           Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        //String temat = "GOCLEVER";//"termy29021986";
        Nauka n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
            System.out.println("777"+slowa);
            String topic = null;
            //String topic = "http://zyczenia.sennik.biz/zyczenia-dla-zakochanych";
//            List sl = instance.dajSlowaAll(slowa);//high
            List sl = instance.dajSlowa(temat,slowa);//high
            Collections.shuffle(sl);
          System.out.println("sl:"+sl);
            //List sl = instance.dajSlowa("alkohol", slowa);//high
//            System.out.println("slowa:"+sl);
  //          System.out.println("slowa size:"+sl.size());

            String tekst = "";
            ArrayList s = new ArrayList();
            String tmp = "";
            Ukladacz ukl = null;
            
            
            DaneWejsciowe d = new DaneWejsciowe(list,sl);//high?
            ukl = new Ukladacz(d,s);//high
            
            String res = "";
            String[] wersy3 = new String[2];
            File fi = null;
            String word = "";
            Iterator it = words.iterator();
            ArrayList tmp2 = null;
            
            while ( it.hasNext() ) {
            
            word = (String)it.next();
                System.out.println("slowo:"+word);
            tmp2 = new ArrayList();
            tmp2.add(word);
            ukl.setKeywords(tmp2);
            ukl.spalone = new ArrayList();
            res = "";
            boolean pom;
            while ( res.length() < ile ) {
                pom = false;
                System.out.println("progres: "+word+"::"+res.length()+"/"+ile);
                wersy3 = new String[2];
                for ( int i = 0 ; i < 2 ; i++){

                    try {
                            tmp = ukl.ulozS(null);
                            System.out.println("tmp:"+tmp);
                            if ( ( tmp == "" ) || ( tmp == null ) )
                            {
                                pom = true;
                                break;
                            }
                            wersy3 = tmp.split("xxx");
                            System.out.println("length:"+wersy3.length);
                            if ( i == 0 ){
                            st.w1 = wersy3[0];
                            st.w3 = wersy3[1];
                            }
                            if ( i == 1 ){
                            st.w2 = wersy3[0];
                            st.w4 = wersy3[1];
                            }
                        }
                     catch ( NullPointerException e ){
                        return null;
                    }
                    catch ( Exception e ){
                        System.out.println("wyjatek3"+e);
                    }
                }
                if ( pom == true )
                    continue;
                    char[] cc1 = st.w1.toCharArray();
                    cc1[0] = String.valueOf(cc1[0]).toUpperCase().toCharArray()[0];
                    st.w1 = new String(cc1);
                
                                        char[] cc2 = st.w2.toCharArray();
                    cc2[0] = String.valueOf(cc2[0]).toUpperCase().toCharArray()[0];
                    st.w2 = new String(cc2);
                                        char[] cc4 = st.w4.toCharArray();
                    cc4[0] = String.valueOf(cc4[0]).toUpperCase().toCharArray()[0];
                    st.w4 = new String(cc4);
                                        char[] cc3 = st.w3.toCharArray();
                    cc3[0] = String.valueOf(cc3[0]).toUpperCase().toCharArray()[0];
                    st.w3 = new String(cc3);
                    res += st.w1+".";
                    res += st.w2+".";
                    res += st.w3+".";
                    res += st.w4+".";
                
            }
            }
            return res;
           
    }
    private static String getTitle(Source source) {
        Element titleElement = null;
        try { 
        titleElement=source.getFirstElement(HTMLElementName.TITLE);
        }
        catch ( NullPointerException e ){
            return null;
        }
    //if (titleElement==null) return null;
    // TITLE element never contains other tags so just decode it collapsing whitespace:
    return CharacterReference.decodeCollapseWhiteSpace(titleElement.getContent());
}

private static String getMetaValue(Source source, String key) {
    System.out.println(source);
    for (int pos=0; pos<source.length();) {
        StartTag startTag = null;
        try { 
        startTag=source.getNextStartTag(pos,"name",key,false);
       

        if (startTag.getName()==HTMLElementName.META)
            return startTag.getAttributeValue("content"); // Attribute values are automatically decoded
        pos=startTag.getEnd();
                }
        catch ( NullPointerException e ){
            return null;     
        }
    }
    return null;
}

    public static void main(String[] args){
        Precle p = new Precle();
        ArrayList slowa = new ArrayList();
        slowa.add("Kredyt");
        p.prec(slowa);
    }
    public void prec(ArrayList sk){
        //File f = new File("c:\\wiersz\\"+temat+".txt");
        //String s = ProlFil.getContents(f);
        //String[] sl = = new String[1];//s.split(System.getProperty("line.separator"));
        for ( int i = 1 ; i < 10 ; i++)
        {   String slowo = "kredyt";
            Precle p = new Precle();
            String a = p.precelTematText(slowo,sk,1200);

              File fi = new File("c:\\artykuly\\"+slowo+i+".txt");
            try { 
            if(!fi.exists()){
            fi.createNewFile();
            }
            ProlFil.setContents(fi, a);
            }
            catch ( Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
