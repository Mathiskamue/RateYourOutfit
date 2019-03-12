/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BenutzerBean;
import dhbwka.wwi.jpa.Benutzer;
import java.io.IOException;
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
@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{
    
    public static final String URL = "/login";
    
    @EJB
    BenutzerBean benutzer;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // Eingegebene Werte auslesen
     
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    
}
    
    @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             // Eingegebene Werte auslesen

       
        String username = request.getParameter("r_username");
        String password = request.getParameter("r_password");

         Benutzer benutzerjpa =     new Benutzer();
         
         benutzerjpa.setName(username);
         benutzerjpa.setPasswort(password);
         
          // Werte im Session Kontext ablegen
         HttpSession session = request.getSession();
         session.setAttribute("r_username", username);
         this.benutzer.saveNew(benutzerjpa);
        
       
       // Und die Seite nochmal laden lassen
      // response.sendRedirect(request.getRequestURI());
  response.sendRedirect(request.getContextPath() + UploadServlet.URL);
   
     }
         
}
