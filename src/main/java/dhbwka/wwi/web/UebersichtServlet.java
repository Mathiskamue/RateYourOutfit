/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BildBean;
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
import org.apache.commons.io.IOUtils;

/**
 *
 * @author mathi
 */

@WebServlet(urlPatterns="/uebersicht")
public class UebersichtServlet extends HttpServlet {
    
    public static final String URL = "/uebersicht";
    
    @EJB
    BildBean bildBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
                
        // Anfrage an die JSP weiterleiten
        List<Integer> ids = bildBean.findAllIds();
        request.setAttribute("bildids", ids);
        
        
        request.getRequestDispatcher("/WEB-INF/uebersicht.jsp").forward(request, response);        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }
    
}
