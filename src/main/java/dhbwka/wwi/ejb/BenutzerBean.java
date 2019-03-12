/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Benutzer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */

@Stateless
public class BenutzerBean {
    
    @PersistenceContext
    EntityManager em;
    
     public Benutzer saveNew(Benutzer benutzer)
     {
        em.persist(benutzer);
        return em.merge(benutzer);
    }

     
    
}
