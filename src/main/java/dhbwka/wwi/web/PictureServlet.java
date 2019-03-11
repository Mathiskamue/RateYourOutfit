/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

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
@WebServlet(urlPatterns="/index.html")
@MultipartConfig
public class PictureServlet extends HttpServlet {
    
    public static final String URL = "/index.html";
    
    @EJB
    KommentarBean kommentarBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        
        response.setContentType("image/jpeg");
        List<byte[]> bilder = this.kommentarBean.findAllPics();
        byte[] imageBytes = bilder.get(0);
        response.setContentLength(imageBytes.length);
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        
        request.getRequestDispatcher("/guestbook.jsp").forward(request, response);


        
    }
    
    
    
    
}
