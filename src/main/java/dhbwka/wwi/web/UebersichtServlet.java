/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BildBean;
import dhbwka.wwi.ejb.KommentarBean;
import dhbwka.wwi.ejb.SternBean;
import dhbwka.wwi.ejb.UserBean;
import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author mathi
 */
//Servlet für die Übersicht über alle Bilder und das Bewerten und Kommentieren
@WebServlet(urlPatterns = "/app/uebersicht/")
public class UebersichtServlet extends HttpServlet {

    //public static final String URL = "/app/uebersicht";
    @EJB
    BildBean bildBean;

    @EJB
    KommentarBean kommentarBean;

    @EJB
    SternBean sternBean;

    @EJB
    UserBean userBean;

    @Override
    @Transactional
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        //Benutzerauslesen
        User username = this.userBean.getCurrentUser();
        String sessionuser = username.getUsername();
        session.setAttribute("session_username", sessionuser);

        //Alle Bildobjekte aus der Datenbank heraussuchen
        List<Bild> bilder = bildBean.findAllPictures();
        
        request.setAttribute("bildids", bilder);
        //Anfrage mit Bildobjekten an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/uebersicht.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //Überprüfen, welcher Button betätigt wurde
        if (request.getParameter("sendebtn") != null) {
            //Wenn der Sende-Button betätigt wurde, soll ein Kommentar abgeschickt werden
            //Überprüfen, ob in dem Kommentarfeld etwas drinsteht, wenn ja wird das Vorhandene in der
            //Datenbank abgespeichert und abgeschickt
            String id = request.getParameter("sendebtn");
            String kommentarfeld = request.getParameter("kommentar" + id);
            if (!(kommentarfeld.equals(""))) {
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                User username = this.userBean.getCurrentUser();
                kommentarBean.createNewComment(kommentarfeld, bild, username);
            }
        } else {
            //Ansonsten kann nur ein Bild bewertet werden
            //Deshalb muss überprüft werden, welches Bild mit welcher Bewertung gedrückt wurde.
            if (request.getParameter("bewertung1") != null) {
                String id = request.getParameter("bewertung1");
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                User username = this.userBean.getCurrentUser();
                double istnichtvorhanden = sternBean.createNewStern(1, bild,username);
                if(istnichtvorhanden==0){
                    bildBean.updateBewertung(bild, 1.0);
                }
                else{
                    bildBean.updateBewertung2(bild,1.0, istnichtvorhanden);
                }
            } else if (request.getParameter("bewertung2") != null) {
                String id = request.getParameter("bewertung2");
                System.out.println("BildID: Stern 2: " + id);
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                User username = this.userBean.getCurrentUser();
                double istnichtvorhanden = sternBean.createNewStern(2, bild,username);
                if(istnichtvorhanden==0){
                    bildBean.updateBewertung(bild, 2.0);
                }
                else{
                    bildBean.updateBewertung2(bild,2.0, istnichtvorhanden);
                }
            } else if (request.getParameter("bewertung3") != null) {
                String id = request.getParameter("bewertung3");
                System.out.println("BildID: Stern 3: " + id);
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                User username = this.userBean.getCurrentUser();
                double istnichtvorhanden = sternBean.createNewStern(3, bild,username);
                if(istnichtvorhanden==0){
                    bildBean.updateBewertung(bild, 3.0);
                }
                else{
                    bildBean.updateBewertung2(bild,3.0, istnichtvorhanden);
                }
            } else if (request.getParameter("bewertung4") != null) {
                String id = request.getParameter("bewertung4");
                System.out.println("BildID: Stern 4: " + id);
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                User username = this.userBean.getCurrentUser();
                double istnichtvorhanden = sternBean.createNewStern(4, bild,username);
                if(istnichtvorhanden==0){
                    bildBean.updateBewertung(bild, 4.0);
                }
                else{
                    bildBean.updateBewertung2(bild,4.0, istnichtvorhanden);
                }
            } else if (request.getParameter("bewertung5") != null) {
                String id = request.getParameter("bewertung5");
                System.out.println("BildID: Stern 5: " + id);
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                User username = this.userBean.getCurrentUser();
                double istnichtvorhanden = sternBean.createNewStern(5, bild,username);
                if(istnichtvorhanden==0){
                    bildBean.updateBewertung(bild, 5.0);
                }
                else{
                    bildBean.updateBewertung2(bild,5.0, istnichtvorhanden);
                }
                
            }
        }

        //response.sendRedirect(request.getContextPath() + UploadServlet.URL);
        response.sendRedirect(WebUtils.appUrl(request, "/app/uebersicht/"));

    }

}
