/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.KommentarBean;
import dhbwka.wwi.ejb.SternBean;
import dhbwka.wwi.jpa.Benutzer;
import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
import java.io.IOException;
import static java.lang.Integer.parseInt;
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
    
    @EJB
    SternBean sternBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Kommentar> findText = this.kommentarBean.findAll();
        request.setAttribute("findText", findText);

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
        this.kommentarBean.saveNew(comment);
        
        //Sterne speichern
        int stern = Integer.parseInt(request.getParameter("bewertung"));
        Stern star = new Stern();
        star.setStern(stern);
        System.out.println(stern);
        this.sternBean.saveStern(star);

        response.sendRedirect(request.getContextPath() + KommentarServlet.URL);

    }

}
