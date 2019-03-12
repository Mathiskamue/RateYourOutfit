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
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet(urlPatterns="/upload.jsp")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    
    public static final String URL = "/upload.jsp";
    
    @EJB
    BildBean bildBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        // Objekt mit leeren Eingabewerten im Request Context ablegen,
        // damit es beim Erstaufruf nicht zum Absturz kommt  
        

        
        HttpSession session = request.getSession();
        BildForm form = (BildForm) session.getAttribute("bild_form");
        
        if (form == null) {
            session.setAttribute("bild_form", new BildForm());
        }
        
        // Anfrage an die JSP weiterleiten
        
        request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request, response);        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        
        BildForm form = new BildForm();
        form.setBeschreibung(request.getParameter("beschreibung"));
        
        Part filepart = request.getPart("picture");
        InputStream inputStream = filepart.getInputStream();
        
        form.setBild(IOUtils.toByteArray(inputStream));
        
        bildBean.createNewBild(form.getBeschreibung(), form.getBild());
        response.sendRedirect(request.getContextPath() + PictureServlet.URL);;
    }
    
}
