/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Benutzer;
import dhbwka.wwi.jpa.Kommentar;
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
public class BenutzerBean extends EntityBean <Benutzer, Long>{
    
     public BenutzerBean() {
        super(Benutzer.class);
    }
    
    @PersistenceContext
    EntityManager em;
    
     public Benutzer saveNew(Benutzer benutzer)
     {
        em.persist(benutzer);
        return em.merge(benutzer);
    }

     public List<Benutzer> findUser(String user) {
        Benutzer benutzer = new Benutzer();
        String select = "SELECT e FROM Benutzer e WHERE e.name = ':user'";
        return em.createQuery(select).getResultList();
    }
     
      public List<Benutzer> findPassword(String pw) {
        Benutzer benutzer = new Benutzer();
        String select = "SELECT e FROM Benutzer e WHERE e.passwort = ':pw'";
        return em.createQuery(select).getResultList();
    }
      
      /*public List<Benutzer> findEmail(String em) {
      Benutzer benutzer = new Benutzer();
      String select = "SELECT e FROM Benutzer e WHERE e.email = ':em'";
      return em.createQuery(select).getResultList();
      }*/
  
     
     
}
