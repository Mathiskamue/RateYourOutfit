/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;


import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
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
public class SternBean extends EntityBean<Stern, Long> {
        
        public SternBean() {
        super(Stern.class);
        }
    
        /*    @PersistenceContext
        EntityManager em;
        
        public Stern saveStern (Stern stern){
        System.out.println(stern.getStern());
        em.persist(stern);
        return em.merge(stern);*/
        
        public Double createNewStern(double bewertung,Bild bild,User user){
            List<Double> sternpruef = em.createQuery("Select w.sterne FROM Stern w WHERE w.user.username = :username AND w.bild.id= :id")
                .setParameter("username", user.getUsername())
                .setParameter("id",bild.getId())
                .getResultList();
            if(!sternpruef.isEmpty()){
                
                System.out.println("ES Funktioniert!");
                Query query = em.createQuery("Update Stern w SET w.sterne = :bewertung WHERE w.user.username = :username AND w.bild.id = :id");
                query.setParameter("username", user.getUsername());
                query.setParameter("id", bild.getId());
                query.setParameter("bewertung", bewertung);
                query.executeUpdate();
                
                return sternpruef.get(0);
                
            }
            else{
               Stern stern = new Stern(bewertung,bild,user);
                em.persist(stern);
                em.merge(stern);
                return 0.0; 
            }
            
        }
        
        
        /**SELECT t.ID, t.BESCHREIBUNG, u.TEXT, COUNT(s.STERNE), (SUM(s.STERNE)/COUNT(s.STERNE)) FROM RATEYOUROUTFIT.BILD AS t 
        INNER JOIN RATEYOUROUTFIT.STERN AS s ON s.BILD_ID = t.ID
        INNER JOIN RATEYOUROUTFIT.KOMMENTAR AS u ON u.BILD_ID = t.ID
        GROUP BY t.ID, t.BESCHREIBUNG, u.TEXT;**/
    }


