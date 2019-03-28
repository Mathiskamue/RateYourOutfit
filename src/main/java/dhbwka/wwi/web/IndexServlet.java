/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
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
 * Servlet für die Startseite /index.html. Hier wird der Anwender einfach auf
 * die Übersichtsseite weitergeleitet. Falls er noch nicht eingeloggt ist, sorgt
 * der Applikationsserver von alleine dafür, zunächst die Loginseite anzuzeigen.
 */
@WebServlet(urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {

    /**
     * GET-Anfrage: Seite anzeigen
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("r_username");
        HttpSession session = request.getSession();
        session.getAttribute("");

        session.setAttribute("session_username", username);

        // Und die Seite nochmal laden lassen // response.sendRedirect(request.getRequestURI());
        response.sendRedirect(WebUtils.appUrl(request, "/app/uebersicht/"));

    }
}

    
