/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/sesion"})
public class Session extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
         System.out.println("Test111");

        HttpSession session = request.getSession();
        String username = request.getParameter("j_username");
        session.setAttribute("session_username", username);

        System.out.println("Test222");
        System.out.println(username);
        //session.getAttribute("");
        String test = (String) session.getAttribute(username);
        System.out.println(test);

        //session.removeAttribute("name");
        // Und die Seite nochmal laden lassen // response.sendRedirect(request.getRequestURI());

    }
}
    

