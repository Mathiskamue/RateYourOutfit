/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BildBean;
import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Kommentar;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathi
 */
@WebServlet(urlPatterns="/bild")
public class PictureServlet extends HttpServlet {
    
    public static final String URL = "/bild";
    
    @EJB
    BildBean bildBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id = BildForm.id;
                 
                
        response.setContentType("image/jpeg");
        Bild bild = this.bildBean.findKommentarById(id);
        byte[] imageBytes = bild.getBild();
        response.setContentLength(imageBytes.length);
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        
    }
}
