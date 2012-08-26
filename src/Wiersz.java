/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import com.sun.corba.se.impl.util.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prolog.util.Gram;
import prolog.util.SlowoGram;
import user.Generator;
import Wiersz.*;
import user.Generator;
import user.Nauczone;
import user.Nauka;
import Accessor.SlowoTemat;
import ColorPick.Topic;
import Gramatyka.GramatykaContainer;
/**
 *
 * @author Grzegorz
 */
@WebServlet(name="Wiersz", urlPatterns={"/Wiersz"}, initParams={@WebInitParam(name="Temat", value="Pies")})
public class Wiersz extends HttpServlet {
   
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
            out.println("<div id=\"content2\"><div class=\"wiersz\">");//TODO:contenet
            String args = "";
            args = request.getParameter("tytul");
            Nauka nauk = new Nauka();
            //String[] adresy = new String[3];
           // for ( int i = 0 ; i < 3; i++)
            //    adresy[i] = request.getParameter("a"+i);
            //if ( ( adresy[0] != null ) || ( adresy[1] != null ) || ( adresy[2] != null ) ){
                Nauczone naucz = new Nauczone();
                if ( nauk.wolnyTemat(args) == true )
                {
                    Topic pt = new Topic();

                    naucz = nauk.ucz(pt.parsujTemat(args, 1000), args);
                }
           // }

            
            Generator g = new Generator();
            String text = "";
                          System.out.println("New SlowoTenat");
        SlowoTemat instance = new SlowoTemat();
                GramatykaContainer gc = new GramatykaContainer();
        List<List<SlowoGram>> list = gc.generujZPlikuGramKolejnosc();

        List<Gram> slowa = gc.generujZPlikuGram();
        String temat = args;
        Nauka n = new Nauka();
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
                String a = "";
                String b = "";
                String c = "";
                a = Character.toString(wynik[0].charAt(16));
                a = a.toUpperCase();
                System.out.println("a:"+a);
                b = wynik[0].substring(17, wynik[0].length());
                c = wynik[0].substring(0, 16);

                wynik[0] = c+a+b;
                c = wynik[0].substring(wynik[0].length()-4,wynik[0].length());
                b = wynik[0].substring(0,wynik[0].length()-4);
                wynik[0] = b + "," + c;

                //w1
                                a = Character.toString(wynik[1].charAt(16));
                a = a.toUpperCase();
                System.out.println("a:"+a);
                b = wynik[1].substring(17, wynik[1].length());
                c = wynik[1].substring(0, 16);

                wynik[1] = c+a+b;
                c = wynik[1].substring(wynik[1].length()-4,wynik[1].length());
                b = wynik[1].substring(0,wynik[1].length()-4);
                wynik[1] = b + "," + c;

                //w2
                                a = Character.toString(wynik[2].charAt(16));
                a = a.toUpperCase();
                System.out.println("a:"+a);
                b = wynik[2].substring(17, wynik[2].length());
                c = wynik[2].substring(0, 16);

                wynik[2] = c+a+b;
                c = wynik[2].substring(wynik[2].length()-4,wynik[2].length());
                b = wynik[2].substring(0,wynik[2].length()-4);
                wynik[2] = b + "," + c;
                //w3
                                a = Character.toString(wynik[3].charAt(16));
                a = a.toUpperCase();
                System.out.println("a:"+a);
                b = wynik[3].substring(17, wynik[3].length());
                c = wynik[3].substring(0, 16);

                wynik[3] = c+a+b;
                c = wynik[3].substring(wynik[3].length()-4,wynik[3].length());
                b = wynik[3].substring(0,wynik[3].length()-4);
                wynik[3] = b + "." + c;
                for ( int i= 0 ; i < wynik.length ; i+=2 )//i++ TODO:final
                    out.print(wynik[i]);
            }
            else {
                //brak wiersza
                        out.println("nie udało się ułożyć wiersza, spróbój ponownie");

                     }
                    }
            catch(Exception e ){
                out.println("<p style=\"text-align: left\">nie udało się ułożyć wiersza, spróbój lepiej nauczyć</p>");
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
           
            out.println("</div></div>");
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
