/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import dhbwka.wwi.ejb.BildBean;
import dhbwka.wwi.ejb.UserBean;
import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.User;
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

//Mit diesem Servlet hat der Benutzer die Möglichkeit, seine Bilder hochzuladen.
@WebServlet(urlPatterns="/app/upload/")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    //URL als final Variable deklarieren
    public static final String URL = "/app/upload/";
    
    @EJB
    BildBean bildBean;
    @EJB
    UserBean userBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        //Benutzerauslesen
        User username = this.userBean.getCurrentUser();
        String sessionuser = username.getUsername();
        session.setAttribute("session_username", sessionuser);
        
        //Bereits vorhandene Bildform mit gesetzen Atributen bekommen
        BildForm form = (BildForm) session.getAttribute("bild_form");
        //Wenn noch keine Bildform vorhanden ist, Bildform neu setzen
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
        
        //Prüfen, welcher Button auf der Seite getätigt wurde
        //Hochladen = Bild anzeigen Button
        if(request.getParameter("hochladen")!=null){
            HttpSession session = request.getSession();
            BildForm formtest =(BildForm) session.getAttribute("bild_form");
            //Entweder es wurde bereits ein Bild hochgeladen in dieser Session 
            //und dieses muss überschrieben werden oder es wurde noch keins hochgeladen
            //Wenn Bereits eine ID gesetzt wurde, dann wurde bereits ein Bild hochgeladen
            if(formtest.getId()!=0){
                //Ablauf zum Übersetzen des Bildes in byte[]
                Part filepart = request.getPart("picture");
                InputStream inputStream = filepart.getInputStream(); 
                formtest.setBild(IOUtils.toByteArray(inputStream));
                //Updaten des Bildes in der Datenbank
                bildBean.updateBild(formtest.getBild(), formtest.getId());
                //in der Session die neue Form setzen
                session.setAttribute("bild_form", formtest);
                //Nochmal auf die gleiche Seite weiterleiten, dieses mal mit neu geupdateten Bild, 
                //da der Benutzer vielleicht noch keine Beschreibung gesetzt hat oder sein Bild in
                //dem Format anschauen möchte
                response.sendRedirect(WebUtils.appUrl(request, "/app/upload/"));
            }
            //Es wurde noch kein Bild davor in der Session hochgeladen
            else{
                //eine neue Bildform wird deklariert
                BildForm form = new BildForm();                
                form.setBeschreibung(request.getParameter("beschreibung"));
                //Übersetzen des Bildes in byte[]
                Part filepart = request.getPart("picture");
                InputStream inputStream = filepart.getInputStream();         
                form.setBild(IOUtils.toByteArray(inputStream));  
                //Prüfen, ob überhaupt ein Bild hochgeladen wurde
                if(form.getBild().length < 2){
                    //Kein Bild wurde hochgeladen, deshalb in der Form Errors hinzufügen und auf der Seite 
                    //mit einem Redirect anzeigen
                    form.errors.add("Bitte laden Sie zuerst ein Bild hoch!");
                    session.setAttribute("bild_form", form);
                    response.sendRedirect(WebUtils.appUrl(request, "/app/upload/"));
                }
                else{
                    //es wurde ein Bild hochgeladen 
                    //Usernamen dafür setzten und das Bild in der Datenbank mit Username abspeichern
                     User username = this.userBean.getCurrentUser();
                     Bild testbild = bildBean.createNewBild2(form.getBild(),username);
                     form.setId(testbild.getId());
                     //Der Session die Attribute übergeben und wieder auf die gleiche Seite weiterleiten, 
                     //dieses mal ist aber eine id gesetzt, d.h. man kann nun noch eine Beschreibung zu 
                     //seinem Bild hinzufügen und das Bild in dem Format, wie es später auf der Website zu
                     //sehen ist anschauen
                     session.setAttribute("bild_form", form);
                     response.sendRedirect(WebUtils.appUrl(request, "/app/upload/"));
                }
               
            }
            
        }
        //Es wurde der Abschicken-Button betätigt
        //d.h. es wird geprüft, ob eine Beschreibung gesetzt wurde
        else{
            HttpSession session = request.getSession();
            BildForm form =(BildForm) session.getAttribute("bild_form");
            form.setBeschreibung(request.getParameter("textarea"));
            form.setErrors(null);
            form.checkValues();
                
            if (!form.errors.isEmpty()) {
                // Formular erneut anzeigen, wenn es Fehler gibt
                HttpSession session2 = request.getSession();
                session2.setAttribute("bild_form", form);
                response.sendRedirect(WebUtils.appUrl(request, "/app/upload/"));
                return;
            }
            //Die Beschreibung für das Bild in der Datenbank setzen
            bildBean.setBeschreibung(form.getBeschreibung(), form.getId());
            form = null;
            HttpSession session3 = request.getSession();
            BildForm leerer = new BildForm();
            session3.setAttribute("bild_form", leerer);
            response.sendRedirect(WebUtils.appUrl(request, "/app/uebersicht/"));
            
        }   
    }
    
}
