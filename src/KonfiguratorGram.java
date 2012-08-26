
import Accessor.Baza;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witchhunter
 */
public class KonfiguratorGram {
    public static void main(String[] args){
        Baza b = new Baza();
        b.polacz();
        for ( char xx = 'a' ; xx < 'z' ; xx++)
            for ( int i = 0 ; i < 5 ; i++ )
                if ( b.przykGram(String.valueOf(xx), i) != "" )
                    System.out.println("<tr><td>"+String.valueOf(xx)+"-"+i+"</td><td>"+b.przykGram(String.valueOf(xx), i)+"</td></tr>");
                for ( char xx = 'A' ; xx < 'Z' ; xx++)
            for ( int i = 0 ; i < 5 ; i++ )
                if ( b.przykGram(String.valueOf(xx), i) != "" )
                    System.out.println("<tr><td>"+String.valueOf(xx)+"-"+i+"</td><td>"+b.przykGram(String.valueOf(xx), i)+"</td></tr>");
    }
}
