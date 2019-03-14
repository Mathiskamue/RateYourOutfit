/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
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
public class KommentarBean {

    @PersistenceContext
    EntityManager em;

    /**
     * Speichern
     */
    public Kommentar saveComment(Kommentar comment) {
        em.persist(comment);
        return em.merge(comment);
    }

    public Stern saveSterne(Stern star) {
        em.persist(star);
        return em.merge(star);
    }

    /**
     * Finde
     * @return 
     */

    public List<Kommentar> findComment() {
        String select = "SELECT e FROM Kommentar e WHERE ";
        return em.createQuery(select).getResultList();
    }

}
