/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BenutzerBean;
import dhbwka.wwi.jpa.Benutzer;
import dhbwka.wwi.jpa.Kommentar;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/signup")
public class AnmeldeServlet extends HttpServlet {

    public static final String URL = "/signup";

    @EJB
    BenutzerBean benutzer;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Eingegebene Werte auslesen
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Eingegebene Werte auslesen

        String username = request.getParameter("r_username");
        String password = request.getParameter("r_password");
        String email = request.getParameter("e_mail");

        List<Benutzer> findUser = this.benutzer.findUser(username);
        List<Benutzer> findPw = this.benutzer.findPassword(password);
        //List<Benutzer> findEm = this.benutzer.findEmail(email);
        System.out.println("Test");
        System.out.println(findUser);

        if (findUser != null) {
            request.setAttribute("usererror", "Benutzer bereits vergeben");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + AnmeldeServlet.URL);
        }else {
            Benutzer benutzerjpa = new Benutzer();

            benutzerjpa.setName(username);
            benutzerjpa.setPasswort(password);
            benutzerjpa.setEmail(email);

            this.benutzer.saveNew(benutzerjpa);
            // Und die Seite nochmal laden lassen // response.sendRedirect(request.getRequestURI());
            response.sendRedirect(request.getContextPath() + LoginServlet.URL);
        }
        /*   /* if (findPw != null) {
        request.setAttribute("usererror", "Passwort bereits vergeben");
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + AnmeldeServlet.URL);
        }
        /*if (findEm != null) {
                request.setAttribute("usererror", "Email bereits vergeben");
                request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath() + AnmeldeServlet.URL);
            }*/
                    

    }
}