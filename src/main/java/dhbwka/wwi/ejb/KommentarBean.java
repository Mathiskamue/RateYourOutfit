 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */


@Stateless
public class KommentarBean extends EntityBean<Kommentar, Long> {
    @PersistenceContext
    EntityManager em;
    
    public KommentarBean() {
        super(Kommentar.class);
    }
    public Kommentar createNewComment(String comment,Bild bild, User user){
        Kommentar kommentar = new Kommentar(comment, bild, user);
        em.persist(kommentar);
        return em.merge(kommentar);
    }

    public List<Kommentar> findCommentsById(long id) {
        return em.createQuery("Select w From Kommentar w WHERE w.bild.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
}
