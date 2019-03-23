/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BildBean;
import dhbwka.wwi.jpa.Bild;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
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
@WebServlet(urlPatterns="/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    
    public static final String URL = "/upload";
    
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
        List<Integer> ids = bildBean.findAllIds();
        request.setAttribute("bildids", ids);
        
        request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request, response);        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        
            
        if(request.getParameter("hochladen")!=null){
            BildForm form = new BildForm();
            form.setBeschreibung(request.getParameter("beschreibung"));
            System.out.println("Beschreibung Textarea:" + request.getParameter("textarea"));
            Part filepart = request.getPart("picture");
            InputStream inputStream = filepart.getInputStream();         
            form.setBild(IOUtils.toByteArray(inputStream));  
            Bild testbild = bildBean.createNewBild2(form.getBild());
            form.setId(testbild.getId());
            
            HttpSession session = request.getSession();
            session.setAttribute("bild_form", form);
            response.sendRedirect(request.getContextPath() + UploadServlet.URL);
        }
        else{
            HttpSession session = request.getSession();
            BildForm form =(BildForm) session.getAttribute("bild_form");
            System.out.println("1.Id überprüfung" + form.getId());
            form.setBeschreibung(request.getParameter("beschreibung"));
            form.checkValues();
                
            if (!form.errors.isEmpty()) {
                // Formular erneut anzeigen, wenn es Fehler gibt
                HttpSession session2 = request.getSession();
                session2.setAttribute("bild_form", form);

                response.sendRedirect(request.getContextPath() + UploadServlet.URL);
                return;
            }
            /*Bild test = bildBean.findBildById(form.getId());
            test.setBeschreibung(form.getBeschreibung());*/
            System.out.println("2.Id überprüfung" + form.getId());
            bildBean.setBeschreibung(form.getBeschreibung(), form.getId());
            form = null;
            HttpSession session3 = request.getSession();
            session3.setAttribute("bild_form", form);
            response.sendRedirect(request.getContextPath() + UebersichtServlet.URL);
            System.out.println("button2");
        }   
    }
    
}
