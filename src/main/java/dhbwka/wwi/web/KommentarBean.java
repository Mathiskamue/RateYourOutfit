/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mathi
 */
@Stateless
public class KommentarBean {
    @PersistenceContext
    EntityManager em;
    
    public Kommentar createNewKommentar(String name, String comment, byte[] bild){
        Kommentar kommentar = new Kommentar(name, comment, bild);
        em.persist(kommentar);
        return em.merge(kommentar);
    }
    public List<Kommentar> findAllKommentare(){
        return em.createQuery("SELECT w FROM  Kommentar w").getResultList();
        
    }
    public List<byte[]> findAllPics(){
        return em.createQuery("SELECT PICTURE FROM KOMMENTAR w").getResultList();
    }
    public List<byte[]> findOnePic(int id){
        return em.createQuery("SELECT PICTURE FROM KOMMENTAR w WHERE ID=201").getResultList();
    }
}
