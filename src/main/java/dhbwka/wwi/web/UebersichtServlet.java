/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BildBean;
import dhbwka.wwi.ejb.KommentarBean;
import dhbwka.wwi.ejb.SternBean;
import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Kommentar;
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
    
    @EJB
    KommentarBean kommentarBean;
    
    @EJB
    SternBean sternBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
                
        // Anfrage an die JSP weiterleiten
        List<Bild> bilder = bildBean.findAllPictures();
        request.setAttribute("bildids", bilder);
        for (Bild b : bilder){
            System.out.println("IDSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
            System.out.println(b.getId());
            long id = b.getId();
            List<Kommentar> kommentare = kommentarBean.findCommentsById(id);
            for(Kommentar k : kommentare){
                System.out.println(k.getText());
            }
            //List<Stern> sterne = sternBean.findStarsById(id);
            /**String attribut = "kommentare" + id;
            request.setAttribute(attribut, kommentare);**/
        }
        
        
        request.getRequestDispatcher("/WEB-INF/uebersicht.jsp").forward(request, response);        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        
        if(request.getParameter("sendebtn")!= null){
            String id = request.getParameter("sendebtn");
            System.out.println("BildID: Kommentar: " + id );
            String kommentarfeld = request.getParameter("kommentar"+id);
            if(!(kommentarfeld.equals(""))){
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                kommentarBean.createNewComment(kommentarfeld, bild); 
            }          
        }
        else{
            if(request.getParameter("bewertung1")!=null){
                String id = request.getParameter("bewertung1");
                System.out.println("BildID: Stern 1: " + id );
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                sternBean.createNewStern(1, bild);
            }
            else if(request.getParameter("bewertung2")!=null){
                String id = request.getParameter("bewertung2");
                System.out.println("BildID: Stern 2: " + id );
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                sternBean.createNewStern(2, bild);
            }
            else if(request.getParameter("bewertung3")!=null){
                String id= request.getParameter("bewertung3");
                System.out.println("BildID: Stern 3: " + id );
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                sternBean.createNewStern(3, bild);
            }
            else if(request.getParameter("bewertung4")!=null){
                String id= request.getParameter("bewertung4");
                System.out.println("BildID: Stern 4: " + id );
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                sternBean.createNewStern(4, bild);
            }
            else if(request.getParameter("bewertung5")!=null){
                String id= request.getParameter("bewertung5");
                System.out.println("BildID: Stern 5: " + id );
                Bild bild = bildBean.findBildById(Long.parseLong(id));
                sternBean.createNewStern(5, bild);
            }
        }
        
        
        response.sendRedirect(request.getContextPath() + UploadServlet.URL);
        
        
    }
    
    
            
    
}
