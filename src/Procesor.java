
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
public class Procesor {
    Procesor() { 
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
     public void ucz(String url,String temat){
         
        
        List<String> lista = new ArrayList();
        
        lista.add(url);
        
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
    public void wierszTytul(String url,String category){
        Source source = null;
        try { 
            System.out.println(url);
        source=new Source(new URL(url));
        
        }
        catch ( Exception e){
            System.out.println("wyjatek,wychodze z metody"+e);
            return;
        }
         String title = this.getTitle(source);
         if ( title == null )
             title = "";
        String keywords = this.getMetaValue(source, "keywords");
        if ( keywords == null )
            keywords = "";
        String description = this.getMetaValue(source, "description");
        if ( description == null )
            description = "";
        String lyric = this.getLyric(url);
            if ( lyric == null )
                lyric = "";
            System.out.println(title);
            System.out.println(keywords);
            System.out.println(description);
            System.out.println(lyric);
            this.dodajInfoDoBazy(url, lyric, title, keywords, description,category);
    }
    public String getLyric(String url){
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
            String topic = url;
            //String topic = "http://zyczenia.sennik.biz/zyczenia-dla-zakochanych";
            List sl = instance.dajSlowa(topic,slowa);
            System.out.println("slowa:"+sl);
            System.out.println("slowa size:"+sl.size());

            String tekst = "";
            ArrayList s = new ArrayList();
            String tmp = "";
            Ukladacz ukl = null;
            
            
            DaneWejsciowe d = new DaneWejsciowe(list,sl);
            ukl = new Ukladacz(d,s);
            
            String[] wersy3 = new String[2];
            for ( int i = 0 ; i < 2 ; i++){

                try {
                    System.out.println("1");
                        tmp = ukl.ulozS(null);
                        System.out.println("2");
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+tmp+i);
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
                //prezentacja
                Demo demo = new Demo();
                String res = "";
                res += "<p>"+st.w1+"</p>";
                res += "<p>"+st.w2+"</p>";
                res += "<p>"+st.w3+"</p>";
                res += "<p>"+st.w4+"</p>";
                //tmp = st.w1+st.w2+st.w3+st.w4;
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
        String slowo = "openworm";
        Procesor p = new Procesor();
        /*File f = new File("c:\\linki\\"+slowo+".txt");
        String s = ProlFil.getContents(f);
        String[] linki = s.split(System.getProperty("line.separator"));
        System.out.println("linki size: "+linki.length);*/
        String url = "";
        //for ( int i = 50 ; i < 2700 ; i++ ){//kredyt od 1623
        url = "http://grzegorz.patynek.pl/ccc";//linki[i];
        //System.out.println("link nr."+i);
        
        p.ucz(url,slowo);
        
        //p.wierszTytul(url,slowo);
        //}
    }
}
