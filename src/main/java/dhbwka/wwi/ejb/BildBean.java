/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Bild;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mathi
 */
@Stateless
public class BildBean {
    @PersistenceContext
    EntityManager em;
    
    
    public Bild createNewBild(String beschreibung, byte[] picture){
        Bild bild = new Bild(beschreibung, picture);
        em.persist(bild);
        return em.merge(bild);
    }
    public List<Bild> findAllKommentare(){
        return em.createQuery("SELECT w FROM BILD w").getResultList();
    }
    
    public Bild findKommentarById(long id) {
        return em.find(Bild.class, id);
    }
    
    
    
    
    
}
