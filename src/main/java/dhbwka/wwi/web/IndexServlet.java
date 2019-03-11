/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.jpa.Kommentar;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
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
@WebServlet(urlPatterns="/index.html")
@MultipartConfig
public class IndexServlet extends HttpServlet {
    
    public static final String URL = "/index.html";
    
    @EJB
    KommentarBean kommentarBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        // Objekt mit leeren Eingabewerten im Request Context ablegen,
        // damit es beim Erstaufruf nicht zum Absturz kommt
        List<Kommentar> entries = this.kommentarBean.findAllKommentare();
        request.setAttribute("entries", entries);
        
        /*response.setContentType("image/jpeg");
        List<byte[]> bilder = this.kommentarBean.findOnePic(151);
        byte[] imageBytes = bilder.get(0);
        response.setContentLength(imageBytes.length);
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        */

        
        HttpSession session = request.getSession();
        KommentarForm form = (KommentarForm) session.getAttribute("kommentar_form");
        
        if (form == null) {
            session.setAttribute("kommentar_form", new KommentarForm());
        }
        
        // Anfrage an die JSP weiterleiten
        
        request.getRequestDispatcher("/guestbook.jsp").forward(request, response);

        // Fehlermeldungen und so weiter aus der Session löschen, damit sie
        // beim nächsten Aufruf verschwinden
        session.removeAttribute("kommentar_form");

        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        
        KommentarForm form = new KommentarForm();
        form.setName(request.getParameter("name"));
        form.setComment(request.getParameter("comment"));
        
        Part filepart = request.getPart("myFile");
        InputStream inputStream = filepart.getInputStream();
        
        form.setBild(IOUtils.toByteArray(inputStream));
        System.out.println("xcccxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " + form.getBild().length);
        
        kommentarBean.createNewKommentar(form.getName(),form.getComment(), form.getBild());
        response.sendRedirect(request.getContextPath() + IndexServlet.URL);;
    }
    
    
}
