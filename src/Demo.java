/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witchhunter
 */
import IO.ProlFil;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.io.File;
import java.sql.DriverManager;
import java.util.Formatter;
public class Demo {
    int wskaznik =0;
    Start s;
    public Demo(){
        //s = new Start();
    }
    public static void main(String[] args){
        Demo d = new Demo();
        int x1 = 0x000000;
        int x2 = 0xffffff;
        for ( int i = 0 ; i < 1 ; i++){
            System.out.println("i"+i);
            //d.generujDoBazy("Spojrzał na Polskę odważnie.Zapieła Grecję piorunem. Zaczerwień swoją flagę. Zorbasom nędza lajkuje. ");//d.processBaza(d.wiersz(),x1,x2)
            ProlFil p = new ProlFil();
            System.out.println("1");
            try { 
            p.setContents(new File("/home/witchhunter/abc.html"),d.gradient("<p>oswajali Hiszpania chomiki</p><p>nadziali Włochy zakupy</p><p>konkretne linki</p><p>Chorwacja witali prostymi domy</p>"));//d.processBaza(d.wiersz(),x1,x2)
            System.out.println("ok");
            }
            catch ( Exception e ){
                
            }

        }
    }
    public String wiersz(){
        return s.get().replace("-", "");
    }
    public void generujDoPliku(String text,String filename){
        ProlFil p = new ProlFil();
        try { 
        p.setContents(new File("/home/witchhunter/yoko/"+filename+".html"), text);
        }
        catch ( Exception e ){
            System.out.println(e);
        }    
    }

        public void generujDoBazy(String text){
        String query = "insert into wil ( lyric ) values ( '"+text+"' );";
            System.out.println(query);
        String dbConnection = "jdbc:mysql://localhost/ispell?user=root&password=";
            try {
             try {
		          // The newInstance() call is a work around for some
		          // broken Java implementations
		          Class.forName("com.mysql.jdbc.Driver").newInstance();
		      } catch (Exception ex) {
		          // handle the error
		    	  System.out.println(ex);
		      }
//			  DriverManager.registerDriver (new Driver());

			  Connection conn = null;
			      conn =
			         DriverManager.getConnection(dbConnection);
                          PreparedStatement pstmt = conn.prepareStatement("insert into wil (lyric) values (?)");
pstmt.setString(1, text); // this is your html string from step #1
pstmt.executeUpdate();
pstmt.close();
conn.close();

                    
            }
            catch ( Exception e ){
                System.out.println(e);
            }
    }
    public String process(String wiersz,int x1,int x2){
        String[] zdania = wiersz.split("\\.");
        String res = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head><body><div style=\"height: 585px;width:900px;-moz-border-radius: 225px 90px / 90px 225px;border-radius: 225px 90px / 90px 2255px;background: #ccc;padding: 45px 0 0 0;\">";
        for ( int i = 0 ; i < 4 ; i++)
            res += "<p style=\"text-align: center;font-size:38px;\">"+this.gradient(zdania[i])+"</p>";
        return res+"</div></body></html>";
        
    }
    public String processBaza(String wiersz,int x1,int x2){
        String[] zdania = wiersz.split("\\.");
        String res = "";
        for ( int i = 0 ; i < 4 ; i++)
            res += "<p style=\"text-align: center;font-size:38px;\">"+this.gradient(zdania[i])+"</p>";
        return res;
        
    }
    public String gradient(String zdanie){
        String res = "";
        int x1 = 0;
        int x2 = 0xffffff;
        
        int z = x2-x1;
        
        double w1 = Math.floor(x1 + z/3);
        int z1 = (int)w1;
        
        double w2 = Math.floor(x1 + z/3*2);
        int z2 = (int)w2;
        
        int i = zdanie.length();
        
        double x = Math.floor(i/3);
        int y = (int)x;
        for ( int k = 0 ; k< y ; k++){
            res += kolor(zdanie.charAt(k),x1,z1,y);
        }
        for ( int k = y ; k< y+y ; k++){
            res += kolor(zdanie.charAt(k),z1,z2,y);
        }
        for ( int k = y+y ; k< i ; k++){
            res += kolor(zdanie.charAt(k),z1,z2,y);
        }
        return res;
    }
    public String kolor(char c,int x1,int x2,int x){
        wskaznik++;
        if ( wskaznik == 45 )
        {
            this.last = 0;
            this.lastr = 0;
            this.kkk = 0;
            this.kkkb = 0;
        }
        String g = this.randomByter();
        String z = this.randomByteLastr();
        String r = this.randomByte();
        String y = this.randomByteLast();
        String b = this.randomByte();
        String w = this.randomByteLast();
        
        //return "#a"+wskaznik+" {background-color:#"+r+g+b+"!important;}";
        return "<span style=\"color:#"+r+g+b+";background: #fff;\">"+c+"</span>";
    }
    public String randomByte(){
        byte b = this.randomNumber();
        StringBuilder sb = new StringBuilder(2);
        Formatter formatter = new Formatter(sb);
        formatter.format("%02x", b);
        return sb.toString();
    }
    public String randomByteLast(){
        byte b = (byte)((byte)255-this.last);
        StringBuilder sb = new StringBuilder(2);
        Formatter formatter = new Formatter(sb);
        formatter.format("%02x", b);
        return sb.toString();
    }
        public String randomByter(){
        byte b = this.randomNumberr();
        StringBuilder sb = new StringBuilder(2);
        Formatter formatter = new Formatter(sb);
        formatter.format("%02x", b);
        return sb.toString();
    }
    public String randomByteLastr(){
        byte b = (byte)((byte)255-this.lastr);
        StringBuilder sb = new StringBuilder(2);
        Formatter formatter = new Formatter(sb);
        formatter.format("%02x", b);
        return sb.toString();
    }
    public byte randomNumber(){
        if ( this.last == 0 ) 
        {   
            this.last = 111;
            return 111;
        }
        byte a;
        if ( this.kkk < 22 )
            a = (byte)( (this.last+3) % 256);
        else
            a = (byte)( (this.last-3) % 256);
        this.kkk++;
        this.last = a;
        return a;
    }
    byte last;
    int kkk;
    int kkkb;
    public byte randomNumberr(){
        if ( this.lastr == 0 ) 
        {   
            this.lastr = (byte)150;
            return (byte)150;
        }
        byte a;
        if ( this.kkkb < 22 )
            a = (byte)( (this.lastr+3) % 256);
        else
            a = (byte)( (this.lastr-3) % 256);
        this.kkkb++;        this.lastr = a;
        return a;
    }
    byte lastr;
        public byte randomNumberg(){
        if ( this.last == 0 ) 
        {   
            this.last = 1;
            return 0;
        }
        byte a = (byte)( (this.last+1) % 256);
        this.last = a;
        return a;
    }
    byte lastg;
        public byte randomNumberb(){
        if ( this.last == 0 ) 
        {   
            this.last = 1;
            return 0;
        }
        byte a = (byte)( (this.last+1) % 256);
        this.last = a;
        return a;
    }
    byte lastb;
}
