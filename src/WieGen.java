/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import Accessor.*;
import com.sun.corba.se.impl.util.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prolog.util.Gram;
import prolog.util.SlowoGram;
import Wiersz.*;
import user.Generator;
import Gramatyka.GramatykaContainer;
import java.util.Iterator;
import user.Nauczone;
import user.Nauka;
/**
 *
 * @author Grzegorz
 */
@WebServlet(name="WieGen", urlPatterns={"/WieGen"})
public class WieGen extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //out.println("<div id=\"content2\"><div class=\"wiersz\">");//TODO:contenet
            //String args = "";
            //args = request.getParameter("link");
            Baza b = new Baza();
            b.polacz();

            List<Lyric> lyrics = b.pobierzWiersze();
            System.out.println("lyrics size");
            System.out.println(lyrics.size());
            Iterator it = lyrics.iterator();

            Lyric a = null;
            Nauka n = null;
            String[] adresy = null;
            Nauczone naucz = null;
            String sessid = null;
            SessionIdentifierGenerator sid = null;
            String aa = null;
            String bb = null;
            String cc = null;
            String wiersz = null;

            while ( it.hasNext() ){
                a = ( Lyric)it.next();
                System.out.println("getlyric:");
                System.out.println(a.getLyric().length());
                if ( a.getLyric().length() < 2 )
                {
                    System.out.println("w ifie");
                    //set wiersz for lyric
                    n = new Nauka();
            adresy = new String[10];
                adresy[0] = a.getUrl();
            naucz = new Nauczone();
            sid = new SessionIdentifierGenerator();
            sessid = sid.nextSessionId();
                    System.out.println("sessid: "+sessid);
            if ( n.wolnyTemat(sessid) == true )
            {
                naucz = n.ucz(adresy, sessid);
                //out.println(naucz.toString());
            }
           // }


            Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        String temat = sessid;
        n = new Nauka();
        //if ( n.wolnyTemat(temat) == false ) {
            List sl = instance.dajSlowa(temat,slowa);
            DaneWejsciowe d = new DaneWejsciowe(list,sl);
            Ukladacz ukl = new Ukladacz(d);
            try {
            DaneWyjsciowe expResult = ukl.uloz(null);
            DaneWyjsciowe expResult2 = ukl.uloz(expResult.getZakazane());
            Utility ut = new Utility();
           // ut.wyswietlSlowa(d);//blad netbeans ?
            if  ( ( expResult != null ) && ( expResult2 != null ))
            {
                String[] wynik = new String[4];
                wynik[0] = expResult.getWersy().get(0);
                wynik[1] = expResult2.getWersy().get(0);
                wynik[2] = expResult.getWersy().get(1);
                wynik[3] = expResult2.getWersy().get(1);

                //duza litera
                aa = "";
                bb = "";
                cc = "";
                aa = Character.toString(wynik[0].charAt(16));
                aa = aa.toUpperCase();
                System.out.println("a:"+aa);
                bb = wynik[0].substring(17, wynik[0].length());
                cc = wynik[0].substring(0, 16);

                wynik[0] = cc+aa+bb;
                cc = wynik[0].substring(wynik[0].length()-4,wynik[0].length());
                bb = wynik[0].substring(0,wynik[0].length()-4);
                wynik[0] = bb + "," + cc;

                //w1
                                aa = Character.toString(wynik[1].charAt(16));
                aa = aa.toUpperCase();
                System.out.println("a:"+aa);
                bb = wynik[1].substring(17, wynik[1].length());
                cc = wynik[1].substring(0, 16);

                wynik[1] = cc+aa+bb;
                cc = wynik[1].substring(wynik[1].length()-4,wynik[1].length());
                bb = wynik[1].substring(0,wynik[1].length()-4);
                wynik[1] = bb + "," + cc;

                //w2
                                aa = Character.toString(wynik[2].charAt(16));
                aa = aa.toUpperCase();
                System.out.println("a:"+aa);
                bb = wynik[2].substring(17, wynik[2].length());
                cc = wynik[2].substring(0, 16);

                wynik[2] = cc+aa+bb;
                cc = wynik[2].substring(wynik[2].length()-4,wynik[2].length());
                bb = wynik[2].substring(0,wynik[2].length()-4);
                wynik[2] = bb + "," + cc;
                //w3
                                aa = Character.toString(wynik[3].charAt(16));
                aa = aa.toUpperCase();
                System.out.println("a:"+aa);
                bb = wynik[3].substring(17, wynik[3].length());
                cc = wynik[3].substring(0, 16);

                wynik[3] = cc+aa+bb;
                cc = wynik[3].substring(wynik[3].length()-4,wynik[3].length());
                bb = wynik[3].substring(0,wynik[3].length()-4);
                wynik[3] = bb + "." + cc;
                wiersz = "";
                for ( int i= 0 ; i < wynik.length ; i++ )//i++ TODO:final
                    wiersz += wynik[i];
            }
            else {
                //brak wiersza
                        out.println("nie udało się ułożyć wiersza, spróbój ponownie");

                     }
                }
            catch ( Exception e ){
                System.out.println(e);
            }
                a.setLyric(wiersz);
                b.setLyric(a);
            }

                    }
           // }
 /*else {
            out.print("<p style=\"text-align: left\">Nie znam tego tematu, naucz mnie tego plis! Podaj adres www strony, z ktorej sie naucze</p>");
            out.print("<ul style=\"list-style: none\">"+
"<li><span class=\"fl\">url 1:<input type=\"text\" id=\"a0\"/></span><p class=\"podpowiedz\">Na przykład http://pl.wikipedia.org/wiki/Pies</p><div class=\"clear\"></div></li>"+
"</ul>");
 }
  * 
  */

           //out.println("wiersz");
           
            out.flush();

            /* TODO output your page here
            
            out.println("<head>");
            out.println("<title>Servlet Wiersz</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Wiersz at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
