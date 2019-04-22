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
    
        //Eine neue Bewertung erstellen
        public Double createNewStern(double bewertung,Bild bild,User user){
            //Prüfen ob der User für dieses Bild bereits eine Bewertung abgegeben hat
            List<Double> sternpruef = em.createQuery("Select w.sterne FROM Stern w WHERE w.user.username = :username AND w.bild.id= :id")
                .setParameter("username", user.getUsername())
                .setParameter("id",bild.getId())
                .getResultList();
            if(!sternpruef.isEmpty()){              
                //Wenn dieser schon eine Bewertung abgegeben hat, wird seine erste Bewertung für dieses Bild upgedatet
                Query query = em.createQuery("Update Stern w SET w.sterne = :bewertung WHERE w.user.username = :username AND w.bild.id = :id");
                query.setParameter("username", user.getUsername());
                query.setParameter("id", bild.getId());
                query.setParameter("bewertung", bewertung);
                query.executeUpdate();
                
                return sternpruef.get(0);
                
            }
            else{
                //der Benutzer hat noch keine Bewertung für das Bild abgegeben. Deshalb wird eine neue Bewertung erstellt
                Stern stern = new Stern(bewertung,bild,user);
                em.persist(stern);
                em.merge(stern);
                return 0.0; 
            }
            
        }
    }


