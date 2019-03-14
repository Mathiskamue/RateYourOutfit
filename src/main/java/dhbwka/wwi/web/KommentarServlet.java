/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.KommentarBean;
import dhbwka.wwi.jpa.Benutzer;
import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thoma
 */
@WebServlet(urlPatterns = {"/comment"})
public class KommentarServlet extends HttpServlet {

    public static final String URL = "/comment";

    @EJB
    KommentarBean kommentarBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* List<Kommentar> findComment = this.kommentarBean.findComment();
        request.setAttribute("kommentar", findComment);*/
        request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Eingegebene Werte auslesen

        //Kommentar speichern
        String kommentar = request.getParameter("kommentarRein");
        Kommentar comment = new Kommentar();
        comment.setText(kommentar);
        this.kommentarBean.saveComment(comment);
        //Sterne speichern
        String stern = request.getParameter("bewertung.value");
        Stern star = new Stern();
        
        switch (stern) {
            case "1":
                
                break;
            case "2":
                System.out.println("i ist zwei");
                break;
            case "3":
                System.out.println("i ist drei");
                break;
            case "4":
                System.out.println("i ist drei");

            case "5":
                System.out.println("i ist drei");
            default:
                System.out.println("i liegt nicht zwischen null und drei");
        }

        response.sendRedirect(request.getContextPath() + KommentarServlet.URL);

    }

}
