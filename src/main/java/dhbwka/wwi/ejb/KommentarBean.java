 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
import dhbwka.wwi.jpa.Bild;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public Kommentar createNewComment(String comment,Bild bild){
        Kommentar kommentar = new Kommentar(comment, bild);
        em.persist(kommentar);
        return em.merge(kommentar);
    }
}
